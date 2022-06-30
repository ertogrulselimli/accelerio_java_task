package com.accelerio.mailmessagetracking.mapper;


import com.accelerio.mailmessagetracking.dto.MailTrackingDTO;
import com.accelerio.mailmessagetracking.entity.MailTracking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MailTrackingMapper {


    @Mappings(value = {
            @Mapping(source = "mailMessage.id", target = "mailMessageId"),
            @Mapping(source = "postOffice.index", target = "postOfficeIndex"),
            @Mapping(source = "id",target = "trackNo")
    })
   MailTrackingDTO toDto(MailTracking mailTracking);

}
