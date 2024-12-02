package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Day1Puzzle {
    public static void solve() {
        InputStream inputStream = Day1Puzzle.class.getResourceAsStream("input");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                a.add(Integer.parseInt(tokenizer.nextToken()));
                b.add(Integer.parseInt(tokenizer.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        calculateTotalDistance(a, b);
        calculateSimilarity(a, b);
    }

    private static void calculateTotalDistance(List<Integer> a, List<Integer> b) {
        a.sort(Integer::compareTo);
        b.sort(Integer::compareTo);

        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            distances.add(Math.abs(a.get(i) - b.get(i)));
        }

        int sum = distances.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total Distance: ");
        System.out.println(sum);
    }

    private static void calculateSimilarity(List<Integer> a, List<Integer> b) {
        List<Integer> appearances = a.stream().map(aElement -> {
            int counter = 0;
            for (int bElement : b) {
                if (aElement == bElement) {
                    counter++;
                }
            }

            return counter;
        }).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i) * appearances.get(i));
        }

        System.out.println("Similarity Score: ");
        System.out.println(result.stream().mapToInt(Integer::intValue).sum());
    }
}
