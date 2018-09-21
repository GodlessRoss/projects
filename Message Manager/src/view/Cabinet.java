package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;

public class Cabinet extends App {

//	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cabinet window = new Cabinet();
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
	public Cabinet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 361, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(toolBar, BorderLayout.WEST);
		toolBar.setFloatable(false);
		
		JLabel lblStatus = new JLabel("status");
		toolBar.add(lblStatus);
		
		JLabel lblAlice = new JLabel("alice");
		toolBar.add(lblAlice);
		
		JLabel lblNewLabel = new JLabel("--------------");
		toolBar.add(lblNewLabel);
		
		JButton button_1 = new JButton("Контакты");
		toolBar.add(button_1);
		
		JLabel label_1 = new JLabel("--------------");
		toolBar.add(label_1);
		
		JButton button_3 = new JButton("Открыть");
		toolBar.add(button_3);
		
		JButton button_2 = new JButton("Удалить");
		toolBar.add(button_2);
		
		JLabel label = new JLabel("--------------");
		toolBar.add(label);
		
		JButton button = new JButton("Выход");
		toolBar.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}
}
