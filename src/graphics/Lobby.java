package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Player;
import sound.Sound;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class Lobby extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5098487617570239475L;
	private JPanel contentPane;
	static private Sound music;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						music = new Sound("src/sound/intro.wav");
						music.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Lobby frame = new Lobby();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lobby() {
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("2 Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player1 = new Player(1, "Jugador 1");
				Player player2 = new Player(2, "Jugador 2");
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Room frame = new Room(player1, player2);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// Esto podria ser un metodo onClose o algo asi
				music.stop();
				setVisible(false);
				// se repite en cada boton
			}
		});
		btnNewButton.setBounds(33, 139, 105, 37);
		contentPane.add(btnNewButton);
		
		JButton btnJugadores = new JButton("3 Jugadores");
		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player1 = new Player(1, "Jugador 1");
				Player player2 = new Player(2, "Jugador 2");
				Player player3 = new Player(2, "Jugador 3");
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Room frame = new Room(player1, player2, player3);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				music.stop();
				setVisible(false);
			}
		});
		btnJugadores.setBounds(167, 139, 105, 37);
		contentPane.add(btnJugadores);
		
		JButton btnNewButton_1_1 = new JButton("4 Jugadores");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player1 = new Player(1, "Jugador 1");
				Player player2 = new Player(2, "Jugador 2");
				Player player3 = new Player(2, "Jugador 3");
				Player player4 = new Player(2, "Jugador 4");
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Room frame = new Room(player1, player2, player3, player4);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				music.stop();
				setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(298, 139, 105, 37);
		contentPane.add(btnNewButton_1_1);
		
		JFormattedTextField frmtdtxtfldSeleccioneTipoDe = new JFormattedTextField();
		frmtdtxtfldSeleccioneTipoDe.setText("Seleccione tipo de partida:");
		frmtdtxtfldSeleccioneTipoDe.setBounds(33, 102, 370, -27);
		contentPane.add(frmtdtxtfldSeleccioneTipoDe);
		
		JLabel lblNewLabel = new JLabel("Selecione tipo de partida:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 65, 372, 48);
		contentPane.add(lblNewLabel);
	}
}
