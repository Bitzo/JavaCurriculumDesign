package cn.jit.myproject.domain;

public class ScoreInfo {
	private int cno;
	private String cname;
	private String teacher;
	private int sno;
	private int score;

	public ScoreInfo()
	{
		this.cno = this.sno = this.score = 0;
		this.teacher = this.cname =  "";
	}

	public ScoreInfo(int cno,String cname, String teacher, int sno, int score) {
		this.cno = cno;
		this.cname = cname;
		this.teacher = teacher;
		this.sno = sno;
		this.score = score;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return this.cno+ " " +this.teacher+" "+this.sno+" "+this.score;
	}
	
}
