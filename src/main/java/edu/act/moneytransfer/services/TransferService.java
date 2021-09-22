package edu.act.moneytransfer.services;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.domains.Transfer;
import edu.act.moneytransfer.dto.TransferRequest;
import edu.act.moneytransfer.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransferService {

    @Autowired
    private AccountService accountservice;

    @Autowired
    private TransferRepository transferRepository;


    public Transfer transferMoney(TransferRequest transferrequest) throws Exception {

        Account senderAccount = accountservice.getAccountById(transferrequest.getSenderId());
        if (senderAccount == null) {
            throw new Exception();
        }


        Account receiverAccount = accountservice.getAccountById(transferrequest.getReceiverId());
        if (receiverAccount == null){
            throw new Exception();
    }
        if (transferrequest.getSenderId().equals(transferrequest.getReceiverId())) {
            throw new Exception();
        }

        if(senderAccount.getBalance() >= transferrequest.getAmount()){

            Double newSenderBalance= senderAccount.getBalance() - transferrequest.getAmount();

            accountservice.updateBalance(senderAccount,newSenderBalance);

            Double newReceiverBalance= receiverAccount.getBalance() + transferrequest.getAmount();
            accountservice.updateBalance(receiverAccount,newReceiverBalance);

            Transfer transfer=Transfer.builder()
                    .senderAccoount(senderAccount)
                    .receiverAccount(receiverAccount)
                    .amount(transferrequest.getAmount())
                    .reason(transferrequest.getReason())
                    .status("asuccesfull")
                    .build();

            transferRepository.save(transfer);
            return transfer;

        }else{

            throw new Exception();
        }

        }

    public Iterable<Transfer> getAllTransfers() {

        return transferRepository.findAll();
    }

    }

