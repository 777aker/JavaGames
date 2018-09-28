package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {
	
	public static final Color GREEN = new Color(1666073);
	
	String winner;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Snake snake = Snake.snake;
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1500, 850);
		g.setColor(Color.CYAN);
		
		for(Point point : snake.snakeParts) {
			
			g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
			
		}
		
		g.setColor(Color.PINK);
		
		for(Point point : snake.snake2Parts) {
			
			g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
			
		}
		
		g.setColor(Color.CYAN);
		g.fillRect(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		g.setColor(Color.PINK);
		g.fillRect(snake.head2.x * Snake.SCALE, snake.head2.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		g.setColor(Color.MAGENTA);
		g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		String string = "Score: " + snake.score + ", P1 Length: " + snake.tailLength + ", P2 Length: " + snake.tailLength2 + ", Time: " + snake.time / 20;
		g.setColor(Color.RED);
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);
		
		if(snake.over) {
			g.drawString("Game Over!", (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
			if(Snake.loser == 1) {
				g.drawString("P2 Wins!", (int) (getWidth() / 2 - string.length() * 2.5f), (int) (snake.dim.getHeight() / 4)+20);
			}else if(Snake.loser == 2) {
				g.drawString("P1 Wins!", (int) (getWidth() / 2 - string.length() * 2.5f), (int) (snake.dim.getHeight() / 4)+20);
			}
		}
		
		string = "Paused!";
		if(snake.paused && !snake.over) {
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}
		
	}
	
}
