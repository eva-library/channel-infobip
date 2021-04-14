package com.everis.eva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.eva.domain.WhatsAppUser;

@Repository
public interface WhatsAppRepository extends JpaRepository<WhatsAppUser, Integer>{

}
