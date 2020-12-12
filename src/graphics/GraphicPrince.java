package graphics;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import context.ContextKing;
import context.ContextPrince;
import model.Game;
import model.Player;
import cards.*;

public class GraphicPrince extends JDialog {

	private static final long serialVersionUID = -6035664481149193723L;

	private JPanel playersPanel;
	
	private static Font enchantedFont = MyFont.createFont();

	
	public GraphicPrince(Game game, Room room, Container contentPane) {
		setTitle("Elige un Juagdor");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 450, 400);
		setModal(true);
		playersPanel = new JPanel();
		playersPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(playersPanel);
		playersPanel.setLayout(null);
		int offset=0;
		int cont = 0;
		String players[] = new String [4];
		
		for(int i = 0; i< game.getPlayerList().size(); i++) {
			players[i] = game.getPlayerList().get(i).getName();
		}
		for(int i = 0; i< game.getPlayerList().size(); i++) {
			if(game.getPlayerList().get(i).isAlive() && !game.getPlayerList().get(i).isProtected()) {
				
				JButton button = new JButton(players[i]);
				button.setText(players[i]);
				
				button.setVisible(true);
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String targetName = button.getText();
						setTitle("Tu nueva carta es:");
						setBounds(350, 100, 450, 400);
						playersPanel.removeAll();
						playersPanel.repaint();
						
						Player target = obtainPlayer(game, targetName);
						Player onTurn = game.getPlayerOnTurn();
						
						JOptionPane.showMessageDialog(playersPanel, "Descartaste tu carta y levantaste otra" , "Atención",JOptionPane.WARNING_MESSAGE );
						dispose();
						
						Card prince = new Prince();
						ContextPrince context = new ContextPrince(onTurn, target, prince, game.getDeck());
						
						game.playCard(onTurn, context, prince);
						room.checkRoundGraphic(game, contentPane);	
						
						
						
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

				cont++;
			}
		}
		
		if (cont == 0) {
			JLabel label = new JLabel("No hay jugadores para elegir");
			label.setBounds(10, 100, 200, 100);
			contentPane.add(label);
			label.setFont(enchantedFont);
			playersPanel.add(label);

			JButton bOk = new JButton();
			bOk.setText("Ok");
			bOk.setVisible(true);
			bOk.setBounds(10, 200, 200, 100);

			bOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					game.setTurn();
					room.checkRoundGraphic(game, contentPane);
					dispose();
				}
			});

			playersPanel.add(bOk);
		}
	}
}