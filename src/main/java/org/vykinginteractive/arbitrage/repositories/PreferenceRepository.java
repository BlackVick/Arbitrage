package org.vykinginteractive.arbitrage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vykinginteractive.arbitrage.entities.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    @Query("SELECT p FROM Preference p WHERE p.key = :key")
    Preference getPreference(String key);

}
