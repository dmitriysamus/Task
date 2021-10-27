import java.util.*;

public class Main {

    public static void main(String[] args) {

        Automate automate = new Automate();
        Scanner scanner = new Scanner(System.in);

        /**
         * Считываем количество ингредиентов на начало дня.
         */
        System.out.println("Введите количество различных ингридиентов");
        int startCount = scanner.nextInt();

        /**
         * Считываем доступные ингридиенты.
         */
        System.out.println("Введите доступные ингридиенты");
        Adder adder = new Adder();
        adder.add(startCount, automate.ingredients);

        /**
         * Считываем количество видов лимонадо.
         */
        System.out.println("Введите количество видов лимонадов");
        Map<String, Map<String, Integer>> lemonadesComposition = new TreeMap<>(); // состав лемонадов

        /**
         * Считываем рецепты лимонадов.
         */
        String lemonadeName;
        int ingrLemCount;
        Map<String, Integer> lemonadesCount = new TreeMap<>(); // количество лемонадов
        int recipes = scanner.nextInt();
        for (int i = 0; i < recipes; i++) {
            Map<String, Integer> composition = new TreeMap<>();
            System.out.println("Введите название лимонада");
            lemonadeName = scanner.next();
            ingrLemCount = scanner.nextInt();
            lemonadesCount.put(lemonadeName, ingrLemCount); // лемонады
            System.out.println("Введите рецепт");
            adder.add(ingrLemCount, composition);
            lemonadesComposition.put(lemonadeName, composition);
        }

        /**
         * Считываем количество лимонадов в заказе.
         */
        System.out.println("Введите количество лимонадов в заказе");
        int orderCount = scanner.nextInt();
        LinkedList<String> order = new LinkedList<>();

        /**
         * Считываем  заказ.
         */
        System.out.println("Введите названия лимонадов");
        for (int i = 0; i < orderCount; i++) {
            lemonadeName = scanner.next();
            order.add(lemonadeName);
        }
        System.out.println("Заказ" + order);

        for (String lemonade: order) {
            automate.removeIngredients(lemonadesComposition.get(lemonade));
        }

        System.out.println(automate.ingredients);
    }
}


