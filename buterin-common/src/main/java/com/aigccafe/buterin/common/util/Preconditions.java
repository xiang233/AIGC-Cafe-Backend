package com.aigccafe.buterin.common.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

public class Preconditions {

    public static void checkNotNull(Object object, String errorMessage) {
        if (object == null) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static void checkNull(Object object, String errorMessage) {
        if (object != null) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static void checkNonEmpty(String text, String errorMessage) {
        if (StringUtils.isEmpty(text)) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static void checkNonEmpty(Collection<?> collection, String errorMessage) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static <T extends Comparable<T>> void checkBetween(T value, T min, T max, String errorMessage) {
        boolean beyondMin = min != null && value.compareTo(min) < 0;
        boolean beyondMax = max != null && value.compareTo(max) > 0;
        if (beyondMin || beyondMax) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static void checkIn(Object value, String errorMessage, Object... candidates) {
        for (Object candidate : candidates) {
            if (value.equals(candidate)) {
                return;
            }
        }
        throw new RuntimeException(errorMessage);
    }

    public static void checkAllIn(Collection values, String errorMessage, Object... candidates) {
        for (Object value : values) {
            checkIn(value, errorMessage, candidates);
        }
    }

    public static void checkArgument(boolean arg, String errorMessage) {
        if (!arg) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static void checkEqual(Object a, Object b, String errorMessage) {
        if (!Objects.equals(a, b)) {
            throw new RuntimeException(errorMessage);
        }
    }

}
