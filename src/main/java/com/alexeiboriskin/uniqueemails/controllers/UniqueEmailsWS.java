package com.alexeiboriskin.uniqueemails.controllers;

import com.alexeiboriskin.uniqueemails.services.UniqueEmailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniqueEmailsWS {

    private final UniqueEmailsService uniqueEmailsService;

    public UniqueEmailsWS(UniqueEmailsService uniqueEmailsService) {
        this.uniqueEmailsService = uniqueEmailsService;
    }

    @GetMapping("/emailscount")
    int getUniqueEmailsCount(@RequestBody String[] emails) {
        return uniqueEmailsService.uniqueEmailsCount(emails);
    }
}
