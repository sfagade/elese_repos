package org.tsp.projects.wbt.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
public class LoginInformationPayload extends PayloadAbstractBase {

    @NotNull
    private String username;
    @NotNull
    @Size(min = 8, max = 16)
    private String password;
    @NotNull
    private long roleId;

    @NotNull
    private String ipAddress;
    @NotNull
    private String loginPortal;
    private String longitude, latitude, client;

}
