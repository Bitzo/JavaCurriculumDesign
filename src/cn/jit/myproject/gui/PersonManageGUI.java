package cn.jit.myproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;

public class PersonManageGUI extends JFrame implements ActionListener{
	private JLabel lbTitle,lbID,lbName,lbAge,lbGender,lbGrade,lbType,lbManage;
	private List<JTextField> tfID = new ArrayList<JTextField>();
	private List<JTextField> tfName = new ArrayList<JTextField>();
	private List<JTextField> tfAge = new ArrayList<JTextField>();
	private List<JTextField> tfGender = new ArrayList<JTextField>();
	private List<JTextField> tfGrade = new ArrayList<JTextField>();
	private List<JTextField> tfType = new ArrayList<JTextField>();
	private List<JButton> btDel = new ArrayList<JButton>();
	private JButton btEnsure;
	private int page = 1;
	private int N = 8;//ҳ����ʾ��������
	
	public PersonManageGUI() {
		super("��Ա����");
		this.setLayout(null);
		this.setSize(670, 420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		lbID = new JLabel("�ʺ�");
		lbID.setFont(new Font("����", NORMAL, 15));
		lbID.setBounds(30, 30, 80, 30);
		this.add(lbID);
		
		lbName = new JLabel("����");
		lbName.setFont(new Font("����", NORMAL, 15));
		lbName.setBounds(120, 30, 80, 30);
		this.add(lbName);
		
		lbAge = new JLabel("����");
		lbAge.setFont(new Font("����", NORMAL, 15));
		lbAge.setBounds(210, 30, 80, 30);
		this.add(lbAge);
		
		lbGender = new JLabel("�Ա�");
		lbGender.setFont(new Font("����", NORMAL, 15));
		lbGender.setBounds(300, 30, 80, 30);
		this.add(lbGender);
		
		lbGrade = new JLabel("�꼶");
		lbGrade.setFont(new Font("����", NORMAL, 15));
		lbGrade.setBounds(390, 30, 80, 30);
		this.add(lbGrade);
		
		lbType = new JLabel("�û�����");
		lbType.setFont(new Font("����", NORMAL, 15));
		lbType.setBounds(480, 30, 80, 30);
		this.add(lbType);
		
		lbManage = new JLabel("����");
		lbManage.setFont(new Font("����", NORMAL, 15));
		lbManage.setBounds(570, 30, 80, 30);
		this.add(lbManage);
		
		LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
		List<Person> stu = new ArrayList<Person>();
		stu = dao.getPersonInfo("ѧ��",page);
		if (stu.size()<N) {
			N = stu.size();
		}
		for(int i=0;i<N;++i){
			System.out.println(stu.get(i));
			
			tfID.add(new JTextField(stu.get(i).getID()));
			tfID.get(i).setBounds(30, 70+35*i, 80, 30);
			tfID.get(i).setEditable(false);
			this.add(tfID.get(i));
			
			tfName.add(new JTextField(stu.get(i).getName()));
			tfName.get(i).setBounds(120, 70+35*i, 80, 30);
			tfName.get(i).setEditable(false);
			this.add(tfName.get(i));
			
			tfAge.add(new JTextField(Integer.toString(stu.get(i).getAge())));
			tfAge.get(i).setBounds(210, 70+35*i, 80, 30);
			tfAge.get(i).setEditable(false);
			this.add(tfAge.get(i));
			
			tfGender.add(new JTextField(stu.get(i).getGender()));
			tfGender.get(i).setBounds(300, 70+35*i, 80, 30);
			tfGender.get(i).setEditable(false);
			this.add(tfGender.get(i));
			
			tfGrade.add(new JTextField(stu.get(i).getGrade()));
			tfGrade.get(i).setBounds(390, 70+35*i, 80, 30);
			tfGrade.get(i).setEditable(false);
			this.add(tfGrade.get(i));
			
			tfType.add(new JTextField("ѧ��"));
			tfType.get(i).setBounds(480, 70+35*i, 80, 30);
			tfType.get(i).setEditable(false);
			this.add(tfType.get(i));
			
			btDel.add(new JButton("ɾ��"));
			btDel.get(i).setBounds(570, 70+35*i, 80, 30);
			btDel.get(i).addActionListener(this);
			this.add(btDel.get(i));
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<btDel.size();++i){
			if (e.getSource() == btDel.get(i)) {
				LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
				if (dao.delUser(Integer.parseInt(tfID.get(i).getText()))) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	}
	
}
