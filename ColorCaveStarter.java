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
	long startTime;
	double currentTime;
	Rectangle button;

	public ColorCaveStarter()
	{
		loader = new RoomLoader();
		loader.deserialize("Aryan.ser");
		loader.load();
		room = loader.getStart();
		end = loader.getEnd();
		options = new ArrayList<>();
		started = false;
		won = false;

		frame = new JFrame("Color Cave");
		frame.setSize(1000,1000);
		frame.add(this);
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		button = new Rectangle(300, 700, 400, 100);

		new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
			public void run() 
			{
				if(started && !won)
				{
					currentTime = (Math.round((System.currentTimeMillis() - startTime) / 100)) / 10.0;
					
					repaint();
				}
			}
		}, 0, 100);
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

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 600, frame.getWidth(), frame.getHeight() - 600);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(20));
		g2.drawRect(10, 10, frame.getWidth() - 35, frame.getHeight() - 35);

		if(started && !won)
		{
			////////////// HEADER /////////////////
			g2.setColor(Color.DARK_GRAY);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 100));
			g2.drawString("COLOR CAVE!", 140, 200);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString(room.getName(), 20, 675);
			g2.drawString(room.getDescription(), 20, 750);
			g2.drawString("Time: " + currentTime, 20, 825);
			g2.drawString("Number of Moves: " + Room.getNumMoves(), 20, 900);

			/////////// PAINT DOORS ///////////////
			Set<Door> doors = room.getDoors();
			options.clear();

			int spacing = (1000 - doors.size() * 200) / (doors.size() + 1);
			int x = spacing + 15;

			for(Door door : doors) 
			{
				options.add(new Option(new Rectangle(x, 300, 150, 300), door));

				g2.setColor(enumToColor(door));
				g2.fill(options.get(options.size() - 1).target);
				g2.setColor(new Color(g2.getColor().getRed() / 2, g2.getColor().getGreen() / 2, g2.getColor().getBlue() / 2));
				g2.fillRect(x + 10, 310, 60, 135);
				g2.fillRect(x + 80, 310, 60, 135);
				g2.fillRect(x + 10, 455, 60, 135);
				g2.fillRect(x + 80, 455, 60, 135);
				g2.setColor(Color.ORANGE);
				g2.fillOval(x + 10, 440, 20, 20);

				x += 200 + spacing;
			}
		}
		else if(!started)
		{
			g2.setColor(Color.DARK_GRAY);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 100));
			g2.drawString("COLOR CAVE!", 140, 200);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString("Instructions", 375, 300);
			g2.setFont(new Font("Century Gothic", Font.PLAIN, 36));
			g2.drawString("1. Navigate the maze by clicking on doors.", 100, 360);
			g2.drawString("2. Each door leads to its corresponding room.", 100, 410);
			g2.drawString("3. Try to reach the end as quick as possible!", 100, 460);
			g2.drawString("4. Click BEGIN to start.", 100, 510);
			g2.setColor(Color.BLACK);
			g2.fill(button);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString("BEGIN", 435, 765);
		}
		else if(won)
		{
			g2.setColor(Color.DARK_GRAY);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 100));
			g2.drawString("COLOR CAVE!", 140, 200);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString("GAME OVER", 350, 300);
			g2.setFont(new Font("Century Gothic", Font.PLAIN, 36));
			g2.drawString("Total Time: " + currentTime, 350, 360);
			g2.drawString("Total Moves: " + Room.getNumMoves(), 350, 410);
			g2.setColor(Color.BLACK);
			g2.fill(button);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g2.drawString("EXIT", 460, 765);
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
			if(button.contains(e.getX(), e.getY()))
			{
				started = true;
				startTime = System.currentTimeMillis();
			}
		}
		else if(won)
		{
			if(button.contains(e.getX(), e.getY()))
			{
				System.exit(0);
			}
		}

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