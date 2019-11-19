package org.tsp.projects.wbt.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * @author sfagade
 */
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "ref_geographical_boundaries")
@AttributeOverride(name = "id", column = @Column(name = "geographical_boundary_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "GeographicalBoundaries.findAll", query = "SELECT g FROM GeographicalBoundaries g"),
        @NamedQuery(name = "GeographicalBoundaries.findByGeographicalBoundaryId", query = "SELECT g FROM GeographicalBoundaries g WHERE g.id = :geographicalBoundaryId"),
        @NamedQuery(name = "GeographicalBoundaries.findByBoundaryName", query = "SELECT g FROM GeographicalBoundaries g WHERE g.boundaryName = :boundaryName")})
public class GeographicalBoundaries extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 35)
    @Column(name = "boundary_name")
    private String boundaryName;
    @Size(max = 7)
    @Column(name = "short_name_code")
    private String shortNameCode;
    @Size(max = 75)
    @Column(name = "origin_name")
    private String originName;
    @Size(max = 5)
    @Column(name = "country_calling_code")
    private String countryCallingCode;
    @Size(max = 5)
    @Column(name = "locale_code")
    private String localeCode;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "geographicalStateId")
    //private List<Addresses> addressesList;
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "geographicalCountryId")
    // private List<Addresses> addressesList1;

    @JoinColumn(name = "boundary_parent_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne
    private GeographicalBoundaries boundaryParentId;
    @OneToMany(mappedBy = "boundaryParentId")
    private List<GeographicalBoundaries> geographicalBoundariesList;
    @JoinColumn(name = "geographical_boundary_type_id")
    @ManyToOne(optional = false)
    private GeographicalBoundaryTypes geographicalBoundaryTypeId;
    //@OneToMany(mappedBy = "stateOfOriginId")
    //private List<People> peopleList;


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicalBoundaries)) {
            return false;
        }
        GeographicalBoundaries other = (GeographicalBoundaries) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
