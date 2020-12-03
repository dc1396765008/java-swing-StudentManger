package com.window;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Delete extends JFrame {



	JLabel jlnumber = new JLabel("城市：");

	JTextField jtnumber = new JTextField("", 20);

	JButton buttondelete = new JButton("删除");
	JButton buttonreturn = new JButton("返回");

	public Delete() {
		JPanel jpnumber = new JPanel();
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);

		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);

		buttondelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String number = jtnumber.getText();

				if (number.equals("")){
					JOptionPane.showMessageDialog(null, "删除城市不能为空");
				}else{
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM student WHERE city='" + number + "'";
				String sql1="SELECT * FROM student";
				int i=0;
				try {
					conn = JdbcUtils.getConn();
					Connection conn1 = JdbcUtils.getConn();
					stat = conn.createStatement();

					PreparedStatement preparedStatement = conn1.prepareStatement(sql1);
					ResultSet resultSet = preparedStatement.executeQuery();
					while(resultSet.next()){
						String string = resultSet.getString(1);
						System.out.println(resultSet.getString(1));
						if (number.equals(string)){

							i++;
						}
					}
					stat.executeUpdate(sql);
					if (i==0){
						JOptionPane.showMessageDialog(null, "删除:"+number+":数据不存在");
					}else{
						JOptionPane.showMessageDialog(null, "删除:"+number+":成功");
					}

					dispose();
				} catch (SQLException h) {

					JOptionPane.showMessageDialog(null, "没有数据");
				} finally {
					try {
						conn.close();
						System.out.println("关闭成功!");
					} catch (SQLException j) {
						System.out.println("关闭失败!");
						j.printStackTrace();
					}
				}
				}
			}
		});

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setTitle("删除城市天气");
		this.setLayout(new GridLayout(9, 1));
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocationRelativeTo(null);
		this.setSize(350, 300);
		this.setVisible(true);
	}
}