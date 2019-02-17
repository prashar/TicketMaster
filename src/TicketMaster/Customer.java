package TicketMaster;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Customer extends Thread{

    private int CustomerId;
    private List<AtomicReference<Integer>> SeatMap;

    // Customer Class variables
    private static int TotalSeatCount;
    private static AtomicInteger AssignedSeatCount = new AtomicInteger(0);

    Customer(int customerId, List<AtomicReference<Integer>> seatMap) {
        this.CustomerId = customerId;
        this.SeatMap = seatMap;
        this.TotalSeatCount = this.SeatMap.size();
    }

    @Override
    public void run() {
        boolean reserved = false;
        try {
            while (!reserved && AssignedSeatCount.get() < TotalSeatCount) {
                // Try to sleep to add some randomness
                Thread.sleep(100);

                // Let's try to get a random seat (0 to TotalSeatCount - 1)
                int trySeat = ThreadLocalRandom.current().nextInt(TotalSeatCount);

                reserved = SeatMap.get(trySeat).compareAndSet(null, CustomerId);

                if (reserved) {
                    AssignedSeatCount.getAndIncrement();
                }
            }

            // Couldn't get a Seat, log message
            if(!reserved) {
                System.out.println("Customer " + CustomerId + " couldn't secure a seat");
            }
        } catch(InterruptedException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

}
