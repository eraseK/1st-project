
public class LoginLogVO {
	
	private String id;
	private String indate;
	private String outdate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public LoginLogVO() {
		super();
	}

	public LoginLogVO(String id, String indate, String outdate) {
		this.id = id;
		this.indate = indate;
		this.outdate = outdate;
	}

	@Override
	public String toString() {
		return "LoginLogVO [id=" + id + ", indate=" + indate + ", outdate=" + outdate + "]";
	}
	

}
