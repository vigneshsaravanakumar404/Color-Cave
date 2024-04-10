public class RoomLoader extends AbstractRoomLoader {

    public RoomLoader() {
        cave = new CaveData();
        load();
        serialize("Aryan.ser");
    }

    @Override
    public void load() {

        // TODO Auto-generated method stub
        // Load up all rooms and doors and add to
        // your cave. Also set start and end rooms

        Room r0 = new Room(">>> Room 0 <<<", "");
        Room r1 = new Room(">>> Room 1 <<<", "");
        Room r2 = new Room(">>> Room 2 <<<", "");
        Room r3 = new Room(">>> Room 3 <<<", "");
        Room r4 = new Room(">>> Room 4 <<<", "");
        Room r7 = new Room(">>> Room 7 <<<", "");
        Room r8 = new Room(">>> Room 8 <<<", "");
        Room r9 = new Room(">>> Room 9 <<<", "");
        Room r10 = new Room(">>> Room 10 <<<", "");
        Room r12 = new Room(">>> Room 12 <<<", "");
        Room r13 = new Room(">>> Room 13 <<<", "");
        Room r14 = new Room(">>> Room 14 <<<", "");
        Room r15 = new Room(">>> Room 15 <<<", "");
        Room r24 = new Room(">>> Room 24 <<<", "");
        Room r25 = new Room(">>> Room 25 <<<", "");
        Room r26 = new Room(">>> Room 26 <<<", "");
        Room r27 = new Room(">>> Room 27 <<<", "");
        Room r28 = new Room(">>> Room 28 <<<", "");
        Room r29 = new Room(">>> Room 29 <<<", "");
        Room r30 = new Room(">>> Room 30 <<<", "");
        Room r33 = new Room(">>> Room 33 <<<", "");
        Room r34 = new Room(">>> Room 34 <<<", "");
        Room r35 = new Room(">>> Room 35 <<<", "");
        Room r36 = new Room(">>> Room 36 <<<", "");
        Room r37 = new Room(">>> Room 37 <<<", "");
        Room r38 = new Room(">>> Room 38 <<<", "");
        Room r39 = new Room(">>> Room 39 <<<", "");
        Room r40 = new Room(">>> Room 40 <<<", "");
        Room r51 = new Room(">>> Room 51 <<<", "");
        Room r52 = new Room(">>> Room 52 <<<", "");
        Room r53 = new Room(">>> Room 53 <<<", "");
        Room r54 = new Room(">>> Room 54 <<<", "");
        Room r55 = new Room(">>> Room 55 <<<", "");
        Room r56 = new Room(">>> Room 56 <<<", "");
        Room r57 = new Room(">>> Room 57 <<<", "");
        Room r58 = new Room(">>> Room 58 <<<", "");
        Room r59 = new Room(">>> Room 59 <<<", "");
        Room r60 = new Room(">>> Room 60 <<<", "");
        Room r61 = new Room(">>> Room 61 <<<", "");
        Room r62 = new Room(">>> Room 62 <<<", "");
        Room r63 = new Room(">>> Room 62 <<<", "");

        r0.addDoor(Door.RED, r1);
        r0.addDoor(Door.GREEN, r2);
        r0.addDoor(Door.BLUE, r3);
        r0.addDoor(Door.PINK, r4);

        r1.addDoor(Door.PINK, r7);
        r1.addDoor(Door.YELLOW, r8);

        r2.addDoor(Door.RED, r9);
        r2.addDoor(Door.BLUE, r10);

        r3.addDoor(Door.RED, r12);
        r3.addDoor(Door.GREEN, r13);
        r3.addDoor(Door.PINK, r14);

        r4.addDoor(Door.RED, r15);

        r7.addDoor(Door.YELLOW, r24);

        r8.addDoor(Door.GREEN, r25);
        r8.addDoor(Door.PINK, r26);

        r9.addDoor(Door.BLUE, r27);
        r9.addDoor(Door.PINK, r28);

        r10.addDoor(Door.RED, r29);
        r10.addDoor(Door.PINK, r30);

        r12.addDoor(Door.GREEN, r33);
        r12.addDoor(Door.PINK, r34);

        r13.addDoor(Door.RED, r35);
        r13.addDoor(Door.PINK, r36);

        r14.addDoor(Door.RED, r37);
        r14.addDoor(Door.GREEN, r38);

        r15.addDoor(Door.GREEN, r39);
        r15.addDoor(Door.BLUE, r40);

        r36.addDoor(Door.YELLOW, r51);

        r51.addDoor(Door.PINK, r52);
        r51.addDoor(Door.RED, r53);
        r51.addDoor(Door.BLUE, r54);

        r52.addDoor(Door.RED, r54);

        r53.addDoor(Door.GREEN, r54);

        r54.addDoor(Door.YELLOW, r55);

        r55.addDoor(Door.PINK, r56);
        r55.addDoor(Door.GREEN, r58);
        r55.addDoor(Door.BLUE, r57);

        r56.addDoor(Door.RED, r57);

        r57.addDoor(Door.YELLOW, r58);

        r58.addDoor(Door.RED, r59);

        r27.addDoor(Door.YELLOW, r60);

        r60.addDoor(Door.PINK, r61);
        r60.addDoor(Door.RED, r63);
        r60.addDoor(Door.BLUE, r62);

        r61.addDoor(Door.RED, r62);

        r62.addDoor(Door.GREEN, r63);

        r24.addDoor(Door.BLUE, r63);
        r30.addDoor(Door.YELLOW, r61);
        r25.addDoor(Door.YELLOW, r26);
        r2.addDoor(Door.PINK, r8);
        r7.addDoor(Door.YELLOW, r40);

        cave.addRoom(r0);
        cave.addRoom(r1);
        cave.addRoom(r2);
        cave.addRoom(r3);
        cave.addRoom(r4);
        cave.addRoom(r7);
        cave.addRoom(r8);
        cave.addRoom(r9);
        cave.addRoom(r10);
        cave.addRoom(r12);
        cave.addRoom(r13);
        cave.addRoom(r14);
        cave.addRoom(r15);
        cave.addRoom(r24);
        cave.addRoom(r25);
        cave.addRoom(r26);
        cave.addRoom(r27);
        cave.addRoom(r28);
        cave.addRoom(r29);
        cave.addRoom(r30);
        cave.addRoom(r33);
        cave.addRoom(r34);
        cave.addRoom(r35);
        cave.addRoom(r36);
        cave.addRoom(r37);
        cave.addRoom(r38);
        cave.addRoom(r39);
        cave.addRoom(r40);
        cave.addRoom(r51);
        cave.addRoom(r52);
        cave.addRoom(r53);
        cave.addRoom(r54);
        cave.addRoom(r55);
        cave.addRoom(r56);
        cave.addRoom(r57);
        cave.addRoom(r58);
        cave.addRoom(r59);
        cave.addRoom(r60);
        cave.addRoom(r61);
        cave.addRoom(r62);
        cave.addRoom(r63);

        cave.setStart(r0);
        cave.setEnd(r59);
    }

}