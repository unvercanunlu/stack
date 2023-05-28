package tr.unvercanunlu.data_structure.stack;

import tr.unvercanunlu.data_structure.stack.impl.exception.StackOverflow;
import tr.unvercanunlu.data_structure.stack.impl.exception.StackUnderflow;

public interface IStack<T> {

    T pop() throws StackUnderflow;

    T peek() throws StackUnderflow;

    void push(T data) throws StackOverflow;

    int size();

    boolean isFull();

    boolean isEmpty();

    void clear();
}
