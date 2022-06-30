package com.accelerio.mailmessagetracking.controller;


import com.accelerio.mailmessagetracking.dto.MailMessageDTO;
import com.accelerio.mailmessagetracking.dto.MailTrackingDTO;
import com.accelerio.mailmessagetracking.dto.OperationMailMessageDTO;
import com.accelerio.mailmessagetracking.dto.RegisterMailMessageDTO;
import com.accelerio.mailmessagetracking.entity.PostOffice;
import com.accelerio.mailmessagetracking.service.MailMessageService;
import com.accelerio.mailmessagetracking.service.MailTrackingService;
import com.accelerio.mailmessagetracking.service.PostOfficeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class BaseController {

    private final PostOfficeService postOfficeService;
    private final MailMessageService mailMessageService;
    private final MailTrackingService mailTrackingService;

    public BaseController(PostOfficeService postOfficeService, MailMessageService mailMessageService, MailTrackingService mailTrackingService) {
        this.postOfficeService = postOfficeService;
        this.mailMessageService = mailMessageService;
        this.mailTrackingService = mailTrackingService;
    }




    @GetMapping(value = "/postoffice/{index}")
    public PostOffice postOfficeByIndex(@PathVariable("index") final Long index) {
        return postOfficeService.getPostOfficeByIndex(index);
    }
    @ApiOperation(notes = "Registering mail message in system Mail type must be one of the following values :LETTER,\n" +
            "    PARCEL,\n" +
            "    PACKAGE,\n" +
            "    POSTCARD",value = "RegisterMailMessage")
    @PostMapping(value = "/mailmessage/register")
    public MailMessageDTO registerMailMessage(@RequestBody RegisterMailMessageDTO mailMessageDTO) {
        return mailMessageService.registerMailMessage(mailMessageDTO);
    }

    @ApiOperation(notes = "You should provide movement status possible values   ARRIVED,\n" +
            "    DEPARTURED,\n" +
            "    RECEIVED", value = "mail Operations")
    @PostMapping(value = "/mailmessage/operation")
    public MailTrackingDTO mailOperations(@RequestBody OperationMailMessageDTO dto) {
      return   mailTrackingService.trackMailMessage(dto);
    }

    @ApiOperation(notes = "Tracking by track no", value = "trackByTrackNo")
    @GetMapping(value = "/track-by-trackNo/{trackNo}")
    public MailTrackingDTO trackByTrackNo(@PathVariable("trackNo") final Long trackNo) {
        return mailTrackingService.getByTrackNo(trackNo);
    }

    @ApiOperation(notes = "Tracking by mail Id", value = "trackByMailId")
    @GetMapping(value = "/track-by-mailId/{mailId}")
    public MailTrackingDTO trackByMailId(@PathVariable("mailId") final Long mailId) {
        return mailTrackingService.getByMailId(mailId);
    }
}
