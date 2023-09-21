package CRUD;

import entidades.Registro;
import config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EliminarRegistro {
    public static void eliminarUsuario(int id) {
        Session session = HibernateUtil.get().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Registro usuario = session.get(Registro.class, id);

            if (usuario != null) {
                session.delete(usuario);
                transaction.commit();
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el usuario con ID " + id);
            }
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
