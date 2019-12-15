package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.UsersLastActivities;

/** This class is used for data access and modification for user-last-activities
 * entity
 * @author sfagade
 */
@Repository
public interface UsersLastActivitiesRepository extends JpaRepository<UsersLastActivities, Long> {
}
