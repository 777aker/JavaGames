import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle implements Runnable {
	
	int x, y, yDirection, xDirection, id;
	
	Rectangle paddle; 
	
	public Paddle(int x, int y, int id) {
		int pw, ph;
		this.x = x;
		this.y = y;
		this.id = id;
		if(this.id <= 2) {
			pw = 10;
			ph = 50;
		}else {
			pw = 50;
			ph = 10;
		}
		paddle = new Rectangle(x, y, pw, ph);
	}
	
	public void keyPressed(KeyEvent e){
		switch(id) {
			default:
				System.out.println("Please enter a valid ID in Paddle constructor");
				break;
			case 1:
				if(e.getKeyCode() == e.VK_W) {
					setYDirection(-1);
				}
				if(e.getKeyCode() == e.VK_S) {
					setYDirection(+1);
				}
				if(e.getKeyCode() == e.VK_A) {
					setXDirection(-1);
				}
				if(e.getKeyCode() == e.VK_D) {
					setXDirection(+1);
				}
				break;
			case 2:
				if(e.getKeyCode() == e.VK_UP) {
					setYDirection(-1);
				}
				if(e.getKeyCode() == e.VK_DOWN) {
					setYDirection(+1);
				}
				if(e.getKeyCode() == e.VK_LEFT) {
					setXDirection(-1);
				}
				if(e.getKeyCode() == e.VK_RIGHT) {
					setXDirection(+1);
				}
				break;
			case 3:
				if(e.getKeyCode() == e.VK_I) {
					setYDirection(-1);
				}
				if(e.getKeyCode() == e.VK_K) {
					setYDirection(+1);
				}
				if(e.getKeyCode() == e.VK_J) {
					setXDirection(-1);
				}
				if(e.getKeyCode() == e.VK_L) {
					setXDirection(+1);
				}
				break;
			case 4:
				if(e.getKeyCode() == e.VK_NUMPAD5) {
					setYDirection(-1);
				}
				if(e.getKeyCode() == e.VK_NUMPAD2) {
					setYDirection(+1);
				}
				if(e.getKeyCode() == e.VK_NUMPAD1) {
					setXDirection(-1);
				}
				if(e.getKeyCode() == e.VK_NUMPAD3) {
					setXDirection(+1);
				}
				break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		switch(id) {
			default:
				System.out.println("Please enter a valid ID in Paddle constructor");
				break;
			case 1:
				if(e.getKeyCode() == e.VK_W) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_S) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_A) {
					setXDirection(0);
				}
				if(e.getKeyCode() == e.VK_D) {
					setXDirection(0);
				}
				break;
			case 2:
				if(e.getKeyCode() == e.VK_UP) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_DOWN) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_LEFT) {
					setXDirection(0);
				}
				if(e.getKeyCode() == e.VK_RIGHT) {
					setXDirection(0);
				}
				break;
			case 3:
				if(e.getKeyCode() == e.VK_I) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_K) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_J) {
					setXDirection(0);
				}
				if(e.getKeyCode() == e.VK_L) {
					setXDirection(0);
				}
				break;
			case 4:
				if(e.getKeyCode() == e.VK_NUMPAD5) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_NUMPAD2) {
					setYDirection(0);
				}
				if(e.getKeyCode() == e.VK_NUMPAD1) {
					setXDirection(0);
				}
				if(e.getKeyCode() == e.VK_NUMPAD3) {
					setXDirection(0);
				}
				break;
		}
		
	}
	
	public void setYDirection(int ydir) {
		yDirection = ydir;
	}
	
	public void setXDirection(int xdir) {
		xDirection = xdir;
	}
	
	public void move() {
		paddle.y += yDirection;
		paddle.x += xDirection;
		if(!Main.fplayers) {
			switch(id) {
			default:
				System.out.println("You done broke the id's");
				break;
			case 1:
				if(paddle.y <= 0)
					paddle.y = 0;
				if(paddle.x <= 0)
					paddle.x = 0;
				if(paddle.y >= 850)
					paddle.y = 850;
				if(paddle.x >= 1095)
					paddle.x = 1095;
				break;
			case 2:
				if(paddle.y <= 0)
					paddle.y = 0;
				if(paddle.x <= 100)
					paddle.x = 100;
				if(paddle.y >= 850)
					paddle.y = 850;
				if(paddle.x >= 1190)
					paddle.x = 1190;
				break;
			}
		}else {
			if(!Main.teams) {
				switch(id) {
				default:
					System.out.println("Id's are still broken");
					break;
				case 1:
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.x <= 100 && paddle.y <= 0)
						paddle.y = 0;
					if(paddle.x <= 100 && paddle.y >= 850)
						paddle.y = 850;
					if(paddle.y <= 50 && paddle.x >= 90)
						paddle.x = 90;
					if(paddle.x >= 90 && paddle.y >= 800)
						paddle.x = 90;
					if(paddle.x >= 100 && paddle.y <= 100)
						paddle.y = 100;
					if(paddle.x >= 100 && paddle.y >= 750)
						paddle.y = 750;
					if(paddle.x >= 1090)
						paddle.x = 1090;
					break;
				case 2:
					if(paddle.x >= 1190)
						paddle.x = 1190;
					if(paddle.x <= 100)
						paddle.x = 100;
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.y >= 850)
						paddle.y = 850;
					if(paddle.y >= 750 && paddle.x <= 1090)
						paddle.y = 750;
					if(paddle.y <= 100 && paddle.x <= 1090)
						paddle.y = 100;
					if(paddle.y <= 50 && paddle.x <= 1100)
						paddle.x = 1100;
					if(paddle.y >= 800 && paddle.x <= 1100)
						paddle.x = 1100;
					break;
				case 3:
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.x >= 1150)
						paddle.x = 1150;
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.y >= 790)
						paddle.y = 790;
					if(paddle.x >= 1050 && paddle.y >= 100)
						paddle.x = 1050;
					if(paddle.x <= 100 && paddle.y >= 100)
						paddle.x = 100;
					if(paddle.x <= 50 && paddle.y >= 90)
						paddle.y = 90;
					if(paddle.x >= 1100 && paddle.y >= 90)
						paddle.y = 90;
					break;
				case 4:
					if(paddle.y >= 890)
						paddle.y = 890;
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.x >= 1150)
						paddle.x = 1150;
					if(paddle.x <= 100 && paddle.y <= 790)
						paddle.x = 100;
					if(paddle.x >= 1050 && paddle.y <= 790)
						paddle.x = 1050;
					if(paddle.y <= 100)
						paddle.y = 100;
					if(paddle.x <= 50 && paddle.y <= 800)
						paddle.y = 800;
					if(paddle.x >= 1100 && paddle.y <= 800)
						paddle.y = 800;
					break;
				}
			}else {
				switch(id) {
				default:
					System.out.println("Their id's are broken");
					break;
				case 1:
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.y >= 850)
						paddle.y = 850;
					if(paddle.x >= 1190)
						paddle.x = 1190;
					if(paddle.x >= 90 && paddle.y >= 800)
						paddle.x = 90;
					if(paddle.x >= 1110 && paddle.y >= 50)
						paddle.y = 50;
					if(paddle.x >= 1090 && paddle.y >= 100)
						paddle.x = 1090;
					if(paddle.y >= 750 && paddle.x >= 100)
						paddle.y = 750;
					break;
				case 2:
					if(paddle.x >= 1190)
						paddle.x = 1190;
					if(paddle.y >= 850)
						paddle.y = 850;
					if(paddle.x <= 90 && paddle.y <= 800)
						paddle.y = 800;
					if(paddle.x <= 100 && paddle.y <= 750)
						paddle.x = 100;
					if(paddle.x <= 1100 && paddle.y <= 50)
						paddle.x = 1100;
					if(paddle.y <= 100 && paddle.x <= 1090)
						paddle.y = 100;
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.x <= 0)
						paddle.x = 0;
					break;
				case 3:
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.x >= 1150)
						paddle.x = 1150;
					if(paddle.y >= 890)
						paddle.y = 890;
					if(paddle.x >= 50 && paddle.y >= 800)
						paddle.x = 50;
					if(paddle.y >= 90 && paddle.x >= 1100)
						paddle.y = 90;
					if(paddle.x >= 100 && paddle.y >= 790)
						paddle.y = 790;
					if(paddle.y >= 100 && paddle.x >= 1050)
						paddle.x = 1050;
					break;
				case 4:
					if(paddle.x <= 0)
						paddle.x = 0;
					if(paddle.y <= 0)
						paddle.y = 0;
					if(paddle.x >= 1150)
						paddle.x = 1150;
					if(paddle.y >= 890)
						paddle.y = 890;
					if(paddle.x <= 50 && paddle.y <= 800)
						paddle.y = 800;
					if(paddle.y <= 90 && paddle.x <= 1100)
						paddle.x = 1100;
					if(paddle.x <= 1050 && paddle.y <= 100)
						paddle.y = 100;
					if(paddle.y <= 790 && paddle.x <= 100)
						paddle.x = 100;
					break;
				}
			}
		}
	}
	
	public void draw(Graphics g) {
		switch(id) {
			default:
				System.out.println("Please enter a valid ID in Paddle constructor");
				break;
			case 1:
				g.setColor(Color.CYAN);
				g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
				break;
			case 2:
				g.setColor(Color.PINK);
				g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
				break;
			case 3:
				if(!Main.teams)
					g.setColor(Color.BLUE);
				else
					g.setColor(Color.CYAN);
				g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
				break;
			case 4:
				if(!Main.teams)
					g.setColor(Color.RED);
				else
					g.setColor(Color.PINK);
				g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
				break;
		}
	}
	
	@Override
	public void run() {
		try{
			while(true){
				move();
				Thread.sleep(5);
			}
			
		}catch(Exception e){System.err.println(e.getMessage());}
	}
	
}
