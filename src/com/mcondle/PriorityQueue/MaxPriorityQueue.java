package com.mcondle.PriorityQueue;

import java.util.Arrays;

/**
 * Created by mscndle on 10/2/14.
 * Implementation of ADT - priority queue
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {

    public static void main(String[] args) {

        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<Integer>(10);

        pq.insert(5);
        pq.insert(6);
        pq.insert(10);
        System.out.println(pq);

        pq.insert(2);
        pq.insert(4);
        pq.insert(7);
        System.out.println(pq);

        pq.insert(9);
        pq.insert(8);
        System.out.println(pq);

        pq.insert(1);
        pq.insert(3);
        System.out.println(pq);

//        while (!pq.empty()) {
//            System.out.println(pq.deleteMax());
//        }

        System.out.println(pq.deleteMax());

        System.out.println(pq);

    }

    private Key[] pq;
    private int N;      //position of the last Key in pq

    @SuppressWarnings("unchecked")
    public MaxPriorityQueue(int max) {
        this.pq = (Key[]) new Comparable[max+1];
    }

    public boolean empty() {
        return this.N == 0;
    }

    public void insert(Key k) {
        this.pq[++this.N] = k;
        this.heapifyUp(N);
    }

    public Key deleteMax() {
        Key max = this.pq[1];

        this.pq[1] = this.pq[N--];  //copy the last element to root
        this.pq[N+1] = null;    //avoid loitering
        this.heapifyDown(1);

        return max;
    }

    public void heapifyUp(int p) {  //p represents the position in pq[]
        while (p > 1) {
            if (this.less(p/2, p)) {
                this.exch(p/2, p);
            }
            p = p/2;
        }
    }

    public void heapifyDown(int p) {
        //System.out.println("starting heapifyDown with: " + this.pq);

        while (p*2 <= this.N) {
            System.out.println("pos: " + p);

            if (this.less(p, p*2)) {
                System.out.println("parent lesser than left child");
                this.exch(p, p*2);
                p = 2*p;
            } else if (this.less(p, p*2 + 1)) {
                System.out.println("parent lesser than right child");
                this.exch(p, p*2 + 1);
                p = 2*p + 1;
            } else break;
        }
    }

    public boolean less(int i, int j) { //compares keys are indexes i and j
        return this.pq[i].compareTo(this.pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key k = this.pq[i];

        this.pq[i] = this.pq[j];
        this.pq[j] = k;
    }

    public String toString() {
        return Arrays.toString(this.pq);
    }
}
