package cn.jit.myproject.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;

public class PersonInfoGUI extends JFrame implements ActionListener, CaretListener {
	/**
	 * ������Ϣҳ��
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbWel,lbID,lbUserName,lbPassword,lbPassword1,lbage,lbgender,lbgrade,lbtype,lbaddress,lbtele,notice;
	private JButton btEnsure,btCancel;
	private JTextField tfID,tfUserName,tfage,tfgender,tfgrade,tfaddress,tftele;
	private JPasswordField tfPassword,tfPassword1;
	private Person p = new Person("", "", 0, true, "", "", "", "");
	
	public PersonInfoGUI(String id, String type) {
		this.p.setID(id);
		LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
		dao.getInfoByID(p);
		System.out.println(p.toString());
		boolean t = false;
		if(type.equals("����Ա")) t = true;
		
		this.setTitle("������Ϣ");
		this.setLayout(null);
		this.setSize(360, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		lbWel = new JLabel("������Ϣ");
		lbWel.setFont(new Font("����", NORMAL, 30));
		lbWel.setBounds(100, 50, 150, 30);
		this.add(lbWel);
		
		lbtype = new JLabel(type);
		lbtype.setFont(new Font("����", NORMAL, 20));
		lbtype.setBounds(240, 60, 80, 20);
		this.add(lbtype);
		
		lbID = new JLabel("�ʺ�ID��");
		lbID.setBounds(60, 100, 100, 30);
		this.add(lbID);
		
		tfID = new JTextField(p.getID());
		tfID.setBounds(160, 100, 100, 30);
		tfID.setEditable(false);
		this.add(tfID);
		
		lbUserName = new JLabel("�û�����");
		lbUserName.setBounds(60, 140, 100, 30);
		this.add(lbUserName);
		
		tfUserName = new JTextField(p.getName());
		tfUserName.setBounds(160, 140, 100, 30);
		tfUserName.setEditable(t);
		this.add(tfUserName);
		
		lbPassword = new JLabel("����:");
		lbPassword.setBounds(60, 180, 100, 30);
		this.add(lbPassword);
		
		tfPassword = new JPasswordField(p.getPassword());
		tfPassword.setBounds(160, 180, 100, 30);
		this.add(tfPassword);
		tfPassword.addCaretListener(this);
		
		lbPassword1 = new JLabel("ȷ������:");
		lbPassword1.setBounds(60, 220, 100, 30);
		this.add(lbPassword1);
		
		tfPassword1 = new JPasswordField(p.getPassword());
		tfPassword1.setBounds(160, 220, 100, 30);
		this.add(tfPassword1);
		tfPassword1.addCaretListener(this);
		
		notice = new JLabel("");
		notice.setForeground(Color.red);
		notice.setBounds(260, 220, 70, 30);
		this.add(notice);
		
		lbage = new JLabel("���䣺");
		lbage.setBounds(60, 260, 100, 30);
		this.add(lbage);
		
		tfage = new JTextField(Integer.toString(p.getAge()));
		tfage.setBounds(160, 260, 100, 30);
		tfage.setEditable(t);
		this.add(tfage);
		
		lbgender = new JLabel("�Ա�");
		lbgender.setBounds(60, 300, 100, 30);
		this.add(lbgender);
		
		tfgender = new JTextField(p.getGender());
		tfgender.setBounds(160, 300, 100, 30);
		tfgender.setEditable(t);
		this.add(tfgender);
		
		lbgrade = new JLabel("�꼶��");
		lbgrade.setBounds(60, 340, 100, 30);
		this.add(lbgrade);
		
		tfgrade = new JTextField(p.getGrade());
		tfgrade.setBounds(160, 340, 100, 30);
		tfgrade.setEditable(t);
		this.add(tfgrade);
		
		lbtele = new JLabel("��ϵ�绰��");
		lbtele.setBounds(60, 380, 100, 30);
		this.add(lbtele);
		
		tftele = new JTextField(p.getTelephone());
		tftele.setBounds(160, 380, 100, 30);
		this.add(tftele);
		
		lbaddress = new JLabel("��ַ��");
		lbaddress.setBounds(60, 420, 100, 30);
		this.add(lbaddress);

		tfaddress = new JTextField(p.getAddress());
		tfaddress.setBounds(160, 420, 100, 30);
		this.add(tfaddress);
		
		btEnsure = new JButton("ȷ���޸�");
		btEnsure.setBounds(60, 480, 100, 30);
		this.add(btEnsure);
		btEnsure.addActionListener(this);
		
		btCancel = new JButton("�����޸�");
		btCancel.setBounds(170, 480, 100, 30);
		this.add(btCancel);
		btCancel.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCancel) {
			tfPassword.setText(p.getPassword());
			tfPassword1.setText(p.getPassword());
		}
		if (e.getSource() == btEnsure) {
			LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
			if (tfPassword.getText().equals(tfPassword1.getText())) {
				Person person = new Person("", "", 0, true, "", "", "", "");
				person = p;
				person.setPassword(tfPassword.getText());
				if(dao.updatePersonInfo(person)) {
					p.setPassword(tfPassword.getText());
					JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ��", "��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	@Override
	public void caretUpdate(CaretEvent ev) {
		if (ev.getSource() == tfPassword || ev.getSource() == tfPassword1) {
			if (!(tfPassword.getText().equals(tfPassword1.getText()))) {
				notice.setText("���벻һ��");
			} else {
				notice.setText("");
			}
		}
	}
}