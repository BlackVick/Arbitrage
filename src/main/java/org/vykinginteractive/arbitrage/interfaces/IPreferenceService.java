package org.vykinginteractive.arbitrage.interfaces;

import org.vykinginteractive.arbitrage.entities.Preference;
import org.vykinginteractive.arbitrage.models.dtos.UpdatePreference;

public interface IPreferenceService {

    Preference updatePreference(UpdatePreference req);

    Preference getSystemPreference();

}
