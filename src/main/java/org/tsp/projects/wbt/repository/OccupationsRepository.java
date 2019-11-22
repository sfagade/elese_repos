/*
 * This interface is used for Occupations entity data access and write
 */
package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tsp.projects.wbt.model.Occupations;

/**
 * @author sfagade
 */
public interface OccupationsRepository extends JpaRepository<Occupations, Long> {

}
