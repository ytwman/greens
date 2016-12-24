package com.ytwman.greens.commons.helper;

import java.util.Random;
import java.util.UUID;

/**
 * 生成随机 key
 * Created by ytwman on 16/12/24.
 */
public class KeyGenerator {

    // !@#$%^&*_-+
    static final String letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // 默认生成长度为18的随机数
    static final int defaultSize = 18;

    public static final String randomKey() {
        return randomKey(defaultSize);
    }

    public static String randomKey(int size) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(letter.length());
            sb.append(letter.charAt(index));
        }
        return sb.toString();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(randomKey(16));
    }
}
