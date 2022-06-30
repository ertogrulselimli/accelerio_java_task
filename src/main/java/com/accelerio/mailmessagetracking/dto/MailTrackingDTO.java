package com.accelerio.mailmessagetracking.dto;


import com.accelerio.mailmessagetracking.entity.MailMessage;
import com.accelerio.mailmessagetracking.entity.PostOffice;
import com.accelerio.mailmessagetracking.enums.MovementStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
public class MailTrackingDTO {


    private Long trackNo;


    private Long mailMessageId;


    private Long postOfficeIndex;


    private Instant arrivalDate;


    private Instant departureDate;


    private Instant receiptDate;


    private MovementStatus status;


}
