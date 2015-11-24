package Graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.applet.AudioClip;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel mContentPane;

	private gTablero mTablero;
	private int puntos;
	private JLabel lblCambioPuntos;
	private JLabel lblMinutos;
	private int horas;
	private int minutos;
	private int segundos;
	private threadCronometro cronometro;
	private AudioClip sonido;
	private JLabel lblGameOver;
	private JLabel lblPuntos;
	private JLabel lblPuntaje;

	public static void main(String[] args) {

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

	public GUI() {
		sonido = java.applet.Applet.newAudioClip(getClass().getResource(
				"/Sonidos/Musica.wav"));
		sonido.play();
		sonido.loop();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				accion(e);
			}
		});

		this.mContentPane = new JPanel();
		mContentPane.setBackground(new Color(0, 191, 255));
		mContentPane.setForeground(new Color(34, 139, 34));
		this.mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mContentPane.setLayout(null);

		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);

		lblPuntaje = new JLabel("");
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Impact", Font.PLAIN, 32));
		lblPuntaje.setForeground(new Color(0, 204, 0));
		lblPuntaje.setBounds(0, 341, 993, 32);
		mContentPane.add(lblPuntaje);

		lblGameOver = new JLabel("");
		lblGameOver.setBackground(Color.DARK_GRAY);
		lblGameOver.setForeground(new Color(204, 0, 0));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Impact", Font.PLAIN, 93));
		lblGameOver.setBounds(0, 140, 984, 181);
		mContentPane.add(lblGameOver);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 415, 993, 57);
		mContentPane.add(panel);
		panel.setLayout(null);

		lblPuntos = new JLabel("PUNTOS:");
		lblPuntos.setFont(new Font("Impact", Font.BOLD, 30));
		lblPuntos.setForeground(Color.WHITE);
		lblPuntos.setBackground(Color.WHITE);
		lblPuntos.setBounds(25, 0, 136, 55);
		panel.add(lblPuntos);

		lblCambioPuntos = new JLabel("0");
		lblCambioPuntos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCambioPuntos.setFont(new Font("Impact", Font.BOLD, 30));
		lblCambioPuntos.setForeground(Color.WHITE);
		lblCambioPuntos.setBounds(165, 0, 426, 55);
		panel.add(lblCambioPuntos);

		JLabel lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setFont(new Font("Impact", Font.BOLD, 30));
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setBounds(628, 0, 113, 55);
		panel.add(lblTiempo);

		lblMinutos = new JLabel("00:00");
		lblMinutos.setFont(new Font("Impact", Font.BOLD, 30));
		lblMinutos.setForeground(Color.WHITE);
		lblMinutos.setBounds(751, 0, 232, 55);
		panel.add(lblMinutos);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GUI.class
				.getResource("/imagenes/Banner.png")));
		label.setBounds(0, 0, 983, 55);
		panel.add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1000, 510);

		this.mTablero = new gTablero(this);

		cronometro = new threadCronometro(this);
		cronometro.start();

	}

	protected void accion(KeyEvent key) {

		this.mTablero.mover(key.getKeyCode());
	}

	public void sumarPuntos(int p) {
		puntos = p;
		lblCambioPuntos.setText("" + p);
	}

	public void setHora(int h, int m, int s) {
		horas = h;
		minutos = m;
		segundos = s;
		lblMinutos.setText(horas + " : " + minutos + " : " + segundos);
		;

	}

	public void fin(int e) {
		cronometro.stop();
		lblGameOver.setText("GAME OVER");
		lblPuntaje.setText("PUNTOS:" + puntos);

		if (e == 0) {
			sonido.stop();
			sonido = java.applet.Applet.newAudioClip(getClass().getResource(
					"/Sonidos/pierde.wav"));
			sonido.play();
		} else if (e == 1) {
			sonido.stop();
			sonido = java.applet.Applet.newAudioClip(getClass().getResource(
					"/Sonidos/fin.wav"));
			sonido.play();
		}

	}
}