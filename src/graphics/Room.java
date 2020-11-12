package graphics;

import java.awt.Container;
import java.awt.EventQueue;

import java.awt.Graphics2D;

import java.awt.Font;

import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cards.Card;
import context.ContextGuard;
import model.*;
import sound.Sound;

public class Room extends JFrame {
	
	private Player playerActual;
//	protected Deck deck = new Deck();
//	protected Card card;

	private Game game;
	
	private static Font enchantedFont = MyFont.createFont();
	
	private int posCartasJugadasX;
	private int posCartasJugadasY;
	
	private int posCartasJugadasX1 = 300;
	private int posCartasJugadasY1 = 300;
	
	private int posCartasJugadasX2 = 300;
	private int posCartasJugadasY2 = 160;
	
	private int tamCartasJugadasX = 74;
	private int tamCartasJugadasY = 103;
	
	private int posCarta1X = 500;
	private int posCarta1Y = 373;
	private int posCarta2X = 650;
	private int posCarta2Y = 373;
	
	private int tamCartaX = 148;
	private int tamCartaY = 206;
	
	private int offset = 60;
	
	private CardPanel cp1;
	private CardPanel cp2;
	
	private int turn = 1;
	
	

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
		
		game = new Game(player1, player2);
		
		Sound music;
		try {
			music = new Sound("src/sound/allstar.wav");
			music.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		playerActual = game.getPlayerOnTurn();
		
		inicioRonda(playerActual);
		
		posCartasJugadasX = posCartasJugadasX1;
		posCartasJugadasY = posCartasJugadasY1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 10, 1280, 720);
		Container contentPane = getContentPane();
		contentPane.add(back);
		back.setLayout(null);

		DeckPanel deckPanel = new DeckPanel();
		deckPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(playerActual.getCard2() == null) {
					game.grabCard(playerActual);

					cp2.setPath(playerActual.getCard2().getImagePath());
					cp2.setVisible(true);
					back.repaint();


					cp1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							cp1.onFocusCard(getGraphics(), posCarta1X, posCarta1Y);
							super.mouseEntered(e);		
						}

						@Override
						public void mouseExited(MouseEvent e) {
							cp1.lostFocus(getGraphics(), posCarta1X, posCarta1Y);
							back.repaint();
							super.mouseExited(e);
						}
						@Override
						public void mouseClicked(MouseEvent e) {
							
							
						
							refreshCartasJugadas(cp1.getPath());
							cp1.setPath(cp2.getPath());
							back.remove(cp2);
							back.remove(cp1);
							back.repaint();
							
							
							// Aca se llama
							 playCard(game, playerActual.getCard1(), contentPane);
							
							//Esto no iria aca:
//							playerActual.setCard1(playerActual.getCard2());
//							playerActual.setCard2(null);
							
							//ESTO LO DEBERIA HACER GAME:
//							if (player1.isTurn()) {
//								player1.setTurn(false);
//								player2.setTurn(true);
//								playerActual = player2;
//							}
//							else {
//								player2.setTurn(false);
//								player1.setTurn(true);
//								playerActual = player1;
//							}
							
							
							cambioTurno(playerActual, contentPane);

						}
					});

					cp2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							cp2.onFocusCard(getGraphics(), posCarta2X, posCarta2Y);;
							super.mouseEntered(e);							
						}
						@Override
						public void mouseExited(MouseEvent e) {
							cp2.lostFocus(getGraphics(), posCarta2X, posCarta2Y);				
							back.repaint();
							super.mouseExited(e);
						}
						@Override
						public void mouseClicked(MouseEvent e) {
//						cp2.setBounds(posCartasJugadasX, posCartasJugadasY, tamCartasJugadasX, tamCartasJugadasY);
//						posCartasJugadasX += offset;

							refreshCartasJugadas(cp2.getPath());
							//cp2.setVisible(false);
							back.remove(cp2);
							
							back.repaint();
							game.getPlayerOnTurn().setPoints(6);
							// Aca se llama
							playCard(game, playerActual.getCard2(), contentPane);
							
							//Esto no iria aca:
//							playerActual.setCard2(null);
							
//							//ESTO LO DEBERIA HACER GAME:
//							if (player1.isTurn()) {
//								player1.setTurn(false);
//								player2.setTurn(true);
//								playerActual = player2;
//							}
//							else {
//								player2.setTurn(false);
//								player1.setTurn(true);
//								playerActual = player1;
//							}
							
							cambioTurno(playerActual, contentPane);

						}
					});
				
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "No vale cartearse", "",JOptionPane.WARNING_MESSAGE );
				}

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
	
	private void inicioRonda(Player playerActual) {
		cp1 = new CardPanel(playerActual.getCard1().getImagePath());
		cp1.setVisible(true);
		cp1.setBounds(posCarta1X, posCarta1Y, tamCartaX, tamCartaY);

		back.add(cp1);
		
		cp2 = new CardPanel();
		cp2.setVisible(false);
		cp2.setBounds(posCarta2X, posCarta2Y, tamCartaX, tamCartaY);
		
		back.add(cp2);
		
	}
	
	private void refreshCartasJugadas(String path) {
		CardPanel cpAux = new CardPanel(path);
		cpAux.setVisible(true);
		cpAux.setBounds(posCartasJugadasX, posCartasJugadasY, tamCartasJugadasX, tamCartasJugadasY);

		back.add(cpAux);
				
		posCartasJugadasX += offset;
		
		if (turn % 2 == 0) {
			posCartasJugadasX2 += offset;		
		}
		else {
			posCartasJugadasX1 += offset;	
		}

	}
	
	private void cambioTurno(Player player, Container contentPane) {
		playerActual = player;
		
		back.remove(cp1);
		back.remove(cp2);
		
		JOptionPane.showMessageDialog(contentPane, "Pase el mando al "+game.getPlayerOnTurn().getName(), "Cambio de turno",JOptionPane.WARNING_MESSAGE );

		
		turn++;
		
		refreshPantalla();
	}
	
	private void refreshPantalla() {
		back.remove(cp1);
		back.remove(cp2);
		
		if (turn % 2 == 0) {
			posCartasJugadasX = posCartasJugadasX2;
			posCartasJugadasY = posCartasJugadasY2;			
		}
		else {
			posCartasJugadasX = posCartasJugadasX1;
			posCartasJugadasY = posCartasJugadasY1;	
		}
		
		inicioRonda(playerActual);
		
		back.repaint();
	}
	
	public void playCard(Game game, Card card, Container contentPane) {
		
		if(card.getName() == "Guardia") {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GraphicGuard frame2 = new GraphicGuard(game);
						frame2.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			

		}else {
			
		}
		
		
	}
	
}
