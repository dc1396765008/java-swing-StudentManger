package com.window;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;



public class Look extends JFrame {



	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;

	JButton buttonlook = new JButton("确定");
	JButton buttonreturn = new JButton("返回");

	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();

	Vector columnNames = null;
	Vector rowData = null;

	public Look() {
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		columnNames = new Vector();
		columnNames.add("城市");
		columnNames.add("天气");
		columnNames.add("最低气温");
		columnNames.add("最高气温");
		columnNames.add("气压");
		columnNames.add("PM2.5");
		columnNames.add("风向");
		rowData = new Vector();

		jpforbutton.add(buttonlook);
		jpforbutton.add(buttonreturn);
		 studentList();
		
		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonlook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(jscrollpane);
		this.setTitle("浏览天气信息");
		getContentPane().setLayout(new GridLayout(2, 5));
		getContentPane().add(jpforbutton);
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setVisible(true);
		this.setResizable(false);

	}
	public void studentList() {
		rowData = new Vector();
          try {

			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement("SELECT * FROM student");
			res = ps.executeQuery();
			while (res.next()) {
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3)+"度");
				hang.add(res.getString(4)+"度");
				hang.add(res.getString(5)+"MPa");
				hang.add(res.getString(6)+"毫克");
				hang.add(res.getString(7));
				rowData.add(hang);

			}

			System.out.println("成功载入");
		} catch (Exception q) {
			q.printStackTrace();
			System.out.println("失败");
		} finally {
			try {
				res.close();
				ps.close();
				conn.close();
				System.out.println("成功关闭");
			} catch (SQLException o) {
				o.printStackTrace();
				System.out.println("关闭失败");
			}
		}

	}

}