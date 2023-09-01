package org.cavila.hibernateapp;

import jakarta.persistence.EntityManager;
import org.cavila.hibernateapp.entity.Cliente;
import org.cavila.hibernateapp.entity.Factura;
import org.cavila.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccionalFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1L);

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);
            cliente.addFactura(f1)
                    .addFactura(f2);
//            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
