package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import model.User;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import controller.JarUsers;

public class Contacts extends App {

	private static Contacts window;

	private JFrame frame;

	User user;
	private JList<String> listContacts;
	private JButton addChatBtn;
	private JButton addContactBtn;
	private JButton deleteContactBtn;

	private JarUsers jarUs = JarUsers.run();
	private DefaultListModel<String> dlm;

	/**
	 * Launch the application.
	 */
	public static void start(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Contacts(user);
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
	public Contacts(User user) {
		this.user = user;
		initialize();
		downloadUserData();
	}

	private void downloadUserData() {
		downloadContacts();
		listContacts.setModel(dlm);
	}

	private void downloadContacts() {
		dlm = new DefaultListModel<>();
		try {
			if (!user.getContacts().isEmpty()) {
				for (User contact : user.getContacts()) {
					dlm.addElement(contact.getName());
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Контакты отсутствуют");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 247, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		addChatBtn = new JButton("Начать чат");
		addChatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startChat();
			}

		});
		toolBar.add(addChatBtn);

		addContactBtn = new JButton("Добавить");
		addContactBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addNewContact();
			}
		});
		toolBar.add(addContactBtn);

		deleteContactBtn = new JButton("Удалить");
		deleteContactBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeContact();
			}
		});
		toolBar.add(deleteContactBtn);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		listContacts = new JList<>();
		listContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listContacts);
	}

	protected void removeContact() {
		String temp = listContacts.getSelectedValue();
		try {
			dlm.remove(listContacts.getSelectedIndex());
			user.removeContact(jarUs.getUserForAlice(temp));
			System.out.println("Контакт удален");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Контакт не выбран");
		}
	}

	protected void addNewContact() {
		AllContacts.start(user);
		window.frame.setVisible(false);
	}

	private void startChat() {
		// TODO Auto-generated method stub

	}

}
