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
import javax.swing.SwingUtilities;

import cards.Card;
import model.*;

public class Room extends JFrame {
	
	private Player playerActual;
//	protected Deck deck = new Deck();
//	protected Card card;

	private Game game;
	private int posCartasJugadasX = 300;
	private int posCartasJugadasY = 300;
	private int tamCartasJugadasX = 74;
	private int tamCartasJugadasY = 103;
	
	private int posCarta1X = 500;
	private int posCarta1Y = 373;
	private int posCarta2X = 650;
	private int posCarta2Y = 373;
	
	private int tamCartaX = 148;
	private int tamCartaY = 206;
	
	private int offset = 60;
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8255156140862271631L;
	private JLayeredPane back = new Background();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Room frame = new Room();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param player2
	 * @param player1
	 */
	public Room(Player player1, Player player2) {

//		deck.fillDeck();
//		deck.shuffleDeck();

		game = new Game(player1, player2);
		
		playerActual = player1;
		
		CardPanel cp1 = inicioRonda(playerActual);
		
//		CardPanel cp1 = new CardPanel(playerActual.getCard1().getImagePath());
//		cp1.setVisible(true);
//		cp1.setBounds(posCarta1X, posCarta1Y, tamCartaX, tamCartaY);
//
//		back.add(cp1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		Container contentPane = getContentPane();
		contentPane.add(back);
		back.setLayout(null);

		DeckPanel deckPanel = new DeckPanel();
		deckPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.grabCard(playerActual);
				
				CardPanel cp2 = new CardPanel(playerActual.getCard2().getImagePath());
				cp2.setVisible(true);
				cp2.setBounds(posCarta2X, posCarta2Y, tamCartaX, tamCartaY);

				back.add(cp2);
				repaint();
				
				
				cp1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
//						cp1.setBounds(posCartasJugadasX, posCartasJugadasY, tamCartasJugadasX, tamCartasJugadasY);
//						posCartasJugadasX += offset;
						
						refreshCartasJugadas(cp1);
						cp1.setVisible(false);
						
						
						//playerActual = player2;
						//repaint();
						
						//inicioRonda(playerActual);
						
						// Se deberia pasar el turno al otro jugador y se deberian crear los context segun la carta
						
						
					}
				});
				
				cp2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
//						cp2.setBounds(posCartasJugadasX, posCartasJugadasY, tamCartasJugadasX, tamCartasJugadasY);
//						posCartasJugadasX += offset;
						
						refreshCartasJugadas(cp2);
						cp2.setVisible(false);
						
						
						//playerActual = player2;
						//repaint();
						
						//inicioRonda(playerActual);
						
						// Se deberia pasar el turno al otro jugador y se deberian crear los context segun la carta
					}
				});

//				else {
//					JOptionPane.showMessageDialog(contentPane, "El maso esta vacío", "Fin de la partida",JOptionPane.WARNING_MESSAGE );
//				}

			}
		});
		deckPanel.setBounds(147, 134, 118, 169);
		back.add(deckPanel);
		deckPanel.setLayout(null);
	}

	public Room(Player player1, Player player2, Player player3) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		Container contentPane = getContentPane();
		contentPane.add(back);
		back.setLayout(null);

		DeckPanel deckPanel = new DeckPanel();
		deckPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

//				if(deck.notEmptyDeck()){
//					card = deck.drawCard();
//					CardPanel cp = new CardPanel(card.getImagePath());
//					cp.setVisible(true);
//					cp.setBounds(606, 373, 148, 206);
//					
//					back.add(cp);
//				}
//				else {
//					JOptionPane.showMessageDialog(contentPane, "El maso esta vacío", "Fin de la partida",JOptionPane.WARNING_MESSAGE );
//				}

			}
		});
		deckPanel.setBounds(147, 134, 118, 169);
		back.add(deckPanel);
		deckPanel.setLayout(null);
	}

	public Room(Player player1, Player player2, Player player3, Player player4) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		Container contentPane = getContentPane();
		contentPane.add(back);
		back.setLayout(null);
		
		DeckPanel deckPanel = new DeckPanel();
		deckPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				if(deck.notEmptyDeck()){
//					card = deck.drawCard();
//					CardPanel cp = new CardPanel(card.getImagePath());
//					cp.setVisible(true);
//					cp.setBounds(606, 373, 148, 206);
//					
//					back.add(cp);
//				}
//				else {
//					JOptionPane.showMessageDialog(contentPane, "El maso esta vacío", "Fin de la partida",JOptionPane.WARNING_MESSAGE );
//				}
				

			}
		});
		deckPanel.setBounds(147, 134, 118, 169);
		back.add(deckPanel);
		deckPanel.setLayout(null);
	}
	
	private CardPanel inicioRonda(Player playerActual) {
		CardPanel cp = new CardPanel(playerActual.getCard1().getImagePath());
		cp.setVisible(true);
		cp.setBounds(posCarta1X, posCarta1Y, tamCartaX, tamCartaY);

		back.add(cp);
		
		return cp;
		
	}
	
	private void refreshCartasJugadas(CardPanel cp) {
		CardPanel cpAux = new CardPanel(cp.getPath());
		cpAux.setVisible(true);
		cpAux.setBounds(posCartasJugadasX, posCartasJugadasY, tamCartasJugadasX, tamCartasJugadasY);

		back.add(cpAux);
		
		posCartasJugadasX += offset;
	}


}
