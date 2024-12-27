package main.taskApp.database;

public class Task {
    public String taskname;
    public String type;
    public String date;
    public String time;

    public Task(String taskname, String type, String date, String time) {
        this.taskname = taskname;
        this.type = type.toLowerCase();
        this.date = date;
        this.time = time;
    }


}
