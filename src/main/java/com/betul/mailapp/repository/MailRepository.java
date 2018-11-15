package com.betul.mailapp.repository;

import com.betul.mailapp.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailEntity, Long> {

}
