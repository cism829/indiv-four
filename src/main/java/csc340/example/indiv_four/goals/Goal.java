package csc340.example.indiv_four.goals;

import csc340.example.indiv_four.tasks.Task;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Table(name = "goals")
public class Goal {
    //goalId - (int) a unique identifier for a goal, autogenerated.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;

    //userId - (int) an ID for the user. <We are not making users for this assignment. In a real world, we would want to record whose goal this is, and this would be a foreign key to the Users table>.
    private int userId;

    //title - (String) nonnull.
    @Nonnull
    private String title;

    //details - (String) may be null.
    private String details;

    //targetDate - (Date).
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date targetDate;

    //status - (String) pending/in-progress/done/cancelled.
    private String status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "goal_id",referencedColumnName = "goal_id")
    @Transient
    private List<Task> task;

    public Goal() {
    }

    public Goal(int goalId, int userId, @Nonnull String title, String details, Date targetDate, String status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    //public Object sqlDate(){
      //  java.sql.Date sqlDate = new java.sql.Date(targetDate.getTime());
        //return sqlDate;
    //}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
