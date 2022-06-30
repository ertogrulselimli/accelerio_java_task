package com.accelerio.mailmessagetracking.service;


import com.accelerio.mailmessagetracking.entity.PostOffice;
import com.accelerio.mailmessagetracking.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostOfficeService {


    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }




    @Transactional
    public PostOffice getPostOfficeByIndex(final Long index) {
      return   postOfficeRepository.findByIndex(index).orElseThrow(() ->new  RuntimeException("Post office not found"));
    }

}
