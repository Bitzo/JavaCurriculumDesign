package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;
import cn.jit.myproject.domain.ScoreInfo;

public class InsertScoreGUI extends JFrame implements ActionListener, KeyListener{

	private JLabel lbTitle,lbTname,lbCoures,name,score,sno;
	private JTextField tfscore,tfStuName,tfscore1,tfStuName1,tfscore2,tfStuName2,tfscore3,tfStuName3,tfscore4,tfStuName4,tfscore5,tfStuName5;
	private JComboBox comboBox,comboBox1,comboBox2,comboBox3,comboBox4,comboBox5;
	private JButton btEnsure;
	private int page = 1;
	List<Person> p;
	String string[];
	Person t;
	int i = 0;
	public List<ScoreInfo> scoreInfo = new ArrayList<ScoreInfo>();;
	
	public InsertScoreGUI(Person teacher) {
		this.setTitle("分数上传");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.t = teacher;
		
		LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
		String str = dao.getCINFOByTName(teacher.getID());
		string = str.split(" ");
		if(string[0].equals("")) {
			JOptionPane.showMessageDialog(null, "身份信息有误！", "提示信息",JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
		}
		
		lbTitle = new JLabel("分数上传");
		lbTitle.setFont(new Font("黑体", NORMAL, 30));
		lbTitle.setBounds(30, 20, 120, 30);
		this.add(lbTitle);
		
		lbTname = new JLabel(teacher.getName());
		lbTname.setFont(new Font("黑体", NORMAL, 20));
		lbTname.setBounds(180, 30, 80, 30);
		this.add(lbTname);
		
		lbCoures = new JLabel(string[0]);
		lbCoures.setFont(new Font("黑体", NORMAL, 20));
		lbCoures.setBounds(320, 30, 1000, 30);
		this.add(lbCoures);
		
		sno = new JLabel("学号");
		sno.setFont(new Font("黑体", NORMAL, 15));
		sno.setBounds(50, 70, 160, 30);
		this.add(sno);
		
		name = new JLabel("姓名");
		name.setFont(new Font("黑体", NORMAL, 15));
		name.setBounds(220, 70, 160, 30);
		this.add(name);
		
		score = new JLabel("成绩");
		score.setFont(new Font("黑体", NORMAL, 15));
		score.setBounds(400, 70, 160, 30);
		this.add(score);
		
		p = dao.getPersonInfo("学生", page);

		comboBox = new JComboBox();
		comboBox.setBounds(50, 100, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox.addItem(p.get(i).getID());
		}
		comboBox.addActionListener(this);
		this.add(comboBox);
		
		tfStuName = new JTextField();
		tfStuName.setBounds(220, 100, 160, 30);
		tfStuName.setEditable(false);
		this.add(tfStuName);
		
		tfscore = new JTextField();
		tfscore.setBounds(400, 100, 160, 30);
		tfscore.addKeyListener(this);
		this.add(tfscore);
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(50, 135, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox1.addItem(p.get(i).getID());
		}
		comboBox1.addActionListener(this);
		this.add(comboBox1);
		
		tfStuName1 = new JTextField();
		tfStuName1.setBounds(220, 135, 160, 30);
		tfStuName1.setEditable(false);
		this.add(tfStuName1);
		
		tfscore1 = new JTextField();
		tfscore1.setBounds(400, 135, 160, 30);
		tfscore1.addKeyListener(this);
		this.add(tfscore1);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(50, 170, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox2.addItem(p.get(i).getID());
		}
		comboBox2.addActionListener(this);
		this.add(comboBox2);
		
		tfStuName2 = new JTextField();
		tfStuName2.setBounds(220, 170, 160, 30);
		tfStuName2.setEditable(false);
		this.add(tfStuName2);
		
		tfscore2 = new JTextField();
		tfscore2.setBounds(400, 170, 160, 30);
		tfscore2.addKeyListener(this);
		this.add(tfscore2);
		
		comboBox3 = new JComboBox();
		comboBox3.setBounds(50, 205, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox3.addItem(p.get(i).getID());
		}
		comboBox3.addActionListener(this);
		this.add(comboBox3);
		
		tfStuName3 = new JTextField();
		tfStuName3.setBounds(220, 205, 160, 30);
		tfStuName3.setEditable(false);
		this.add(tfStuName3);
		
		tfscore3 = new JTextField();
		tfscore3.setBounds(400, 205, 160, 30);
		tfscore3.addKeyListener(this);
		this.add(tfscore3);
		
		comboBox4 = new JComboBox();
		comboBox4.setBounds(50, 240, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox4.addItem(p.get(i).getID());
		}
		comboBox4.addActionListener(this);
		this.add(comboBox4);
		
		tfStuName4 = new JTextField();
		tfStuName4.setBounds(220, 240, 160, 30);
		tfStuName4.setEditable(false);
		this.add(tfStuName4);
		
		tfscore4 = new JTextField();
		tfscore4.setBounds(400, 240, 160, 30);
		tfscore4.addKeyListener(this);
		this.add(tfscore4);
		
		comboBox5 = new JComboBox();
		comboBox5.setBounds(50, 275, 160, 30);
		for(int i=0;i<p.size();++i) {
			comboBox5.addItem(p.get(i).getID());
		}
		comboBox5.addActionListener(this);
		this.add(comboBox5);
		
		tfStuName5 = new JTextField();
		tfStuName5.setBounds(220, 275, 160, 30);
		tfStuName5.setEditable(false);
		this.add(tfStuName5);
		
		tfscore5 = new JTextField();
		tfscore5.setBounds(400, 275, 160, 30);
		tfscore5.addKeyListener(this);
		this.add(tfscore5);
		
		btEnsure = new JButton("确认提交");
		btEnsure.setBounds(250, 320, 100,30);
		btEnsure.addActionListener(this);
		this.add(btEnsure);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == comboBox) {
			String str = comboBox.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == comboBox1) {
			String str = comboBox1.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName1.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == comboBox2) {
			String str = comboBox2.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName2.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == comboBox3) {
			String str = comboBox3.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName3.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == comboBox4) {
			String str = comboBox4.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName4.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == comboBox5) {
			String str = comboBox5.getSelectedItem().toString();
			for(int i=0;i<p.size();++i) {
				if (str.equals(p.get(i).getID())) tfStuName5.setText(p.get(i).getName());
			}
		}
		if (ev.getSource() == btEnsure) {
			if (!tfscore.getText().trim().equals("") && !tfStuName.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox.getSelectedItem());
				int score = Integer.parseInt(tfscore.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			if (!tfscore1.getText().trim().equals("") && !tfStuName1.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox1.getSelectedItem());
				int score = Integer.parseInt(tfscore1.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			if (!tfscore2.getText().trim().equals("") && !tfStuName2.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox2.getSelectedItem());
				int score = Integer.parseInt(tfscore2.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			if (!tfscore3.getText().trim().equals("") && !tfStuName3.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox3.getSelectedItem());
				int score = Integer.parseInt(tfscore3.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			if (!tfscore4.getText().trim().equals("") && !tfStuName4.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox4.getSelectedItem());
				int score = Integer.parseInt(tfscore4.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			if (!tfscore5.getText().trim().equals("") && !tfStuName5.getText().equals("")) {
				int cno = Integer.parseInt(string[1]);
				String tid = t.getID();
				int id = Integer.parseInt((String)comboBox5.getSelectedItem());
				int score = Integer.parseInt(tfscore5.getText().trim());
				ScoreInfo s = new ScoreInfo(cno,"",tid,id,score);
				scoreInfo.add(s);
			}
			LoginDaolmplByJdbc daolmplByJdbc = new LoginDaolmplByJdbc();
			if (scoreInfo.size() != 0) {
				if (daolmplByJdbc.saveScore(scoreInfo)) {
					JOptionPane.showMessageDialog(null, "保存成功", "提示信息",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "保存异常", "提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "还未填写数据，无法保存", "提示信息",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyChar=e.getKeyChar();
		if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
			
		} else {
			e.consume();  
		}
		
	}
	
}
