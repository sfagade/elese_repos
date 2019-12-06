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
    private final LoginInformationRepository loginInformationRepository;
    private final ContactInformationRepository contactInformationRepository;
    private final UserRoleRepository userRoleRepository;
    private final GeographicalBoundariesRepository geographicalBoundariesRepository;
    private final GenderTypeRepository genderTypeRepository;
    private final MaritalStatusRepository maritalStatusRepository;
    private final OccupationsRepository occupationsRepository;
    private final PersonTitlesRepository personTitlesRepository;
    private final ReligionRepository religionsRepository;
    private final AuthenticationRolesRepository authenticationRolesRepository;

    private GeographicalBoundaries geographicalBoundaryLocalGovt = null;
    private GenderTypes genderTypes = null;
    private MaritalStatus maritalStatus = null;
    private Occupation occupation = null;
    private PersonTitles personTitles = null;
    private Religion religion = null;
    private AuthenticationRole authenticationRole = null;
    private String errorMessage;

    @Autowired
    public RegistrationResource(PersonRepository personRepos, AddressesRepository addressesRepos, GeographicalBoundariesRepository geographicalBoundariesRepos,
                                GenderTypeRepository genderTypeRepos, MaritalStatusRepository maritalStatusRepos, OccupationsRepository occupationsRepos,
                                PersonTitlesRepository personTitlesRepos, ReligionRepository religionsRepos, AuthenticationRolesRepository authenticationRolesRepos,
                                LoginInformationRepository loginInformationRepos, ContactInformationRepository contactInformationRepos,
                                UserRoleRepository userRoleRepos) {
        this.personRepository = personRepos;
        this.addressesRepository = addressesRepos;
        this.geographicalBoundariesRepository = geographicalBoundariesRepos;
        this.genderTypeRepository = genderTypeRepos;
        this.maritalStatusRepository = maritalStatusRepos;
        this.occupationsRepository = occupationsRepos;
        this.personTitlesRepository = personTitlesRepos;
        this.religionsRepository = religionsRepos;
        this.authenticationRolesRepository = authenticationRolesRepos;
        this.loginInformationRepository = loginInformationRepos;
        this.contactInformationRepository = contactInformationRepos;
        this.userRoleRepository = userRoleRepos;
    }

    @Transactional
    @RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewApplicationUser(@Valid @RequestBody PersonPayload personRequestPayload) {
        log.info("Registering new app user: {}", personRequestPayload);
        LoginInformationPayload loginPayload = personRequestPayload.getLoginInformation();
        AddressesPayload addressPayload = personRequestPayload.getAddresses();
        ContactInformationPayload contactInfoPayload = personRequestPayload.getContactInformation();

        if (!isValidPayloadReferences(personRequestPayload)) {
            log.info("Payload reference data validation failed: {}", errorMessage);
            return ResponseEntity.badRequest().body(new ApiResponse(false, errorMessage));
        }
        log.info("Completed all reference data validation");

        LoginInformation loginInformation = new LoginInformation(null, loginPayload.getUsername(), loginPayload.getPassword(), false, null, null);
        Addresses address = new Addresses(null, addressPayload.getHouseNo(), addressPayload.getCity(), geographicalBoundaryLocalGovt, null, null);
        Person person = new Person(null, personRequestPayload.getFirstName(), personRequestPayload.getLastName(), personRequestPayload.getMiddleName(),
                personRequestPayload.getDateOfBirth(), genderTypes, address, loginInformation, personTitles, geographicalBoundaryLocalGovt, maritalStatus,
                occupation, religion, loginInformation, null, null);
        ContactInformation contactInformation = new ContactInformation(null, contactInfoPayload.getContactPhoneNumber(), null,
                contactInfoPayload.getPrimaryEmailAddress(), null, address, loginInformation, person, null, null);

        loginInformationRepository.save(loginInformation);
        addressesRepository.save(address);
        personRepository.save(person);
        contactInformationRepository.save(contactInformation);
        userRoleRepository.save(new UserRole(null, loginInformation, authenticationRole, null, null, null));

        return ResponseEntity.ok(person);
    }

    private Boolean isValidPayloadReferences(PersonPayload personRequestPayload) {

        AddressesPayload addressPayload = personRequestPayload.getAddresses();
        Optional<GeographicalBoundaries> optionalLocalGovt = geographicalBoundariesRepository.findById(addressPayload.getLocalGovtAreaId());
        if (!optionalLocalGovt.isPresent()) {
            log.info("invalid local govt. id specified: {}", addressPayload.getLocalGovtAreaId());
            errorMessage = "Invalid Local Govt. ID specified";
            return false;
        }
        geographicalBoundaryLocalGovt = optionalLocalGovt.get();

        Optional<GenderTypes> optionalGenderType = genderTypeRepository.findById(personRequestPayload.getGenderId());
        if (!optionalGenderType.isPresent()) {
            log.info("invalid gender id specified: {}", personRequestPayload.getGenderId());
            errorMessage = "Invalid Gender ID specified";
            return false;
        }
        genderTypes = optionalGenderType.get();

        Optional<MaritalStatus> optionalMaritalStatus = maritalStatusRepository.findById(personRequestPayload.getMaritalStatusId());
        if (!optionalMaritalStatus.isPresent()) {
            log.info("invalid marital status id specified: {}", personRequestPayload.getMaritalStatusId());
            errorMessage = "Invalid Marital Status ID specified";
            return false;
        }
        maritalStatus = optionalMaritalStatus.get();

        Optional<Occupation> optionalOccupation = occupationsRepository.findById(personRequestPayload.getOccupationId());
        if (!optionalOccupation.isPresent()) {
            log.info("invalid occupation id specified: {}", personRequestPayload.getOccupationId());
            errorMessage = "Invalid Occupation ID specified";
            return false;
        }
        occupation = optionalOccupation.get();

        Optional<PersonTitles> optionalPersonTitle = personTitlesRepository.findById(personRequestPayload.getPersonTitleId());
        if (!optionalPersonTitle.isPresent()) {
            log.info("invalid person title id specified: {}", personRequestPayload.getPersonTitleId());
            errorMessage = "Invalid Title ID specified";
            return false;
        }
        personTitles = optionalPersonTitle.get();

        Optional<Religion> optionalReligion = religionsRepository.findById(personRequestPayload.getReligionId());
        if (!optionalReligion.isPresent()) {
            log.info("invalid religion id specified: {}", personRequestPayload.getReligionId());
            errorMessage = "Invalid Religion specified";
            return false;
        }
        religion = optionalReligion.get();

        Optional<AuthenticationRole> optionalAuthRole = authenticationRolesRepository.findById(personRequestPayload.getLoginInformation().getRoleId());
        if (!optionalAuthRole.isPresent()) {
            log.info("invalid authentication role id specified: {}", personRequestPayload.getLoginInformation().getRoleId());
            errorMessage = "Invalid Authentication Role specified";
            return false;
        }
        authenticationRole = optionalAuthRole.get();

        return true;
    }
}
