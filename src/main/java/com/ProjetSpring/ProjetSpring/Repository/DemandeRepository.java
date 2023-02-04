package com.ProjetSpring.ProjetSpring.Repository;

import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DemandeRepository extends JpaRepository<DemandeRemboursement, Integer> {
}
