import java.util.*;

public class SmartBot {

    // Variables
    private Room currRoom;
    private AbstractRoomLoader loader;
    private String str;
    private int stepCost = 0;

    // Initialize
    public void load() {
        loader = new RoomLoader();
        loader.load();
        loader.deserialize("Aryan.ser");
        currRoom = loader.getStart();
        str = "[" + currRoom.getID() + "]";
    }

    // Run
    public void run() {

        // While the current room is not the end room
        while (!currRoom.equals(loader.getEnd())) {

            // Get the path to the end room from search algorithm
            List<Door> path = aStarSearch(currRoom, loader.getEnd());

            // Follow route from start to end
            for (Door d : path) {
                str += " -> " + d;
                currRoom = currRoom.enter(d);
                str += " -> [" + currRoom.getID() + "]";
            }
        }

        // Print the results
        System.out.println("Found the End! " + Room.getNumMoves() + " steps");
        System.out.println("Path: " + str);
        System.out.println("Step Cost: " + stepCost);
    }

    private List<Door> aStarSearch(Room start, Room goal) {

        // Variables
        PriorityQueue<Node> openRooms = new PriorityQueue<>(); // List of nodes to be evaluated in order of increasing
                                                               // cost from heuristic method
        Map<Room, Door> cameFrom = new HashMap<>(); // Map of rooms and the door that was used to enter them
        Map<Room, Integer> gScore = new HashMap<>(); // Map of rooms and the cost of getting to them from the start
        Map<Room, Integer> fScore = new HashMap<>(); // Map of rooms and the cost of getting to them from the start +
                                                     // heuristic cost

        // Add the start room to the open rooms
        openRooms.add(new Node(start, null, 0, heuristicCost(start, goal)));
        gScore.put(start, 0);
        fScore.put(start, heuristicCost(start, goal));

        // Variable to store the previous room and count steps
        Room previous = null;

        // While there are rooms to evaluate (then we will have found the end room)
        while (!openRooms.isEmpty()) {

            // Get the best option from the open room
            Node current = openRooms.poll();
            if (previous != null) {
                List<Door> path = reconstructPath(cameFrom, previous); // Backtrack
                System.out.println("Backtracking with step cost: " + path.size());
                stepCost += path.size();
            }

            // If the current room is the goal room, return the path
            Room currentRoom = current.room;
            if (currentRoom.equals(goal)) {
                return reconstructPath(cameFrom, currentRoom);
            }

            System.out.print("Current Room: \t" + currentRoom.getID() + "\t Checking children: [ ");
            int i = 0;
            for (Door d : currentRoom.getDoors()) {

                // Go to the neighbor room
                Room neighborRoom = currentRoom.enter(d);
                int tentativeGScore = gScore.getOrDefault(currentRoom, Integer.MAX_VALUE) + 1;

                if (tentativeGScore < gScore.getOrDefault(neighborRoom, Integer.MAX_VALUE)) {
                    cameFrom.put(neighborRoom, d);
                    gScore.put(neighborRoom, tentativeGScore);
                    fScore.put(neighborRoom, tentativeGScore + heuristicCost(neighborRoom, goal));
                    openRooms.add(new Node(neighborRoom, d, tentativeGScore, fScore.get(neighborRoom)));
                }
                System.out.print(neighborRoom.getID() + " ");
                currentRoom.enter(d); // Go back to the current room
                i++;
            }
            System.out.println("]\t Step Cost: " + (i * 2));
            stepCost += i * 2;
            previous = currentRoom; // Set the previous room to the current room
        }
        return null;
    }

    private List<Door> reconstructPath(Map<Room, Door> cameFrom, Room current) {
        List<Door> path = new ArrayList<>();
        while (cameFrom.containsKey(current)) {
            Door door = cameFrom.get(current);
            path.add(door);
            current = current.enter(door);
        }
        Collections.reverse(path);
        return path;
    }

    // Determine distance between two rooms based on room number 💀💀💀
    private int heuristicCost(Room current, Room goal) {
        return Math.abs(current.getID() - goal.getID());
    }

    // Temporary Node class from previous project
    private static class Node implements Comparable<Node> {
        Room room;
        Door cameFromDoor;
        int gScore;
        int fScore;

        Node(Room room, Door cameFromDoor, int gScore, int fScore) {
            this.room = room;
            this.cameFromDoor = cameFromDoor;
            this.gScore = gScore;
            this.fScore = fScore;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.fScore, other.fScore);
        }
    }

    public static void main(String[] args) {
        SmartBot bot = new SmartBot();
        bot.load();
        bot.run();
    }
}