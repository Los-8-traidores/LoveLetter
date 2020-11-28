package graphics;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cards.Card;
import cards.Handmaid;
import cards.Princess;
import context.ContextHandmaid;
import context.ContextPrincess;
import model.Game;
import model.Player;

public class GraphicPrincess extends JDialog{

	private static final long serialVersionUID = 1816297503220369796L;
	
	private static Font enchantedFont = MyFont.createFont();
	private JPanel playersPanel;

	
	public GraphicPrincess(Game game, Room room, Container contentPane) {
//		setTitle("Mucama");
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		setBounds(350, 100, 450, 400);
//		setModal(true);
//		playersPanel = new JPanel();
//		playersPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(playersPanel);
//		playersPanel.setLayout(null);
		
//		JLabel label = new JLabel("Estás protegido hasta tu siguiente turno");
//		label.setBounds(10, 100, 200, 100);
//		contentPane.add(label);
//		label.setFont(enchantedFont);
		
//		JButton bOk = new JButton();
//		bOk.setText("Ok");
//		bOk.setVisible(true);
//		bOk.setBounds(10, 200, 200, 100);
		
		
		
		//Falla, creemos que es porque no le refresca el estado a desprotegido cuando arranca la siguiente mano
		JOptionPane.showMessageDialog(playersPanel, "Has sido eliminado" , "Perdiste",JOptionPane.WARNING_MESSAGE );
		dispose();
		
		Card princess = new Princess();
		Player onTurn = game.getPlayerOnTurn();
		
		ContextPrincess context = new ContextPrincess(onTurn, princess);
		game.playCard(onTurn, context, princess);

		room.checkRoundGraphic(game, contentPane);
		
		
		
//		bOk.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		
//		playersPanel.add(label);
//		playersPanel.add(bOk);
	}
}
