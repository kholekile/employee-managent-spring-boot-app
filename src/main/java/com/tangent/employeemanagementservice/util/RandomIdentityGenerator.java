package com.tangent.employeemanagementservice.util;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class RandomIdentityGenerator {

    private static final Random random = new Random((new Date()).getTime());

    public static String getIdentity(){

        char[] allowedPrefixes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        char[] allowedSuffixes = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        var prefix = generate(allowedPrefixes, 2);

        var suffix = generate(allowedSuffixes, 4);

        return prefix.concat(suffix);
    }

    public static String generate(char[] allowedPrefixes, int length) {

        String out = "";

        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(allowedPrefixes.length);
            out += allowedPrefixes[idx];
        }

        return out;
    }
}
