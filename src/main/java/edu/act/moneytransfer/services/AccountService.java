package edu.act.moneytransfer.services;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;


@Service

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account createaccount(Account account){
        int age= calculateAge(account.getDateOfBirth(),LocalDate.now());
        if(age>15){

            return accountRepository.save(account);
        }else
            System.out.println("age less than 15 is not allowed!");
            return null;



    }
    private static int calculateAge(LocalDate birthDate,LocalDate currentDate){
             if((birthDate!=null) && (currentDate!=null)){
                  return Period.between(birthDate,currentDate).getYears();
             }else
                 return 0;



    }
    public Iterable<Account> allAccounts(){
        return accountRepository.findAll();
    }

}
