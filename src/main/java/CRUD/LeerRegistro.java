package CRUD;

import entidades.Registro;
import config.HibernateUtil;
import org.hibernate.Session;

public class LeerRegistro {
    public static Registro leerRegistro(int id) {
        Session session = HibernateUtil.get().openSession();
        Registro registro = null;

        try {
            registro = session.get(Registro.class, id);

            if (registro != null) {
                System.out.println("ID: " + registro.getId());
                System.out.println("Nombre: " + registro.getNombre());
                System.out.println("Apellido: " + registro.getApellido());
                System.out.println("Email: " + registro.getEmail());
                // Puedes seguir imprimiendo otros atributos aquí
            } else {
                System.out.println("No se encontró el registro con ID " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return registro;
    }
}
