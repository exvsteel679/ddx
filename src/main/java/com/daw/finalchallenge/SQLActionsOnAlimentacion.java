/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.finalchallenge;

import javax.persistence.EntityManager;

/**
 *
 * @author Alumnado
 */
public class SQLActionsOnAlimentacion {

    public static void insertData(Alimentacion alimentacion) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(alimentacion);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateData(Alimentacion a) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteData(Alimentacion a) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        a = em.find(Alimentacion.class, a.getAlimentacion());
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }

    public static Alimentacion query(Alimentacion a) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        a = em.find(Alimentacion.class, a.getAlimentacion());
        em.close();
        return a;
    }
}
