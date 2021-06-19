package container;

public class CustomArrayListIII<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayListIII() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayListIII(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("capacity parameter error");
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    public void add(E e) {
        if (size == elementData.length) {
            Object[] newElement = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newElement, 0, elementData.length);
            elementData = newElement;
        }
        elementData[size++] = e;
    }

    public void set(E e, int index) {
        checkRange(index);
        elementData[index] = e;
    }

    public E get(int index) {
        checkRange(index);
        return (E)elementData[index];
    }

    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index parameter error");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomArrayListIII<String> l = new CustomArrayListIII<String>();
        for (int i = 0; i < 40; i++) {
            l.add("" + i);
        }
        System.out.println(l);
        l.set("11", 10);
        System.out.println(l);
        System.out.println(l.get(10));
    }

}
