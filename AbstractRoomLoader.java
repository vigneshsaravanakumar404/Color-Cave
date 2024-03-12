import java.util.HashMap;
import java.awt.Color;
import java.io.*;
public class AbstractRoomLoader implements Serializable {

	Room start, end;

	public AbstractRoomLoader(){
		load();
		serialize();
	}

	public abstract void load(){

		// Load up all rooms and doors and add to
		// your cave.  Also set start and end rooms
		Room r1 = new Room(">>>  Room 1  <<<","");
		Room r2 = new Room(">>>  Room 2  <<<","");
		Room r3 = new Room(">>>  Room 3  <<<","");
		Room r4 = new Room(">>>  Room 4  <<<","");
		r1.addDoor(Door.RED,r2);
		r1.addDoor(Door.GREEN,r3);
		r2.addDoor(Door.BLUE,r3);
		r3.addDoor(Door.PINK,r4);
		start = r1;
		end = r4;

	}

	public Room getStart(){
		return start;
	}

	public Room getEnd(){
		return end;
	}

	public void serialize(){
		String filename = "file.ser";

		// Serialization
		try
		{
				//Saving of object in a file
				FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file);

				// Method for serialization of object
				out.writeObject(this);

				out.close();
				file.close();

				System.out.println("RoomLoader has been serialized to =>"+fileName);

		}

		catch(IOException ex)
		{
				System.out.println("IOException is caught");
		}

	}

public RoomLoader deserialize(String fileName){
	RoomLoader rL = null;
		try
		{
				// Reading the object from a file
				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file);

				// Method for deserialization of object
				rL = (RoomLoader)in.readObject();

				in.close();
				file.close();

				System.out.println("Object has been deserialized ");
				System.out.println("Start = "+rL.getStart()+", end = "+rL.getEnd());
		}

		catch(IOException ex)
		{
				System.out.println("IOException is caught");
		}

		catch(ClassNotFoundException ex)
		{
				System.out.println("ClassNotFoundException is caught");
		}

		return rL;

}

	public static void main(String[]args){
		RoomLoader rL = new RoomLoader();
		rL.deserialize("file.ser");

	}


}