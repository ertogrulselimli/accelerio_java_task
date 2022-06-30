package com.accelerio.mailmessagetracking.entity;


import com.accelerio.mailmessagetracking.enums.MovementStatus;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "MAIL_TRACKING")
public class MailTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRACKING_NO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "MAIL_ID",referencedColumnName = "MAIL_ID",unique = true)
    private MailMessage mailMessage;


    @ManyToOne
    @JoinColumn(name = "OFFICE_ID",referencedColumnName = "ID")
    private PostOffice postOffice;

    @Column(name = "ARRIVAL_DATE")
    private Instant arrivalDate;

    @Column(name = "DEPARTURE_DATE")
    private Instant departureDate;

    @Column(name = "RECEIPT_DATE")
    private Instant receiptDate;


    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private MovementStatus status;




}
