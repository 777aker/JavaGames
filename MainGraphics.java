import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class MainGraphics extends JComponent {

	//dimensions of the screen gotten here
		private final static Dimension SCREEN_SIZE =
				new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	
	//example of font
	Font exampleFont = new Font("Calibri", Font.BOLD, 27);
	
	//if you want a specific instance or 
	//something put it in constructor here
	MainGraphics() {
		
	}
	
	//things you want to draw here 
	public void draw(Graphics g) {
		
		
		
	}
	
	public void testing() {
		
	}
	
	//double buffering graphics variables 
	Image dmImage;
	Graphics dbg;
	//set whether or not you want to use double buffering
	boolean doubleBuffer = true;
	//a variable needed for changing backgrounds or even setting
	//a background when not using double buffering
	boolean bgChange = true;
	//the painting method
	public void paint(Graphics g) {
		//decides whether or not using double buffering
		if(doubleBuffer == true) {
			//double buffering stuff dont touch
			dmImage = createImage(getWidth(), getHeight());
			dbg = dmImage.getGraphics();
			draw(dbg);
			g.drawImage(dmImage, 0, 0, this);
		} else {
			//decides if background needs updating
			if(bgChange) {
				//redraws the background
				g.setColor(getBackground());
				g.fillRect(0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height);
				bgChange = false;
			}
			//things you want to draw here 
			
		}
		//starts the paint method over so the screen is updated
		repaint();
	
	}
	
}
