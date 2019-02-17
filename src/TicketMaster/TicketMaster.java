package TicketMaster;

import sun.jvm.hotspot.runtime.Threads;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class TicketMaster {
    // This class variable will be shared by all the threads
    public static List<AtomicReference<Integer>> seatList = new ArrayList<>();
    public static final int CustomerCount = 25;
    public static final int SeatCount = 20;

    public static void main(String[] args) throws InterruptedException {

        // Fill up empty seats
        for(int i=0 ; i < SeatCount; i++) {
            seatList.add(new AtomicReference<Integer>());
        }

        // Create threads that will try to acquire empty seats
        Customer[] customerThreads = new Customer[CustomerCount];
        for(int i=0 ; i < customerThreads.length; i++) {
            customerThreads[i] = new Customer(i,seatList);
            customerThreads[i].start();
        }

        // Wait for things to be done.
        for(Customer customerThread: customerThreads) {
            customerThread.join();
        }

        // Print Results of all the acquired Seats
        for(int i=0 ; i < SeatCount; i++) {
            System.out.println("Seat " + i + " acquired by " + seatList.get(i));
        }

        return;

    }
}
