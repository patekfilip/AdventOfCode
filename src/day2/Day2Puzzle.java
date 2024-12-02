package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day2Puzzle {
    public static void solve() {
        InputStream inputStream = Day2Puzzle.class.getResourceAsStream("input");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<List<Integer>> reports = new ArrayList<>();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                List<Integer> report = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    report.add(Integer.parseInt(tokenizer.nextToken()));
                }

                reports.add(report);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int safeCounter = 0;
        for (List<Integer> report : reports) {
            if (isSortedAsc(report) || isSortedDesc(report)) {
                boolean isSafe = true;
                for (int i = 1; i < report.size(); i++) {
                    int difference = Math.abs(report.get(i-1) - report.get(i));
                    if (difference < 1 || difference > 3) {
                        isSafe = false;
                        break;
                    }
                }

                if (isSafe) {
                    safeCounter++;
                }
            }
        }

        System.out.println("Safe reports: ");
        System.out.println(safeCounter);
    }

    private static boolean isSortedAsc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSortedDesc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}