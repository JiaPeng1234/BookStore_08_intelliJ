package peng.bean;

public class OrderItem {
	
	//	private Integer id;
	private String title; //���������
	private double price; //ͼ��ĵ���
	private int count;	  //���������
	private double totalPrice;   //ͼ����ܼ�
	private String orderId;		 //�����ĸ�����
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderItem(String title, double price, int count, double totalPrice, String orderId) {
		super();
		this.title = title;
		this.price = price;
		this.count = count;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [title=" + title + ", price=" + price + ", count=" + count + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + "]";
	}
	
}
