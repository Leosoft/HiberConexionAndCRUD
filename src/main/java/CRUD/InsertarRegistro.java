package CRUD;



import config.HibernateUtil;
import entidades.Registro;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertarRegistro {
    public static void insertarUsuario(Registro usuario) {
        Session session = HibernateUtil.get().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
            System.out.println("Usuario insertado exitosamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
