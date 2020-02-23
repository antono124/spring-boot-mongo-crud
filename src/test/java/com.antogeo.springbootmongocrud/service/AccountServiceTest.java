package com.antogeo.springbootmongocrud.service;

import com.antogeo.springbootmongocrud.model.Account;
import com.antogeo.springbootmongocrud.model.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@EnableConfigurationProperties
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    private AccountRepository accountRepository;

    private AccountServiceImpl subject;

    @Before
    public void setup() {
        accountRepository = mock(AccountRepository.class);
        subject = new AccountServiceImpl(accountRepository);
    }

    @Test
    public void shouldSaveAnAccount(){
        // Given
        Account account = new Account("test", "test@gmail.com", "Tom", 20);

        // When
        subject.saveAccount(account);
    }

    @Test
    public void shouldDeleteAccount(){
        // Given
        Account account = new Account("test", "test@gmail.com", "Tom", 20);

        // When
        subject.deleteAccount(account);
    }

    @Test
    public void shouldFindAccountById(){
        // Given
        String id = "test";
        Account expected = new Account(id, "test@gmail.com", "Tom", 20);
        when(accountRepository.findById(id)).thenReturn(Optional.of(expected));

        // When
        Optional<Account> actual = subject.findById(id);

        // Then
        assertTrue(actual.isPresent());
        assertEquals(expected.getId(), actual.get().getId());
        assertEquals(expected.getEmail(), actual.get().getEmail());
        assertEquals(expected.getFirstName(), actual.get().getFirstName());
        assertEquals(expected.getAge(), actual.get().getAge());

    }
}
