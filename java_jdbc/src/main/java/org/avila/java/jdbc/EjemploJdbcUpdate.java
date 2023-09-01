package org.avila.java.jdbc;

import org.avila.java.jdbc.modelo.Categoria;
import org.avila.java.jdbc.modelo.Producto;
import org.avila.java.jdbc.repositorio.ProductoRepositorioImple;
import org.avila.java.jdbc.repositorio.Repositorio;
import org.avila.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
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

            System.out.println("============ Actualizar producto ==============");
            Producto producto = new Producto();
            producto.setId(4L);
            producto.setNombre("Teclado Corsair k95 Mecánico");
            producto.setPrecio(700);
            //creamos la categoria
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            producto.setFechaRegistro(new Date());
            repositorio.guardar(producto);
            System.out.println("Producto Actualizado con éxito!!");

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








