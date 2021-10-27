import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс, представляющий киоск с запасом ингридиентов.
 */
public class Automate {
    Map<String, Integer> ingredients = new TreeMap<>();

    public void removeIngredients (Map<String, Integer> remove) {
        for (Map.Entry<String, Integer> entry: remove.entrySet()) {
            ingredients.put(entry.getKey(),  ingredients.get(entry.getKey()) - entry.getValue());
        }
    }
}
