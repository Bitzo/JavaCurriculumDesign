package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.jit.myproject.domain.Person;

public class StudentGUI extends JFrame implements ActionListener{
	
	private JButton btInfo,btScore,btExit;
	private JLabel lbInfo,lbScore,lbStu;
	private String SNO;
	private String name;
	private Person student;
	
	public StudentGUI(Person stu) {
		this.SNO = stu.getID();
		this.name = stu.getName();
		this.student = stu;
		
		this.setTitle("ѧ������");
		this.setLayout(null);
		this.setSize(260, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JLabel lbWelcome = new JLabel("��ӭ,");
		lbWelcome.setFont(new Font("����", NORMAL, 20));
		lbWelcome.setBounds(40, 50, 50, 30);;
		this.add(lbWelcome);
		
		lbStu = new JLabel(name);
		lbStu.setFont(new Font("����", NORMAL, 20));
		lbStu.setBounds(100, 50, 80, 30);
		this.add(lbStu);
		
		btInfo = new JButton("�鿴������Ϣ");
		btInfo.setBounds(50, 120, 150, 50);
		this.add(btInfo);
		btInfo.addActionListener(this);
		
		btScore = new JButton("�鿴�ɼ�");
		btScore.setBounds(50, 200, 150, 50);
		this.add(btScore);
		btScore.addActionListener(this);
		
		btExit = new JButton("�˳�ϵͳ");
		btExit.setBounds(50, 280, 150, 50);
		this.add(btExit);
		btExit.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==btInfo) {
			new PersonInfoGUI(student.getID(), "ѧ��");
		}
		if(ev.getSource()==btScore) {
			new QueryScoreGUI(student);
		}
		if(ev.getSource()==btExit) {
			System.exit(0);
		}
	}
	
	
}
