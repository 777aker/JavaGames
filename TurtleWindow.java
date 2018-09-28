import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class TurtleWindow extends JFrame {

	private final static Dimension SCREEN_SIZE = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	boolean bgchange = true;
	static Turtle t1 = new Turtle();
	static Turtle t2 = new Turtle();
	static Turtle t3 = new Turtle();
	static Turtle t4 = new Turtle();
	static Turtle t5 = new Turtle();
	static Turtle t6 = new Turtle();
	static Color[] purples = new Color[15];
	
	
	public TurtleWindow() {
		this.setSize(SCREEN_SIZE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.addKeyListener(new KeyListener());
	}
	
	public static void main(String[] args) {
		
		TurtleWindow tw = new TurtleWindow();
		purples[0] = new Color(181, 100, 227);
		purples[1] = new Color(216, 191, 216);
		purples[2] = new Color(221, 160, 221);
		purples[3] = new Color(238, 130, 238);
		purples[4] = new Color(218, 112, 214);
		purples[5] = new Color(255, 0, 255);
		purples[6] = new Color(186, 85, 211);
		purples[7] = new Color(147, 112, 219);
		purples[8] = new Color(138, 43, 226);
		purples[9] = new Color(148, 0, 211);
		purples[10] = new Color(153, 50, 204);
		purples[11] = new Color(139, 0, 139);
		purples[12] = new Color(128, 0, 128);
		purples[13] = new Color(75, 0, 130);
		//pick one to run
		//one();
		//two(); //throws null, gotta fix 
		//three(); 
		//four();  
		//five();
		//tree();//not tested yet
		//skeleton();//just so someone can make there own turtle to do stuff easily
		
	}
	
	
	public static void skeleton() {
		int posx = 0;
		int posy = 0;
		int number = 0;
		while(number < 10 && posx < SCREEN_SIZE.width) {
			Turtle turtle = new Turtle();
			Thread tt = new Thread(turtle);
			turtle.moveto(posx, posy);
			if(posy >= SCREEN_SIZE.height) {
				posy = 100;
				posx += 500;
			} else {
				posy += 500;
			}
			number++;
			turts.add(turtle);
			tt.start();
		}
		for(int i = 0; i < 1000; i++) {
			for(Turtle t: turts) {
				
			}
		}
	}
	
	static ArrayList<Turtle> turts = new ArrayList<Turtle>();
	static ArrayList<Thread> tts = new ArrayList<Thread>();
	
	public static void mathShapes() {
		
		for(Thread tt: tts) {
			tt.start();
		}
	}
	
	public static void tree() {
		Turtle turt1 = new Turtle();
		Thread tt1 = new Thread(turt1);
		turt1.tColor(Color.CYAN);
		turt1.moveto((SCREEN_SIZE.width/2) - 100, SCREEN_SIZE.height);
		turt1.forward(1);
		turt1.right(-90);
		turt1.forward(550);
		Turtle turt2 = new Turtle();
		Thread tt2 = new Thread(turt2);
		turt2.tColor(Color.CYAN);
		turt2.moveto((SCREEN_SIZE.width/2) + 100, SCREEN_SIZE.height);
		turt2.forward(1);
		turt2.right(-90);
		turt2.forward(550);
		turts.add(turt1);
		turts.add(turt2);
		tts.add(tt1);
		tts.add(tt2);
		
		int length = 500;
		while(length > 0) {
			int it = 1;
			for(Turtle turt: turts) {
				turt.forward(length);
				if(it % 2 == 0) {
					turt.right(20);
				} else {
					turt.right(-20);
				}
				it++;
			}
			length -= 50;
		}
		for(Thread ttz: tts) {
			ttz.start();
		}
	}
	
	public static void five() {
		int number = 0;
		while(number < 10) {
			Turtle turtle = new Turtle();
			Thread tt = new Thread(turtle);
			turtle.tColor(new Color(120, number * 10, 120));
			number++;
			turts.add(turtle);
			tts.add(tt);
		}
		for(int i = 0; i < 1000; i++) {
			int it = 2;
			for(Turtle t: turts) {
				t.forward(i*4);
				t.right(360/it);
				if(it <= 10) {
					it += 1;
				} else  {
					it = 1;
				}
			}
		}
		for(Thread tt: tts) {
			tt.start();
		}
	}
	
	public static void four() {
		int posx = 0;
		int posy = 0;
		int number = 0;
		while(number < 50 && posx < SCREEN_SIZE.width) {
			Turtle turtle = new Turtle();
			Thread tt = new Thread(turtle);
			posx = (int) (Math.random()*SCREEN_SIZE.width);
			posy = (int) (Math.random()*SCREEN_SIZE.height);
			turtle.moveto(posx, posy);
			turtle.tColor(Color.CYAN);
			number++;
			turts.add(turtle);
			tt.start();
		}
		for(int i = 0; i < 1000; i++) {
			for(Turtle t: turts) {
				t.forward(i);
				t.right(120);
				t.forward(i);
				t.right(120);
				t.forward(120);
				t.right(150);
				t.forward(i);
			}
		}
	}
	
	public static void three() {
		int posx = 150;
		int posy = 100;
		while(posx <= SCREEN_SIZE.width) {
			Turtle turtle = new Turtle();
			Thread tt = new Thread(turtle);
			turtle.moveto(posx, posy);
			if(posy >= SCREEN_SIZE.height) {
				posy = 100;
				posx += 500;
			} else {
				posy += 500;
			}
			turts.add(turtle);
			tt.start();
		}
		for(int i = 1; i < 1000; i++) {
			for(Turtle t: turts) {
				t.tColor(purples[(int)(Math.random()*15)]);
				for(int f = 1; f <= 10; f++) {
					t.forward(i);
					t.right(36);
				}
				t.forward(i);
				t.right(360/i);
				for(int f = 1; f <= 9; f++) {
					t.tColor(purples[(int)(Math.random()*15)]);
					t.forward(20);
					t.right(40);
				}
			}
		}
	}
	
	public static void two() {
		for(int i = 0; i < 9; i++) {
			Turtle turtle = new Turtle();
			turtle.speed(1);
			turtle.tColor(Color.MAGENTA);
			Thread tt = new Thread(turtle);
			turts.add(turtle);
			tt.start();
		}
		for(int i = 0; i < 1000; i++) {
			int it = 0;
			for(Turtle t: turts) {
				for(int f = 0; f < 6; f++) {
					t.forward(i);
					t.right(60);
				}
				t.forward(i*it);
				t.right(30);
				t.tColor(new Color((it*it)*3, it*20,(it*it)*3));
				t.speed(it);
				it++;
			}
		}
	}
	
	public static void one() {
		
		t1.tColor(Color.RED);
		t1.speed(1);
		t1.moveto(SCREEN_SIZE.width/2, 300);
		for(int i = 0; i < 999; i++) {
			t1.forward(1);
			t1.right(i);
			t1.forward(20);
		}
		
		t2.speed(1);
		t2.penWidth(5);
		t2.moveto(SCREEN_SIZE.width/2, SCREEN_SIZE.height-200);
		int r = 0;
		int b = 0;
		int g = 0;
		for(int i = 0; i < 10000; i++) {
			r += (int) (Math.random() * 10);
			b += (int) (Math.random() * 10);
			g += (int) (Math.random() * 10);
			if(r > 255)
				r = 0;
			if(g > 255)
				g = 0;
			if(b > 255)
				b = 0;
			t2.forward(i*10);
			t2.right(120);
			t2.forward(i*10);
			t2.right(120);
			t2.forward(i*10);
			t2.right(150);
			t2.forward(i*10);
			t2.tColor(new Color(r, g, b));
		}
		
		t3.speed(1);
		t3.moveto(SCREEN_SIZE.width - 500, SCREEN_SIZE.height - 500);
		t3.tColor(Color.MAGENTA);
		t3.penWidth(1);
		for(int i = 0; i < 1000; i++) {
			t3.forward(i);
			t3.right(120);
			t3.forward(i);
			t3.right(120);
			t3.forward(i);
			t3.right(150);
			t3.forward(1);
		}
		
		t4.speed(1);
		t4.moveto(500, 500);
		for(int i = 0; i < 1000; i++) {
			t4.forward(i);
			t4.right(120);
			t4.forward(i);
			t4.right(120);
			t4.forward(i);
			t4.right(i);
			t4.forward(1);
		}
		
		t5.moveto(1000, SCREEN_SIZE.height - 500);
		t5.tColor(Color.BLUE);
		for(int i = 0; i < 1000; i += 5) {
			t5.forward(i);
			t5.right(30);
			t5.forward(i);
			t5.right(30);
			t5.forward(i);
			t5.right(30);
			t5.forward(i);
			t5.right(30);
			t5.forward(i);
			t5.right(30);
			t5.forward(20);
			t5.right(90);
			t5.forward(20);
		}
		
		t6.moveto(SCREEN_SIZE.width - 500, 500);
		t6.speed(1);
		t6.tColor(Color.PINK);
		for(int i = 0; i < 1000; i++) {
			t6.forward(i);
			t6.right(120);
			t6.forward(i);
			t6.right(120);
			t6.forward(120);
			t6.right(150);
			t6.forward(i);
		}
		
		Thread tu1 = new Thread(t1);
		Thread tu2 = new Thread(t2);
		Thread tu3 = new Thread(t3);
		Thread tu4 = new Thread(t4);
		Thread tu5 = new Thread(t5);
		Thread tu6 = new Thread(t6);
		tu1.start();
		tu2.start();
		tu3.start();
		tu4.start();
		tu5.start();
		tu6.start();
		
	}
	
	int t = 0;
	@Override
	public void paint(Graphics g) {
		if(bgchange) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height);
			bgchange = false;
		}
		t1.draw(g);
		t2.draw(g);
		t3.draw(g);
		t4.draw(g);
		t5.draw(g);
		t6.draw(g);
		if(!turts.isEmpty()) {
			int size = turts.size();
			for(int i = 0; i < size; i++) {
				turts.get(i).draw(g);
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
