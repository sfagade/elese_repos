package org.tsp.projects.wbt.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.tsp.projects.wbt.model.*;
import org.tsp.projects.wbt.payload.*;
import org.tsp.projects.wbt.repository.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/registrationResource")
public class RegistrationResource {

    private final PersonRepository personRepository;
    private final AddressesRepository addressesRepository;
    private final GeographicalBoundariesRepository geographicalBoundariesRepository;
    private final GenderTypeRepository genderTypeRepository;
    private final MaritalStatusRepository maritalStatusRepository;
    private final OccupationsRepository occupationsRepository;

    @Autowired
    public RegistrationResource(PersonRepository personRepos, AddressesRepository addressesRepos, GeographicalBoundariesRepository geographicalBoundariesRepos,
                                GenderTypeRepository genderTypeRepos, MaritalStatusRepository maritalStatusRepos, OccupationsRepository occupationsRepos) {
        this.personRepository = personRepos;
        this.addressesRepository = addressesRepos;
        this.geographicalBoundariesRepository = geographicalBoundariesRepos;
        this.genderTypeRepository = genderTypeRepos;
        this.maritalStatusRepository = maritalStatusRepos;
        this.occupationsRepository = occupationsRepos;
    }

    @Transactional
    @RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewApplicationUser(@Valid @RequestBody PersonPayload personRequestPayload) {
        log.info("Registering new app user: {}", personRequestPayload);
        LoginInformationPayload loginPayload = personRequestPayload.getLoginInformation();
        AddressesPayload addressPayload = personRequestPayload.getAddresses();
        ContactInformationPayload contactInfoPayload = personRequestPayload.getContactInformation();

        Optional<GeographicalBoundaries> optionalLocalGovt = geographicalBoundariesRepository.findById(addressPayload.getLocalGovtAreaId());
        if (!optionalLocalGovt.isPresent()) {
            log.info("invalid local govt. id specified: {}", addressPayload.getLocalGovtAreaId());
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid Local Govt. ID specified"));
        }

        Optional<GenderTypes> optionalGenderType = genderTypeRepository.findById(personRequestPayload.getGenderId());
        if (!optionalGenderType.isPresent()) {
            log.info("invalid gender id specified: {}", personRequestPayload.getGenderId());
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid Gender ID specified"));
        }

        Optional<MaritalStatus> optionalMaritalStatus = maritalStatusRepository.findById(personRequestPayload.getMaritalStatusId());
        if (!optionalMaritalStatus.isPresent()) {
            log.info("invalid marital status id specified: {}", personRequestPayload.getMaritalStatusId());
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid Marital Status ID specified"));
        }

        LoginInformation loginInformation = new LoginInformation(null, loginPayload.getUsername(), loginPayload.getPassword(), false, null, null);
        Addresses address = new Addresses(null, addressPayload.getHouseNo(), addressPayload.getCity(), optionalLocalGovt.get(), null, null);
        People person = new People();
        ContactInformation contactInformation = new ContactInformation();


        return null;
    }
}
