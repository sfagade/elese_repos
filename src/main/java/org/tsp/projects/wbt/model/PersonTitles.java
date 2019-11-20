package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
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
@Table(name = "ref_person_titles")
@AttributeOverride(name = "id", column = @Column(name = "person_title_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class PersonTitles extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title_name")
    private String titleName;
    @Size(max = 30)
    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "personTitleId")
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
        if (!(object instanceof PersonTitles)) {
            return false;
        }
        PersonTitles other = (PersonTitles) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
