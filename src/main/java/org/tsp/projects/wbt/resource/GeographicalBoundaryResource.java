package org.tsp.projects.wbt.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.GeographicalBoundaries;
import org.tsp.projects.wbt.repository.GeographicalBoundariesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/geoBoundaryResource")
public class GeographicalBoundaryResource {

    private final GeographicalBoundariesRepository geoBoundaryRepository;

    @Autowired
    public GeographicalBoundaryResource(GeographicalBoundariesRepository geographicalBoundariesRepository) {
        this.geoBoundaryRepository = geographicalBoundariesRepository;
    }

    /**
     * This method is used to fetch all geographical boundary records e.g.
     * Country, states
     *
     *
     * @param boundaryType - e.g. Country, State, Local govt
     * @param boundaryId - In case we need to fetch just one record
     * @return GeographicalBoundaryDto collection
     */
    @RequestMapping(value = "/fetchGeographicalBoundariesData/{boundary_type}/{parent_id}",
            method = RequestMethod.GET)
    public List<GeographicalBoundaries> fetchGeographicalBoundariesData(@PathVariable("boundary_type") String boundaryType,
                                                                        @PathVariable("parent_id") String boundaryId) {
        List<GeographicalBoundaries> boundaries;

        if (!boundaryId.equals("0")) {
            boundaries = geoBoundaryRepository.findByParentId(Long.valueOf(boundaryId));
        } else if (!boundaryType.equals("0")) {
            boundaries = geoBoundaryRepository.findAllByGeographicalBoundaryTypeId(Long.valueOf(boundaryType));
        } else {
            boundaries = geoBoundaryRepository.findAll();
        }

        return boundaries;
    }
}
