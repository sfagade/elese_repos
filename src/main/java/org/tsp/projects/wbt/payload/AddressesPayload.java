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
public class AddressesPayload extends PayloadAbstractBase {

    @NotNull
    @Size(min = 7, max = 50)
    private String streetName;
    @NotNull
    @Size(min = 4, max = 50)
    private String city;
    @NotNull
    private String houseNo;
    @NotNull
    private long localGovtAreaId;
}
