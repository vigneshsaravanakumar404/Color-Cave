import java.util.*;

public class SmartBot {

    private Room currRoom;
    private AbstractRoomLoader loader;
    private String str;

    public void load() {
        loader = new RoomLoader();
        loader.load();
        loader.deserialize("CycleMonster.ser");
        currRoom = loader.getStart();
        str = "[" + currRoom.getID() + "]";
    }

    public void run() {
        while (!currRoom.equals(loader.getEnd())) {
            List<Door> path = aStarSearch(currRoom, loader.getEnd());
            if (path == null) {
                System.out.println("No path found!");
                return;
            }

            for (Door d : path) {
                str += " -> " + d;
                currRoom = currRoom.enter(d);
                str += " -> [" + currRoom.getID() + "]";
            }
        }
        System.out.println("Found the End! " + Room.getNumMoves() + " steps");
        System.out.println(str);
    }

    private List<Door> aStarSearch(Room start, Room goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Map<Room, Door> cameFrom = new HashMap<>();
        Map<Room, Integer> gScore = new HashMap<>();
        Map<Room, Integer> fScore = new HashMap<>();

        openSet.add(new Node(start, null, 0, heuristicCost(start, goal)));
        gScore.put(start, 0);
        fScore.put(start, heuristicCost(start, goal));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            Room currentRoom = current.room;

            if (currentRoom.equals(goal)) {
                return reconstructPath(cameFrom, currentRoom);
            }

            for (Door d : currentRoom.getDoors()) {
                Room neighborRoom = currentRoom.enter(d);
                int tentativeGScore = gScore.getOrDefault(currentRoom, Integer.MAX_VALUE) + 1;

                if (tentativeGScore < gScore.getOrDefault(neighborRoom, Integer.MAX_VALUE)) {
                    cameFrom.put(neighborRoom, d);
                    gScore.put(neighborRoom, tentativeGScore);
                    fScore.put(neighborRoom, tentativeGScore + heuristicCost(neighborRoom, goal));
                    openSet.add(new Node(neighborRoom, d, tentativeGScore, fScore.get(neighborRoom)));
                }
            }
        }
        return null; // No path found
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

    private int heuristicCost(Room current, Room goal) {
        return Math.abs(current.getID() - goal.getID());
    }

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
