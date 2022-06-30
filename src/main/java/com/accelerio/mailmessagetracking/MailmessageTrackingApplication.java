package com.accelerio.mailmessagetracking;

import com.accelerio.mailmessagetracking.entity.PostOffice;
import com.accelerio.mailmessagetracking.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class MailmessageTrackingApplication implements CommandLineRunner {

    @Autowired
    PostOfficeRepository postOfficeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MailmessageTrackingApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        PostOffice postOffice = new PostOffice();
        postOffice.setAddress("Test");
        postOffice.setIndex(1l);
        postOffice.setTitle("Test");
        postOfficeRepository.save(postOffice);
    }
}
