/*
 * This interface is used for every data access for File purpose entity
 */
package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.FilePurpose;

/**
 *
 * @author sfagade
 */
@Repository
public interface FilePurposeRepository extends JpaRepository<FilePurpose, Long> {

}
