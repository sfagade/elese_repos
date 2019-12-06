package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "organizations")
@AttributeOverride(name = "id", column = @Column(name = "organization_id", nullable = false, columnDefinition = "BIGINT"))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizations.findAll", query = "SELECT o FROM Organizations o"),
    @NamedQuery(name = "Organizations.findByOrganizationId", query = "SELECT o FROM Organizations o WHERE o.id = :organizationId"),
    @NamedQuery(name = "Organizations.findByOrganizationName", query = "SELECT o FROM Organizations o WHERE o.organizationName = :organizationName")})
public class Organizations extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "organization_name")
    private String organizationName;
    @Size(max = 12)
    @Column(name = "organization_code")
    private String organizationCode;
    @Column(name = "rcno")
    private String rcno;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "is_vendor")
    private Boolean isVendor;

    @OneToMany(mappedBy = "organizationId")
    private List<Person> personList;
    @OneToMany(mappedBy = "organizationId")
    private List<ContactInformation> contactInformationList;
    @JoinColumn(name = "organization_logo_id", referencedColumnName = "file_upload_id")
    @ManyToOne
    private FileUploads organizationLogoId;
    @JoinColumn(name = "created_by_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation createdById;
    @JoinColumn(name = "organization_type_id", referencedColumnName = "organization_type_id")
    @ManyToOne(optional = false)
    private OrganizationSectors organizationTypeId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizations)) {
            return false;
        }
        Organizations other = (Organizations) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
