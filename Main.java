import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	//Double buffering
	Image dbImage;
	Graphics dbg;
	
	//Ball objects
	static Ball b = new Ball(193, 143);
	
	//Threads, duh
	Thread ball = new Thread(b);
	Thread p1 = new Thread(b.p1);
	Thread p2 = new Thread(b.p2);
	Thread p3 = new Thread(b.p3);
	Thread p4 = new Thread(b.p4);
	
	boolean hardDifficulty = false;
	public static boolean teams = false;
	public static boolean fplayers = false;
	
	//Game started or nahhh variable
	boolean gameStarted = false;
	
	boolean sHover;
	boolean qHover;
	boolean pHover;
	boolean tHover;
	
	//Menu Buttons
	Rectangle startButton = new Rectangle(150, 100, 100, 25);
	Rectangle difficultyButton = new Rectangle(150, 150, 100, 25);
	Rectangle players = new Rectangle(150, 200, 100, 25);
	Rectangle team = new Rectangle(150, 250, 100, 25);
	//Variables for screen size
	int
	GWIDTH = 1200,
	GHEIGHT = 900;
	//Dimension of GWIDTH*GHEIGHT
	Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
	
	//Create constructor to spawn window
	public Main() {
		this.setTitle("Copy of Pong 3.1");
		this.setSize(screenSize);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.addKeyListener(new AL());
		this.addMouseListener(new MouseHandler());
		this.addMouseMotionListener(new MouseHandler());
		this.setLocationRelativeTo(null);
	}
	
	public void startGame() {
		gameStarted = true;
		ball.start();
		p1.start();
		p2.start();
		if(fplayers) {
		p3.start();
		p4.start();
		}
	}
	
	public static void main(String[] args){
		
		Main m = new Main();
		
	}
	
	@Override
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		draw(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void draw(Graphics g){
		if(!gameStarted) {
			//Menu
			g.setFont(new Font("Arial", Font.BOLD, 26));
			g.setColor(Color.WHITE);
			g.drawString("Pong Game!", 125, 75);
			if(!sHover)
				g.setColor(Color.CYAN);
			else
				g.setColor(Color.PINK);
			g.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.setColor(Color.GRAY);
			g.drawString("Start Game", startButton.x+20, startButton.y+17);
			if(!qHover)
				g.setColor(Color.CYAN);
			else
				g.setColor(Color.PINK);
			g.fillRect(difficultyButton.x, difficultyButton.y, difficultyButton.width, difficultyButton.height);
			g.setColor(Color.GRAY);
			g.drawString("Difficulty: ", difficultyButton.x+5, difficultyButton.y+17);
			if(!hardDifficulty) {
				g.setColor(Color.BLUE);
				g.drawString("Easy", difficultyButton.x+65, difficultyButton.y+17);
			}
			else {
				g.setColor(Color.RED);
				g.drawString("Hard", difficultyButton.x+65, difficultyButton.y+17);
			}
			if(!pHover)
				g.setColor(Color.CYAN);
			else
				g.setColor(Color.PINK);
			g.fillRect(players.x, players.y, players.width, players.height);
			g.setColor(Color.GRAY);
			g.drawString("Players: ", players.x+5, players.y+17);
			if(!fplayers) {
				g.setColor(Color.BLUE);
				g.drawString("2", players.x+65, players.y+17);
			}else {
				g.setColor(Color.RED);
				g.drawString("4", players.x+65, players.y+17);
			}
			if(fplayers) {
				if(!tHover)
					g.setColor(Color.CYAN);
				else
					g.setColor(Color.PINK);
					g.fillRect(team.x, team.y, team.width, team.height);
					g.setColor(Color.GRAY);
					g.drawString("Teams: ", team.x+5, team.y+17);
				if(!teams) {
					g.setColor(Color.BLUE);
					g.drawString("false", team.x+65, team.y+17);
				}else {
					g.setColor(Color.RED);
					g.drawString("true", team.x+65, team.y+17);
				}
			}
		}
		else {
			//Game drawings
			b.draw(g);
			b.p1.draw(g);
			b.p2.draw(g);
			if(fplayers) {
			b.p3.draw(g);
			b.p4.draw(g);
			}
			//Scores
			g.setColor(Color.WHITE);
			if(!teams) {
				g.drawString(""+b.p1Score, 15, 450);
				g.drawString(""+b.p2Score, 1170, 450);
				if(fplayers) {
					g.drawString(""+b.p3Score, 600, 50);
					g.drawString(""+b.p4Score, 600, 850);
				}
				g.setFont(new Font("Arial", Font.BOLD, 26));
				g.setColor(Color.WHITE);
				g.drawString("Matthew is not allowed to win", 525, 100);
			}else {
				g.drawString(""+b.t1Score, 15, 50);
				g.drawString(""+b.t2Score, 1170, 850);
			}
			//lines
			if(!fplayers) {
				g.setColor(Color.CYAN);
				g.drawRect(95, 0, 5, 900);
				g.setColor(Color.PINK);
				g.drawRect(1100, 0, 5, 900);
			}else {
				if(!teams) {
					g.setColor(Color.CYAN);
					g.drawRect(0, 100, 100, 700);
					g.setColor(Color.RED);
					g.drawRect(100, 800, 1000, 100);
					g.setColor(Color.BLUE);
					g.drawRect(100, 0, 1000, 100);
					g.setColor(Color.PINK);
					g.drawRect(1100, 100, 100, 700);
				}else {
					g.setColor(Color.CYAN);
					g.drawRect(0, 100, 100, 700);
					g.drawRect(100, 0, 1000, 100);
					g.setColor(Color.PINK);
					g.drawRect(100, 800, 1000, 100);
					g.drawRect(1100, 100, 100, 700);
				}
			}
			
		}
		
		repaint();
	}
	
	/////////EVENT LISTENER CLASS/////////
	public class AL extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			b.p1.keyPressed(e);
			b.p2.keyPressed(e);
			if(fplayers) {
			b.p3.keyPressed(e);
			b.p4.keyPressed(e);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			b.p1.keyReleased(e);
			b.p2.keyReleased(e);
			if(fplayers) {
			b.p3.keyReleased(e);
			b.p4.keyReleased(e);
			}
		}
	}
	
	public class MouseHandler extends MouseAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			if(mx > startButton.x && mx < startButton.x+startButton.width && my > startButton.y && my < startButton.y+startButton.height)
				sHover = true;
			else
				sHover = false;
			if(mx > difficultyButton.x && mx < difficultyButton.x+difficultyButton.width && my > difficultyButton.y && my < difficultyButton.y+difficultyButton.height)
				qHover = true;
			else
				qHover = false;
			if(mx > players.x && mx < players.x+players.width && my > players.y && my < players.y+players.height)
				pHover = true;
			else
				pHover = false;
			if(mx > team.x && mx < team.x+team.width && my > team.y && my < team.y+team.height)
				tHover = true;
			else
				tHover = false;
		}
		@Override
		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			if(mx > startButton.x && mx < startButton.x+startButton.width && my > startButton.y && my < startButton.y+startButton.height)
				startGame();
			if(mx > difficultyButton.x && mx < difficultyButton.x+difficultyButton.width && my > difficultyButton.y && my < difficultyButton.y+difficultyButton.height)
				if(!hardDifficulty) {
					b.setDifficulty(4);
					hardDifficulty = true;
				}
				else {
					b.setDifficulty(7);
					hardDifficulty = false;
				}
			if(mx > players.x && mx < players.x+players.width && my > players.y && my < players.y+players.height) {
				if(!fplayers) {
					fplayers = true;
				}else {
					fplayers = false;
				}
			}
			if(mx > team.x && mx < team.x+team.width && my > team.y && my < team.y+team.height) {
				if(!teams)
					teams = true;
				else
					teams = false;
			}
			}
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}
	/////////END EVENT LISTENER CLASS/////////
	
}
