class Box<T> {

    private T value;

    Box(T v) {
        value = v;
    }

    T get() {
        return value;
    }

    void set(T v) {
        value = v;
    }
}

class Pair<A, B> {

    private A first;
    private B second;

    Pair(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class GenericContainers {

    static <T> T first(T[] a) {

        if (a.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        return a[0];
    }

    public static void main(String[] args) {

        Box<String> text = new Box<>("Hello");

        Box<Integer> number = new Box<>(100);

        Pair<String, Integer> p = new Pair<>("Age", 20);

        String[] names = {
            "Prince",
            "Smit"
        };

        System.out.println(text.get() + ", " + number.get());

        System.out.println(p);

        System.out.println("First: " + first(names));
    }
}