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

public class AddUserGUI extends JFrame implements ActionListener, KeyListener{

	private JLabel lbName,lbage,lbgender,lbgrade;
	private JButton btEnsure;
	private List<JTextField> tfName = new ArrayList<JTextField>();
	private List<JTextField> tfAge = new ArrayList<JTextField>();
	private List<JComboBox> tfGender = new ArrayList<JComboBox>();
	private List<JComboBox> tfGrade = new ArrayList<JComboBox>();
	private List<Person> persons = new ArrayList<Person>();
	private int N = 8;//界面显示的数据行数
	
	
	public AddUserGUI() {
		this.setTitle("新增用户：");
		this.setLayout(null);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		lbName = new JLabel("姓名");
		lbName.setFont(new Font("黑体", NORMAL, 15));
		lbName.setBounds(50, 30, 130, 30);
		this.add(lbName);
		
		lbage = new JLabel("年龄");
		lbage.setFont(new Font("黑体", NORMAL, 15));
		lbage.setBounds(180, 30, 130, 30);
		this.add(lbage);
		
		lbgender = new JLabel("性别");
		lbgender.setFont(new Font("黑体", NORMAL, 15));
		lbgender.setBounds(310, 30, 130, 30);
		this.add(lbgender);
		
		lbgrade = new JLabel("年级");
		lbgrade.setFont(new Font("黑体", NORMAL, 15));
		lbgrade.setBounds(440, 30, 130, 30);
		this.add(lbgrade);
		
		for(int i=0;i<N;i++) {
			tfName.add(new JTextField());
			tfName.get(i).setBounds(40, 70+30*i, 120, 30);
			this.add(tfName.get(i));
			
			tfAge.add(new JTextField());
			tfAge.get(i).setBounds(170, 70+30*i, 120, 30);
			this.add(tfAge.get(i));
			tfAge.get(i).addKeyListener(this);
			
			tfGender.add(new JComboBox());
			tfGender.get(i).setBounds(300, 70+30*i, 120, 30);
			tfGender.get(i).addItem("男");
			tfGender.get(i).addItem("女");
			this.add(tfGender.get(i));
			
			tfGrade.add(new JComboBox());
			tfGrade.get(i).setBounds(430, 70+30*i, 120, 30);
			tfGrade.get(i).addItem("大一");
			tfGrade.get(i).addItem("大二");
			tfGrade.get(i).addItem("大三");
			tfGrade.get(i).addItem("大四");
			tfGrade.get(i).addItem("教职工");
			this.add(tfGrade.get(i));
		}
		btEnsure = new JButton("确认");
		btEnsure.setBounds(250, 330, 60, 27);
		btEnsure.addActionListener(this);
		this.add(btEnsure);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btEnsure) {
			for(int i=0;i<N;++i) {
				if (!tfName.get(i).getText().trim().equals("")
				&&!tfAge.get(i).getText().trim().equals("")) {
					String name = tfName.get(i).getText().trim();
					int age = Integer.parseInt(tfAge.get(i).getText().trim());
					String gender = (String)tfGender.get(i).getSelectedItem();
					boolean g = true;
					if (gender.equals("女")) {
						g = false;
					}
					String grade = (String)tfGrade.get(i).getSelectedItem();
					String type = "学生";
					if (grade.equals("教职工")) {
						type = "教师";
					}
					Person temp = new Person("", name, age, g, grade, "123456", "", type);
					persons.add(temp);
				}
			}
			LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
			if (dao.addUser(persons)) {
				JOptionPane.showMessageDialog(null, "保存成功\n默认密码：123456", "提示信息",JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "保存异常", "提示信息",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
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
