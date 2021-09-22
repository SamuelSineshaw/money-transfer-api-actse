package edu.act.moneytransfer.services;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.act.moneytransfer.utils.AgeCalculator;

import java.time.LocalDate;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createaccount(Account account){
        // validation
        int age = AgeCalculator.calculateAge(account.getDateOfBirth(), LocalDate.now());

        if (age > 15) {
            return accountRepository.save(account);
        } else {
            System.out.println("Sorry. User under the age of 15 years cannot register.");
            return null;
        }
    }


    public Iterable<Account> allAccounts(){
        return accountRepository.findAll();
    }


    public Account getAccountById(Long senderId) {
        return accountRepository.findById(senderId).get();
    }


    public void updateBalance(Account senderAccount, Double newSenderBalance) {

        senderAccount.setBalance(newSenderBalance);
        accountRepository.save(senderAccount);
    }
}
