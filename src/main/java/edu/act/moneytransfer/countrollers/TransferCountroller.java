package edu.act.moneytransfer.countrollers;

import edu.act.moneytransfer.domains.Transfer;
import edu.act.moneytransfer.dto.TransferRequest;
import edu.act.moneytransfer.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferCountroller {

    @Autowired
    private TransferService transferservice;

    @GetMapping("/api/transfer/list")
    public Iterable<Transfer>getAllTransfers(){

        return transferservice.getAllTransfers();

    }

    @PostMapping("/api/transfer")
    public Transfer transferMoney(@RequestBody TransferRequest transferrequest) throws Exception {

        return transferservice.transferMoney(transferrequest);

    }
}
