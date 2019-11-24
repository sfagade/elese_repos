package org.tsp.projects.wbt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.Religions;
import org.tsp.projects.wbt.repository.ReligionsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/religionResource")
public class ReligionResource {

    private final ReligionsRepository religionRepos;

    @Autowired
    public ReligionResource(ReligionsRepository religionsRepository) {
        this.religionRepos = religionsRepository;
    }

    /**
     * This method is used to fetch all Religions
     *
     * @return Religions collection
     *
     */
    @GetMapping("/fetchAllReligions")
    public List<Religions> fetchAllReligions() {
        return religionRepos.findAll();
    }
}
