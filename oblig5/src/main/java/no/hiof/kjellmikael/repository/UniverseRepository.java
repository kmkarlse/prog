package no.hiof.kjellmikael.repository;

import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;

import java.util.ArrayList;

public interface UniverseRepository {

    ArrayList<PlanetSystem> getAllPlanetSystems();
    PlanetSystem getPlanetSystem(String navn);

    ArrayList<Planet> getPlanets(String planetSystemNavn);
    Planet getPlanet(String planetSystemId ,String planetId);

    Planet createPlanet(String planetSystemId);
    Planet updatePlanetInfo(String planetSystemId,String planetId);
    PlanetSystem deletePlanet(String planetSystemId, String planetId);
}
