package tr.unvercanunlu.stack.impl;

import tr.unvercanunlu.stack.IStack;
import tr.unvercanunlu.stack.impl.exception.NegativeCapacity;
import tr.unvercanunlu.stack.impl.exception.StackOverflow;
import tr.unvercanunlu.stack.impl.exception.StackUnderflow;

import java.util.Arrays;

public class Stack<T> implements IStack<T> {

    private static final int INITIAL_INDEX = -1;

    private static final int DEFAULT_CAPACITY = 100;

    private final Object[] items;

    private int index = INITIAL_INDEX;

    public Stack() {
        this.items = new Object[DEFAULT_CAPACITY];
    }

    public Stack(int capacity) throws NegativeCapacity {
        if (capacity < 0) throw new NegativeCapacity();

        this.items = new Object[capacity];
    }

    @Override
    public T pop() throws StackUnderflow {
        if (this.isEmpty()) throw new StackUnderflow();

        T data = (T) this.items[index];

        this.items[index] = null;

        this.index -= 1;

        return data;
    }

    @Override
    public T peek() throws StackUnderflow {
        if (this.isEmpty()) throw new StackUnderflow();

        return (T) this.items[index];
    }

    @Override
    public void push(T data) throws StackOverflow {
        if (this.isFull() || ((this.size() + 1) > this.items.length)) throw new StackOverflow();

        index += 1;

        this.items[index] = data;
    }

    @Override
    public int size() {
        return (this.index + 1);
    }

    @Override
    public boolean isFull() {
        return (this.size() == this.items.length);
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public void clear() {
        Arrays.fill(this.items, null);

        this.index = INITIAL_INDEX;
    }
}
