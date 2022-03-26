package peng.dao;

import java.util.List;

import peng.bean.Book;

public interface BookDao {

	/**
	 * ��ȡ����ͼ��
	 * @return
	 */
	public List<Book> getAllBook();
	
	/**
	 * @param ���һ��ͼ�� ����Ҫ��ӵ�ͼ��
	 * @return true������ӳɹ�
	 */
	public boolean addBook(Book book);
	/**
	 * ɾ��һ��ͼ��
	 * @param bookҪɾ����ͼ�飬id
	 * @return
	 */
	public boolean delBook(Book book);
	/**
	 * �޸�һ��ͼ��
	 * @param bookҪ�޸ĵ�ͼ�飬�ڴ����book�������޸�
	 * @return
	 */
	public boolean updateBook(Book book);
	/**
	 * ȡ��ͼ�����
	 * @param book
	 * @return
	 */
	public Book getBook(Book book);
	/**
	 * ��ҳ����ͼ��ķ���
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Book> getPageList(int index, int size);
	/**
	 * ���ҵ������ݿ���bookһ���ж��ٱ�
	 * @return
	 */
	public int getTotalCount();
	/**
	 * ���ռ۸�������ҵ������ݿ���bookһ���ж��ٱ�
	 * @return
	 */
	public int getTotalCountByPrice(double minPrice, double maxPrice);
	/**
	 * ���ռ۸������ҳ����ͼ��
	 * @return
	 */
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice);
		
}
