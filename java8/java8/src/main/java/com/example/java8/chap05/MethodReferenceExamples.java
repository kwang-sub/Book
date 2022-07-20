package com.example.java8.chap05;

import com.example.java8.chap03.entity.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        List<BigDecimal> collect = Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
//                .sorted(BigDecimalUtil::compare)
                .sorted(BigDecimal::compareTo)
                .collect(Collectors.toList());
        System.out.println(collect);

        boolean b = Arrays.asList("a", "b", "c", "d")
                .stream()
//                .anyMatch(s -> s.equals("c"));
                .anyMatch("c"::equals);
        System.out.println(b);

        List<Product> collect1 = Arrays.asList(
                        new Product(1L, "1", new BigDecimal(1)),
                        new Product(2L, "2", new BigDecimal(2)),
                        new Product(3L, "3", new BigDecimal(3)),
                        new Product(4L, "4", new BigDecimal(4))
                ).stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal db1, BigDecimal db2) {
        return db1.compareTo(db2);
    }
}
