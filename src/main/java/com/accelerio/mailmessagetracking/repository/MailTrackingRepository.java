package com.accelerio.mailmessagetracking.repository;


import com.accelerio.mailmessagetracking.entity.MailMessage;
import com.accelerio.mailmessagetracking.entity.MailTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailTrackingRepository  extends JpaRepository<MailTracking,Long> {

    Optional<MailTracking>  findByMailMessage(final MailMessage mailMessage);

    Optional<MailTracking> findById(final Long id);
}
