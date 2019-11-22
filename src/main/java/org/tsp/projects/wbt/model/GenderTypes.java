package org.tsp.projects.wbt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author sfagade
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Table(name = "ref_gender_types")
@AttributeOverride(name = "id", column = @Column(name = "gender_id", nullable = false, columnDefinition = "BIGINT"))
public class GenderTypes extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "gender_name")
    private String genderName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

}
