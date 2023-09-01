package org.avila.java.jdbc;
import org.avila.java.jdbc.modelo.Categoria;
import org.avila.java.jdbc.modelo.Producto;
import org.avila.java.jdbc.repositorio.ProductoRepositorioImple;
import org.avila.java.jdbc.repositorio.Repositorio;
import org.avila.java.jdbc.util.ConexionBaseDatos;
import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImple();
        System.out.println("============= listar productos =============");
        repositorio.listar().forEach(System.out::println);
        System.out.println("\n");
        System.out.println("============= obtener por id =============");
        System.out.println(repositorio.porId(1L));
        System.out.println("\n");
        System.out.println("============= insertar nuevo producto =============");
        Producto producto = new Producto();
        producto.setNombre("Notebook Omen HP");
        producto.setPrecio(2900);
        producto.setFechaRegistro(new Date());
        Categoria categoria = new Categoria();
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto guardado con éxito");
        repositorio.listar().forEach(System.out::println);
    }
}







