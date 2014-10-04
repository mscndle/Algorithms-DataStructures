package com.mcondle.PriorityQueue;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

@RunWith(JUnit4.class)
public class PQtest {

    public static MaxPriorityQueue<Integer> pq;

    @BeforeClass
    public static void MakePQ() {
        pq = new MaxPriorityQueue<Integer>(10);

        pq.insert(5);
        pq.insert(6);
        pq.insert(10);
        pq.insert(2);
        pq.insert(4);
        pq.insert(7);
        pq.insert(9);
        pq.insert(8);
        pq.insert(1);
        pq.insert(3);
    }


    @Test
    public void checkMaxValues() {
        assert(10 == pq.deleteMax());
//        assert(9 == pq.deleteMax());
//        assert(8 == pq.deleteMax());
//        assert(7 == pq.deleteMax());
//        assert(6 == pq.deleteMax());
//        assert(5 == pq.deleteMax());
//        assert(4 == pq.deleteMax());
//        assert(3 == pq.deleteMax());
//        assert(2 == pq.deleteMax());
        //assert(1 == pq.deleteMax());
    }



}
