package no.hiof.kjellmikael.repository;

import java.util.ArrayList;
import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;
import no.hiof.kjellmikael.model.Star;

public class UniverseDataRepository implements UniverseRepository {
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

    public UniverseDataRepository() {
        Star sun = new Star("Sun", 695700, 1.98892E30, 5777, "http://bit.ly/333CTus");

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, "http://bit.ly/3cVhuZc");

        solarSystem.addPlanet(new Planet("Mercury", 3.283E23,2439.7, 0.387, 0.206, 88, sun,"http://bit.ly/2TB2Heo"));
        solarSystem.addPlanet(new Planet("Venus",4.867E24,6051.8, 0.723, 0.007, 225, sun,"http://bit.ly/2W3p4L9"));
        solarSystem.addPlanet(new Planet("Earth",5.972E24,6371, 1, 0.017, 365, sun,"http://bit.ly/33bvXLZ"));
        solarSystem.addPlanet(new Planet("Mars",6.39E23,3389.5, 1.524, 0.093, 687, sun,"http://bit.ly/3aGyFvr"));
        solarSystem.addPlanet(new Planet("Jupiter",1.898E27,69911, 5.20440, 0.049, 4380, sun,"http://bit.ly/2Q0fjK3"));
        solarSystem.addPlanet(new Planet("Saturn",5.683E26,58232, 9.5826, 0.057, 10585, sun,"http://bit.ly/2W0sqic"));
        solarSystem.addPlanet(new Planet("Uranus",8.681E25,25362, 19.2184, 0.046, 30660, sun,"http://bit.ly/335pbHy"));
        solarSystem.addPlanet(new Planet("Neptune",1.024E26,24622, 30.11, 0.010, 60225, sun,"http://bit.ly/38AyEba"));

        planetSystems.add(solarSystem);
        generateKeplerSystem();
    }

    private void generateKeplerSystem() {
        Star kepler11 = new Star("Kepler-11", 1.889E30, 710310, 5680, "http://bit.ly/336nzNZ");

        PlanetSystem kepler11System = new PlanetSystem("Kepler 11 System", kepler11, "http://bit.ly/2Iz4jPB");

        kepler11System.addPlanet(new Planet("Mercury", 3.283E23,2439.7, 0.387, 0.206, 88, kepler11));
        kepler11System.addPlanet(new Planet("Venus",4.867E24,6051.8, 0.723, 0.007, 225, kepler11));
        kepler11System.addPlanet(new Planet("Earth",5.972E24,6371, 1, 0.017, 365, kepler11));
        kepler11System.addPlanet(new Planet("Mars",6.39E23,3389.5, 1.524, 0.093, 687, kepler11));
        kepler11System.addPlanet(new Planet("Jupiter",1.898E27,69911, 5.20440, 0.049, 4380, kepler11));
        kepler11System.addPlanet(new Planet("Saturn",5.683E26,58232, 9.5826, 0.057, 10585, kepler11));
        kepler11System.addPlanet(new Planet("Uranus",8.681E25,25362, 19.2184, 0.046, 30660, kepler11));
        kepler11System.addPlanet(new Planet("Neptune",1.024E26,24622, 30.11, 0.010, 60225, kepler11));

        planetSystems.add(kepler11System);
    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        return new ArrayList<>(planetSystems);
    }

    @Override
    public PlanetSystem getPlanetSystem(String navn) {
        for (PlanetSystem planetSystem : planetSystems) {
            if (planetSystem.getName().equalsIgnoreCase(navn))
                return planetSystem;
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemNavn) {
        PlanetSystem aktueltPlanetSystem = getPlanetSystem(planetSystemNavn);

                if (aktueltPlanetSystem != null)
                    return aktueltPlanetSystem.getPlanets();

                return new ArrayList<>();
    }

    @Override
    public Planet getPlanet(String planetSystemId ,String planetId) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemId);

        if (planetSystem != null)
        return planetSystem.getPlanet(planetId);

        return null;
    }

    @Override
    public Planet createPlanet(String planetSystemId) {
        return null;
    }

    @Override
    public Planet updatePlanetInfo(String planetSystemId, String planetId) {
        return null;
    }

    @Override
    public PlanetSystem deletePlanet(String planetSystemId, String planetId) {


        return null;
    }

}
