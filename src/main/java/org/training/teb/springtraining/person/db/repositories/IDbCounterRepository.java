package org.training.teb.springtraining.person.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.teb.springtraining.person.service.models.DbCounter;

public interface IDbCounterRepository extends JpaRepository<DbCounter,Long> {

}
