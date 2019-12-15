package org.tsp.projects.wbt.resource.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tsp.projects.wbt.model.AuthenticationRole;
import org.tsp.projects.wbt.model.WbtAbstractModelBase;
import org.tsp.projects.wbt.payload.AuthenticationRolesPayload;
import org.tsp.projects.wbt.repository.AuthenticationRolesRepository;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/authRolesResource")
public class AuthenticationRolesResource {

    private final AuthenticationRolesRepository authenticationRolesRepository;

    @Autowired
    public AuthenticationRolesResource(AuthenticationRolesRepository authenticationRolesRepos) {
        this.authenticationRolesRepository = authenticationRolesRepos;
    }

    @RequestMapping(value = "/createNewApplicationRole", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<WbtAbstractModelBase> createNewApplicationRole(@Valid @RequestBody AuthenticationRolesPayload authRoleRequestPayload) {
        log.info("About to save auth-role: {}", authRoleRequestPayload);
        AuthenticationRole authenticationRole = new AuthenticationRole(authRoleRequestPayload.getRoleName(), authRoleRequestPayload.getRoleDescription(),
                authRoleRequestPayload.getRoleType(), authRoleRequestPayload.getRoleOrder(), authRoleRequestPayload.getUrlMapping(),
                authRoleRequestPayload.getIsRestricted(),null, null);

        authenticationRolesRepository.save(authenticationRole);
        return ResponseEntity.ok(authenticationRole);
    }
}
