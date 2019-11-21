package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "login_information")
@AttributeOverride(name = "id", column = @Column(name = "login_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class LoginInformation extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "pword")
    private String pword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Column(name = "login_status")
    private Boolean loginStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "activation_key")
    private String activationKey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "secret_question_answer")
    private String secretQuestionAnswer;
    @Column(name = "activate_status")
    private Boolean activateStatus;
    @Column(name = "lastlogindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogindate;
    @Column(name = "pword_reset_required")
    private Boolean pwordResetRequired;
    @Size(max = 35)
    @Column(name = "reset_key")
    private String resetKey;
    @Size(max = 18)
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    @Size(max = 150)
    @Column(name = "remember_token")
    private String rememberToken;

    @Size(max = 25)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 25)
    @Column(name = "latitude")
    private String latitude;

    @Column(name = "day_key_expiry")
    @Temporal(TemporalType.DATE)
    private Date dayKeyExpiry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdById")
    private List<Addresses> addressesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdById")
    private List<People> peopleList1;
    @OneToMany(mappedBy = "uploadedById")
    private List<FileUploads> fileUploadsList;
    @OneToMany(mappedBy = "deletedById")
    private List<FileUploads> fileUploadsList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdById")
    private List<ContactInformation> contactInformationsList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdById")
    private List<Organizations> organizationsList;
     @OneToMany(mappedBy="loginInformation")
    private Set<UsersLastActivities> usersLastActivitiesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logindetailId")
    private List<UserRoles> userRolesList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginInformation)) {
            return false;
        }
        LoginInformation other = (LoginInformation) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
