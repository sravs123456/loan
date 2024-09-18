package com.neoteric.fullstackdemo_310824.controller;

import com.neoteric.fullstackdemo_310824.model.Account;
import com.neoteric.fullstackdemo_310824.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountController {

    @PostMapping(value = "/accountcreation",
            consumes = "application/json",
            produces = "/application/json")

    public Account GetAccountNumber(@RequestBody Account account) throws Exception {
        AccountService accountService = new AccountService();
        String accountNumber = accountService.createAccount(account);
        account.setAccountNumber(accountNumber);
        return account;
    }

    @GetMapping(value = "/api/searchAccount",
            consumes = "application/json",
            produces = "/application/json")

    public Account GetAccountNumber(@RequestHeader("accountinput")
                                    String accountnumber) throws Exception {
        //List<String>accountNumberList=httpHeaders.get("accountinput") ;
        // String accountFromhttpHeaders=accountNumberList.get(0);
        AccountService accountService = new AccountService();
        return accountService.searchAccount(accountnumber);
    }
}
