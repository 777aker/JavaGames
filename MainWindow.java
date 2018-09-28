import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	//dimensions of the screen gotten here
	public final static Dimension SCREEN_SIZE =
			new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	
	//the mouse, key, and graphics classes instantiated
	KeyHandler keyHandler = new KeyHandler();
	MouseHandler mouseHandler = new MouseHandler();
	MainGraphics mainGraphics = new MainGraphics();
	
	//creates the window and sets various properties
	public MainWindow() {
		this.setSize(SCREEN_SIZE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setBackground(Color.DARK_GRAY);
		this.addKeyListener(keyHandler);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.add(mainGraphics);
	}
	
	//starts the program
	static MainWindow mainWindow = new MainWindow();
	//the code that will execute here 
	public static void main(String[] args) {
		
	}
	
}
