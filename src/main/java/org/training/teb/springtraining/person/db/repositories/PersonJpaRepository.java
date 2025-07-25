package org.training.teb.springtraining.person.db.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.training.teb.springtraining.person.service.models.Person;

@Repository
public class PersonJpaRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void insertPerson(Person personParam) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.joinTransaction();
            em.persist(personParam);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void insertPersonJava(Person personParam) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction()
              .begin();
            try {
                em.persist(personParam);
                em.getTransaction()
                  .commit();
            } catch (Exception exp) {
                em.getTransaction()
                  .rollback();
                exp.printStackTrace();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
