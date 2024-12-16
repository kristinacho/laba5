import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> items;

    public GenericList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public boolean replaceFirstOccurrence(GenericList<T> subList, GenericList<T> replacement) {
        for (int i = 0; i <= items.size() - subList.size(); i++) {
            if (items.subList(i, i + subList.size()).equals(subList.getItems())) {
                items.subList(i, i + subList.size()).clear();
                items.addAll(i, replacement.getItems());
                return true;
            }
        }
        return false;
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
