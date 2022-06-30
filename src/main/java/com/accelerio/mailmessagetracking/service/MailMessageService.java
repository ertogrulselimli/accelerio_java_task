package com.accelerio.mailmessagetracking.service;

import com.accelerio.mailmessagetracking.dto.MailMessageDTO;
import com.accelerio.mailmessagetracking.dto.RegisterMailMessageDTO;
import com.accelerio.mailmessagetracking.entity.MailMessage;
import com.accelerio.mailmessagetracking.mapper.MailMessageMapper;
import com.accelerio.mailmessagetracking.repository.MailMessageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MailMessageService {

    private final MailMessageRepository mailMessageRepository;
    private final MailMessageMapper mailMessageMapper;

    public MailMessageService(MailMessageRepository mailMessageRepository, MailMessageMapper mailMessageMapper) {
        this.mailMessageRepository = mailMessageRepository;
        this.mailMessageMapper = mailMessageMapper;
    }


    @Transactional
    public MailMessageDTO registerMailMessage(RegisterMailMessageDTO dto) {

        MailMessage mailMessage = mailMessageMapper.toMailMessage(dto);
        MailMessage persisted = mailMessageRepository.save(mailMessage);
        return mailMessageMapper.toMailMessageDTO(persisted);
    }



}
