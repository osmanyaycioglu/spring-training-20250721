package org.training.teb.springtraining.person.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.teb.springtraining.person.rest.models.PersonDto;
import org.training.teb.springtraining.person.service.models.Person;

import java.util.List;

@Mapper
public interface IPersonMapper {
    IPersonMapper PERSON_MAPPER = Mappers.getMapper(IPersonMapper.class);

    Person toPerson(PersonDto person);

    PersonDto toPersonDto(Person person);

    List<Person> toPersons(List<PersonDto> person);

    List<PersonDto> toPersonDtos(List<Person> person);

}
