package com.alexeiboriskin.uniqueemails.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueEmailsServiceTest {

    private final UniqueEmailsService uniqueEmailsService = new UniqueEmailsService();

    @Test
    void uniqueEmailsCount() {

        assertEquals(1, uniqueEmailsService.uniqueEmailsCount(
                new String[]{"test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"}));

        assertEquals(2, uniqueEmailsService.uniqueEmailsCount(
                new String[]{"test.email@gmail.com", "test.email@fetchrewards.com"}));
    }
}