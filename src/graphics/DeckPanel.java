package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cards.Card;
import model.Deck;

public class DeckPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8537744878005923285L;
	private Image image;

    @Override
    public void paint(Graphics g) {
    	
    	image = new ImageIcon(getClass().getResource("/img/backCard.png")).getImage();
    	
    	g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    	setOpaque(false);
    	
        super.paint(g);
    }
}
