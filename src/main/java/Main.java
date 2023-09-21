import CRUD.ActualizarRegistro;
import CRUD.EliminarRegistro;
import CRUD.InsertarRegistro;
import CRUD.LeerRegistro;

import entidades.Registro;
import org.hibernate.Session;
import config.HibernateUtil;

public class Main {
    public static void main(String[] args){
        
        String loco = "";
        System.out.println("es un " + loco);
        
        System.out.println("Iniciando conexion a MYSQL con HIBERNATE");
        Session session = HibernateUtil.get().openSession();

        // Insertar un nuevo usuario
        Registro nuevoUsuario = new Registro();
        nuevoUsuario.setNombre("Thiago");
        nuevoUsuario.setApellido("Mow");
        nuevoUsuario.setEmail("mownito@example.com");
        InsertarRegistro.insertarUsuario(nuevoUsuario);

        // Leer un usuario por ID
        LeerRegistro.leerRegistro(16);

        // Actualizar un usuario
        Registro usuarioAActualizar = LeerRegistro.leerRegistro(4);
        if (usuarioAActualizar != null) {
            usuarioAActualizar.setNombre("Diego Torres");
            ActualizarRegistro.actualizarUsuario(usuarioAActualizar);
        }

        // Eliminar un usuario
        //EliminarRegistro.eliminarUsuario(15); // Cambia el ID según el usuario que desees eliminar

        session.close();
        System.out.println("finalizando la conexion a MYSQL con HIBERNATE");
    }
}
