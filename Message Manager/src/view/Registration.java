package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.JarUsers;
import model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField loggTF;
	private JTextField passTF;
	private JTextField aliceTF;
	
	static Registration window;
	private JButton canselBtn;

	
	private JarUsers jarUs = JarUsers.run();

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 256, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loggTF = new JTextField();
		loggTF.setColumns(10);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		
		aliceTF = new JTextField();
		aliceTF.setColumns(10);
		
		JButton addBtn = new JButton("Применить");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (loggTF.getText() != null && passTF.getText() != null && aliceTF.getText() != null) {
					User temp = new User(loggTF.getText(), passTF.getText(), aliceTF.getText());
					if (jarUs.add(temp)) {
						System.out.println("Пользователь добавлен");
						Logger.start();
						window.frame.setVisible(false);
					} else {
						System.out.println("Ошибка добавления");
					}
				}
			}
		});
		
		canselBtn = new JButton("Отмена");
		canselBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Logger.start();
					window.frame.setVisible(false);
			}
		});
		
		JLabel label = new JLabel("Логин");
		
		JLabel label_1 = new JLabel("Пароль");
		
		JLabel label_2 = new JLabel("Псевданим");
		
		JLabel label_3 = new JLabel("Регистрация в системе");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(addBtn)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(canselBtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(aliceTF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(passTF, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(loggTF, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(label_3)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(label_3)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(loggTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(aliceTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(canselBtn))
					.addGap(24))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
