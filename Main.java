package com.company.java_core.homework23.task1;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Supplier<Deputy> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter user name");
            String name = in.next();
            in.close();
            return new Deputy(name);
        };

        Deputy user1 = userFactory.get();
        Deputy user2 = userFactory.get();

        System.out.println("Name user1 = "+user1.getName());
        System.out.println("Name user2 = "+user2.getName());

        List<String> collection = Arrays.asList(user1.getName());

        Stream<String> s1 = collection.stream();

        List<String> map = collection.stream().map(s -> s + "__><><").collect(Collectors.toList());
        System.out.println(map);

        String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
        System.out.println(Arrays.stream(data).flatMap(x->Arrays.stream(x)).collect(Collectors.toList()));

        Stream<String[]> arrayStream = Arrays.stream(data);
        Stream<String> flatMap = arrayStream.flatMap(x -> Arrays.stream(x));
        List<String> flatMapFiltered = flatMap.filter(x -> "a".equals(x.toString())).collect(Collectors.toList());
        System.out.println(flatMapFiltered);
    }
}
