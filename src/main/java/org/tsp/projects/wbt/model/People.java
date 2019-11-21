package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

/**
 *
 * @author sfagade
 */
@Entity
@Table(name = "people")
@AttributeOverride(name = "id", column = @Column(name = "person_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class People extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 40)
    @Column(name = "middle_name")
    private String middleName;
    @Size(max = 45)
    @Column(name = "mother_maiden_name")
    private String motherMaidenName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "next_of_kin")
    private Integer nextOfKin;
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    @ManyToOne
    private GenderTypes genderTypeId;
    @Column(name = "wedding_anniversary")
    @Temporal(TemporalType.DATE)
    private Date weddingAnniversary;
    @Column(name = "update_required")
    private Boolean updateRequired;
    @Column(name = "is_disabled")
    private Boolean isDisabled;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne
    private Addresses addressId;
    @JoinColumn(name = "picture_upload_id", referencedColumnName = "file_upload_id")
    @ManyToOne
    private FileUploads pictureUploadId;
    @JoinColumn(name = "created_by_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation createdById;
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    @ManyToOne
    private Organizations organizationId;
    @JoinColumn(name = "person_title_id", referencedColumnName = "person_title_id")
    @ManyToOne
    private PersonTitles personTitleId;
    @JoinColumn(name = "local_govt_of_origin_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne
    private GeographicalBoundaries localGovtOfOriginId;
    @JoinColumn(name = "state_of_origin_id", referencedColumnName = "geographical_boundary_id")
    @ManyToOne
    private GeographicalBoundaries stateOfOriginId;
    @JoinColumn(name = "marital_status_id", referencedColumnName = "marital_status_id")
    @ManyToOne(optional = false)
    private MaritalStatus maritalStatusId;
    @JoinColumn(name = "occupation_id", referencedColumnName = "occupation_id")
    @ManyToOne
    private Occupations occupationId;
    @JoinColumn(name = "religion_id", referencedColumnName = "religion_id")
    @ManyToOne
    private Religions religionId;
    @OneToMany(mappedBy = "personId")
    private List<ContactInformation> contactInformationList;

    @Formula("Concat_ws(' ',first_name, last_name)")
    private String fullName;

    @Formula("Concat_ws(' ',first_name, middle_name, last_name)")
    private String completeName;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
