# TicketMaster

Customer class contains 2 static variables:

1. AssignedSeatCount -> an atomic integer initialized to 0
2. TotalSeats

Each thread contains 3 other private variables

1. Reserved
2. Initial Seat Map of AtomicReferences. 

TicketMaster class creates a bunch of Customer Threads and then tries to wait until those threads are done acquiring all the seats. 

Output would look like:

Customer 11 couldn't secure a seat
Customer 23 couldn't secure a seat
Customer 19 couldn't secure a seat
Customer 21 couldn't secure a seat
Customer 14 couldn't secure a seat
Seat 0 acquired by 13
Seat 1 acquired by 24
Seat 2 acquired by 22
Seat 3 acquired by 20
Seat 4 acquired by 2
Seat 5 acquired by 0
Seat 6 acquired by 9
Seat 7 acquired by 7
Seat 8 acquired by 8
Seat 9 acquired by 3
Seat 10 acquired by 12
Seat 11 acquired by 15
Seat 12 acquired by 4
Seat 13 acquired by 1
Seat 14 acquired by 17
Seat 15 acquired by 10
Seat 16 acquired by 16
Seat 17 acquired by 18
Seat 18 acquired by 5
Seat 19 acquired by 6