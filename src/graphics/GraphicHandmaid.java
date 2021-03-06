package graphics;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cards.Handmaid;
import context.ContextHandmaid;
import model.Game;

public class GraphicHandmaid extends JDialog{

	private static final long serialVersionUID = -5147301925662008944L;

	private static Font enchantedFont = MyFont.createFont();
	private JPanel playersPanel;

	
	public GraphicHandmaid(Game game, Room room, Container contentPane) {
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
		JOptionPane.showMessageDialog(playersPanel, "Ahora estas protegido hasta tu siguiente turno" , "Estas protegido!",JOptionPane.WARNING_MESSAGE );
		dispose();
		
		ContextHandmaid context = new ContextHandmaid(game.getPlayerOnTurn());
		game.playCard(game.getPlayerOnTurn(), context, new Handmaid());

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
