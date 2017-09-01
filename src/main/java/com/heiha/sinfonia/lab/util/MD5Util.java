package com.heiha.sinfonia.lab.util;

import com.heiha.sinfonia.lab.enums.Algorithm;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/1 16:06<br>
 * <b>Author:</b> heiha<br>
 */
public class MD5Util {
    public static String digest(byte[] input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance(Algorithm.MD5.name());
        return new BigInteger(1, md5.digest(input)).toString(16);
    }
}
