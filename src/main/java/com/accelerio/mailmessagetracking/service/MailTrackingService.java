package com.accelerio.mailmessagetracking.service;


import com.accelerio.mailmessagetracking.dto.MailTrackingDTO;
import com.accelerio.mailmessagetracking.dto.OperationMailMessageDTO;
import com.accelerio.mailmessagetracking.entity.MailMessage;
import com.accelerio.mailmessagetracking.entity.MailTracking;
import com.accelerio.mailmessagetracking.entity.PostOffice;
import com.accelerio.mailmessagetracking.enums.MovementStatus;
import com.accelerio.mailmessagetracking.mapper.MailTrackingMapper;
import com.accelerio.mailmessagetracking.repository.MailMessageRepository;
import com.accelerio.mailmessagetracking.repository.MailTrackingRepository;
import com.accelerio.mailmessagetracking.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class MailTrackingService {

    private final MailMessageRepository mailMessageRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final MailTrackingRepository mailTrackingRepository;
    private final MailTrackingMapper mailTrackingMapper;

    public MailTrackingService(MailMessageRepository mailMessageRepository, PostOfficeRepository postOfficeRepository, MailTrackingRepository mailTrackingRepository, MailTrackingMapper mailTrackingMapper) {
        this.mailMessageRepository = mailMessageRepository;
        this.postOfficeRepository = postOfficeRepository;
        this.mailTrackingRepository = mailTrackingRepository;
        this.mailTrackingMapper = mailTrackingMapper;
    }





    @Transactional
    public MailTrackingDTO trackMailMessage(OperationMailMessageDTO dto) {
        MailMessage mailMessage = mailMessageRepository.findById(dto.getMailId()).orElseThrow(() -> new RuntimeException("Mail message not found with id " + dto.getMailId()));
        PostOffice postOffice = postOfficeRepository.findByIndex(dto.getPostOfficeIndex()).orElseThrow(() -> new RuntimeException("Post office not found with index " + dto.getPostOfficeIndex()));
        MailTracking mailTracking=null;
        if(dto.getMovementStatus() != MovementStatus.ARRIVED) {
            mailTracking = mailTrackingRepository.findByMailMessage(mailMessage).orElseThrow(()->new RuntimeException("Mail tracking record not found"));
            if(dto.getMovementStatus() == MovementStatus.DEPARTURED) {
                mailTracking.setDepartureDate(Instant.now());
            }else{
                mailTracking.setReceiptDate(Instant.now());
            }
        }else{
            mailTracking=new MailTracking();
            mailTracking.setPostOffice(postOffice);
            mailTracking.setMailMessage(mailMessage);
            mailTracking.setArrivalDate(Instant.now());
        }
        mailTracking.setStatus(dto.getMovementStatus());
        mailTracking.setPostOffice(postOffice); //also need to check post Office Id is not different
        MailTracking persisted = mailTrackingRepository.save(mailTracking);
        return mailTrackingMapper.toDto(persisted);
    }


    @Transactional(readOnly = true)
    public MailTrackingDTO getByTrackNo(final Long trackNo) {
        MailTracking mailTracking = mailTrackingRepository.findById(trackNo).orElseThrow(() -> new RuntimeException("Track no not found"));
        return mailTrackingMapper.toDto(mailTracking);
    }


    @Transactional(readOnly = true)
    public MailTrackingDTO getByMailId(final Long mailId) {
        MailMessage mailMessage = mailMessageRepository.findById(mailId).orElseThrow(() -> new RuntimeException("Mail Id not found"));
        MailTracking mailTracking = mailTrackingRepository.findByMailMessage(mailMessage).orElseThrow(() -> new RuntimeException("Tracking information not found"));
        return mailTrackingMapper.toDto(mailTracking);
    }

}
