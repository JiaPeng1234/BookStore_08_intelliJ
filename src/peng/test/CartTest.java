package peng.test;

import java.math.BigDecimal;

import org.junit.Test;

import peng.bean.Book;
import peng.bean.Cart;

public class CartTest {

	Book book1 = new Book(1, "���μ�1", "��ж�", 0.01, 1, 1, "");
	Book book2 = new Book(2, "���μ�2", "��ж�", 0.06, 1, 1, "");
	Book book3 = new Book(3, "���μ�3", "��ж�", 31.11, 1, 1, "");
	Book book4 = new Book(4, "���μ�4", "��ж�", 41.11, 1, 1, "");
	Book book5 = new Book(5, "���μ�5", "��ж�", 51.11, 1, 1, "");
	Book book6 = new Book(6, "���μ�6", "��ж�", 61.11, 1, 1, "");

	@Test
	public void cartTest() {
		Cart cart = new Cart();
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);
		System.out.println(cart.getAllItems());
		System.out.println("��ǰ�ܼ�" + cart.getTotalCount() + "����");
		System.out.println("��ǰ�ܼ�" + cart.getTotalMoney());
		cart.updateCount("1", "3");
		System.out.println(cart.getAllItems());
		System.out.println("��ǰ�ܼ�" + cart.getTotalCount() + "����");
		System.out.println("��ǰ�ܼ�" + cart.getTotalMoney());
		cart.deleteItem("1");
		System.out.println(cart.getAllItems());
		System.out.println("��ǰ�ܼ�" + cart.getTotalCount() + "����");
		System.out.println("��ǰ�ܼ�" + cart.getTotalMoney());
	}

	@Test
	public void test2() {
//		int i = 1;
//		for (int j = 1; j < 15; j++) {
//			i *= j;
//		}
//		System.out.println(i);
		
//		double a = 0.01;
//		double b = 0.06;
//		BigDecimal decimal1 = new BigDecimal(a);
//		BigDecimal decimal2 = new BigDecimal(b);
//		System.out.println(decimal1.add(decimal2));
		int num = 123456;
		System.out.println(Integer.toString(num));
		System.out.println((Integer.toString(num)).getClass());
	}
}
