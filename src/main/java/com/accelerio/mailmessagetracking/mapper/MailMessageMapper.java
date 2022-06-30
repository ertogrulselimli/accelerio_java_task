package com.accelerio.mailmessagetracking.mapper;


import com.accelerio.mailmessagetracking.dto.MailMessageDTO;
import com.accelerio.mailmessagetracking.dto.RegisterMailMessageDTO;
import com.accelerio.mailmessagetracking.entity.MailMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailMessageMapper {


   MailMessage toMailMessage(RegisterMailMessageDTO mailMessageDTO);

   MailMessageDTO toMailMessageDTO(MailMessage mailMessage);

}
