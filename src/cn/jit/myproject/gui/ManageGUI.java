package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.jit.myproject.domain.Person;

public class ManageGUI extends JFrame implements ActionListener{
	
	private JButton btInfo,btAddUser,btAddTea,btExit;
	private JLabel lbInfo,lbScore,lbStu;
	private String SNO;
	private String name;
	private Person manange;
	
	public ManageGUI(Person manage) {
		this.SNO = manage.getID();
		this.name = manage.getName();
		this.manange = manage;
		
		this.setTitle("管理员界面");
		this.setLayout(null);
		this.setSize(260, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JLabel lbWelcome = new JLabel("欢迎,");
		lbWelcome.setFont(new Font("黑体", NORMAL, 20));
		lbWelcome.setBounds(40, 50, 50, 30);;
		this.add(lbWelcome);
		
		lbStu = new JLabel(name);
		lbStu.setFont(new Font("黑体", NORMAL, 20));
		lbStu.setBounds(100, 50, 80, 30);
		this.add(lbStu);
		
		btInfo = new JButton("查看个人信息");
		btInfo.setBounds(50, 120, 150, 50);
		this.add(btInfo);
		btInfo.addActionListener(this);
		
		btAddUser = new JButton("添加用户");
		btAddUser.setBounds(50, 200, 150, 50);
		this.add(btAddUser);
		btAddUser.addActionListener(this);
		
		btAddTea = new JButton("查看/删除用户");
		btAddTea.setBounds(50, 280, 150, 50);
		this.add(btAddTea);
		btAddTea.addActionListener(this);
		
		btExit = new JButton("退出系统");
		btExit.setBounds(50, 360, 150, 50);
		this.add(btExit);
		btExit.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==btInfo) {
			new PersonInfoGUI(manange.getID(), "管理员");
		}
		if(ev.getSource()==btAddUser) {
			new AddUserGUI();
		}
		if(ev.getSource()==btAddTea) {
			new PersonManageGUI();
		}
		if(ev.getSource()==btExit) {
			System.exit(0);
		}
	}
}
