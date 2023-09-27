package br.edu.unifalmg.service;

import br.edu.unifalmg.domain.exception.DuplicatedChoreException;
import br.edu.unifalmg.domain.exception.InvalidDeadlineException;
import br.edu.unifalmg.domain.exception.InvalidDescriptionException;
import br.edu.unifalmg.domain.service.ChoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        assertThrows(DuplicatedChoreException.class,
                    ()-> service.addChore("Description", LocalDate.now()));

    }

    @Test
    @DisplayName("#addChore > When just one chore is adding > Should not throw any exception")
    public void addJustOneChoreWithoutExceptions() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertDoesNotThrow(() -> service.addChore("Description", LocalDate.now())),
                () -> assertDoesNotThrow(() -> service.addChore("Another Description", LocalDate.now().plusDays(1)))
        );
    }

    @Test
    @DisplayName("#addChore > When adding more than one chore at the same time (without repetition) > Should not throw any exception")
    public void addMoreThanOneChoreWithoutRepetition() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertDoesNotThrow(() -> service.addChore("Description 1", LocalDate.now())),
                () -> assertDoesNotThrow(() -> service.addChore("Description 2", LocalDate.now().plusDays(1))),
                () -> assertDoesNotThrow(() -> service.addChore("Description 3", LocalDate.now().plusDays(2)))
        );
    }


}
