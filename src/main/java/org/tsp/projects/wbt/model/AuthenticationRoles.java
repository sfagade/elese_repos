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
@Table(name = "authentication_roles")
@AttributeOverride(name = "id", column = @Column(name = "authentication_role_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AuthenticationRoles extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "role_name")
    private String roleName;
    @Size(max = 225)
    @Column(name = "role_description")
    private String roleDescription;
    @Column(name = "role_type")
    private Integer roleType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_order")
    private int roleOrder;
    @Size(max = 15)
    @Column(name = "url_mapping")
    private String urlMapping;
    @Column(name = "is_restricted")
    private Boolean isRestricted;
    @Size(max = 35)
    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authenticationRoleId")
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
        if (!(object instanceof AuthenticationRoles)) {
            return false;
        }
        AuthenticationRoles other = (AuthenticationRoles) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
