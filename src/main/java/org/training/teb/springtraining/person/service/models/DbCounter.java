package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbCounter {
    @Id
    @GeneratedValue
    private Long   counterId;
    private String counterName;
    private Long   currentCount;

}
