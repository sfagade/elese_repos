package org.tsp.projects.wbt.resource.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.GeographicalBoundaryTypes;
import org.tsp.projects.wbt.repository.GeographicalBoundaryTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/geoBoundaryResource")
public class GeographicalBoundaryTypeResource {

    private final GeographicalBoundaryTypeRepository geoBoundaryTypeRepos;

    @Autowired
    public GeographicalBoundaryTypeResource(GeographicalBoundaryTypeRepository geographicalBoundaryTypeRepository) {
        this.geoBoundaryTypeRepos = geographicalBoundaryTypeRepository;
    }

    @RequestMapping(value = "/fetchGeographicalBoundaryTypes", method = RequestMethod.GET)
    public List<GeographicalBoundaryTypes> fetchGeographicalBoundaryType() {
        return geoBoundaryTypeRepos.findAll();
    }
}
