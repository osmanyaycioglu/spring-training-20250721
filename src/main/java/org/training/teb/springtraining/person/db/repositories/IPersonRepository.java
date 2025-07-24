package org.training.teb.springtraining.person.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.teb.springtraining.person.service.models.Person;

public interface IPersonRepository extends JpaRepository<Person,Long> {
}
