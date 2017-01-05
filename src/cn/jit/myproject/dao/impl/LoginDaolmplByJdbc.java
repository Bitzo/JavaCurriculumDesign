package cn.jit.myproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jit.myproject.dao.LoginDao;
import cn.jit.myproject.domain.Person;
import cn.jit.myproject.domain.ScoreInfo;

public class LoginDaolmplByJdbc implements LoginDao {	
	private String dbHost = "jdbc:mysql://59.110.162.50:3306/myproject?characterEncoding=utf-8";
	private String dbuser = "root";
	private String dbpassword = "123456";
	
	@Override
	public boolean Login(Person stu, String type) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl= dbHost;
			String user = dbuser;
			String password = dbpassword;
			ResultSet res = null;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="select * from userinfo where AccountID = ? and Password = ? and type = ?";
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			System.out.println(stu.getID()+" "+stu.getPassword()+" "+type);
			ps.setString(1, stu.getID());
			ps.setString(2, stu.getPassword());
			ps.setString(3, type);
			res = ps.executeQuery();
			if(res.next()) {
				String userName = res.getString("UserName");
				String id = res.getString("AccountID");
				int age = res.getInt("age");
				String str = res.getString("gender");
				boolean gender = ((str.equals("男"))?true:false);
				String grade = res.getString("grade");
				String add = res.getString("address");
				String tele = res.getString("telephone");
				stu.setGender(gender);
				stu.setAge(age);
				stu.setName(userName);
				stu.setGrade(grade);
				stu.setAddress(add);
				stu.setTelephone(tele);
				return true;
			}else return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean getInfoByID(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			ResultSet res = null;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="select * from userinfo where AccountID = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getID());
			res = ps.executeQuery();
			if(res.next()) {
				p.setAddress(res.getString("address"));
				p.setAge(res.getInt("age"));
				p.setGender(res.getString("gender").equals("男")?true:false);
				p.setGrade(res.getString("grade"));
				p.setName(res.getString("UserName"));
				p.setPassword(res.getString("Password"));
				p.setTelephone(res.getString("telephone"));
				System.out.println(p.toString());
			}
			else return false;
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean updatePersonInfo(Person p) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="update userinfo set username = ?, Password = ?,"
				+ " age = ?, gender = ?, address = ?, telephone = ?, grade = ? where AccountID = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getPassword());
			ps.setString(3, Integer.toString(p.getAge()));
			ps.setString(4, p.getGender());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getTelephone());
			ps.setString(7, p.getGrade());
			ps.setString(8, p.getID());
			int i = ps.executeUpdate();
			System.out.println(i);
			if(i>0) return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public String getCINFOByTName(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			ResultSet res = null;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="select CNO,CName,grade from courseinfo where Cteacher = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			if(res.next()){
				return res.getString("CName")+" "+res.getString("CNO");
			}else return "";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	@Override
	public List<Person> getPersonInfo(String type,int page) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Person> list = new ArrayList<Person>();
		int num = 8;//页面显示数量和
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			ResultSet res = null;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="select AccountID,UserName,age,gender,grade from userinfo where type = ? limit ?,?";
			ps=con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, (page-1)*num);
			ps.setInt(3, num);
			res = ps.executeQuery();
			while(res.next()){
				boolean gender = res.getString("gender").equals("男")?true:false;
				Person person = new Person(res.getString("AccountID"), res.getString("UserName"), res.getInt("age"), gender, res.getString("grade"), "", "", "");
				list.add(person);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public boolean saveScore(List<ScoreInfo> s) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="insert into scoreinfo (CNO, SNO, score) values";
			for(int i=0;i<s.size();++i){
				if(i!=0)
					sql += ",";
				sql+="("+s.get(i).getCno()+","+s.get(i).getSno()+","+s.get(i).getScore()+")";
			}
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			if (ps.executeUpdate() == s.size()) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<ScoreInfo> getScoreByID(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		List<ScoreInfo> list = new ArrayList<ScoreInfo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			ResultSet res = null;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="select CNO,CName,TName,SNO,Score from v_stuscore where SNO = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			while(res.next()){
				ScoreInfo scoreInfo = new ScoreInfo(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),res.getInt(5));
				list.add(scoreInfo);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public boolean addUser(List<Person> p) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="insert into userinfo (UserName,Password,age,gender,grade,type) values";
			System.out.println(p);
			for(int i=0;i<p.size();++i){
				if(i!=0)
					sql += ",";
				sql+="('"+p.get(i).getName()+"', '123456', '"+p.get(i).getAge()+"','"+p.get(i).getGender()+"', '"+p.get(i).getGrade()+"', '"+p.get(i).getTelephone()+"')";
			}
			ps=con.prepareStatement(sql);
			if (ps.executeUpdate() == p.size()) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean delUser(int ID) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl=dbHost;
			String user = dbuser;
			String password = dbpassword;
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("con="+con+" Success");
			String sql="delete from userinfo where AccountID = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, ID);
			if (ps.executeUpdate()==1) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(ps!=null){
			  try {
				ps.close();
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
