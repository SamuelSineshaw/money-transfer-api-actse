package edu.act.moneytransfer;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.domains.Transfer;
import edu.act.moneytransfer.dto.TransferRequest;
import edu.act.moneytransfer.services.AccountService;
import edu.act.moneytransfer.services.TransferService;
import lombok.extern.java.Log;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Log
//@AutoConfigureTestDatabase
public class TransferServiceIntegrationTest {

    @Autowired
    private TransferService transferservice;
    @Autowired
    private AccountService accountService;

    //Happy path

    @Test
    public void ShouldTransferMoneyFromValidAccountToAnother() throws Exception {


        //given
        TransferRequest transferrequest=TransferRequest.builder()
                .senderId(1L)
                .receiverId(2L)
                .amount(100.0)
                .reason("gift")
                .build();
         //when
        Transfer transfer = transferservice.transferMoney(transferrequest);

        //Then
        assertEquals(transfer.getAmount(),transferrequest.getAmount());
        assertNotNull(transfer.getId());
        assertEquals(transfer.getStatus(), "SUCCESSFUL");

       Account senderAccount = accountService.getAccountById(1L);
        Account receiverAccount = accountService.getAccountById(2L);

        assert senderAccount.getBalance() == 100.0;
        assert receiverAccount.getBalance() == 150.0;

    }

    @Ignore
    @Test(expected = Exception.class)
    public void ShouldFaillIfTransferAmountIsGreatherThanAccountBalance() throws Exception {

        //given
        TransferRequest transferrequest=TransferRequest.builder()
                .senderId(1L)
                .receiverId(2L)
                .amount(10000.0)
                .reason("gift")
                .build();
        //when
        Transfer transfer = transferservice.transferMoney(transferrequest);

    }


}
