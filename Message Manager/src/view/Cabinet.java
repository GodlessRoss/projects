package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.JarUsers;
import model.Chat;
import model.User;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cabinet {

	private static Cabinet window;

	private JFrame frame;
	private JLabel aliceLB;
	private JButton contactsBtn;
	private JButton deleteBtn;

	private User user;
	private JarUsers jarUs = JarUsers.run();
	private JList<String> listChats;
	private DefaultListModel<String> dlm;

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
		downloadChats();
		listChats.setModel(dlm);
	}

	private void downloadChats() {
		dlm = new DefaultListModel<>();
		try {
			if (!user.getChats().isEmpty()) {
				for (Chat chat : user.getChats()) {
					dlm.addElement(chat.getTitle());
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Чаты отсутсвуют.");
		}
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
		contactsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contacts.start(user);
				window.frame.setVisible(false);
			}
		});
		toolBar.add(contactsBtn);

		JLabel label = new JLabel("--------------");
		toolBar.add(label);

		JButton openBtn = new JButton("Открыть");
		toolBar.add(openBtn);

		deleteBtn = new JButton("Удалить");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeChat();
			}
		});
		toolBar.add(deleteBtn);

		JLabel label_1 = new JLabel("--------------");
		toolBar.add(label_1);

		JButton exitBtn = new JButton("Выход");
		toolBar.add(exitBtn);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		listChats = new JList<>();
		scrollPane.setViewportView(listChats);
	}

	protected void removeChat() {
		String temp = listChats.getSelectedValue();
		try {
			dlm.remove(listChats.getSelectedIndex());
			user.removeContact(jarUs.getUserForAlice(temp));
			System.out.println("Чат удален");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Чат не выбран");
		}
	}

}
