package org.tsp.projects.wbt.resource.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.Occupation;
import org.tsp.projects.wbt.repository.OccupationsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/occupationResource")
public class OccupationResource {

    private final OccupationsRepository occupationRepository;

    @Autowired
    public OccupationResource(OccupationsRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    /**
     * This method is used to fetch all Occupations from the database
     *
     * @return Occupations collections
     */
    @RequestMapping(value = "/fetchAllOccupations", method = RequestMethod.GET)
    public List<Occupation> fetchAllOccupations() {
        return occupationRepository.findAll();
    }
}
