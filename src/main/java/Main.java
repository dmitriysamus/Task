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
        if (startCount < 1 || startCount > 500) {
            System.out.println("Некорректный ввод");
            return;
        }

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
        int recipes = scanner.nextInt();
        if (recipes < 1 || recipes > 100) {
            System.out.println("Некорректный ввод");
            return;
        }


        /**
         * Считываем рецепты лимонадов.
         */
        String lemonadeName;
        int ingrLemCount;
        Map<String, Integer> lemonadesCount = new TreeMap<>(); // количество лемонадов
        Map<String, Map<String, Integer>> lemonadesComposition = new TreeMap<>(); // состав лемонадов
        for (int i = 0; i < recipes; i++) {
            Map<String, Integer> composition = new TreeMap<>();
            System.out.println("Введите название лимонада");
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

        /**
         * Считываем количество лимонадов в заказе.
         */
        System.out.println("Введите количество лимонадов в заказе");
        int orderCount = scanner.nextInt();
        if (recipes < 1 || recipes > 100) {
            System.out.println("Некорректный ввод");
            return;
        }

        /**
         * Считываем  заказ.
         */
        LinkedList<String> order = new LinkedList<>();
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


