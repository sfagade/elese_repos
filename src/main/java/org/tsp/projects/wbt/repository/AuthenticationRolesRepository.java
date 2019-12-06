package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.AuthenticationRole;

/**
 *
 * @author sfagade
 */
@Repository
public interface AuthenticationRolesRepository extends JpaRepository<AuthenticationRole, Long> {
    
}
