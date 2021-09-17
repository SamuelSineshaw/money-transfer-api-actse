package edu.act.moneytransfer;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AccountCountrollerIT {

    private final String Account_EndPoint="/api/account/create";
    @Autowired
    private MockMvc mockmvc;

    @Test
    public void shouldCrateAccountWithValidInformation() throws Exception {



        String payload = "{\n" +
                "  \"firstName\": \"tadele\",\n" +
                "  \"middleName\": \"kebu\",\n" +
                "  \"lastName\": \"bebi\",\n" +
                "  \"email\": \"sisay@gmail.com\",\n" +
                "  \"phoneNumber\": \"09863893337\",\n" +
                "  \"dateOfBirth\": \"1985-01-01\",\n" +
                "  \"pin\": 15469\n" +
                "}";

        mockmvc.perform(
                post(Account_EndPoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        )
                .andDo(print())
                .andExpect(status().isOk());




    }

    @Ignore

    @Test
    public void ShouldFaillBecausePhoneNumberAndEmailIsEmpty() throws Exception {



        String payload = "{\n" +
                "  \"firstName\": \"tadele\",\n" +
                "  \"middleName\": \"kebu\",\n" +
                "  \"lastName\": \"bebi\",\n" +
                "  \"dateOfBirth\": \"1985-01-01\",\n" +
                "  \"pin\": 15469\n" +
                "}";

        mockmvc.perform(
                post(Account_EndPoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        )
                .andDo(print())
                .andExpect(status().isOk());




    }


}