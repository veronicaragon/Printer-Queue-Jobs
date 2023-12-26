public class PrintQueue {
    private Node front, rear;

    public PrintQueue() {
        front = rear = null;
    }

    /*Implement enqueue method for adding jobs to the queue.
     * SOP that the job has been added to the queue
     * @param job The job to add to the queue */
    public void enqueueJob(PrintJob job) {
        Node newNode = new Node(job);

        // If the queue is empty, set the front and rear to the new node
        if (rear == null) {
            front = rear = newNode;
        } else {
            // Otherwise, add the new node to the rear
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued job: " + job.getName());
    }

    /*If there are no jobs on the queue, SOP
     * Removes a job from the queue (a single job)
     * SOP the name of the job processed */
    public void processNextJob() {
        if (front == null) {
            System.out.println("No jobs to process");
            return;
        }

        PrintJob processedJob = dequeue();
        System.out.println("Processing job: " + processedJob.getName());
    }

    /*Cancels a job by Id, all jobs have unique ids. The ids are generated automatically (PrintJob.java)
     * If the queue does not contain a job with the provided id, SOP
     * If the job is removed from the queue, SOP
     * @param jobId*/
    public void cancelJob(int jobId) {
        Node current = front;
        Node prev = null;

        // Search for the job with the given ID
        while (current != null && current.data.getId() != jobId) {
            prev = current;
            current = current.next;
        }

        // If the job is not found
        if (current == null) {
            System.out.println("Job with ID " + jobId + " not found in the queue.");
            return;
        }

        // Remove the job from the queue
        if (prev == null) {
            // If the job is the first in the queue
            front = current.next;
        } else {
            prev.next = current.next;
        }

        // If the removed job was the last in the queue, update rear
        if (current == rear) {
            rear = prev;
        }

        System.out.println("Cancelled job with ID: " + jobId);
    }

    /*Displays all jobs contained in this queue. */
    public void displayQueue() {
        Node current = front;
        System.out.println("Current Print Queue:");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /*Reverses the jobs in the queue*/
    public void reverseJobs() {
        Stack stack = new Stack();

        // Push all jobs onto a stack
        while (front != null) {
            stack.push(dequeue());
        }

        // Pop jobs from the stack and enqueue them back to reverse the order
        while (!stack.isEmpty()) {
            enqueueJob(stack.pop());
        }

        System.out.println("Reversed all jobs in the queue.");
    }

    /*Removes and returns a job
     * @return */
    private PrintJob dequeue() {
        if (front == null) {
            return null;
        }

        PrintJob job = front.data;
        front = front.next;

        // If the queue becomes empty, update rear
        if (front == null) {
            rear = null;
        }

        return job;
    }

    /*Returns true if the queue is empty, false otherwise
     * @return*/
    public boolean isQueueEmpty() {
        return front == null;
    }
}
