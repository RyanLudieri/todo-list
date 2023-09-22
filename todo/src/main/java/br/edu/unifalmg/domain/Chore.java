package br.edu.unifalmg.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Chore {
    boolean isCompleted;

    String description;

    LocalDate deadline;


}
