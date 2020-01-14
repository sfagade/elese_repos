package org.tsp.projects.wbt.builders;

import org.tsp.projects.wbt.model.GenderTypes;
import org.tsp.projects.wbt.payload.response.GenderTypeResponse;

public class GenderResponseBuilder {

    public static GenderTypeResponse buildGenderResponseData(GenderTypes genderType) {
        return new GenderTypeResponse(genderType.getId(), genderType.getGenderName(), genderType.getDescription(),
                genderType.getCreated(), genderType.getModified());
    }
}
