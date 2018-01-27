package com.coinbase.exchange.api.authentication;

import com.coinbase.exchange.api.BaseTest;
import com.coinbase.exchange.api.GdaxClient;
import com.coinbase.exchange.api.accounts.Account;
import com.coinbase.exchange.api.accounts.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by irufus (sakamura@gmail.com)
 * @Description The primary function of this class is to run through basic tests for the Authentication and GdaxExchange classes
 */
public class AuthenticationTests extends BaseTest {

    AccountService accountService;

    @Before
    public void init() {
        this.accountService = gdax.accountService();
    }

    // ensure a basic request can be made. Not a great test. Improve.
    @Test
    public void simpleAuthenticationTest(){
        List<Account> accounts = accountService.getAccounts().block();
        assertTrue(accounts != null);
        assertTrue(accounts.size() > 0);
    }

}
