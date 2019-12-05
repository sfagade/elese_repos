package org.tsp.projects.wbt.payload;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiResponse extends PayloadAbstractBase {

    private Boolean success;
    private String message;

}
