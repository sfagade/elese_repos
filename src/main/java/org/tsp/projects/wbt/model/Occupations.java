package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sfagade
 */
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "ref_occupations")
@AttributeOverride(name = "id", column = @Column(name = "occupation_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Occupations.findAll", query = "SELECT o FROM Occupations o"),
    @NamedQuery(name = "Occupations.findByOccupationId", query = "SELECT o FROM Occupations o WHERE o.id = :occupationId"),
    @NamedQuery(name = "Occupations.findByOccupationName", query = "SELECT o FROM Occupations o WHERE o.occupationName = :occupationName")})
public class Occupations extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "occupation_name")
    private String occupationName;
    @Size(max = 1000)
    @Column(name = "remarks")
    private String remarks;

    @OneToMany(mappedBy = "occupationId")
    private List<People> peopleList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occupations)) {
            return false;
        }
        Occupations other = (Occupations) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
