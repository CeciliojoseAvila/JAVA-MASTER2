package org.cavila.hibernateapp;

import jakarta.persistence.EntityManager;
import org.cavila.hibernateapp.entity.Cliente;
import org.cavila.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
