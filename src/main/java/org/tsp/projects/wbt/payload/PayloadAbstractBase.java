package org.tsp.projects.wbt.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class PayloadAbstractBase {

    protected Long baseId, createdById;
    protected LocalDateTime created, modified;
}
