package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


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

        a.sort(Integer::compareTo);
        b.sort(Integer::compareTo);

        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            distances.add(Math.abs(a.get(i) - b.get(i)));
        }

        int sum = distances.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Result of Day 1 Puzzle: ");
        System.out.println(sum);
    }
}
