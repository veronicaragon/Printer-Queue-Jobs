class Stack {
    private Node top;

    public void push(PrintJob job) {
        Node newNode = new Node(job);
        newNode.next = top;
        top = newNode;
    }

    public PrintJob pop() {
        if (top == null) return null;
        PrintJob job = top.data;
        top = top.next;
        return job;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
