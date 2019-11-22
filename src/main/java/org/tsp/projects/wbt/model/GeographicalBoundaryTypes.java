package org.tsp.projects.wbt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author sfagade
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Table(name = "ref_geographical_boundary_types")
@AttributeOverride(name = "id", column = @Column(name = "geographical_boundary_type_id", nullable = false, columnDefinition = "BIGINT"))
public class GeographicalBoundaryTypes extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 45)
    @Column(name = "boundary_type_name")
    private String boundaryTypeName;
    @Size(max = 25)
    @Column(name = "entity_name")
    private String entityName;

}
