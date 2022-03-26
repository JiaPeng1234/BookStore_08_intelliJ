package peng.service;

import java.util.List;

import peng.bean.Book;
import peng.bean.Page;

/**
 * ͼ��ҵ���߼�
 * @author JaP44
 *
 */
public interface BookService {

	/**
	 * ���ͼ��
	 * @param book
	 * @return
	 */
	public boolean add(Book book);
	
	/**
	 * �޸�ͼ��
	 * @param book
	 * @return
	 */
	public boolean update(Book book);
	
	/**
	 * ɾ��ͼ��
	 * @param book
	 * @return
	 */
	public boolean delete(Book book);
	
	/**
	 * ����һ��ͼ��
	 * @param book
	 * @return
	 */
	public Book getOne(Book book);
	
	/**
	 * ��ѯ������ͼ��
	 * @return
	 */
	public List<Book> getAll();
	
	/**
	 * ���ط�ҳ����
	 * @return
	 */
	public Page<Book> getPage(String pageNo, String pageSize);
	
	/**
	 * ���ռ۸����䷵�ط�ҳ����
	 * @return
	 */
	public Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice);
}
