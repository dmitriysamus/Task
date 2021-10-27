import java.util.Map;
import java.util.Scanner;

/**
 * Отвечает за добавление элементов в Map из консоли.
 */
public class Adder {
    void add (int a, Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        int intScan;
        String strScan;

        for (int j = 0; j < a; j++) {
            strScan = scanner.next();// добавить ограничения
            if (strScan.length() > 100) {
                System.out.println("Некорректный ввод");
                return;
            }
            intScan = scanner.nextInt();
            map.put(strScan, intScan);
        }
    }
}
