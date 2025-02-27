package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.GenderTypes;

/**
 *
 * @author sfagade
 */
@Repository
public interface GenderTypeRepository extends JpaRepository<GenderTypes, Long> {

}
