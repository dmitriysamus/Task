import java.util.Map;
import java.util.TreeMap;

/**
 * Класс {@link Automate} представляет киоск с запасом ингридиентов.
 */
public class Automate {

    Map<String, Integer> ingredients = new TreeMap<>();

    /**
     * Метод {@link Automate#removeIngredients(Map)}
     * удаляет ингридиенты равное количеству ингредиентов переданного в качестве аргумента напитка.
     */
    public boolean removeIngredients(Map<String, Integer> lemonade) {
        for (Map.Entry<String, Integer> entry : lemonade.entrySet()) {
            if ((ingredients.get(entry.getKey()) - entry.getValue()) < 0) {
                return false;
            }
            ingredients.put(entry.getKey(), ingredients.get(entry.getKey()) - entry.getValue());
        }
        return true;
    }
}
