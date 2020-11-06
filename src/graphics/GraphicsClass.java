package graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClass extends JFrame {
	private static final long serialVersionUID = 887598134004090343L;

	private DrawPanel drawPanel;

	public GraphicsClass() {
		drawPanel = new DrawPanel();
		add(drawPanel);
		
		
		JButton b = new JButton("Levantar Carta");
		b.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent ae){
		        drawPanel.i++;
		        //invalidate();
		        repaint();
		    }
		});
		
		drawPanel.add(b);

		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);
		requestFocusInWindow();

	}

	public void refresh() {
		drawPanel.repaint();
	}

	public class DrawPanel extends JPanel {
		private static final long serialVersionUID = -2725717888103986580L;
		int i=0;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			String[] path = {"src/misc/cards/cardDoncella.png" ,
								"src/misc/cards/backCard.png",
								"src/misc/cards/cardGuardia.png"};
			
			
			// Cuando descomento esto no me trae las imagenes
			// Dimension currentDimension = getContentPane().getSize();
			// g2.scale(currentDimension.getWidth()/WIDTH,
			// currentDimension.getHeight()/HEIGHT);

//			g2.setFont(new Font("Calibri", Font.BOLD, 25));
//			g2.drawString("Levante una carta", 10, 40);
			

			try {
				g2.drawImage(ImageIO.read(new File(path[i%(path.length)])), 250, 100, null);
//				g2.drawImage(ImageIO.read(new File("src/misc/cards/cardDoncella.png")), 250, 100, null);
//				g2.drawImage(ImageIO.read(new File("src/misc/cards/backCard.png")), 0, 100, null);
//				g2.drawImage(ImageIO.read(new File("src/misc/cards/cardGuardia.png")), 500, 100, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(800, 600);
		}

	}

	public static void main(String[] args) throws Exception {
		GraphicsClass gc = new GraphicsClass();

		while (true) {
			gc.refresh();
			Thread.sleep(33);
		}

	}

}
