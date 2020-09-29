package com.alexeiboriskin.uniqueemails.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UniqueEmailsService {

    public int uniqueEmailsCount(String[] emails) {

        return Arrays.stream(emails).parallel()
                .map(e -> {
                    String[] emailParts = e.split("@");
                    String nameWithoutPlusAndDots = emailParts[0]
                            .replace(".", "")
                            .split("\\+")[0];
                    return nameWithoutPlusAndDots + "@" + emailParts[1];
                })
                .collect(Collectors.toSet())
                .size();
    }
}
