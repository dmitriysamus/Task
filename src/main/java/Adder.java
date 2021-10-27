import java.util.Map;
import java.util.Scanner;

/**
 * Класс {@link Adder} отвечает за добавление элементов в Map из консоли.
 */
public class Adder {

    /**
     * Метод {@link Adder#add(int, Map)} )}
     * удаляет ингридиенты равное количеству ингредиентов переданного в качестве аргумента напитка.
     */
    void add(int a, Map<String, Integer> map) {
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

    /**
     * Метод {@link Adder#orderCounter(Map, Automate, Automate)} )}
     * выводит количество доступных к готовке напитков.
     */
    boolean orderCounter(Map<String, Map<String, Integer>> lemonadesComposition,
                         Automate copyAutomate, Automate automate) {
        boolean result = true;
        int counter = 0;
        while (result) {
            for (String key : lemonadesComposition.keySet()) {
                result = copyAutomate.removeIngredients(lemonadesComposition.get(key));
                if (!result) {
                    break;
                }
                ++counter;
            }
        }

        System.out.println(counter);
        return result;
    }
}
