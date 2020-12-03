package com.window;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Change extends JFrame {



	JLabel jlnumber = new JLabel("城市：");
	JLabel jlname = new JLabel("天气：");
	JLabel jlage = new JLabel("最低温");
	JLabel jlsex = new JLabel("最高温");
	JLabel jlmath = new JLabel("气压");
	JLabel jlenglish = new JLabel("pm2.5");
	JLabel jldata = new JLabel("风向");

	JTextField jtnumber = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtage = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtmath = new JTextField("", 20);
	JTextField jtenglish = new JTextField("", 20);
	JTextField jtdata = new JTextField("", 20);

	JButton buttonchange = new JButton("修改");
	JButton buttonreturn = new JButton("返回");


	public Change() {

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

		this.setTitle("修改天气信息");
		getContentPane().setLayout(null);
		getContentPane().add(jpnumber);
		getContentPane().add(jpname);
		getContentPane().add(jpage);
		getContentPane().add(jpsex);
		getContentPane().add(jpmath);
		buttonchange.setBounds(0, 224, 168, 29);
		getContentPane().add(buttonchange);
		buttonreturn.setBounds(168, 224, 168, 29);
		getContentPane().add(buttonreturn);
		getContentPane().add(jpmath1);
		getContentPane().add(jpmath2);

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = jtnumber.getText();
				String name = jtname.getText();
				String age = jtage.getText();
				String sex = jtsex.getText();
				String math = jtmath.getText();
				String english = jtenglish.getText();
				String data = jtdata.getText();

				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;

				String sql = "SELECT * FROM student;";
			
				try {
					conn = JdbcUtils.getConn();
					stat = conn.createStatement();
					res = stat.executeQuery(sql);
					int i=0;
					while (res.next()) {
						// change
						if (res.getString(1).equals(jtnumber.getText())) {
							i++;

							String sql2 = "UPDATE student SET weather='" + name + "'  WHERE city='" + jtnumber.getText()
									+ "'";
							String sql3 = "UPDATE student SET min='" + age + "'  WHERE city='" + jtnumber.getText()
									+ "'";
							String sql4 = "UPDATE student SET max='" + sex + "'  WHERE city='" + jtnumber.getText()
									+ "'";
							String sql5 = "UPDATE student SET pressure='" + math + "'  WHERE city='" + jtnumber.getText()
									+ "'";
							String sql6 = "UPDATE student SET pm='" + english + "'  WHERE city='"
									+ jtnumber.getText() + "'";
							String sql7 = "UPDATE student SET wind='" + data + "'  WHERE city='" + jtnumber.getText()
									+ "'";
							try {
								conn = JdbcUtils.getConn();
								stat = conn.createStatement();
								stat.executeUpdate(sql2);
								stat.executeUpdate(sql3);
								stat.executeUpdate(sql4);
								stat.executeUpdate(sql5);
								stat.executeUpdate(sql6);
								stat.executeUpdate(sql7);

								dispose();
							} catch (SQLException g) {
								// TODO Auto-generated catch block
								g.printStackTrace();
							}
							try {
								stat.close();
								conn.close();
							} catch (SQLException ar) {
								ar.printStackTrace();
							}
							break;
						}
						// change end
					}
					if (i==0){
						JOptionPane.showMessageDialog(null, jtnumber.getText()+":不存在");

					}else {
						JOptionPane.showMessageDialog(null, jtnumber.getText()+":修改成功");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException ar) {
						ar.printStackTrace();
					}
				}
			}
		});
		this.setLocationRelativeTo(null);
		this.setSize(350, 300);
		this.setVisible(true);

	}
}
