package eb1;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
public class JList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	DefaultListModel<String> dlm_izena = new DefaultListModel<String>(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JList frame = new JList();
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
	public JList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		javax.swing.JList lstizena = new javax.swing.JList();
		lstizena.setModel(dlm_izena);
		lstizena.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			String izena;
				izena=lstizena.getSelectedValue().toString();	
				textField.setText(izena);
			
			}
		});
		lstizena.setBounds(24, 85, 108, 144);
		contentPane.add(lstizena);
		JButton btnNewButton = new JButton("Izena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlm_izena.addElement(textField.getText());
				textField.setText("");
			}
		});
		btnNewButton.setBounds(132, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton izena_ezab = new JButton("Ezabatu izena");
		izena_ezab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index= lstizena.getSelectedIndex();
				  dlm_izena.removeElementAt(index) ;
			}
		});
		izena_ezab.setBounds(142, 118, 116, 23);
		contentPane.add(izena_ezab);
	}
}
