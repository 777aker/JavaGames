import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//handles the mouse inputs and stuff
public class MouseHandler extends MouseAdapter {

	//same exact format as keyhandler
	public void MousePressed(MouseEvent m) {
		
	}
	
	public void MouseReleased(MouseEvent m) {
		
	}
	
	public void MouseClicked(MouseEvent m) {
		
	}
	
	//if the mouse is moved updates the x and y of the mouse
	//keeps track of the mouse's x and y position
	public int mx, my;
	public void MouseMoved(MouseEvent m) {
		mx = m.getX();
		my = m.getY();
	}
	
}
