package org.tsp.projects.wbt.builders;

import org.tsp.projects.wbt.model.Person;
import org.tsp.projects.wbt.payload.response.PersonResponse;

public class PersonResponseBuilder {

    public static PersonResponse buildPersonResponseData(Person person, boolean isDetail) {
        PersonResponse personResponse;
        if (!isDetail) {
            personResponse = new PersonResponse(person.getId(), person.getFirstName(), person.getLastName(), 
                    person.getMiddleName(), person.getDateOfBirth(), 
                    GenderResponseBuilder.buildGenderResponseData(person.getGenderTypeId()), 
                    person.getUpdateRequired(), person.getIsDisabled(), person.getIsDeleted(), 
                    LoginInformationResponseBuilder.buildLoginInformationResponseData(person.getLoginInformation(), isDetail),
                    person.getFullName(), person.getCompleteName(), person.getCreated(), person.getModified());
        } else {
            personResponse = buildPersonResponseData(person, false);
        }

        return personResponse;
    }
}
