package org.tsp.projects.wbt.resource.reference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.GenderTypes;
import org.tsp.projects.wbt.repository.GenderTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/referenceData/genderResource")
public class GenderResource {

    private final GenderTypeRepository genderTypeRepos;

    @Autowired
    public GenderResource(GenderTypeRepository genderTypeRepository) {
        this.genderTypeRepos = genderTypeRepository;
    }

    /**
     * This method is used to fetch all Gender types
     *
     * @return GenderTypes collection
     */
    @RequestMapping(value = "/fetchAllGenderTypes", method = RequestMethod.GET)
    public List<GenderTypes> fetchAllGenderTypes() {
        return genderTypeRepos.findAll();
    }
}
