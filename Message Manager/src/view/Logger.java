package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.JarUsers;
import model.Aliases;
import model.User;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logger extends App {

	private JFrame frame;
	private JTextField loggTF;
	private JTextField passTF;
	private JButton exitBtn;
	private JButton enterBtn;
	private JButton regBtn;

	static Logger window;

	private JarUsers jarUs = JarUsers.run();

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Logger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	{
		if (getAliece() == null) {
			setAliece(Aliases.LOGGER);
		}
	}

	/**
	 * Create the application.
	 */
	public Logger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 246, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loggTF = new JTextField();
		loggTF.setToolTipText("");
		loggTF.setColumns(10);

		passTF = new JTextField();
		passTF.setColumns(10);

		exitBtn = new JButton("Выход");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(42);
			}
		});

		enterBtn = new JButton("Войти");
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jarUs.serarch(loggTF.getText(), passTF.getText())) {
					User temp = jarUs.getUserForLog(loggTF.getText());
					Cabinet.start(temp);
					temp.setOnline(true);
					window.frame.setVisible(false);
				}
				;
			}
		});

		regBtn = new JButton("Зарегистрироваться");
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration.start();
				window.frame.setVisible(false);
			}
		});

		JLabel label = new JLabel("Логин");

		JLabel label_1 = new JLabel("Пароль");

		JLabel label_2 = new JLabel("Вход в систему");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label).addComponent(label_1))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(passTF, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
												.addComponent(loggTF, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(23)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(regBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196,
														Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addComponent(enterBtn)
														.addGap(65).addComponent(exitBtn, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGap(44))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(label_2).addGap(94)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(39).addComponent(label_2).addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(loggTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(passTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(enterBtn).addComponent(exitBtn))
						.addGap(18).addComponent(regBtn).addGap(32)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
