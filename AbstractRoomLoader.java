import java.io.*;
public abstract class AbstractRoomLoader implements Serializable {

	protected Room start, end;

	public abstract void load();

	public abstract Room getStart();

	public abstract Room getEnd();

	public void serialize(String fileName){
		// Serialization
		try
		{
				//Saving of object in a file
				FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(file);

				// Method for serialization of object
				out.writeObject(this);

				out.close();
				file.close();

				System.out.println("RoomLoader has been serialized to =>"+fileName);

		}

		catch(IOException ex)
		{
				System.out.println("IOException is caught => "+ex);
		}

	}

public AbstractRoomLoader deserialize(String fileName){
	AbstractRoomLoader rL = null;
		try
		{
				// Reading the object from a file
				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file);

				// Method for deserialization of object
				rL = (AbstractRoomLoader)in.readObject();

				in.close();
				file.close();

				System.out.println("Object has been deserialized  from file "+fileName);
				System.out.println("Start = "+rL.getStart()+", end = "+rL.getEnd());
		}

		catch(IOException ex)
		{
				System.out.println("IOException is caught => "+ex);
		}

		catch(ClassNotFoundException ex)
		{
				System.out.println("ClassNotFoundException is caught => "+ex);
		}

		return rL;

}

}