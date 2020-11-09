package com.test.repository;

import com.test.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnketaRepository extends JpaRepository<Anketa, Integer> {

    List<Anketa> findAllByCity(String city);

    List<Anketa> findTop3ByCity(String city);

    Anketa findById(int id);

    List<Anketa> findBySerialAndNumber(int serial, int number);

    List <Anketa> findByNumber(int number);


    @Query(value = "select * from anketa", nativeQuery = true)
    List<AnketaDTO> getAllAnketa();

    @Query(value = "select city from Anketa", nativeQuery = true)
   List<AnketaDTOCity> getCity();

    @Query(value = "select city, number, sum(serial) from Anketa group by city", nativeQuery = true)
    List<AnketaDTOCityNumberSum> groupCity();

    @Query(value = "select * from Anketa inner join Person", nativeQuery = true)
    Object[] joinPerson();

    @Query(value = "select new com.test.entity.AnketaDTOListCount(a.city, count(a.number))" +
            "from Anketa as a group by a.city")
    List<AnketaDTOListCount> numberCity(int number);

    @Query("select new com.test.entity.Anketa(a.id, a.number, a.city, a.serial)"
    + "from Anketa as a")
    List<Anketa> getCityandId();

    @Query("select new com.test.entity.AnketaDTOIdCount(a.id, count(a.city))" +
    "from Anketa as a group by a.city")
    List<AnketaDTOIdCount> countAnketa();




}
