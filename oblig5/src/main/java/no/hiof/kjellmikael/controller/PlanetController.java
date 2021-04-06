package no.hiof.kjellmikael.controller;

import io.javalin.http.Context;
import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;
import no.hiof.kjellmikael.repository.UniverseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanetController {
    private UniverseRepository universeRepository;

    public PlanetController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getAllPlanets(Context context) {
        String systemName = context.pathParam(":planet-system-id");
        String sortBy = context.queryParam("sort_by");
        ArrayList<Planet> allPlanets = universeRepository.getPlanets(systemName);

        /*switch (sortBy) {
            case "name" -> Collections.sort(allPlanets);
            case "mass" -> Collections.sort(allPlanets, new Comparator<Planet>() {
                @Override
                public int compare(Planet o1, Planet o2) {
                    return 0;
                }
            });
            case "radius" -> Collections.sort(allPlanets, Comparator.comparing(Planet :: getRadius));
        }*/

        context.json(allPlanets);
    }

    public void getPlanet(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");
        String planetId = context.pathParam(":planet-id");

        Planet planet = universeRepository.getPlanet(planetSystemId,planetId);

        context.json(planet);
    }

    public void deletePlanet(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");
        String planetId = context.pathParam(":planet-id");

        universeRepository.deletePlanet(planetSystemId, planetId);

        context.redirect("/api/planet-system/:planet-system-id/planets");
    }

    public void createPlanet(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");


        universeRepository.createPlanet(planetSystemId);
    }

    public void updatePlanetInfo(Context context) {
    }
}
