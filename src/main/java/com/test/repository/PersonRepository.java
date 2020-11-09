package com.test.repository;

import com.test.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findAll();

    List<Person>  findAllByName(String name);

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> findAllSQL();

    @Query(value = "select * from Person where name = ?1",  nativeQuery = true)
    List<Person> findAllByNameSQL(String name);

    @Query(value = "select address, age from Person where name = ?1",  nativeQuery = true)
    List<IPersonDTOAddressAge> findAddressAgeByNameSQL(String name);

    @Query("from Person")
    List<Person> findAllJPQL();

    @Query("from Person where name = ?1")
    List<Person> findAllByNameJPQL(String name);

    @Query("select new com.test.entity.PersonDTOAddressAge(p.address, p.age)" +
            "from Person as p where p.name = ?1")
    List<PersonDTOAddressAge> findAddressAgeByNameJPQL(String name);


    @Query("select new com.test.entity.DTOPersonAddressAvgAge(p.address, avg(p.age)) from Person as p group by p.address")
    List<DTOPersonAddressAvgAge> dtoAddressAvg();


    @Query(value = "select address, avg(age) as avg from person group by address", nativeQuery = true)
    List<DTOPersonAvgSQL> addressAvg();


    @Query(value = "select p.name, p.address, a.city from person as p inner join anketa as a where p.id = a.id", nativeQuery = true)
    List<IPersonAnketaDTONameAddressCity> iPersonAnketaDTONameAddressCity();


    @Query("select new com.test.entity.PersonAnketaDTONameAddress(p.name, p.address, a.city)" +
            "from Person as p join Anketa as a on p.id = a.id")
    List<PersonAnketaDTONameAddress> personAnketaDTONameAddress();
}
