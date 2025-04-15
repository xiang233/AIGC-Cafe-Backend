package com.aigccafe.buterin.common.util;

import java.util.Random;

public class RandomUtil {
    /**
     * 生成指定位数的随机数字字符串
     *
     * @param length 随机数字字符串的位数
     * @return 随机生成的数字字符串
     */
    public static String generateRandomNumberString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // 生成一个0-9之间的随机数字
            sb.append(digit);
        }
        return sb.toString();
    }

    /**
     * 生成指定位数的随机英文字符串
     *
     * @param length 随机英文字符串的位数
     * @return 随机生成的英文字符串
     */
    public static String generateRandomEnglishString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char letter = (char) ('A' + random.nextInt(26)); // 生成一个'A'到'Z'之间的随机字符
            if (random.nextBoolean()) {
                letter = Character.toLowerCase(letter); // 随机将字符转换为小写
            }
            sb.append(letter);
        }
        return sb.toString();
    }
}
