package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.JarUsers;
import model.User;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Cabinet {

	private JFrame frame;
	private static Cabinet window;
	private JLabel aliceLB;
	private JButton contactsBtn;
	private JButton deleteBtn;
	
	private User user;
	
	private JarUsers jarUs = JarUsers.run();

	/**
	 * Launch the application.
	 */
	public static void start(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Cabinet(user);
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
	public Cabinet(User user) {
		this.user = user;
		initialize();
		downloadUserData();
	}

	private void downloadUserData() {
//		statusLB = user.isOnline();
		aliceLB.setText(user.getName());
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
		toolBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(toolBar, BorderLayout.WEST);
		
		aliceLB = new JLabel("nameUsr");
		toolBar.add(aliceLB);
		
		JLabel lblNewLabel = new JLabel("--------------");
		toolBar.add(lblNewLabel);
		
		contactsBtn = new JButton("Контакты");
		toolBar.add(contactsBtn);
		
		JLabel label = new JLabel("--------------");
		toolBar.add(label);
		
		JButton openBtn = new JButton("Открыть");
		toolBar.add(openBtn);
		
		deleteBtn = new JButton("Удалить");
		toolBar.add(deleteBtn);
		
		JLabel label_1 = new JLabel("--------------");
		toolBar.add(label_1);
		
		JButton exitBtn = new JButton("Выход");
		toolBar.add(exitBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
