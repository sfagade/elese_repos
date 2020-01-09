package org.tsp.projects.wbt.payload.response;

import lombok.*;
import org.tsp.projects.wbt.payload.PayloadAbstractBase;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiResponse extends PayloadAbstractBase {

    private Boolean success;
    private String message;

}
