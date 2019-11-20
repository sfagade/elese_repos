package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "file_uploads")
@AttributeOverride(name = "id", column = @Column(name = "file_upload_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class FileUploads extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "file_type")
    private String fileType;
    @Size(max = 9)
    @Column(name = "picture_side")
    private String pictureSide;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "file_path")
    private String filePath;
    @Size(max = 200)
    @Column(name = "absolute_path")
    private String absolutePath;
    @Lob
    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "picture_encoded")
    private String pictureEncoded;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    @JoinColumn(name = "uploaded_by_id", referencedColumnName = "login_id")
    @ManyToOne
    private LoginInformation uploadedById;
    @JoinColumn(name = "deleted_by_id", referencedColumnName = "login_id")
    @ManyToOne
    private LoginInformation deletedById;
    @JoinColumn(name = "file_purpose_id", referencedColumnName = "file_purpose_id")
    @ManyToOne(optional = false)
    private FilePurpose filePurposeId;
    @OneToMany(mappedBy = "pictureUploadId")
    private List<People> peopleList;

    @OneToMany(mappedBy = "organizationLogoId")
    private List<Organizations> organizationsList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileUploads)) {
            return false;
        }
        FileUploads other = (FileUploads) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
