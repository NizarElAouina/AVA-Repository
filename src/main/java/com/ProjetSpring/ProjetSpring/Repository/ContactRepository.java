package com.ProjetSpring.ProjetSpring.Repository;

import com.ProjetSpring.ProjetSpring.model.Contact;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
