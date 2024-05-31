package csc340.example.indiv_four.tasks;

import csc340.example.indiv_four.goals.Goal;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @Nonnull
    private String title;

    private String details;

    private String status;


    public Task() {
    }

    public Task(int taskId, String status, String details, @Nonnull String title, Goal goal) {
        this.taskId = taskId;
        this.status = status;
        this.details = details;
        this.title = title;
        this.goal = goal;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
