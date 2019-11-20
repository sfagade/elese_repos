package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sfagade
 */
@Entity
@Table(name = "addresses")
@AttributeOverride(name = "id", column = @Column(name = "address_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Addresses extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 45)
    @Column(name = "house_no")
    private String houseNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "street_name")
    private String streetName;
    @Size(max = 200)
    @Column(name = "address_cont")
    private String addressCont;
    @Size(max = 100)
    @Column(name = "directions")
    private String directions;
    @Size(max = 100)
    @Column(name = "city")
    private String city;
    @Size(max = 8)
    @Column(name = "area_code")
    private String areaCode;

    @JoinColumn(name = "created_by_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation createdById;
    @JoinColumn(name = "geographical_state_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne(optional = false)
    private GeographicalBoundaries geographicalStateId;
    @JoinColumn(name = "geographical_country_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne(optional = false)
    private GeographicalBoundaries geographicalCountryId;
    @JoinColumn(name = "local_council_dev_area_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne()
    private GeographicalBoundaries localCouncilDevAreaId;
    @OneToMany(mappedBy = "addressId")
    private List<People> peopleList;
    @OneToMany(mappedBy = "addressId")
    private List<ContactInformations> contactInformationsList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
