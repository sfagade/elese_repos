package org.tsp.projects.wbt.model.listener;

import org.tsp.projects.wbt.model.WbtAbstractModelBase;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class RecordUpdateListener {

    @PreUpdate
    public void setUpdateDates(WbtAbstractModelBase abso) {
        abso.setModified(LocalDateTime.now());
    }

    @PrePersist
    public void setCreateDates(WbtAbstractModelBase abs) {
        abs.setModified(LocalDateTime.now());
        abs.setCreated(LocalDateTime.now());
    }
}
