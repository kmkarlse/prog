package no.hiof.kjellmikael.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;



public class UniverseJSONRepository implements UniverseRepository {
    private String JsonFile;
    private HashMap<String, PlanetSystem> JsonRepository;

    public UniverseJSONRepository(String JsonFile) throws URISyntaxException, MalformedURLException {
        this.JsonFile = JsonFile;
        JsonRepository = lesJsonFil(JsonFile);
    }

    public HashMap<String, PlanetSystem> lesJsonFil(String filnavn) throws URISyntaxException, MalformedURLException {
        HashMap<String, PlanetSystem> planetListe = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filnavn);

        try {
            PlanetSystem[] planetSystems = objectMapper.readValue(file, PlanetSystem[].class);

            for (PlanetSystem planetSystem : planetSystems) {
                planetListe.put(planetSystem.getName(), planetSystem);
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return planetListe;
    }

    public void writeToJson(String path) {
        ObjectMapper objectJsonMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectJsonMapper.writerWithDefaultPrettyPrinter();

        try {
            objectWriter.writeValue(new File(path), JsonRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        ArrayList<PlanetSystem> planetSystemer = new ArrayList<>();
        JsonRepository.forEach((s, planetSystem) -> planetSystemer.add(planetSystem));
        return planetSystemer;
    }

    @Override
    public PlanetSystem getPlanetSystem(String navn) {
        return JsonRepository.get(navn);
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemNavn) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemNavn);
        return planetSystem.getPlanets();
    }


    @Override
    public Planet getPlanet(String planetSystemId, String planetId) {
        return JsonRepository.get(planetSystemId).getPlanet(planetId);
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
        PlanetSystem planetSystem = getPlanetSystem(planetSystemId);
        ArrayList<Planet> planets = planetSystem.getPlanets();
        Planet planet = planetSystem.getPlanet(planetId);

        if (planets.remove(planet)) {
            System.out.println("dette fungerte");
        } else {
            System.out.println("dette fungerte ikke");
        }

        planets = planetSystem.getPlanets();
        System.out.println(planets);

        return planetSystem;
    }
}
