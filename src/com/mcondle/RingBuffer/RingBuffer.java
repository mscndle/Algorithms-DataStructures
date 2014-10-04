package com.mcondle.RingBuffer;

/**
 * simple implementation of a ring buffer / circular buffer / circular queue
 */
public class RingBuffer<T> {
    private T[] buffer;
    private int first;
    private int next;
    private int numberOfElements;

    public RingBuffer(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be positive");
        }

        this.buffer = newArray(size);
    }

    @SuppressWarnings("unchecked")
    //Generics and arrays don't go well together
    private T[] newArray(final int length) {
        return (T[]) new Object[length];
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == this.buffer.length;
    }

    /** Returns the current number of elements in the buffer */
    public int getSize() {
        return this.numberOfElements;
    }

    public void add(final T element) {
        if (isFull()) {
            throw new IllegalStateException("Buffer is full");
        }

        this.buffer[next] = element;
        next = (next + 1) % this.buffer.length;
        ++numberOfElements;
    }

    public void addAll(final T[] elements) {
        //TODO - complete this


    }

    public T deleteOldest() {
        if (isEmpty()) {
            throw new IllegalStateException("Buffer is empty");
        }

        T oldest = this.buffer[first];
        first = (first + 1) / this.buffer.length;
        --numberOfElements;
        return oldest;
    }
}
