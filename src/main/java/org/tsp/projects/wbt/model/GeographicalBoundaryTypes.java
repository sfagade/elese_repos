package org.tsp.projects.wbt.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author sfagade
 */
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "ref_geographical_boundary_types")
@AttributeOverride(name = "id", column = @Column(name = "geographical_boundary_type_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "GeographicalBoundaryTypes.findAll", query = "SELECT g FROM GeographicalBoundaryTypes g"),
        @NamedQuery(name = "GeographicalBoundaryTypes.findByGeographicalBoundaryTypeId", query = "SELECT g FROM GeographicalBoundaryTypes g WHERE g.id = :geographicalBoundaryTypeId"),
        @NamedQuery(name = "GeographicalBoundaryTypes.findByBoundaryTypeName", query = "SELECT g FROM GeographicalBoundaryTypes g WHERE g.boundaryTypeName = :boundaryTypeName")})
public class GeographicalBoundaryTypes extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 45)
    @Column(name = "boundary_type_name")
    private String boundaryTypeName;
    @Size(max = 25)
    @Column(name = "entity_name")
    private String entityName;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicalBoundaryTypes)) {
            return false;
        }
        GeographicalBoundaryTypes other = (GeographicalBoundaryTypes) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
}
