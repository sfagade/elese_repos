package org.tsp.projects.wbt.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsp.projects.wbt.model.FilePurpose;
import org.tsp.projects.wbt.repository.FilePurposeRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/filePurposeResource")
public class FilePurposeResource {

    private final FilePurposeRepository filePurposeRepos;

    @Autowired
    public FilePurposeResource(FilePurposeRepository filePurposeRepository) {
        this.filePurposeRepos = filePurposeRepository;
    }

    /**
     * This method is used to fetch all file purpose
     *
     * @return FilePurpose collection
     */
    @RequestMapping(value = "/fetchAllFilePurposes", method = RequestMethod.GET)
    public List<FilePurpose> fetchAllFilePurpose() {
        return filePurposeRepos.findAll();
    }
}
