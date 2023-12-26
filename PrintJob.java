public class PrintJob {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public PrintJob(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PrintJob{id=" + id + ", name='" + name + "'}";
    }
}
