package org.tsp.projects.wbt.builders;

import org.tsp.projects.wbt.model.LoginInformation;
import org.tsp.projects.wbt.payload.response.LoginInformationResponse;

public class LoginInformationResponseBuilder {

    public static LoginInformationResponse buildLoginInformationResponseData(LoginInformation loginInformation, boolean isDetail) {

        LoginInformationResponse loginInfoResponse;
        if (!isDetail) {
            loginInfoResponse = new LoginInformationResponse(loginInformation.getId(), loginInformation.getUsername(),
                    loginInformation.isActive(), loginInformation.getLoginStatus(), loginInformation.getLastLoginDate(),
                    loginInformation.getCreated(), loginInformation.getModified());
        } else {
            loginInfoResponse = buildLoginInformationResponseData(loginInformation, false);
        }
        return loginInfoResponse;
    }
}
