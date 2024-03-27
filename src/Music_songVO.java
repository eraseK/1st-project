
public class Music_songVO {
	private int sNum;
	private String sName;
	private String singer;
	private String albulm;
	private String genre;
	private String feel;
	
	
	public Music_songVO() {
		super();
	}


	public Music_songVO(int sNum, String sName, String singer, String albulm, String genre) {
		super();
		this.sNum = sNum;
		this.sName = sName;
		this.singer = singer;
		this.albulm = albulm;
		this.genre = genre;
	}


	public Music_songVO(int sNum, String sName, String singer, String albulm, String genre, String feel) {
		super();
		this.sNum = sNum;
		this.sName = sName;
		this.singer = singer;
		this.albulm = albulm;
		this.genre = genre;
		this.feel = feel;
	}


	public Music_songVO(int sNum, String sName, String singer, String albulm) {
		super();
		this.sNum = sNum;
		this.sName = sName;
		this.singer = singer;
		this.albulm = albulm;
	}


	public int getsNum() {
		return sNum;
	}


	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getSinger() {
		return singer;
	}


	public void setSinger(String singer) {
		this.singer = singer;
	}


	public String getAlbulm() {
		return albulm;
	}


	public void setAlbulm(String albulm) {
		this.albulm = albulm;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getFeel() {
		return feel;
	}


	public void setFeel(String feel) {
		this.feel = feel;
	}


	@Override
	public String toString() {
		return "Music_songVO [sNum=" + sNum + ", sName=" + sName + ", singer=" + singer + ", albulm=" + albulm
				+ ", genre=" + genre + ", feel=" + feel + "]";
	}
	
	
	

}
