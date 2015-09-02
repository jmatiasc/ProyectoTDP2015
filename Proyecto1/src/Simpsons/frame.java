package Simpsons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

public class frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 442, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(frame.class.getResource("/Simpsons/SoyunUnitonto.gif")));
		lblNewLabel.setBounds(0, 0, 442, 355);
		panel.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(117, 379, 200, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnPresioneAqu = new JButton("Presione Aqu\u00ED");
		btnPresioneAqu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setIcon(new ImageIcon(frame.class.getResource("/Simpsons/SoyunUnicornio.gif")));
				textField.setText("Soy un unicornio");
			}
		});
		btnPresioneAqu.setBounds(117, 460, 200, 23);
		panel.add(btnPresioneAqu);
		
	}
}
