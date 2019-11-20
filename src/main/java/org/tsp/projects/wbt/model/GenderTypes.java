package org.tsp.projects.wbt.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@Table(name = "ref_gender_types")
@AttributeOverride(name = "id", column = @Column(name = "gender_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenderTypes.findAll", query = "SELECT g FROM GenderTypes g"),
    @NamedQuery(name = "GenderTypes.findByGenderId", query = "SELECT g FROM GenderTypes g WHERE g.id = :genderId"),
    @NamedQuery(name = "GenderTypes.findByGenderName", query = "SELECT g FROM GenderTypes g WHERE g.genderName = :genderName")})
public class GenderTypes extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "gender_name")
    private String genderName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenderTypes)) {
            return false;
        }
        GenderTypes other = (GenderTypes) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
}
