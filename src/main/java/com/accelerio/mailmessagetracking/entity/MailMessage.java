package com.accelerio.mailmessagetracking.entity;

import com.accelerio.mailmessagetracking.enums.MailType;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "MAIL_MESSAGE")
public class MailMessage {
    @Id
    @Column(name = "MAIL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private MailType type;

    private Long addresseeIndex;

    private String addresseeAddress;

    private String addresseeName;


}
