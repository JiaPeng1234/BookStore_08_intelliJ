package peng.service.Impl;

import java.util.List;

import peng.bean.Book;
import peng.bean.Page;
import peng.dao.BookDao;
import peng.dao.Impl.BookDaoImpl;
import peng.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao bd = new BookDaoImpl();

	/**
	 * ����һ��ͼ��
	 */
	@Override
	public boolean add(Book book) {
		return bd.addBook(book);
	}

	/**
	 * ����һ��ͼ��
	 */
	@Override
	public boolean update(Book book) {
		return bd.updateBook(book);
	}

	/**
	 * ɾ��ͼ��
	 */
	@Override
	public boolean delete(Book book) {
		return bd.delBook(book);
	}

	/**
	 * ����һ��ͼ��
	 */
	@Override
	public Book getOne(Book book) {
		return bd.getBook(book);
	}

	/**
	 * ��������ͼ��
	 */
	@Override
	public List<Book> getAll() {
		return bd.getAllBook();
	}

	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		
		Page<Book> page = new Page<Book>();
		
		// 1. ���û����������ת�Ͳ���װ��������Ĭ��ֵ
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. ��ΪҪʹ��totalcountҲ���ǵ�ǰ�ܼ�¼��������Ҫ��ѯ���ݿ�
		// �������ӵ�ps����Ҫ֪�����Ƿ�Խ�Ͻ磬����ļ��������߼����밴������˳��
		// ��Ҫ����ҳ���С
		page.setPageSize(ps);
		// ��ȡ�ܼ�¼��
		int totalcount = bd.getTotalCount();
		// �����ܼ�¼��
		page.setTotalCount(totalcount);
		// �����Ϳ��������ҳ�� getTotalPage()
		// setPageNo(pn)��pageNo��ֵ��page����ͬʱ��Ҫ�ж�pn�Ƿ�>0&<page.getTotalPage()��������Ҫ��ҳ��page.getTotalPage()
		// getTotalPage()����setPageNo֮���Զ����ã���getTotalPage����Ҫ֪��getTotalCount() / getPageSize()
		page.setPageNo(pn);
		
		// 3. ���õ���pageData���ݸ�ֵ��page�����е�pageData����
		List<Book> list = bd.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);

		return page;
	}
	
	@Override
	public Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice) {
		
		Page<Book> page = new Page<Book>();
		double max = Double.MAX_VALUE;
		double min = 0.0;
		try {
			max = Double.parseDouble(maxPrice);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			min = Double.parseDouble(minPrice);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 1. ���û����������ת�Ͳ���װ��������Ĭ��ֵ
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. ��ΪҪʹ��totalcountҲ���ǵ�ǰ�ܼ�¼��������Ҫ��ѯ���ݿ�
		// �������ӵ�ps����Ҫ֪�����Ƿ�Խ�Ͻ磬����ļ��������߼����밴������˳��
		// ��Ҫ����ҳ���С
		page.setPageSize(ps);
		// ��ȡ�ܼ�¼��
		int totalcount = bd.getTotalCountByPrice(min, max);
		// �����ܼ�¼��
		page.setTotalCount(totalcount);
		// �����Ϳ��������ҳ�� getTotalPage()
		// setPageNo(pn)��pageNo��ֵ��page����ͬʱ��Ҫ�ж�pn�Ƿ�>0&<page.getTotalPage()��������Ҫ��ҳ��page.getTotalPage()
		// getTotalPage()����setPageNo֮���Զ����ã���getTotalPage����Ҫ֪��getTotalCount() / getPageSize()
		page.setPageNo(pn);
		
		// 3. ���õ���pageData���ݸ�ֵ��page�����е�pageData����
		List<Book> list = bd.getPageByPrice(page.getIndex(), page.getPageSize(), min, max);
		page.setPageData(list);

		return page;
	}

}
