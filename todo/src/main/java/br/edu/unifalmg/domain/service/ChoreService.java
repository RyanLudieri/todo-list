package br.edu.unifalmg.domain.service;

import br.edu.unifalmg.domain.Chore;
import br.edu.unifalmg.domain.exception.DuplicatedChoreException;
import br.edu.unifalmg.domain.exception.InvalidDeadlineException;
import br.edu.unifalmg.domain.exception.InvalidDescriptionException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class ChoreService {
    private List<Chore> chores;

    public ChoreService(){
        List<Chore> chores = new ArrayList<>();
    }


    public Chore addChore(String description, LocalDate deadline){
        if(description == null || description.isEmpty()){
            throw new InvalidDescriptionException("The description cannot be null or empty");
        }

        if(deadline == null || deadline.isBefore(LocalDate.now())){
            throw new InvalidDeadlineException("The deadline cannot be null or before the current date");
        }

        for(Chore chore : chores){
            if(chore.getDescription().equals(description)
                    && chore.getDeadline().isEqual(deadline) ){
                throw new DuplicatedChoreException("The Given chore already exists");
            }
        }
        Chore chore = new Chore();
        chore.setDescription(description);
        chore.setDeadline(deadline);
        chore.setIsCompleted(Boolean.FALSE);
        chores.add(chore);
        return chore;

    }

}
