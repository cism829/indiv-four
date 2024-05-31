package csc340.example.indiv_four.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;

    public Object getAllTasks(int id){
        return taskRepo.findAll();
    }

    public Task getTaskById(int taskId) {
        return taskRepo.findById(taskId).orElse(null);
    }
    public void addNewtask(Task task){
        taskRepo.save(task);
    }
    public void deleteTask(int taskId) {
        taskRepo.deleteById(taskId);
    }

}
