package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.jit.myproject.domain.Person;

public class TeacherGUI extends JFrame implements ActionListener{
	private JButton btInfo,btScore,btExit;
	private JLabel lbInfo,lbScore,lbStu;
	private String SNO;
	private String name;
	private Person teacher;
	
	public TeacherGUI(Person p) {
		this.SNO = p.getID();
		this.name = p.getName();
		this.teacher = p;
		
		this.setTitle("教师界面");
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
		
		btScore = new JButton("录入成绩");
		btScore.setBounds(50, 200, 150, 50);
		this.add(btScore);
		btScore.addActionListener(this);
		
		btExit = new JButton("退出系统");
		btExit.setBounds(50, 280, 150, 50);
		this.add(btExit);
		btExit.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==btInfo) {
			new PersonInfoGUI(teacher.getID(), "教师");
		}
		if(ev.getSource()==btScore) {
			new InsertScoreGUI(teacher);
		}
		if(ev.getSource()==btExit) {
			System.exit(0);
		}
	}

}
