package csc340.example.indiv_four.tasks;

import csc340.example.indiv_four.goals.Goal;
import csc340.example.indiv_four.goals.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class TaskController {
    @Autowired
    TaskService taskService;
    GoalService goalService;

    @GetMapping("/tasks/all")
    public String getAllTasks(@PathVariable int id, Model model) {
        model.addAttribute("taskList", taskService.getAllTasks(id));
        return "taskList";
    }

    //view 1 task
    @GetMapping("/tasks/{taskId}")
    public String viewTask(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-detail";
    }

    @PostMapping("/tasks/create")
    public String addNewTask(Task task) {
        taskService.addNewtask(task);
        String url = "redirect:/goals/" + task.getGoal().getGoalId();
        return url;
    }

    @GetMapping("/tasks/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-update";
    }

    @PostMapping("/tasks/update")
    public String updateTask(Task task) {
        taskService.addNewtask(task);
//        String url="redirect:/goals/"+task.getGoal().getGoalId();
        return "task-detail";
    }

    @GetMapping("/tasks/delete/{goalId}/{id}")
    public String deleteGoalById(@PathVariable int id, @PathVariable int goalId) {
        taskService.deleteTask(id);
        return "redirect:/goals/" + goalId;
    }
}
