package day3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Puzzle {
    public void solve() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("./src/day3/input")));
            Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
            Matcher matcher = pattern.matcher(content);

            List<Integer> results = new ArrayList<>();
            while (matcher.find()) {
                results.add(Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2)));
            }

            System.out.println("Sum of Multiplications: ");
            System.out.println(results.stream().mapToInt(Integer::intValue).sum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
