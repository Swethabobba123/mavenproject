package newyearsgift;

public class Chocolates implements Gifts{
	public int rs;
	public int wt;
	
	Chocolate(int rs, int wt) {
		this.rs = rs;
		this.wt = wt;
	}
	
	public int getWt() {
		return this.wt;
	}
	
	public int getRs() {
		return this.rs;
	}
}
