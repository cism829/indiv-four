package csc340.example.indiv_four.goals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    @Autowired
    GoalRepository goalRepository;

    public Object getAllGoals(){
        return goalRepository.findAll();
    }
    public Goal getGoalById(int id){
        return goalRepository.findById(id).orElse(null);
    }
    public void deleteGoalbyId(int id){
        goalRepository.deleteById(id);
    }
    public void addNewGoal(Goal goal){
        goalRepository.save(goal);
    }


}
