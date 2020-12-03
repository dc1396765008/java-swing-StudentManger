package com.window;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.window.Window;
//import com.mysql.jdbc.Driver;

public class Add extends JFrame {

	JLabel jlnumber = new JLabel("城市：");
	JLabel jlname = new JLabel("天气：");
	JLabel jlage = new JLabel("最低温");
	JLabel jlsex = new JLabel("最高温");
	JLabel jlmath = new JLabel("气压");
	JLabel jlenglish = new JLabel("PM2.5");
	JLabel jldata = new JLabel("风向");




	JTextField jtnumber = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtage = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtmath = new JTextField("", 20);
	JTextField jtenglish = new JTextField("",20);
	JTextField jtdata = new JTextField("",20);

	JButton buttonadd = new JButton("添加");
	JButton buttonreturn = new JButton("返回");

	public Add() {

		JPanel jpnumber = new JPanel();
		jpnumber.setBounds(0, 1, 336, 29);
		JPanel jpname = new JPanel();
		jpname.setBounds(0, 30, 336, 29);
		JPanel jpage = new JPanel();
		jpage.setBounds(0, 59, 336, 29);
		JPanel jpsex = new JPanel();
		jpsex.setBounds(0, 88, 336, 29);
		JPanel jpmath = new JPanel();
		jpmath.setBounds(0, 117, 336, 29);
		JPanel jpmath1 = new JPanel();
		jpmath1.setBounds(0, 136, 336, 29);
		JPanel jpmath2 = new JPanel();
		jpmath2.setBounds(0, 165, 336, 29);
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);

		jpname.add(jlname);
		jpname.add(jtname);

		jpage.add(jlage);
		jpage.add(jtage);

		jpsex.add(jlsex);
		jpsex.add(jtsex);

		jpmath.add(jlmath);
		jpmath.add(jtmath);

		jpmath1.add(jlenglish);
		jpmath1.add(jtenglish);

		jpmath2.add(jldata);
		jpmath2.add(jtdata);

		this.setTitle("添加城市天气");
		getContentPane().setLayout(null);
		getContentPane().add(jpnumber);
		getContentPane().add(jpname);
		getContentPane().add(jpage);
		getContentPane().add(jpsex);
		getContentPane().add(jpmath);
		getContentPane().add(jpmath1);
		getContentPane().add(jpmath2);

		buttonadd.setBounds(0, 224, 168, 29);
		getContentPane().add(buttonadd);
		buttonreturn.setBounds(168, 224, 168, 29);
		getContentPane().add(buttonreturn);

//		getContentPane().add(jtenglish);
//		jlenglish.setBounds(41, 156, 98, 15);
//
//		getContentPane().add(jlenglish);
//		jldata.setBounds(51, 179, 117, 15);
//
//		getContentPane().add(jldata);

//		getContentPane().add(jtdata);

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jtnumber.getText().equals("")){
					JOptionPane.showMessageDialog(null, "城市不能为空");
				}else {
					// Add
					Connection conn = null;
					Statement stat = null;
					PreparedStatement ps = null;
					try {

						// 打开链接
						System.out.println("连接数据库...");
						conn = JdbcUtils.getConn();

						// 执行查询
						stat = conn.createStatement();
						String sql = "INSERT INTO student ( city, weather, min, max, pressure, pm, wind)\r\n" +
								"VALUES\r\n" +
								"	( ?, ?, ?, ?, ?, ?, ? )";
						ps = conn.prepareStatement(sql);

						ps.setString(1, jtnumber.getText());
						ps.setString(2, jtname.getText());
						ps.setString(3, jtage.getText());
						ps.setString(4, jtsex.getText());
						ps.setString(5, jtmath.getText());
						ps.setString(6, jtenglish.getText());
						ps.setString(7, jtdata.getText());

						ps.executeUpdate();


						System.out.println("MySQL 连接成功!");
						System.out.println("插入数据成功!");
						JOptionPane.showMessageDialog(null, jtnumber.getText()+":添加成功");
						dispose();
					} catch (SQLException b) {
						if (jtnumber.getText().equals("")){

						}else {
							JOptionPane.showMessageDialog(null, jtnumber.getText()+":城市已经存在");
						}

					} finally {
						try {
							conn.close();
							System.out.println("MySQL 关闭成功");
						} catch (SQLException c) {
							System.out.println("MySQL 关闭失败 ");
							c.printStackTrace();
						}
					}

				}

			}
		});
		this.setLocationRelativeTo(null);
		this.setSize(350, 300);
		this.setVisible(true);
	}
}