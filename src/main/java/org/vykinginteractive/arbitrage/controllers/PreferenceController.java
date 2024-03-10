package org.vykinginteractive.arbitrage.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.vykinginteractive.arbitrage.entities.Preference;
import org.vykinginteractive.arbitrage.interfaces.IPreferenceService;
import org.vykinginteractive.arbitrage.models.dtos.UpdatePreference;
import org.vykinginteractive.arbitrage.models.responses.GeneralResponses;

@RestController
@RequestMapping("/system")
public class PreferenceController {

    private IPreferenceService preferenceService;

    public PreferenceController(IPreferenceService preferenceService){
        this.preferenceService = preferenceService;
    }

    //update preference
    @PutMapping("/preference/update")
    public ResponseEntity<Object> updatePreference(@Valid @RequestBody UpdatePreference req){
        Preference preference = preferenceService.updatePreference(req);
        return GeneralResponses.respondSuccessData(HttpStatus.OK, true, "Preference saved successfully!", preference);
    }

    //get preference
    @GetMapping("/preference")
    public ResponseEntity<Object> getSystemPreference(){
        Preference preference = preferenceService.getSystemPreference();
        return GeneralResponses.respondSuccessData(HttpStatus.OK, true, "", preference);
    }

}
