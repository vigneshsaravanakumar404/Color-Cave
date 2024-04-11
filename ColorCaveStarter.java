import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ColorCaveStarter extends JPanel implements MouseListener
{
	ArrayList<Rectangle> rooms;
	Room room, end;
	JFrame frame;
	AbstractRoomLoader loader;

	public ColorCaveStarter()
	{
		loader = new RoomLoader(); //need to extend abstract with concrete class
		loader.deserialize("Aryan.ser");
		loader.load();
		room = loader.getStart();
		end = loader.getEnd();
		rooms = new ArrayList<>();
		frame = new JFrame("Color Cave");
		frame.setSize(1000,1000);
		frame.add(this);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);

		g2.fillRect(0,0,frame.getWidth(),frame.getHeight());

		////////////// HEADER /////////////////
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.BOLD, 44));
		g2.drawString("COLOR CAVE!",80, 40);
		g2.setFont(new Font("Arial", Font.BOLD, 24));
		//g2.drawString(room.getName(),80, 80);					// uncomment when you have a room object
		//g2.drawString(room.getDescription(),80, 120);
		g2.drawString("Number of Moves: " + Room.getNumMoves(),80, 600);

		/////////// PAINT DOORS ///////////////
		Set<Door> doors = room.getDoors();
		rooms.clear();
		int spacing = (1000 - doors.size() * 200) / (doors.size() + 1);
		int x = spacing;
		for(Door door : doors) 
		{
			rooms.add(new Rectangle(x, 200, 150, 300));
			x += 200 + spacing;

			g2.setColor(enumToColor(door));
			g2.fill(rooms.get(rooms.size() - 1));
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		/*if (r.contains(e.getX(),e.getY()))
		{
			System.out.println("Inside the Rectangle");
			/* Move from room to next room */
		/*} 
		else {
			System.out.println("Outside the Rectangle");
		}*/
		repaint();
	}

	// Other mouse listener methods we don't need to use
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	private Color enumToColor(Door d)
	{
		switch(d)
		{
			case RED: return Color.RED;
			case BLUE: return Color.BLUE;
			case GREEN: return Color.GREEN;
			case PINK: return Color.PINK;
			case YELLOW: return Color.YELLOW;

			default:
				return Color.WHITE;
		}

	}

	public static void main(String[] args)
	{
		new ColorCaveStarter();
	}
}