package org.samuel_vargas.Main.Infraestructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.samuel_vargas.Main.Domain.Gorra;
import org.samuel_vargas.Main.Aplication.GorraRepository;

import java.util.List;
import java.util.Optional;

public class JpaCanchaRepository implements GorraRepository {
    private final EntityManagerFactory emf;

    public JpaCanchaRepository() {
        emf = Persistence.createEntityManagerFactory("CitasUp");
    }

    @Override
    public void saveCancha(Gorra cancha) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cancha);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateCancha(Gorra cancha) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(cancha);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteCancha(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Gorra cancha = em.find(Gorra.class, id);
            if (cancha != null) {
                em.remove(cancha);
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public Optional<Gorra> findCanchaById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return Optional.ofNullable(em.find(Gorra.class, id));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Gorra> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT c FROM Cancha c", Gorra.class)
                    .getResultList();
        }
    }
}
