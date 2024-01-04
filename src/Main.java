import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] inputArrays = {{"-1", "sadf", "30", "61", "d.3", "60", "1.f", "80", "90", "11", "90"},
                {"null", "15", "25", "null", "35", "45", "null", "55", "65"}};

        List<String> result = analyzeArray(inputArrays);
        System.out.println(result);
    }

    public static List<String> analyzeArray(String[][] arr) {
        List<String> result = new ArrayList<>();
        for (String[] innerArr : arr) {
            List<String> temp = new ArrayList<>();
            for (String s : innerArr) {
                if (s != null && isNumeric(s)) {
                    temp.add(s);
                }
            }
            for (int i = 0; i < temp.size(); i += 3) {
                int sum = 0;
                int counter = 0;
                for (int j = i; j < i + 3 && j < temp.size(); j++) {
                    sum += Integer.parseInt(temp.get(j));
                    counter++;
                }
                if (sum >= 90 && counter == 3) {
                    for (int j = i; j < i + 3 && j < temp.size(); j++) {
                        result.add(temp.get(j));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}