public class CustomQueue<T> {
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public CustomQueue() {
        elements = new Object[10];
        size = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(T item) {
        if (size == elements.length) {
            resize(2 * elements.length);
        }
        elements[rear] = item;
        rear = (rear + 1) % elements.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        T item = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        Object[] newElements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        elements = newElements;
        front = 0;
        rear = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[(front + i) % elements.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
