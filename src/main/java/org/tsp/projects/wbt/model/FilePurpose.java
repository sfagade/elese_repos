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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sfagade
 */
@Entity
@Table(name = "ref_file_purpose")
@AttributeOverride(name = "id", column = @Column(name = "file_purpose_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class FilePurpose extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "purpose_name")
    private String purposeName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filePurposeId")
    private List<FileUploads> fileUploadsList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilePurpose)) {
            return false;
        }
        FilePurpose other = (FilePurpose) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
