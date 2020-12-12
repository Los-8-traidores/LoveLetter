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

public class GraphicPrince2 extends JDialog{

	private static final long serialVersionUID = 1816297503220369796L;
	
	private static Font enchantedFont = MyFont.createFont();
	private JPanel playersPanel;

	
	public GraphicPrince2(Game game, Room room, Container contentPane) {
		JOptionPane.showMessageDialog(playersPanel, "Has sido eliminado" , "Perdiste",JOptionPane.WARNING_MESSAGE );
		dispose();
		
		Card prince = new Prince();
		Player onTurn = game.getPlayerOnTurn();
		
		ContextPrince context = new ContextPrincess(onTurn, princess);
		game.playCard(onTurn, context, princess);

		room.checkRoundGraphic(game, contentPane);
		
		
	}
}
