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
	private int cont;
	private  ImageIcon img1;

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
		setBounds(100, 100, 450, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 442, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		img1=new ImageIcon("SoyunUnitonto.gif");
		JLabel lblNewLabel = new JLabel(img1);
		//lblNewLabel.setIcon(img1);
		lblNewLabel.setBounds(0, 0, 442, 355);
		panel.add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(117, 379, 200, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnPresioneAqu = new JButton("Presione Aquí");
		panel.add(btnPresioneAqu);
		btnPresioneAqu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setIcon(new ImageIcon("SoyunUnicornio.gif"));
				textField.setText("Soy Un Unicornio");
			}
		});
		btnPresioneAqu.setBounds(117, 452, 200, 23);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cont==0){lblNewLabel.setIcon(new ImageIcon("exit.gif"));
							cont++;
				}
				else dispose();
			}
		});
		btnExit.setBounds(341, 452, 91, 23);
		panel.add(btnExit);
		
	}
}
