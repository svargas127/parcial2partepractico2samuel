package org.samuel_vargas.Main.Interfaces;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.samuel_vargas.Main.Domain.Gorra;
import org.samuel_vargas.Main.Aplication.GorraRepository;
import java.util.List;

public class JpaGorraRepository implements GorraRepository {
    private final EntityManagerFactory emf;

    public JpaGorraRepository() {
        emf = Persistence.createEntityManagerFactory("GorrasUp");
    }

    @Override
    public void saveGorra(Gorra gorra) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(gorra);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateGorra(Gorra gorra) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(gorra);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteGorra(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Gorra gorra = em.find(Gorra.class, id);
            if (gorra != null) {
                em.remove(gorra);
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public Gorra findGorraById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Gorra.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Gorra> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT g FROM Gorra g", Gorra.class)
                    .getResultList();
        }
    }
}

