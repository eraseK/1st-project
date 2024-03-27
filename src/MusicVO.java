
public class MusicVO {
	
	private String name;
	private String id;
	private String pw;
	private String phNum;
	private String email;
	private String memsYN;
	private String msterm;
	
	
	
	public MusicVO() {
		super();
	}



	public MusicVO(String id, String pw, String phNum, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.phNum = phNum;
		this.email = email;
	}



	public MusicVO(String name, String id, String phNum, String email, String memsYN, String msterm) {
		super();
		this.name = name;
		this.id = id;
		this.phNum = phNum;
		this.email = email;
		this.memsYN = memsYN;
		this.msterm = msterm;
	}



	public MusicVO(String name, String id, String pw, String phNum, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phNum = phNum;
		this.email = email;
	}




	public MusicVO(String name, String id, String pw, String phNum, String email, String memsYN, String msterm) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phNum = phNum;
		this.email = email;
		this.memsYN = memsYN;
		this.msterm = msterm;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getPhNum() {
		return phNum;
	}



	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMemsYN() {
		return memsYN;
	}



	public void setMemsYN(String memsYN) {
		this.memsYN = memsYN;
	}



	public String getMsterm() {
		return msterm;
	}



	public void setMsterm(String msterm) {
		this.msterm = msterm;
	}



	@Override
	public String toString() {
		return "memberVO [name=" + name + ", id=" + id + ", pw=" + pw + ", phNum=" + phNum + ", email=" + email
				+ ", memsYN=" + memsYN + ", msterm=" + msterm + "]";
	}
	
	
	
}
