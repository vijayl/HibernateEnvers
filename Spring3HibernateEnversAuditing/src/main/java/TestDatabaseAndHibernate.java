import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestDatabaseAndHibernate {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
			String url = "jdbc:mysql://localhost:8889/HibernateDB";
			String user = "root";
			String password = "root";
	
			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establish connection to MySQL
			Connection conn = DriverManager.getConnection(url, user, password);
		
			 SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		        // Create session from the Session Factory
		        Session session = sessionFactory.openSession();

		        // Save model objects using session.
		        session.beginTransaction();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
