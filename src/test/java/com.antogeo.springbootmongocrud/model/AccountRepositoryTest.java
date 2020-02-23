package com.antogeo.springbootmongocrud.model;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository subject;

    @After
    public void after(){
        Optional<Account> account = subject.findById("test");
        account.ifPresent(account1 -> subject.delete(account1));
    }

    @Test
    public void shouldSaveAccount() {
        // Given
        Account account = new Account("test", "test@gmail.com", "Tom", 20);

        // When
        subject.save(account);

        // Then
        assertNotNull(subject.findById("test"));
    }

    @Test
    public void shouldRetrieveAccount() {
        // Given
        Account account = new Account("test", "test@gmail.com", "Tom", 20);
        subject.save(account);

        // When
        Optional<Account> actual = subject.findById("test");

        // Then
        assertTrue(actual.isPresent());
        assertEquals(account.getId(), actual.get().getId());
        assertEquals(account.getEmail(), actual.get().getEmail());
        assertEquals(account.getFirstName(), actual.get().getFirstName());
        assertEquals(account.getAge(), actual.get().getAge());
    }

    @Test
    public void shouldDeleteAccount() {
        // Given
        Account account = new Account("test", "test@gmail.com", "Tom", 20);
        subject.save(account);

        Optional<Account> accountToDelete = subject.findById("test");
        assertTrue(accountToDelete.isPresent());

        // When
        subject.delete(accountToDelete.get());

        // Then
        Optional<Account> actual = subject.findById("test");
        assertFalse(actual.isPresent());
    }
}
