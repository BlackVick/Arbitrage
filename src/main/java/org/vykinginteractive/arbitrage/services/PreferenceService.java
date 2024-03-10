package org.vykinginteractive.arbitrage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vykinginteractive.arbitrage.entities.Preference;
import org.vykinginteractive.arbitrage.interfaces.IPreferenceService;
import org.vykinginteractive.arbitrage.models.dtos.UpdatePreference;
import org.vykinginteractive.arbitrage.repositories.PreferenceRepository;
import org.vykinginteractive.arbitrage.utils.Methods;
import org.vykinginteractive.arbitrage.values.Common;

@Service
public class PreferenceService implements IPreferenceService {

    @Autowired
    private PreferenceRepository prefRepository;

    public PreferenceService(PreferenceRepository prefRepository){
        this.prefRepository = prefRepository;
    }

    @Override
    public Preference updatePreference(UpdatePreference req) {
        //get preference
        Preference preference = prefRepository.getPreference(Common.PREF_KEY);
        if (preference != null){

            preference.setName(Methods.checkForStringNull(req.getName(), preference.getName()));
            preference.setAddress(Methods.checkForStringNull(req.getAddress(), preference.getAddress()));
            preference.setWebsite(Methods.checkForStringNull(req.getWebsite(), preference.getWebsite()));
            preference.setEmail(Methods.checkForStringNull(req.getEmail(), preference.getEmail()));
            preference.setPhone(Methods.checkForStringNull(req.getPhone(), preference.getPhone()));
            preference.setPrivacy(Methods.checkForStringNull(req.getPrivacy(), preference.getPrivacy()));
            preference.setTerms(Methods.checkForStringNull(req.getTerms(), preference.getTerms()));
            preference.setAndroidMinVersion(Methods.checkForIntNull(req.getAndroidMinVersion(), preference.getAndroidMinVersion()));
            preference.setIosMinVersion(Methods.checkForIntNull(req.getIosMinVersion(), preference.getIosMinVersion()));

        } else {

            preference = new Preference();
            preference.setKey(Common.PREF_KEY);
            preference.setName("VI Arbitrage Signaling");
            preference.setAddress("Lagos Island, Lagos");
            preference.setWebsite("https://viarbitrage.com");
            preference.setEmail("hello@viarbitrage.com");
            preference.setPhone("08033556677");
            preference.setPrivacy("https://viarbitrage.com/privacy");
            preference.setTerms("https://viarbitrage.com/terms");
            preference.setAndroidMinVersion(1);
            preference.setIosMinVersion(1);

        }

        //updated date
        preference.setDateUpdated(Methods.dateTimeFormat.format(System.currentTimeMillis()));

        //save
        preference = prefRepository.save(preference);
        return preference;
    }

    @Override
    public Preference getSystemPreference() {
        //get preference
        Preference preference = prefRepository.getPreference(Common.PREF_KEY);
        if (preference == null){

            preference = new Preference();
            preference.setKey(Common.PREF_KEY);
            preference.setName("VI Arbitrage Signaling");
            preference.setAddress("Lagos Island, Lagos");
            preference.setWebsite("https://viarbitrage.com");
            preference.setEmail("hello@viarbitrage.com");
            preference.setPhone("08033556677");
            preference.setPrivacy("https://viarbitrage.com/privacy");
            preference.setTerms("https://viarbitrage.com/terms");
            preference.setAndroidMinVersion(1);
            preference.setIosMinVersion(1);
            preference.setDateUpdated(Methods.dateTimeFormat.format(System.currentTimeMillis()));

        }

        //save
        preference = prefRepository.save(preference);
        return preference;
    }

}
