import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final double SHRINK_THRESHOLD = 0.25; // Shrink if size is less than 25% of capacity

    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        shrinkIfNeeded(); // Consider shrinking after removal
        return removedElement;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    public void shrink() {
        int currentCapacity = elements.length;
        if (size < currentCapacity) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    private void shrinkIfNeeded() {
        int currentCapacity = elements.length;
        if (size < (int) (currentCapacity * SHRINK_THRESHOLD) && currentCapacity > DEFAULT_CAPACITY) {
            shrink();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity / 2);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity < 0) {
            if (minCapacity < 0)
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> numbers = new CustomArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }
        System.out.println("Initial list (size=" + numbers.size() + ", capacity=" + numbers.elements.length + "): " + numbers);

        for (int i = 0; i < 15; i++) {
            numbers.remove(numbers.size() - 1);
        }
        System.out.println("After removing elements (size=" + numbers.size() + ", capacity=" + numbers.elements.length + "): " + numbers);

        numbers.shrink();
        System.out.println("After explicit shrink (size=" + numbers.size() + ", capacity=" + numbers.elements.length + "): " + numbers);

        CustomArrayList<String> names = new CustomArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("Initial names (size=" + names.size() + ", capacity=" + names.elements.length + "): " + names);
        names.remove("Bob");
        System.out.println("After removing (size=" + names.size() + ", capacity=" + names.elements.length + "): " + names);
        // shrinkIfNeeded() will be called after removal

        names.shrink(); // Explicitly call shrink again
        System.out.println("After explicit shrink (size=" + names.size() + ", capacity=" + names.elements.length + "): " + names);
    }
}