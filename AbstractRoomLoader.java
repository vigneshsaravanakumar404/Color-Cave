import java.io.*;

public abstract class AbstractRoomLoader implements Serializable {

	protected Room start, end;

	public abstract void load();

	public abstract Room getStart();

	public abstract Room getEnd();

	/**
	 * Serializes the current instance of the AbstractRoomLoader class and saves it
	 * to a file.
	 * 
	 * @param fileName the name of the file to save the serialized object to
	 */
	public void serialize(String fileName) {

		try {

			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(this);
			out.close();
			file.close();

			System.out.println("RoomLoader has been serialized to =>" + fileName);

		}

		catch (IOException ex) {
			System.out.println("IOException is caught => " + ex);
		}

	}

	/**
	 * Deserializes an AbstractRoomLoader object from the specified file.
	 *
	 * @param fileName the name of the file to deserialize from
	 * @return the deserialized AbstractRoomLoader object
	 */
	public class AbstractRoomLoader {

		public AbstractRoomLoader deserialize(String fileName) {
			AbstractRoomLoader rL = null;
			try {
				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file);

				rL = (AbstractRoomLoader) in.readObject();

				in.close();
				file.close();

				System.out.println("Object has been deserialized from file " + fileName);
				System.out.println("Start = " + rL.getStart() + ", end = " + rL.getEnd());
			} catch (IOException ex) {
				System.out.println("IOException is caught => " + ex);
			} catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException is caught => " + ex);
			}

			return rL;
		}
	}

}