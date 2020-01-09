package org.tsp.projects.wbt.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.builders.PersonResponseBuilder;
import org.tsp.projects.wbt.model.Person;
import org.tsp.projects.wbt.payload.response.PersonResponse;
import org.tsp.projects.wbt.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/peopleResource")
public class PeopleResource {

    private final PersonRepository personRepository;

    @Autowired
    public PeopleResource(PersonRepository personRepos) {
        this.personRepository = personRepos;
    }

    @RequestMapping(value = "/fetchAllSystemUsers", method = RequestMethod.GET)
    public List<PersonResponse> fetchAllSystemUsers() {
        List<Person> personList = personRepository.findAll();
        List<PersonResponse> personListResponse = new ArrayList<>();
        if (personList != null && personList.size() > 0) {
            personList.forEach((person) -> {
                personListResponse.add(PersonResponseBuilder.buildPersonResponseData(person, false));
            });
        }

        return personListResponse;
    }
}
