package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;
import cn.jit.myproject.domain.ScoreInfo;

public class QueryScoreGUI extends JFrame{
	private JLabel lbTitle,lbName,lbSNO,lbCName,lbTName,lbScore;
	private List<JTextField> tfCName = new ArrayList<JTextField>();
	private List<JTextField> tfTName = new ArrayList<JTextField>();
	private List<JTextField> tfScore = new ArrayList<JTextField>();
	private Person stu;
	
	public QueryScoreGUI(Person student) {
		super("成绩查询");
		this.setLayout(null);
		this.setSize(600, 420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.stu = student;
		
		lbTitle = new JLabel("成绩查询");
		lbTitle.setFont(new Font("黑体", NORMAL, 30));
		lbTitle.setBounds(30, 20, 120, 30);
		this.add(lbTitle);
		
		lbName = new JLabel(student.getName());
		lbName.setFont(new Font("黑体", NORMAL, 20));
		lbName.setBounds(200, 30, 80, 30);
		this.add(lbName);
		
		lbSNO = new JLabel("学号："+student.getID());
		lbSNO.setFont(new Font("黑体", NORMAL, 20));
		lbSNO.setBounds(300, 30, 200, 30);
		this.add(lbSNO);
		
		lbCName = new JLabel("课程名称");
		lbCName.setFont(new Font("黑体", NORMAL, 15));
		lbCName.setBounds(50, 70, 160, 30);
		this.add(lbCName);
		
		lbTName = new JLabel("教师名");
		lbTName.setFont(new Font("黑体", NORMAL, 15));
		lbTName.setBounds(220, 70, 160, 30);
		this.add(lbTName);
		
		lbScore = new JLabel("成绩");
		lbScore.setFont(new Font("黑体", NORMAL, 15));
		lbScore.setBounds(400, 70, 160, 30);
		this.add(lbScore);
		
		LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
		List<ScoreInfo> scoreInfos = dao.getScoreByID(stu.getID());
		
		int MAX = scoreInfos.size();
		if (MAX >= 8) {
			MAX = 8;
		}
		for (int i = 0; i < MAX; i++) {
			tfCName.add(new JTextField(scoreInfos.get(i).getCname()));
			tfCName.get(i).setBounds(50, 100+35*i, 160, 30);
			tfCName.get(i).setEditable(false);
			this.add(tfCName.get(i));
			
			tfTName.add(new JTextField(scoreInfos.get(i).getTeacher()));
			tfTName.get(i).setBounds(220, 100+35*i, 160, 30);
			tfTName.get(i).setEditable(false);
			this.add(tfTName.get(i));
			
			tfScore.add(new JTextField((Integer.toString(scoreInfos.get(i).getScore()))));
			tfScore.get(i).setBounds(400, 100+35*i, 160, 30);
			tfScore.get(i).setEditable(false);
			this.add(tfScore.get(i));
		}
	}
}
