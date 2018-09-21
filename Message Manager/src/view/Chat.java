package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;

public class Chat extends App{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(toolBar, BorderLayout.WEST);
		
		JLabel lblStatus = new JLabel("status");
		toolBar.add(lblStatus);
		
		JLabel lblInterlocutor = new JLabel("interlocutor");
		toolBar.add(lblInterlocutor);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		JButton btnNewButton = new JButton("Удалить");
		toolBar.add(btnNewButton);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		frame.getContentPane().add(toolBar_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		toolBar_1.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Отправить");
		toolBar_1.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
