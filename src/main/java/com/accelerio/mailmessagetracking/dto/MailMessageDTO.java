package com.accelerio.mailmessagetracking.dto;

import com.accelerio.mailmessagetracking.enums.MailType;
import lombok.Data;


@Data
public class MailMessageDTO {

    private Long id;

    private MailType type;

    private Long addresseeIndex;

    private String addresseeAddress;

    private String addresseeName;

}
