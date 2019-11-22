package org.tsp.projects.wbt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author sfagade
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Table(name = "ref_occupations")
@AttributeOverride(name = "id", column = @Column(name = "occupation_id", nullable = false, columnDefinition = "BIGINT"))
public class Occupations extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "occupation_name")
    private String occupationName;
    @Size(max = 1000)
    @Column(name = "remarks")
    private String remarks;

    @JsonIgnore
    @OneToMany(mappedBy = "occupationId")
    private List<People> peopleList;

}
