package st10074970;



public class Task {
    private final String name;
    private final int number;
    private final String developerDetails;    
    private final String taskID;
    private final String description;
    private final String status;
    private final int duration;
    
    public Task(String name, int number, String developerDetails, String description, String status, int duration) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.developerDetails = developerDetails;       
        this.status = status;
        this.duration = duration;
        this.taskID = createTaskID();
    }

    
    public int getDuration(){
        return this.duration;
    }

    
    public String getTaskID(){
        return this.taskID;
    }
    

    private String createTaskID() {
        String id;
        String firstName = this.developerDetails.substring(0, this.developerDetails.indexOf(" "));
        id = this.name.substring(0, 2) + ":";
        id += this.number + ":";        
        id += this.developerDetails.substring(firstName.length() - 3, firstName.length());
        return id.toUpperCase();
    }
    


    public boolean checkTaskDescription() {
        return description.length() <= 50;
    }


    public String printTaskDetails() {
        return "Task Status: " + this.status + '\n' + "Developer Details: " + this.developerDetails + '\n' + "Task Number: " + this.number + '\n'  + "Task Name" + this.name + '\n' + "Task Description: " + this.description + '\n' + "Task ID: " + this.taskID + '\n' + "Duration :" + this.duration;
    }


    public int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }
        return totalHours;
    }
}    