package edu.act.moneytransfer.countrollers;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class AccountCountroller {


    @Autowired
    private AccountService accountservice;

    @PostMapping("/api/account/create")
    public Account createaccount(@RequestBody Account account){

        return accountservice.createaccount(account);
    }

    //list all acounts
    @GetMapping("/api/account/list")
    public Iterable<Account> listAccounts(){
        return accountservice.allAccounts();

    }


}
