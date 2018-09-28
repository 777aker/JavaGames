import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {
	
	//Global variables
	int x, y, xDirection, yDirection;
	
	int difficulty = 7;
	
	//Score
	int p1Score, p2Score, p3Score, p4Score, t1Score, t2Score;
	
	Paddle p1 = new Paddle(15, 140, 1);
	Paddle p2 = new Paddle(1150, 140, 2);
	Paddle p3 = new Paddle(450, 140, 3);
	Paddle p4 = new Paddle(450, 850, 4);
	
	Rectangle ball = new Rectangle();
	
	public Ball(int x, int y) {
		p1Score = p2Score = p3Score = p4Score = 0;
		this.x = x;
		this.y = y;
		//Set ball moving randomly
		Random r = new Random();
		int rDir = r.nextInt(1);
		if(rDir==0)
			rDir--;
		setXDirection(rDir);
		int yrDir = r.nextInt(1);
		if(yrDir==0)
			yrDir--;
		setYDirection(yrDir);
		//Create 'ball'
		ball = new Rectangle(this.x, this.y, 7, 7);
	}
	
	public void setXDirection(int xdir) {
		xDirection = xdir;
	}
	public void setYDirection(int ydir) {
		yDirection = ydir;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}
	
	public void collision() {
		if(ball.intersects(p1.paddle)) {
			if(xDirection == -1) {
				setXDirection(+1);
			}else if(xDirection == +1) {
				setXDirection(-1);
			}
		}
		if(ball.intersects(p2.paddle)) {
			if(xDirection == -1) {
				setXDirection(+1);
			}else if(xDirection == +1) {
				setXDirection(-1);
			}
		}
		if(Main.fplayers) {
			if(ball.intersects(p3.paddle)) {
				if(yDirection == -1) {
					setYDirection(+1);
				}else if(yDirection == +1) {
					setYDirection(-1);
				}
			}
			if(ball.intersects(p4.paddle)) {
				if(yDirection == -1) {
					setYDirection(+1);
				}else if(yDirection == +1) {
					setYDirection(-1);
				}
			}
		}
	}
	
	public void move(){
		collision();
		ball.x += xDirection;
		ball.y += yDirection;
		//Bounce the ball when edge is detected
		if(ball.x <= 0) {
			setXDirection(+1);
			if(!Main.teams)
				p2Score++;
			else
				t2Score++;
		}
		if(ball.x >= 1193) {
			setXDirection(-1);
			if(!Main.teams)
				p1Score++;
			else
				t1Score++;
		}
		if(ball.y <= 23) {
			setYDirection(+1);
			if(!Main.teams)
				p4Score++;
			else
				t2Score++;
		}
		if(ball.y >= 893) {
			setYDirection(-1);
			if(!Main.teams)
				p3Score++;
			else
				t1Score++;
		}
	}
	
	@Override
	public void run() {
		try{
			while(true) {
				move();
				Thread.sleep(difficulty);
			}
			
		}catch(Exception e){System.err.println(e.getMessage());}
	}
	
	public void setDifficulty(int diff) {
		difficulty = diff;
	}
	
}
