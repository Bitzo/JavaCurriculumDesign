package cn.jit.myproject.dao;

import java.awt.Window.Type;
import java.util.List;

import cn.jit.myproject.domain.Person;
import cn.jit.myproject.domain.ScoreInfo;

public interface LoginDao {
	public boolean Login(Person p, String type);
	public boolean getInfoByID(Person p);
	public boolean updatePersonInfo(Person p);
	public String getCINFOByTName(String id);
	public List<Person> getPersonInfo(String type,int page);
	public boolean saveScore(List<ScoreInfo> s);
	public List<ScoreInfo> getScoreByID(String id);
	public boolean addUser(List<Person> p);
	public boolean delUser(int ID);
}
