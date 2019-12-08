package org.tsp.projects.wbt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 *
 * @author sfagade
 */
@Entity
@Table(name = "ref_religions")
@AttributeOverride(name = "id", column = @Column(name = "religion_id", nullable = false, columnDefinition = "BIGINT"))
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Religion extends WbtAbstractModelBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "religion_name")
    private String religionName;
    @Size(max = 30)
    @Column(name = "created_by")
    private String createdBy;

    @JsonIgnore
    @OneToMany(mappedBy = "religionId")
    private List<Person> personList;

}
