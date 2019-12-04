package org.tsp.projects.wbt.payload;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AuthenticationRolesPayload extends PayloadAbstractBase {

    @NotNull
    @Size(min = 1, max = 55)
    private String roleName;
    @Size(max = 225)
    private String roleDescription;
    private Integer roleType;
    @NotNull
    private int roleOrder;
    @Size(max = 15)
    private String urlMapping;
    private Boolean isRestricted;
}
