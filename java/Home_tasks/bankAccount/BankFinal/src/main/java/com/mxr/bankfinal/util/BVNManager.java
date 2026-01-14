package com.mxr.bankfinal.util;

import java.util.UUID;

public class BVNManager {
    
    public static String generateUniqueBvn() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 11);
    }
}
