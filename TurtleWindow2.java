import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class TurtleWindow2 extends JFrame {

	private final static Dimension SCREEN_SIZE = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	boolean bgchange = true;	
	ArrayList<Turtle> turts = new ArrayList<Turtle>();
	ArrayList<Thread> tts = new ArrayList<Thread>();
	
	public TurtleWindow2() {
		this.setSize(SCREEN_SIZE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.addKeyListener(new KeyListener());
	}
	
	public static void main(String[] args) {
		
		TurtleWindow2 tw = new TurtleWindow2();
		
		tw.doStuff();
		
	}
	
	public void doStuff() {
		
		
		for(Thread tt: tts) {
			tt.start();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(bgchange) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height);
			bgchange = false;
		}
		if(!turts.isEmpty()) {
			for(Turtle t: turts) {
				t.draw(g);
			}
		}
		repaint();
	}

	public class KeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == e.VK_ESCAPE) {
				System.exit(0);
			}
		}
	}
	
}
