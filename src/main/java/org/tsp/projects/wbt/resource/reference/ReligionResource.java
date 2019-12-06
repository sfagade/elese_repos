package org.tsp.projects.wbt.resource.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.Religion;
import org.tsp.projects.wbt.repository.ReligionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/religionResource")
public class ReligionResource {

    private final ReligionRepository religionRepos;

    @Autowired
    public ReligionResource(ReligionRepository religionsRepository) {
        this.religionRepos = religionsRepository;
    }

    /**
     * This method is used to fetch all Religions
     *
     * @return Religions collection
     *
     */
    @GetMapping("/fetchAllReligions")
    public List<Religion> fetchAllReligions() {
        return religionRepos.findAll();
    }
}
