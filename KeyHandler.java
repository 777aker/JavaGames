import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//handles all the key typing and inputs 
public class KeyHandler extends KeyAdapter {
	
	//this format is used for every method
	//this method is when a key is pressed
	public void keyPressed(KeyEvent e) {
		
		//exits program if esc is typed
		if(e.getKeyCode() == e.VK_ESCAPE) {
			System.exit(0);
		}
	}
	
	//this method is for when a key is released
	public void keyReleased(KeyEvent e) {
			
	}
	
	//this method is for when a key is pressed
	//then released soon after
	public void keyTyped(KeyEvent e) {
		
	}
	
}
