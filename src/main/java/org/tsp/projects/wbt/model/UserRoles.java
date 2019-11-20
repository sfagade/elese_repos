/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tsp.projects.wbt.model;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "user_roles")
@AttributeOverride(name = "id", column = @Column(name = "user_role_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
    @NamedQuery(name = "UserRoles.findByUserRoleId", query = "SELECT u FROM UserRoles u WHERE u.id = :userRoleId")})
public class UserRoles extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @JoinColumn(name = "authentication_role_id", referencedColumnName = "authentication_role_id")
    @ManyToOne(optional = false)
    private AuthenticationRoles authenticationRoleId;
    @JoinColumn(name = "logindetail_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation logindetailId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
