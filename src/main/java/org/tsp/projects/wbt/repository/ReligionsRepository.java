/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tsp.projects.wbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tsp.projects.wbt.model.Religions;

import java.util.List;

/**
 *
 * @author sfagade
 */
public interface ReligionsRepository extends JpaRepository<Religions, Long> {

}
