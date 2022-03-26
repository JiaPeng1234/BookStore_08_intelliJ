package peng.test;

import java.util.List;

import org.junit.Test;

import peng.bean.Book;
import peng.bean.Page;
import peng.dao.BookDao;
import peng.dao.Impl.BookDaoImpl;
import peng.service.BookService;
import peng.service.Impl.BookServiceImpl;

public class BookDaoTest {

	BookDao bd = new BookDaoImpl();
	
	@Test
	public void test() {
		List<Book> list = bd.getAllBook();
		System.out.println(list);
	}
	
	/**
	 * �yԇ��ӈD��
	 */
	@Test
	public void test2() {
		Book book = new Book(null, "����һ��BookDao", "pinklipinkli", 12.12, 1, 22, null);
		boolean b = bd.addBook(book);
		System.out.println(b);
	}
	
	/**
	 * �yԇɾ���D��
	 */
	@Test
	public void test3() {
		Book book = new Book();
		book.setId(3);
		boolean b = bd.delBook(book);
		System.out.println(b);
	}
	
	/**
	 * �yԇ�޸ĈD��
	 */
	@Test
	public void test4() {
		Book book = new Book();
		book.setId(24);
		book.setTitle("�����д�");
		book.setAuthor("�i��");
		boolean b = bd.updateBook(book);
		System.out.println(b);
	}
	
	/**
	 * �yԇ��ȡpage
	 */
	@Test
	public void test5() {
		BookService bs = new BookServiceImpl();
		
		Page<Book> page = bs.getPage("2", "4");
		System.out.println(page);
		System.out.println(page.getPageData());
	}
	
	/**
	 * �yԇ��ȡpageByPrice
	 */
	@Test
	public void test6() {
		BookService bs = new BookServiceImpl();
		
		Page<Book> page = bs.getPageByPrice("1", "4", "10", "40");
		System.out.println(page);
		System.out.println(page.getPageData());
		System.out.println(page.getTotalCount());
	}
}
