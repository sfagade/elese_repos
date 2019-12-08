package org.tsp.projects.wbt.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class PayloadAbstractBase {

    private Long baseId, createdById;
    private LocalDateTime created, modified;
}
