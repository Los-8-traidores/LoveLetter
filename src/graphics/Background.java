package graphics;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;



public class Background extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8666574576151415843L;
	private Image image;
	
    @Override
    public void paint(Graphics g) {
    	
    	image = new ImageIcon(getClass().getResource("/img/tablero.png")).getImage();
    	
    	g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    	setOpaque(false);
    	
        super.paint(g);
    }
}
