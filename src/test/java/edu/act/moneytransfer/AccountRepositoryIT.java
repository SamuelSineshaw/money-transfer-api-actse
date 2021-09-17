package edu.act.moneytransfer;


import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepositoryIT {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void ShouldCreateAccountInDb(){

        Account account=Account.builder()
                .firstName("samuel")
                .middleName("sineshaw")
                .lastName("tesasu")
                .dateOfBirth(LocalDate.of(2020,01,01))
                .email("slimsami2007@gmail.com")
                .phoneNumber("+0923975645")
                .pin(1234)
                .build();

          Account savedaccount= accountRepository.save(account);

          assertThat(savedaccount).isNotNull();
          assertThat(savedaccount.getId()).isEqualTo(1);
          assertThat(savedaccount.getFirstName()).isEqualTo("samuel");


    }


}
