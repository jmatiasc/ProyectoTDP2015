import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;


public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Proyecto cero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFrase = new JLabel("...");
		lblFrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblImg = new JLabel("");
		
		lblImg.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/SoyunUnitonto.gif")));
		
		JButton btnFrase = new JButton("Presione ---> Aqu\u00ED <---");
		btnFrase.setForeground(Color.BLACK);
		btnFrase.setBackground(Color.YELLOW);
		btnFrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblFrase.setText("Soy un unicornio");
				lblImg.setIcon(new ImageIcon(GUI.class.getResource("/Imagenes/SoyUnUnicornio.gif")));
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblImg))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFrase, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(btnFrase, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(138))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblImg)
					.addGap(7)
					.addComponent(lblFrase)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFrase)
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	
}
