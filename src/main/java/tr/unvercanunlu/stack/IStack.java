package tr.unvercanunlu.stack;

import tr.unvercanunlu.stack.impl.exception.StackOverflow;
import tr.unvercanunlu.stack.impl.exception.StackUnderflow;

public interface IStack<T> {

    T pop() throws StackUnderflow;

    T peek() throws StackUnderflow;

    void push(T data) throws StackOverflow;

    int size();

    boolean isFull();

    boolean isEmpty();

    void clear();
}
