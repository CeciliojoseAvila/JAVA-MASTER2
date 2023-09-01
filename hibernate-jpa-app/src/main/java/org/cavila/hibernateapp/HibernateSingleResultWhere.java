package org.cavila.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.cavila.hibernateapp.entity.Cliente;
import org.cavila.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernateSingleResultWhere {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
       // query.setParameter(1, "debito");
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
        query.setMaxResults(1);
        //List<Cliente> clientes = query.getResultList();
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}

// ingresar parametros como "debito", "credito","paypal" .