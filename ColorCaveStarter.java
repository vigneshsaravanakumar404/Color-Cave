import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ColorCaveStarter extends JPanel implements MouseListener
{
	ArrayList<Option> options;
	Room room, end;
	JFrame frame;
	AbstractRoomLoader loader;
	boolean started;
	boolean won;

	public ColorCaveStarter()
	{
		loader = new RoomLoader();
		loader.deserialize("Aryan.ser");
		loader.load();
		room = loader.getStart();
		end = loader.getEnd();
		options = new ArrayList<>();
		frame = new JFrame("Color Cave");
		frame.setSize(1000,1000);
		frame.add(this);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		started = false;
		won = false;
	}

	class Option
	{
		public Rectangle target;
		public Door door;

		public Option(Rectangle target, Door door)
		{
			this.target = target;
			this.door = door;
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);

		g2.fillRect(0,0,frame.getWidth(),frame.getHeight());

		if(started && !won)
		{
			////////////// HEADER /////////////////
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 100));
			g2.drawString("COLOR CAVE!", 140, 200);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString(room.getName(), 20, 675);
			g2.drawString(room.getDescription(), 20, 750);
			g2.drawString("Time: " + Room.getNumMoves(), 20, 825);
			g2.drawString("Number of Moves: " + Room.getNumMoves(), 20, 900);

			/////////// PAINT DOORS ///////////////
			Set<Door> doors = room.getDoors();
			int spacing = (1000 - doors.size() * 200) / (doors.size() + 1);
			int x = spacing;
			for(Door door : doors) 
			{
				options.add(new Option(new Rectangle(x, 300, 150, 300), door));
				x += 200 + spacing;

				g2.setColor(enumToColor(door));
				g2.fill(options.get(options.size() - 1).target);
			}
		}
		else if(!started)
		{

		}
		else if(won)
		{

		}
	}

	public void mouseClicked(MouseEvent e)
	{
		if(started && !won)
		{
			for(Option option : options)
			{
				if(option.target.contains(e.getX(), e.getY()))
				{
					room = room.enter(option.door);
					if(room.equals(end))
					{
						won = true;
					}
				}
			}
		}
		else if(!started)
		{

		}
		else if(won)
		{

		}
		
		options.clear();
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