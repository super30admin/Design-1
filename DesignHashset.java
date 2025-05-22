
import java.util.ArrayList;


class DesignHashset {

    ArrayList<Integer> list;

    public DesignHashset() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        DesignHashset obj = new DesignHashset();

        obj.add(1);
        obj.add(2);
        System.out.println("Contains 1: " + obj.contains(1)); // true
        System.out.println("Contains 3: " + obj.contains(3)); // false

        obj.add(2);
        System.out.println("Contains 2: " + obj.contains(2)); // true

        obj.remove(2);
        System.out.println("Contains 2 after remove: " + obj.contains(2)); // false
    }
}
