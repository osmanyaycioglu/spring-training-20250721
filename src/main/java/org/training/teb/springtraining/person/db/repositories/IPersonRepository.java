package org.training.teb.springtraining.person.db.repositories;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.training.teb.springtraining.person.service.models.Person;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Person findFirstByNameAndSurname(String name,
                                              String surname);

    List<Person> findByName(String name);

    List<Person> findByNameAndSurnameOrderBySurname(String name,
                                                    String surname);

    List<Person> findByNameIn(List<String> name);

    Future<List<Person>> findBySurname(String surname);

    Stream<Person> findByNameAndAmountBetween(String name,
                                              BigDecimal low,
                                              BigDecimal high);

    @Modifying
    @Query("update Person p set p.height=?1 where p.personId= ?2")
    void updateHeight(Integer height,Long personId);

    @Query("select p from Person p where p.name=?1")
    List<Person> searchName(String name);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName2(@Param("isim") String name);

    @Query(value = "select * from person p where p.person_name=?1", nativeQuery = true)
    List<Person> searchNameNative(String name);

    @Query("select p.name,p.surname from Person p where p.name=:isim")
    List<Object[]> searchNameToColoms(@Param("isim") String name);

//    @Query("select new org.training.teb.springtraining.person.db.repositories(p.name,p.surname) from Person p where p.name=:isim")
//    List<PersonInfo> searchNameToColoms2(@Param("isim") String name);

}
