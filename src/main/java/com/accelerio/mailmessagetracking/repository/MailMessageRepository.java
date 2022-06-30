package com.accelerio.mailmessagetracking.repository;

import com.accelerio.mailmessagetracking.entity.MailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMessageRepository  extends JpaRepository<MailMessage, Long> {
}
