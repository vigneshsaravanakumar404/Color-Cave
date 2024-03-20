import java.util.LinkedList;
import java.util.Queue;

public class IntelligentBot {

    private Room currRoom;
    private AbstractRoomLoader loader;
    private String str;

    public void load() {
        loader = new RoomLoader();
        currRoom = loader.getStart();
        str = "[" + currRoom.getID() + "]";
    }

    public void run() {
        Queue<Room> queue = new LinkedList<>();
        queue.add(currRoom);

        while (!queue.isEmpty()) {
            currRoom = queue.poll();
            str += " -> [" + currRoom.getID() + "]";

            if (currRoom.equals(loader.getEnd())) {
                System.out.println("Found the End! " + Room.getNumMoves() + " steps");
                System.out.println(str);
                return;
            }
            
            for (Door door : currRoom.getDoors()) {
                Room nextRoom = currRoom.enter(door);
                if (nextRoom != null && !nextRoom.isVisited()) {
                    nextRoom.setVisited(true);
                    queue.add(nextRoom);
                }
            }
        }

        System.out.println("End not found!");
    }

    public static void main(String[] args) {
        IntelligentBot bot = new IntelligentBot();
        bot.load();
        bot.run();
    }
}
