package sda;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// niezbedna jako punkt konfiguacyjny polaczenia z hibernate'm
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();

        // metadata to inforamcje dotyczace plikow. z danych zaladowanych wczesniej
        //tworzymy sobie obiek metadata
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder().build();

        //stworzenie sesji z danych zawartych w pliku hibernate cfg xml
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
