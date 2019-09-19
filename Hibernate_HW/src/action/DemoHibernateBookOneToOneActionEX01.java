package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.BookBean;
import model.BookDetailBean;
import util.HibernateUtil;

public class DemoHibernateBookOneToOneActionEX01 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.openSession();

		try {
			session.beginTransaction();
			
			BookBean book = new BookBean();
			BookDetailBean bookDetail = new BookDetailBean ();
			
			
			book.setBookname("harry portter");
			book.setAuthor("emma");
			book.setPrice(1200);
			
			bookDetail.setPublisher("APPLE");
			bookDetail.setPublisheraddress("USA");
			
			
			book.setBookDetail(bookDetail);
			bookDetail.setBook(book);
			
			session.save(book);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.closeFactory();
		}
	}

}
