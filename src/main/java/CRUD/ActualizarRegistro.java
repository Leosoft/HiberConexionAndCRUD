package CRUD;


import config.HibernateUtil;
import entidades.Registro;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ActualizarRegistro {
    public static void actualizarUsuario(Registro usuario) {
        Session session = HibernateUtil.get().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
            System.out.println("Usuario actualizado exitosamente.");
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
