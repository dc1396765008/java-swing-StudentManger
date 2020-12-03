package com.window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add f = new Add();
				f.setSize(400, 300);
				JLabel label = new JLabel("");
				f.add(label);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(90, 129, 120, 28);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete f = new Delete();
				// f.setSize(400,300);
				// JLabel label = new JLabel("我是新窗口");
				// f.add(label)f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(382, 129, 120, 28);
		contentPane.add(btnNewButton_1);

//		JButton btnNewButton_2 = new JButton("查询");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Ask f = new Ask();
//				 f.setSize(400,300);
//				 JLabel label = new JLabel("我是新窗口");
//				 f.add(label);
//				f.setLocationRelativeTo(null);
//				f.setVisible(true);
//			}
//		});
//		btnNewButton_2.setBounds(90, 181, 120, 28);
//		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("浏览");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Look f = new Look();
				 f.setSize(400,300);
//				 JLabel label = new JLabel("浏览");
//				 f.add(label);
	                f.setLocationRelativeTo(null);
	                f.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(382, 183, 120, 25);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("天气预报管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(198, 37, 197, 43);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_4 = new JButton("修改");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change f = new Change();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(90, 181, 120, 28);
		contentPane.add(btnNewButton_4);
	}
}