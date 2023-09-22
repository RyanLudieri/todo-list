package br.edu.unifalmg.service;

import br.edu.unifalmg.domain.exception.DuplicatedChoreException;
import br.edu.unifalmg.domain.exception.InvalidDeadlineException;
import br.edu.unifalmg.domain.exception.InvalidDescriptionException;
import br.edu.unifalmg.domain.service.ChoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChoreServiceTest {

    @Test
    void addChoreWhenDescriptionIsInvalidThrownAnException(){
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null,null)),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("",null)),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().minusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().minusDays(1)))

        );
    }

    @Test
    @DisplayName("#addChore > When the deadline is invalid > Throw an exception")
    void addChoreWhenDeadlineIsInvalidThrownAnException(){
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDeadlineException.class,
                        () -> service.addChore("Description", null)),
                () -> assertThrows(InvalidDeadlineException.class,
                        () -> service.addChore("Description", LocalDate.now().minusDays(1)))
        );
    }

    @Test
    @DisplayName("$addChore > When add a chore > When the chore already exists > Throw a exception")
    void addChoreWhenAddingAChoreAlreadyExistsThrowAnException(){
        ChoreService service = new ChoreService();
        service.addChore("Description", LocalDate.now());
        assertAll(
                ()-> assertThrows(DuplicatedChoreException.class,
                    ()-> service.addChore("Description", LocalDate.now()))
        );

    }


}
