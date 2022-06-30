package com.accelerio.mailmessagetracking.repository;

import com.accelerio.mailmessagetracking.entity.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

    Optional<PostOffice> findByIndex(final Long index);
}
