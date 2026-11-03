import java.util.Arrays;

class GenericStack<T> {

    private Object[] data;
    private int size = 0;

    GenericStack(int capacity) {
        data = new Object[capacity];
    }

    void push(T value) {
        if (size == data.length) {
            throw new IllegalStateException("Stack full");
        }

        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        T value = (T) data[--size];
        data[size] = null;

        return value;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

class NoSuchElementException extends RuntimeException {

    NoSuchElementException(String m) {
        super(m);
    }
}

public class GenericStackDemo {

    public static void main(String[] args) {

        GenericStack<String> words = new GenericStack<>(5);
        words.push("Java");
        words.push("OOP");

        System.out.println(words.pop());

        GenericStack<Integer> nums = new GenericStack<>(5);
        nums.push(10);
        nums.push(20);

        System.out.println(nums.pop());

        try {
            nums.pop();
            nums.pop();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}