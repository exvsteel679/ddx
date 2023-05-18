/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.finalchallenge;

import javax.persistence.EntityManager;

/**
 *
 * @author eloyt
 */
public class SQLActionsOnEspecies {

    public static void insertData(Especies especie) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(especie);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateData(Especies e) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteData(Especies e) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        e = em.find(Especies.class, e.getNombre());
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }

    public static Especies query(Especies e) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        e = em.find(Especies.class, e.getNombre());
        em.close();
        return e;
    }
}
