package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;

public class LoginGUI extends JFrame implements ActionListener{
	/**
	 * ��½����
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbLogin,lbUsername,lbPassword;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JButton btLogin,btCancel;
	private ButtonGroup buttongroup;
	private JRadioButton[] radio;
	
	public LoginGUI() {
		super("�ɼ�����ϵͳ");
		this.setLayout(null);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbLogin = new JLabel("��¼");
		lbLogin.setBounds(70, 30, 100, 50);
		lbLogin.setFont(new Font("����", NORMAL, 35));
		this.add(lbLogin);
		
		lbUsername = new JLabel("ѧ�ţ�");
		lbUsername.setFont(new Font("����", NORMAL, 20));
		lbUsername.setBounds(70, 100, 80, 40);
		this.add(lbUsername);
		
		tfUsername = new JTextField("");
		tfUsername.setFont(new Font("����", NORMAL, 20));
		tfUsername.setBounds(140, 100, 150, 40);
		this.add(tfUsername);
		
		lbPassword = new JLabel("���룺");
		lbPassword.setFont(new Font("����", NORMAL, 20));
		lbPassword.setBounds(70, 150, 80, 40);
		this.add(lbPassword);
		
		tfPassword = new JPasswordField("");
		lbPassword.setFont(new Font("����", NORMAL, 20));
		tfPassword.setBounds(140, 150, 150, 40);
		this.add(tfPassword);
		
		radio=new JRadioButton[3];
		buttongroup=new ButtonGroup();
		radio[0]=new JRadioButton("ѧ��");
		radio[1]=new JRadioButton("��ʦ");
		radio[2]=new JRadioButton("����Ա");
		buttongroup.add(radio[0]);
		buttongroup.add(radio[1]);
		buttongroup.add(radio[2]);
		radio[0].setBounds(70, 200, 80, 30);
		radio[1].setBounds(160, 200, 80, 30);
		radio[2].setBounds(250, 200, 80, 30);
		this.add(radio[0]);
		this.add(radio[1]);
		this.add(radio[2]);

		
		btLogin = new JButton("��¼");
		btLogin.setBounds(100, 250, 80, 30);
		this.add(btLogin);
		btLogin.addActionListener(this);
		
		btCancel = new JButton("����");
		btCancel.setBounds(200, 250, 80, 30);
		this.add(btCancel);
		btCancel.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == btLogin) {
			if(!(tfUsername.getText().trim() == "" || tfPassword.getText().trim() == "")) {
				LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
				String id = tfUsername.getText().trim();
				String password = tfPassword.getText().trim();
				String type = "";
				Person p = new Person(id, "", 0, true, "", password, "", "");
				if (radio[0].isSelected()) {
					type = "ѧ��";
				} else if (radio[1].isSelected()) {
					type = "��ʦ";
				} else if (radio[2].isSelected()) {
					type = "����Ա";
				}
				System.out.println(id + " " + password);
				if(dao.Login(p, type)) {
					System.out.println("Login Success!");
					this.setVisible(false);
					if (type == "ѧ��") {
						new StudentGUI(p);
					}
					if (type == "��ʦ") {
						new TeacherGUI(p);
					}
					if (type == "����Ա") {
						new ManageGUI(p);
					}
				} else {
					JOptionPane.showMessageDialog(null, "�ʺŻ��������", "��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Login Fail!");
				}
			}
		}
		if (ev.getSource() == btCancel) {
			tfPassword.setText("");
			tfUsername.setText("");
		}
	}
	
}
