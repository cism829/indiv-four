package csc340.example.indiv_four.goals;
import csc340.example.indiv_four.tasks.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;

    @Autowired
    TaskService taskService;

    //View a list of all goals for this user.
    @GetMapping("/all")
    public String getAllGoals(Model model){
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goal-List";
    }

    //create goal
    @PostMapping("/create")
    public String addNewGoal( Goal goal){;
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        model.addAttribute("taskList", taskService.getAllTasks(id));
        return "goal-detail";
    }
    //Update an existing goal
    @PostMapping("/update")
    public String updateGoal(Goal goal){
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-update";
    }


    //Delete a goal.
    @GetMapping("delete/{id}")
    public String deleteGoalById(@PathVariable int id){
        goalService.deleteGoalbyId(id);
        return "redirect:/goals/all";
    }


}
