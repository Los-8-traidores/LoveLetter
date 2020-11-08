package graphics;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import cards.Card;
import model.*;

public class Room extends JFrame {

	protected Deck deck = new Deck();
	protected Card card;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255156140862271631L;
	private JLayeredPane back = new Background();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room frame = new Room();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Room() {	
		
		deck.fillDeck();
		deck.shuffleDeck();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		Container contentPane = getContentPane();
		contentPane.add(back);
		back.setLayout(null);
		
		DeckPanel deckPanel = new DeckPanel();
		deckPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(deck.notEmptyDeck()){
					card = deck.drawCard();
					CardPanel cp = new CardPanel(card.getImagePath());
					cp.setVisible(true);
					cp.setBounds(606, 373, 148, 206);
					
					back.add(cp);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El maso esta vacío", "Fin de la partida",JOptionPane.WARNING_MESSAGE );
				}
				

			}
		});
		deckPanel.setBounds(147, 134, 118, 169);
		back.add(deckPanel);
		deckPanel.setLayout(null);
	}

}
