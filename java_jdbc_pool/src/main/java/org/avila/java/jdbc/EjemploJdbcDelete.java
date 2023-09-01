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

        Repositorio<Producto> repositorio = new ProductoRepositorioImple();
        System.out.println("============= listar =============");
        repositorio.listar().forEach(System.out::println);

        System.out.println("============= obtener por id =============");
        System.out.println(repositorio.porId(1L));

        System.out.println("============= Eliminar producto =============");
        repositorio.eliminar(9L);
        System.out.println("Producto eliminado con éxito");
        repositorio.listar().forEach(System.out::println);
    }
}








