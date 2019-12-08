package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tsp.projects.wbt.model.Addresses;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
