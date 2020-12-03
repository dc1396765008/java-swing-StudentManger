package com.window;



import javax.swing.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JFrame jFrame;
    private JPanel jPanel;
    private JLabel user;
    private JLabel password;
    private JTextField usertxt;
    private JTextField passwordtxt;
    private JButton login;
    private JButton registered;
    public static String subject;
    public static int id;
    public void show(){
        jFrame = new JFrame("天气预报管理系统");
        jFrame.setBounds(700,200,400,300);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.add(panel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    public JPanel panel(){
        jPanel = new JPanel(null);

        user = new JLabel("用户名");
        user.setBounds(50,50,50,30);
        jPanel.add(user);

        usertxt = new JTextField("admin");
        usertxt.setBounds(120,50,100,30);
        jPanel.add(usertxt);

        password = new JLabel("密码");
        password.setBounds(50,100,50,30);
        jPanel.add(password);

        passwordtxt = new JPasswordField("admin");
        passwordtxt.setBounds(120,100,100,30);
        jPanel.add(passwordtxt);

        login = new JButton("登录");
        login.setBounds(120,150,70,30);
        jPanel.add(login);



        login.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 String user = usertxt.getText();
                 String password = passwordtxt.getText();
              if (user.equals("admin")&password.equals("admin")){
                        new Window().show();
                         jFrame.setLocationRelativeTo(null);
                        jFrame.setVisible(false);
                    
                    }else {
                        JOptionPane.showMessageDialog(null, "账号或密码错误！");
                      
                    }
                }
            
        });
 
        return jPanel;
    }
}
