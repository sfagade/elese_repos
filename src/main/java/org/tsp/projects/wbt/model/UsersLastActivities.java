package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sfagade
 */
@Entity
@Table(name = "users_last_activities")
@AttributeOverride(name = "id", column = @Column(name = "user_last_activity_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UsersLastActivities extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "activity")
    private String activity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activity_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityTime;
    @Size(max = 18)
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "entity_id")
    private Long entityId;
    @Size(max = 25)
    @Column(name = "entity_name")
    private String entityName;
    @Size(max = 25)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 25)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 200)
    @Column(name = "client")
    private String client;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "request_message")
    private String requestMessage;
    @Column(name = "response_message")
    private String responseMessage;
    @Column(name = "reference_identifier")
    private String referenceIdentifier;
    @Column(name = "response")
    private String response;
    @Column(name = "activity_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityStartTime;

     @JoinColumn(name = "login_id")
    @ManyToOne(optional = false)
    private LoginInformation loginInformation;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersLastActivities)) {
            return false;
        }
        UsersLastActivities other = (UsersLastActivities) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
