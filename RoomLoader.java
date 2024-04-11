public class RoomLoader extends AbstractRoomLoader {

    public RoomLoader() {
        cave = new CaveData();
        load();
        serialize("Mazes/Aryan.ser");
    }

    @Override
    public void load() {

        Room r0 = new Room(">>> Room 0 <<<", "");
        Room r1 = new Room(">>> Room 1 <<<", "");
        Room r2 = new Room(">>> Room 2 <<<", "");
        Room r3 = new Room(">>> Room 3 <<<", "");
        Room r4 = new Room(">>> Room 4 <<<", "");
        Room r5 = new Room(">>> Room 5 <<<", "");
        Room r6 = new Room(">>> Room 6 <<<", "");
        Room r7 = new Room(">>> Room 7 <<<", "");
        Room r8 = new Room(">>> Room 8 <<<", "");
        Room r9 = new Room(">>> Room 9 <<<", "");
        Room r10 = new Room(">>> Room 10 <<<", "");
        Room r11 = new Room(">>> Room 11 <<<", "");
        Room r12 = new Room(">>> Room 12 <<<", "");
        Room r13 = new Room(">>> Room 13 <<<", "");
        Room r14 = new Room(">>> Room 14 <<<", "");
        Room r15 = new Room(">>> Room 15 <<<", "");
        Room r16 = new Room(">>> Room 16 <<<", "");
        Room r17 = new Room(">>> Room 17 <<<", "");
        Room r18 = new Room(">>> Room 18 <<<", "");
        Room r19 = new Room(">>> Room 19 <<<", "");
        Room r20 = new Room(">>> Room 20 <<<", "");
        Room r21 = new Room(">>> Room 21 <<<", "");
        Room r22 = new Room(">>> Room 22 <<<", "");
        Room r23 = new Room(">>> Room 23 <<<", "");
        Room r24 = new Room(">>> Room 24 <<<", "");
        Room r25 = new Room(">>> Room 25 <<<", "");
        Room r26 = new Room(">>> Room 26 <<<", "");
        Room r27 = new Room(">>> Room 27 <<<", "");
        Room r28 = new Room(">>> Room 28 <<<", "");
        Room r29 = new Room(">>> Room 29 <<<", "");
        Room r30 = new Room(">>> Room 30 <<<", "");
        Room r31 = new Room(">>> Room 31 <<<", "");
        Room r32 = new Room(">>> Room 32 <<<", "");
        Room r33 = new Room(">>> Room 33 <<<", "");
        Room r34 = new Room(">>> Room 34 <<<", "");
        Room r35 = new Room(">>> Room 35 <<<", "");
        Room r36 = new Room(">>> Room 36 <<<", "");
        Room r37 = new Room(">>> Room 37 <<<", "");
        Room r38 = new Room(">>> Room 38 <<<", "");
        Room r39 = new Room(">>> Room 39 <<<", "");
        Room r40 = new Room(">>> Room 40 <<<", "");

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

        r36.addDoor(Door.YELLOW, r32);

        r32.addDoor(Door.PINK, r31);
        r32.addDoor(Door.RED, r23);
        r32.addDoor(Door.BLUE, r22);

        r31.addDoor(Door.RED, r22);

        r23.addDoor(Door.GREEN, r22);

        r22.addDoor(Door.YELLOW, r21);

        r21.addDoor(Door.PINK, r20);
        r21.addDoor(Door.GREEN, r18);
        r21.addDoor(Door.BLUE, r19);

        r20.addDoor(Door.RED, r19);

        r19.addDoor(Door.YELLOW, r18);

        r18.addDoor(Door.RED, r17);

        r27.addDoor(Door.YELLOW, r16);

        r16.addDoor(Door.PINK, r11);
        r16.addDoor(Door.RED, r5);
        r16.addDoor(Door.BLUE, r6);

        r11.addDoor(Door.RED, r6);

        r6.addDoor(Door.GREEN, r5);

        r24.addDoor(Door.BLUE, r5);
        r30.addDoor(Door.YELLOW, r11);
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
        cave.addRoom(r32);
        cave.addRoom(r31);
        cave.addRoom(r23);
        cave.addRoom(r22);
        cave.addRoom(r21);
        cave.addRoom(r20);
        cave.addRoom(r19);
        cave.addRoom(r18);
        cave.addRoom(r17);
        cave.addRoom(r16);
        cave.addRoom(r11);
        cave.addRoom(r6);
        cave.addRoom(r5);

        cave.setStart(r0);
        cave.setEnd(r17);
    }

}