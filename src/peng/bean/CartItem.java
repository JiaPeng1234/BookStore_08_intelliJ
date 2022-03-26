package peng.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// �������ﳵ��Ŀ�е���
	private Book book;
	
	// �����ж��ٱ��ڹ��ﳵ��
	private int count;
	
	// ���и����ڹ��ﳵ�еļ�Ǯ
	// private double totalPrice;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalPrice() {
		// ����ȡ���ļ۸����BigDecimal��װ���Է�ֹ���㲻׼������String������װ
		BigDecimal price = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount()+"");
		BigDecimal multiply = price.multiply(count);
		// ����BigDecimal������ת��Ϊdouble��
		return multiply.doubleValue();
	}

	public CartItem(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}

	public CartItem() {
		super();
	}

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}
	
	
}
