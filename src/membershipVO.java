
public class membershipVO {
	private int num;
	private String type;
	private String price;
	private String term;
	
	
	public membershipVO() {
		super();
	}

	public membershipVO(int num, String type, String price, String term) {
		this.num = num;
		this.type = type;
		this.price = price;
		this.term = term;
	}

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}




	public membershipVO(String type, String price, String term) {
		super();
		this.type = type;
		this.price = price;
		this.term = term;
	}





	public String gettype() {
		return type;
	}


	public void setName(String type) {
		this.type = type;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	@Override
	public String toString() {
		return "membershipVO [num=" + num + ", name=" + type + ", price=" + price + ", term=" + term + "]";
	}



	
	
}
