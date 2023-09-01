package org.avila.java.jdbc;

import org.avila.java.jdbc.modelo.Producto;
import org.avila.java.jdbc.repositorio.ProductoRepositorioImple;
import org.avila.java.jdbc.repositorio.Repositorio;
import org.avila.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcDelete {
    public static void main(String[] args) {
       /*String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
        String username = "root";
        String password = "8629";*/
        try (Connection conn = ConexionBaseDatos.getInstance() ){ //DriverManager.getConnection(url, username, password);

            Repositorio<Producto> repositorio = new ProductoRepositorioImple();
            System.out.println("============ Listar ==============");
            repositorio.listar().forEach(System.out::println);
            System.out.print("\n");

            System.out.println("============ Obtener por id ==============");
            System.out.println(repositorio.porId(2l));
            // System.out.println(repositorio.porId(1l));
            System.out.print("\n");

            System.out.println("============ Eliminar producto ==============");

            repositorio.eliminar(5L);
            System.out.println("Producto Eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

            //Statement stmt = conn.createStatement();
           // ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");
            /*
            while (resultado.next()){
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getDate("fecha_registro"));
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}








