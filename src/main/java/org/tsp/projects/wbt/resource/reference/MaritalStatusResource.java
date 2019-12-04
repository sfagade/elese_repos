package org.tsp.projects.wbt.resource.reference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.MaritalStatus;
import org.tsp.projects.wbt.repository.MaritalStatusRepository;

import java.util.List;

@RestController
@RequestMapping("/api/maritalStatusResource")
public class MaritalStatusResource {

    private final MaritalStatusRepository maritalStatusRepos;

    @Autowired
    public MaritalStatusResource(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepos = maritalStatusRepository;
    }

    /**
     * This method is used to fetch all Marital status values
     *
     * @return MaritalStatus collection
     */
    @RequestMapping(value = "/fetchAllMaritalStatus", method = RequestMethod.GET)
    public List<MaritalStatus> fetchAllMaritalStatus() {
        return maritalStatusRepos.findAll();
    }
}
