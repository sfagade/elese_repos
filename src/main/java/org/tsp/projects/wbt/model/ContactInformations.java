package org.tsp.projects.wbt.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sfagade
 */
@Entity
@Table(name = "contact_informations")
@AttributeOverride(name = "id", column = @Column(name = "contact_information_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ContactInformations extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 15)
    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;
    @Size(max = 15)
    @Column(name = "backup_phone_number")
    private String backupPhoneNumber;
    @Basic(optional = false)
    @NotNull
    @Email
    @Size(min = 1, max = 100)
    @Column(name = "office_email_address")
    private String officeEmailAddress;
    @Size(max = 100)
    @Column(name = "personal_email_address")
    private String personalEmailAddress;
    @Size(max = 100)
    @Column(name = "web_address")
    private String webAddress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "fax")
    private String fax;

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne
    private Addresses addressId;
    @JoinColumn(name = "created_by_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation createdById;
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    @ManyToOne
    private Organizations organizationId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private People personId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactInformations)) {
            return false;
        }
        ContactInformations other = (ContactInformations) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
