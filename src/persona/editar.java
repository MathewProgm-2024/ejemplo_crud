/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class editar {

    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        // DATOS A EDITAR
        int id_editar = 1;
        String new_nombre = "Fabio";
        String new_apellido = "Navarro";
        String new_edad = "28";

        //ONSTRUCCION SQL
        String sql = "UPDATE persona set nombre='" + new_nombre + "', apellido='" + new_apellido + "', edad='" + new_edad + "' where id=" + id_editar;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // EDITAR DATOS
            rs = st.executeQuery("SELECT * FROM persona"); // TRAER DATOS DE LA TABLA PERSONA
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PERSONA
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apellido")+" - "+rs.getString("edad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
