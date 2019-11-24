package org.tsp.projects.wbt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.PersonTitles;
import org.tsp.projects.wbt.repository.PersonTitlesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/personTitleResource")
public class PersonTitleResource {

    private final PersonTitlesRepository personTitlesRepository;

    @Autowired
    public PersonTitleResource(PersonTitlesRepository personTitlesRepository) {
        this.personTitlesRepository = personTitlesRepository;
    }

    /**
     * This method is used to fetching all Salutations
     *
     * @return PersonTitles collection
     */
    @GetMapping("/fetchPersonTitles")
    public List<PersonTitles> fetchPersonTitles() {
        return personTitlesRepository.findAll();
    }
}
