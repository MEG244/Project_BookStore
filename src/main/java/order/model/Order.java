package order.model;

public class Order {
	private int oid;
	private int bnum;
	private int mid;
	private int qty;
	private String oaddr;
	private String orderdate;


	public Order() {
		super();
	}

	public Order(int oid, int bnum, int mid, int qty, String oaddr, String orderdate) {
		super();
		this.oid = oid;
		this.bnum = bnum;
		this.mid = mid;
		this.qty = qty;
		this.oaddr = oaddr;
		this.orderdate = orderdate;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getOaddr() {
		return oaddr;
	}
	public void setOaddr(String oaddr) {
		this.oaddr = oaddr;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}



}