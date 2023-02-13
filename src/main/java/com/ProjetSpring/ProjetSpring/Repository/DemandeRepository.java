package com.ProjetSpring.ProjetSpring.Repository;

import com.ProjetSpring.ProjetSpring.model.Animal;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<DemandeRemboursement, Integer> {

    List<DemandeRemboursement> findByUserIdUser(Long idUser);
}
