package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import model.Chat;
import model.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog extends App {

	private JFrame frame;
	private JTextField textField;

	private User user;
	private User interlocutor;

	private JLabel statusLB;
	private JLabel interlocutorLB;

	private static Dialog window;
	private Chat chat;
	
	/**
	 * Launch the application.
	 */
	public static void start(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Dialog(user);
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
	public Dialog(User user) {
		this.user = user;
		initialize();
		downloadUserData();
	}

	private void downloadUserData() {
		statusLB.setText(interlocutor.isOnline());
		interlocutorLB.setText(interlocutor.getName());
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

		statusLB = new JLabel("status");
		toolBar.add(statusLB);

		interlocutorLB = new JLabel("interlocutor");
		toolBar.add(interlocutorLB);

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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBar_1.add(button);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
