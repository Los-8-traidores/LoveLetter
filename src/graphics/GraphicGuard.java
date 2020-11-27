package graphics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import context.ContextGuard;
import model.Game;
import model.Player;
import cards.*;

public class GraphicGuard extends JDialog {

	private static final long serialVersionUID = -3449182262328049673L;

	
	private JPanel playersPanel;
//	protected Player target;
	
	
	public GraphicGuard(Game game, Room room, Container contentPane) {
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
		String cardList[] = {"Sacerdote", "Baron", "Mucama", "Principe", "Rey", "Condesa", "Princesa"};
		
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
						setTitle("Adivina su carta");
						String targetName = button.getText();
						setBounds(350, 100, 450, 400);
						playersPanel.removeAll();
						playersPanel.repaint();
						int offset1 = 0;
						int offset2 = 0;
						
						for(int i = 0; i <7 ; i++) {
							JButton card = new JButton(cardList[i]);
							card.setText(cardList[i]);
							
							card.setVisible(true);
							
							card.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {

									Player target = obtainPlayer(game, targetName);

									Card guard = new Guard();
									ContextGuard context = new ContextGuard(game.getPlayerOnTurn(), target, guard, card.getText());
									game.playCard(game.getPlayerOnTurn(), context, guard);
									
									if(context.getAcierto()) {
										JOptionPane.showMessageDialog(playersPanel, "Se elimin� al jugador: "+ button.getText(), "Hubo Acierto",JOptionPane.WARNING_MESSAGE );
											room.checkRoundGraphic(game, contentPane);

									}else {
										
										JOptionPane.showMessageDialog(playersPanel, "Nadie fu� eliminado", "No Hubo Acierto",JOptionPane.WARNING_MESSAGE );
										room.checkRoundGraphic(game, contentPane);
									}
									
									dispose();
									
								}

								private Player obtainPlayer(Game game, String playerName) {
									for(int i = 0; i< game.getPlayerList().size(); i++) {
										if(game.getPlayerList().get(i).getName() == playerName)
											return game.getPlayerList().get(i);
									}
//									return game.getPlayerList().get(0);
									return null;
									
								}
							});
							
							if(i>4){
								card.setBounds(210, 10+offset2, 200, 50);
								offset2+=50;
							}else {
								card.setBounds(10, 10+offset1, 200, 50);
							}
							
							
							playersPanel.add(card);
							offset1+=50;
						}
						

					}
				});
				button.setBounds(10, 10+offset, 200, 100);
				
				playersPanel.add(button);
				offset+=120;
				
				
				
				
			}
		}
		
		
	}
	
	
}
