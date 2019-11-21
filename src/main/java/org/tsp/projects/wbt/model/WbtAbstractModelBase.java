package org.tsp.projects.wbt.model;

import lombok.Data;
import org.tsp.projects.wbt.model.listener.RecordUpdateListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(RecordUpdateListener.class)
public abstract class WbtAbstractModelBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    protected Long id;

    @Column(name = "created")
    protected LocalDateTime created;

    @Column(name = "modified")
    protected LocalDateTime modified;
}
