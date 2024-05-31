package csc340.example.indiv_four.tasks;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
