package com.ProjetSpring.ProjetSpring.Repository;

import com.ProjetSpring.ProjetSpring.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByUserIdUser(Long idUser);

    //@Query("SELECT a FROM Animal a WHERE a.idUser = :userId")
    //List<Animal> findByUserID(@Param("userId") Long userId);

}
