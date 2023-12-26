public class PrintQueueManagement {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        // Enqueuing multiple print jobs
        printQueue.enqueueJob(new PrintJob("Document1.pdf")); // ID 1
        printQueue.enqueueJob(new PrintJob("Document2.pdf")); // ID 2
        printQueue.enqueueJob(new PrintJob("Image1.png"));    // ID 3
        printQueue.enqueueJob(new PrintJob("Report1.pdf"));   // ID 4
        printQueue.enqueueJob(new PrintJob("Chart1.png"));    // ID 5
        System.out.println();

        // Displaying the queue
        System.out.println("Displaying initial Queue...");
        printQueue.displayQueue();
        System.out.println();

        // Canceling a job (e.g., with ID 3)
        printQueue.cancelJob(3);

        // Displaying the queue after cancellation
        System.out.println("\nQueue after canceling a job:");
        printQueue.displayQueue();

        System.out.println();

        // Reversing the jobs in the queue
        printQueue.reverseJobs();

        // Displaying the queue after reversal
        System.out.println("\nQueue after reversal:");
        printQueue.displayQueue();
        
        System.out.println();

        // Processing the remaining jobs
        while (!printQueue.isQueueEmpty()) {
            printQueue.processNextJob();
        }
    }
}
