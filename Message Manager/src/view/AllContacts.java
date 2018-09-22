package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import controller.JarUsers;
import model.User;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class AllContacts {

	private static AllContacts window;
	private JFrame frame;

	private JButton addBtn;
	private JButton canselBtn;
	private JList<String> listContacts;

	private JarUsers jarUs = JarUsers.run();
	private DefaultListModel<String> dlm;
	User user;

	/**
	 * Launch the application.
	 */
	public static void start(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new AllContacts(user);
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
	public AllContacts(User user) {
		this.user = user;
		initialize();
		downloadAllContacts();
		listContacts.setModel(dlm);
	}

	private void downloadAllContacts() {
		dlm = new DefaultListModel<>();
		for (User user : JarUsers.getUsers()) {
			dlm.addElement(user.getLogin());
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

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		addBtn = new JButton("Добавить");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addContact();
			}
		});
		panel.add(addBtn);

		canselBtn = new JButton("Отмена");
		canselBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contacts.start(user);
				window.frame.setVisible(false);
			}
		});
		panel.add(canselBtn);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		listContacts = new JList<>();
		listContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listContacts);
	}

	protected void addContact() {
		user.addContact(jarUs.getUserForLog(listContacts.getSelectedValue()));
		Contacts.start(user);
		window.frame.setVisible(false);
	}
}
