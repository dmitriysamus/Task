import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Класс {@link KioskScanning} отвечает за работу киоска, связанную с вводом и выводом.
 */
public class KioskScanning {

    /**
     * Метод {@link KioskScanning#scanning(Automate automate)} принимает с консоли входные данные.
     */
    public void scanning(Automate automate) {

        Scanner scanner = new Scanner(System.in);

        //Считываем количество ингредиентов на начало дня
        System.out.println("Введите количество различных ингридиентов");
        int startCount = scanner.nextInt();

        if (startCount < 1 || startCount > 500) {
            System.out.println("Некорректный ввод");
            return;
        }

        //Считываем доступные ингридиенты
        System.out.println("Введите доступные ингридиенты");
        Adder adder = new Adder();
        adder.add(startCount, automate.ingredients);


        //Считываем количество видов напитков
        System.out.println("Введите количество видов напитков");
        int recipes = scanner.nextInt();
        if (recipes < 1 || recipes > 100) {
            System.out.println("Некорректный ввод");
            return;
        }

        //Считываем рецепты напитков
        String lemonadeName;
        int ingrLemCount;
        Map<String, Integer> lemonadesCount = new TreeMap<>(); // количество лемонадов
        Map<String, Map<String, Integer>> lemonadesComposition = new TreeMap<>(); // состав лемонадов
        for (int i = 0; i < recipes; i++) {
            Map<String, Integer> composition = new TreeMap<>();
            System.out.println("Введите название напитка");
            lemonadeName = scanner.next();
            if (lemonadeName.length() > 100) {
                System.out.println("Некорректный ввод");
                return;
            }
            ingrLemCount = scanner.nextInt();
            lemonadesCount.put(lemonadeName, ingrLemCount); // лемонады
            System.out.println("Введите рецепт");
            adder.add(ingrLemCount, composition);
            lemonadesComposition.put(lemonadeName, composition);
        }

        //Считываем количество напитков в заказе
        System.out.println("Введите количество напитков в заказе");
        int orderCount = scanner.nextInt();

        LinkedList<String> order = new LinkedList<>();
        System.out.println("Введите названия напитков");

        //Считываем  заказ
        for (int i = 0; i < orderCount; i++) {
            lemonadeName = scanner.next();
            order.add(lemonadeName);
        }
        output(automate, order, lemonadesComposition);
    }

    /**
     * Метод {@link KioskScanning#output(Automate, LinkedList, Map)}
     * выводит количество доступных к готовке напитков.
     */
    private void output(Automate automate, LinkedList<String> order, Map<String, Map<String, Integer>> lemonadesComposition) {

        //Копия доступных ингридиентов
        Automate copyAutomate = new Automate();
        Adder adder = new Adder();
        copyAutomate.ingredients.putAll(automate.ingredients);

        //Вывод количества доступных к готовке напитков
        for (String lemonade : order) {
            boolean result = true;
            while (result) {
                result = adder.orderCounter(lemonadesComposition, copyAutomate, automate);
            }

            copyAutomate = new Automate();
            copyAutomate.ingredients.putAll(automate.ingredients);

            automate.removeIngredients(lemonadesComposition.get(lemonade));
            copyAutomate.removeIngredients(lemonadesComposition.get(lemonade));
        }
        adder.orderCounter(lemonadesComposition, copyAutomate, automate);
    }

}
