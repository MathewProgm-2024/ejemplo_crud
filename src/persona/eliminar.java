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
public class eliminar {
    public static void main(String[] args) {
        // CONEXION
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // DATO A ELIMINAR
        int id_eliminar = 2;
        
        // INSTRUCCION SQL
        String sql = "DELETE FROM persona where id="+id_eliminar;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql); // ELIMINAR DATO
            rs = st.executeQuery("SELECT * FROM persona"); // TRAER DATOS DE LA TABLA PERSONA
            rs.next();

            // IMPRIMIR EN CONSOLA LOS DATOS DE LA TABLA PERSONA
            do {
                System.out.println(rs.getInt("id")+": "+rs.getString("nombre")+" - "+rs.getString("apellido")+" - "+rs.getString("edad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
