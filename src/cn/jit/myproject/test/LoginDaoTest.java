package cn.jit.myproject.test;

import org.junit.Test;

import cn.jit.myproject.dao.impl.LoginDaolmplByJdbc;
import cn.jit.myproject.domain.Person;
import cn.jit.myproject.gui.PersonInfoGUI;

public class LoginDaoTest {
	
	@Test
	public void testLogin(){
		LoginDaolmplByJdbc dao = new LoginDaolmplByJdbc();
		Person st = new Person("10001", "admin", 19, true, "大一", "1231456", "", "");
		System.out.println(dao.Login(st, "学生"));
	}
	
}
