public class RoomLoader extends AbstractRoomLoader{

    public RoomLoader(){
        cave = new CaveData();
        load();
        serialize("RedGreenStart.ser");
    }

    @Override
    public void load() {
        // TODO Auto-generated method stub
        // Load up all rooms and doors and add to
        // your cave.  Also set start and end rooms

        Room r1 = new Room(">>>  Room 1  <<<","");
        Room r2 = new Room(">>>  Room 2  <<<","");
        Room r3 = new Room(">>>  Room 3  <<<","");
        Room r4 = new Room(">>>  Room 4  <<<","");
        Room r5 = new Room(">>>  Room 4  <<<","");
        Room r6 = new Room(">>>  Room 4  <<<","");
        Room r7 = new Room(">>>  Room 4  <<<","");
        
        r1.addDoor(Door.RED,r3);
        r1.addDoor(Door.BLUE,r2);

        r2.addDoor(Door.GREEN, r3);
        r2.addDoor(Door.YELLOW, r4);

        r3.addDoor(Door.PINK, r4);
        r3.addDoor(Door.BLUE, r7);

        r4.addDoor(Door.RED, r6);
        r4.addDoor(Door.BLUE, r5);

        r6.addDoor(Door.BLUE, r7);

        cave.addRoom(r1);
        cave.addRoom(r2);
        cave.addRoom(r3);
        cave.addRoom(r4);
        cave.addRoom(r5);
        cave.addRoom(r6);
        cave.addRoom(r7);

        cave.setStart(r1);
        cave.setEnd(r7);
    }

}