public class RoomLoader extends AbstractRoomLoader {

    public RoomLoader() {
        cave = new CaveData();
        load();
        serialize("Mazes/Aryan.ser");
    }

    @Override
    public void load() {
        Room[] rooms = new Room[41];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(">>> Room " + i + " <<<", "");
        }

        rooms[0].addDoor(Door.RED, rooms[1]);
        rooms[0].addDoor(Door.GREEN, rooms[2]);
        rooms[0].addDoor(Door.BLUE, rooms[3]);
        rooms[0].addDoor(Door.PINK, rooms[4]);

        rooms[1].addDoor(Door.PINK, rooms[7]);
        rooms[1].addDoor(Door.YELLOW, rooms[8]);

        rooms[2].addDoor(Door.RED, rooms[9]);
        rooms[2].addDoor(Door.BLUE, rooms[10]);

        rooms[3].addDoor(Door.RED, rooms[12]);
        rooms[3].addDoor(Door.GREEN, rooms[13]);
        rooms[3].addDoor(Door.PINK, rooms[14]);

        rooms[4].addDoor(Door.RED, rooms[15]);

        // Add the rest of the doors similarly

        for (Room room : rooms) {
            cave.addRoom(room);
        }

        cave.setStart(rooms[0]);
        cave.setEnd(rooms[17]);
    }
}
