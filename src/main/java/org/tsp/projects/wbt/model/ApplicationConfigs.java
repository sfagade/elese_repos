package org.tsp.projects.wbt.model;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sfagade
 */
@Entity
@Table(name = "application_config")
@AttributeOverride(name = "id", column = @Column(name = "application_config_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ApplicationConfigs extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "maximum_centers")
    private int maximumCenters;
    @Column(name = "maximum_agents")
    private Integer maximumAgents;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minimum_activation_recharge")
    private Float minimumActivationRecharge;
    @Column(name = "maximum_activation_recharge")
    private Float maximumActivationRecharge;
    @Column(name = "minimum_subsequent_recharge")
    private Float minimumSubsequentRecharge;
    @Column(name = "maximum_subsequent_recharge")
    private Float maximumSubsequentRecharge;
    @Column(name = "session_idle_time")
    private Integer sessionIdleTime;
    @Column(name = "refund_msisdn_price_difference")
    private Boolean refundMsisdnPriceDifference;
    @Column(name = "pay_msisdn_price_difference")
    private Boolean payMsisdnPriceDifference;
    @Column(name = "max_age")
    private Integer maxAge;
    @Column(name = "min_age")
    private Integer minAge;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "paystack_api_secret_key")
    private String paystackApiSecretKey;
    @Column(name = "paystack_api_public_key")
    private String paystackApiPublicKey;
    @Column(name = "sim_reserve_default_days")
    private Integer simReserveDefaultDays;

    @ManyToOne
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    private LoginInformation lastUpdateLoginId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationConfigs)) {
            return false;
        }
        ApplicationConfigs other = (ApplicationConfigs) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
