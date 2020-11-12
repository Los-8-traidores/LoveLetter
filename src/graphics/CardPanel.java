package graphics;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CardPanel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5198975502489925420L;
	private Image image;
	private String path;
	
	public CardPanel() {
		
	}
	
	public CardPanel(String path) {
		this.path = path;
	}
	
    @Override
    public void paint(Graphics g) {
    	
    	image = new ImageIcon(getClass().getResource("/img/" + path + ".png")).getImage();
    	
    	g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    	setOpaque(false);
    	
        super.paint(g);
    }
    
    public void onFocusCard (Graphics g, int posX, int posY) {
    	image = new ImageIcon(getClass().getResource("/img/" + path + "Glow" + ".png")).getImage();
    	
    	g.drawImage(image, posX, posY, (int)Math.round(getWidth()*1.5), (int)Math.round(getHeight()*1.5), this);
    	setOpaque(false);
    	
        super.paint(g);
    }
    
    public void lostFocus (Graphics g, int posX, int posY) {
    	image = new ImageIcon(getClass().getResource("/img/"+ path +".png")).getImage();
    
    	g.drawImage(image, posX, posY, getWidth(), getHeight(), this);
    	setOpaque(false);

    	
        super.paint(g);
    }
    
    public String getPath() {
		return path;
	}
    
    public void setPath(String path) {
		this.path = path;
	}
}