package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ref_marital_status")
@AttributeOverride(name = "id", column = @Column(name = "marital_status_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MaritalStatus extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "marital_status_name")
    private String maritalStatusName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maritalStatusId")
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
        if (!(object instanceof MaritalStatus)) {
            return false;
        }
        MaritalStatus other = (MaritalStatus) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
