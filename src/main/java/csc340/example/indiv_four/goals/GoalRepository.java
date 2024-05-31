package csc340.example.indiv_four.goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>{
    //task list goes here ?
}