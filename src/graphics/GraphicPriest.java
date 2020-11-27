package graphics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cards.Card;
import cards.Guard;
import cards.Priest;
import context.ContextGuard;
import context.ContextPriest;
import model.Game;
import model.Player;

public class GraphicPriest extends JDialog{
	
	
	private static final long serialVersionUID = -5909258688050224976L;
	
	private JPanel playersPanel;
	
	
	public GraphicPriest(Game game, Room room, Container contentPane) {
		setTitle("Elige un Juagdor");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 450, 400);
		setModal(true);
		playersPanel = new JPanel();
		playersPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(playersPanel);
		playersPanel.setLayout(null);
		int offset=0;
		String players[] = new String [4];
		
		for(int i = 0; i< game.getPlayerList().size(); i++) {
			players[i] = game.getPlayerList().get(i).getName();
		}
		for(int i = 0; i< game.getPlayerList().size(); i++) {
			if(game.getPlayerList().get(i).isAlive() && game.getPlayerList().get(i) != game.getPlayerOnTurn() && !game.getPlayerList().get(i).isProtected()) {
				
				JButton button = new JButton(players[i]);
				button.setText(players[i]);
				
				button.setVisible(true);
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String targetName = button.getText();
						setTitle("La carta de " + targetName + " es:");
						setBounds(350, 100, 450, 400);
						playersPanel.removeAll();
						playersPanel.repaint();
						
						JButton oponentCard = new JButton();
						Player target = obtainPlayer(game, targetName);
						
						
						oponentCard.setText(target.getCard1().getName());
						oponentCard.setVisible(true);
						oponentCard.setBounds(210, 50, 200, 50);
						oponentCard.addActionListener(new ActionListener() {
						
							@Override
							public void actionPerformed(ActionEvent e) {
								//Ver si podemos mejorar todo y ademas usar el ContextPriest
								game.playCard(game.getPlayerOnTurn(), new ContextPriest(target), new Priest());
								room.checkRoundGraphic(game, contentPane);
								dispose();
								
							}
						});
						playersPanel.add(oponentCard);					
						
					}
					private Player obtainPlayer(Game game, String playerName) {
						for(int i = 0; i< game.getPlayerList().size(); i++) {
							if(game.getPlayerList().get(i).getName() == playerName)
								return game.getPlayerList().get(i);
						}
						return null;
						
					}
				});
				button.setBounds(10, 10+offset, 200, 100);
				
				playersPanel.add(button);
				offset+=120;
				
				
				
				
			}
		}
	}	
}
