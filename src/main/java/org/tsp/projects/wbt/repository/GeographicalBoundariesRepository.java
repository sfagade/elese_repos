package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.GeographicalBoundaries;

import java.util.List;

/**
 *
 * @author sfagade
 */
@Repository
public interface GeographicalBoundariesRepository extends JpaRepository<GeographicalBoundaries, Long> {

    @Query("SELECT g FROM GeographicalBoundaries g WHERE g.geographicalBoundaryTypeId.id = :boundary_type order by g.boundaryName")
    List<GeographicalBoundaries> findAllByGeographicalBoundaryTypeId(@Param("boundary_type") Long boundaryTypeId);

    @Query("SELECT g FROM GeographicalBoundaries g WHERE g.boundaryParentId.id = :parent_id order by g.boundaryName")
    List<GeographicalBoundaries> findByParentId(@Param("parent_id") Long parent);
}
