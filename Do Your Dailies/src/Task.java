public class Task {

    private String description;
    private int completed;

    /**
     * Constructor for the task object
     * 
     * @param description - string description of what the task is for
     * @param completed   - 0 = task is not completed; 1 = task is completed
     */
    public Task(String description, int completed) {
        this.description = description;
        this.completed = completed;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompleted() {
        return this.completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

}
