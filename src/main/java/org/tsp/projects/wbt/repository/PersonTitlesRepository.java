package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.PersonTitles;

/**
 * @author sfagade Feb 28, 2018
 */
@Repository
public interface PersonTitlesRepository extends JpaRepository<PersonTitles, Long> {

}
