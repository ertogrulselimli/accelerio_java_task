package com.accelerio.mailmessagetracking.dto;

import com.accelerio.mailmessagetracking.enums.MovementStatus;
import lombok.Data;

@Data
public class OperationMailMessageDTO {

    private Long mailId;

    private Long postOfficeIndex;

    private MovementStatus movementStatus;

}
