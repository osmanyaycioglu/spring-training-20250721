package org.training.teb.springtraining.person.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddResponse {
    private String note;
    private Long personId;
}
