package graphics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import context.ContextBaron;
import model.Game;
import model.Player;
import cards.*;

public class GraphicBaron extends JDialog {
	
	private static final long serialVersionUID = 434544119756910629L;

	private JPanel playersPanel;

	
	public GraphicBaron(Game game, Room room, Container contentPane) {
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
				//Sacar de ContextBaron la validacion de si el juegador target esta protegido, ya se hace aca
				
				JButton button = new JButton(players[i]);
				button.setText(players[i]);
				
				button.setVisible(true);
				

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String targetName = button.getText();
						setTitle("Comparacion de cartas");
						setBounds(350, 100, 450, 400);
						playersPanel.removeAll();
						playersPanel.repaint();

						Player target = obtainPlayer(game, targetName);
						
						Card baron = new Baron();
						ContextBaron context = new ContextBaron(game.getPlayerOnTurn(), target, baron);
						game.playCard(game.getPlayerOnTurn(), context, baron);
						if(!target.isAlive()){
							JOptionPane.showMessageDialog(playersPanel, "Se elimina al jugador: "+ button.getText(), "Tu carta era mayor",JOptionPane.WARNING_MESSAGE );
								room.checkRoundGraphic(game, contentPane);

						}else if(!game.getPlayerOnTurn().isAlive()){
							JOptionPane.showMessageDialog(playersPanel, "Fuiste eliminado", "Tu carta era menor",JOptionPane.WARNING_MESSAGE );
							room.checkRoundGraphic(game, contentPane);
						}

						
						dispose();

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