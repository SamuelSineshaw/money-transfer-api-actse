package edu.act.moneytransfer.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data  //to automatically add setter gater methods
public class TransferRequest {

    private Long senderId;
    private Long receiverId;
    private Double amount;
    private String reason;

}
