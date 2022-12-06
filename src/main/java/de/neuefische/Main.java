package de.neuefische;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Task 1: Sort, sum, product
        int[] nums = new int[] {9, 1, 8, 2, 7, 3, 6, 4, 5};

        System.out.println(Arrays.stream(nums).sorted().boxed().toList());
        System.out.println(Arrays.stream(nums).reduce(Integer::sum).orElse(0));
        System.out.println(Arrays.stream(nums).reduce((num,sum)-> {
            return sum * num;
        }).orElse(0));

        // Task 2: Streams file
        try {
            Stream<String> lines = Files.lines(Path.of("students.csv"));
            lines.skip(1)
                    .filter(line -> !line.isEmpty())
                    .distinct()
                    .map(line -> {
                        String[] vars = line.split(",");
                        return new Student(Integer.parseInt(vars[0]), vars[1], Integer.parseInt(vars[2]), Integer.parseInt(vars[3]));
                    }).toList()
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("File not found");
        }

    }

}