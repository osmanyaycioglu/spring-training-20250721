package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonPhone {
    @Id
    @GeneratedValue
    private Long personPhoneId;
    private String phoneName;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @Override
    public String toString() {
        return "PersonPhone{" +
               "personPhoneId=" + personPhoneId +
               ", phoneName='" + phoneName + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               '}';
    }
}
