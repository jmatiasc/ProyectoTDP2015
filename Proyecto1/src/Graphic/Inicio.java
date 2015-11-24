package Graphic;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.applet.AudioClip;

public class Inicio extends JFrame {
	private AudioClip sonido;

	private static Inicio frame;
	private final JLabel Image = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Inicio();
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
	public Inicio() {

		sonido = java.applet.Applet.newAudioClip(getClass().getResource(
				"/Sonidos/MusicaMenu.wav"));
		sonido.play();

		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 510);
		getContentPane().setLayout(null);

		JButton btnComenzar = new JButton("");
		btnComenzar.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/BOTON.png")));
		btnComenzar.setBackground(new Color(30, 144, 255));
		btnComenzar.setFont(new Font("Impact", Font.BOLD, 25));
		btnComenzar.setForeground(new Color(245, 255, 250));
		btnComenzar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				sonido.stop();
				frame.setVisible(false);

				EventQueue.invokeLater(new Runnable() {

					public void run() {
						try {
							GUI frame = new GUI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnComenzar.setBounds(688, 289, 186, 57);
		getContentPane().add(btnComenzar);
		Image.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/start.png")));
		Image.setBounds(50, 0, 900, 474);
		getContentPane().add(Image);
	}
}
