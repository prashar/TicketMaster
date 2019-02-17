# TicketMaster

Customer class contains 2 static variables:

1. AssignedSeatCount -> an atomic integer initialized to 0
2. TotalSeats

Each thread contains 3 other private variables

1. Reserved
2. Initial Seat Map of AtomicReferences. 

TicketMaster class creates a bunch of Customer Threads and then tries to wait until those threads are done acquiring all the seats. 