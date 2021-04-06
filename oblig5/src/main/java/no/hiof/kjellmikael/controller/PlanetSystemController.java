package no.hiof.kjellmikael.controller;

import io.javalin.http.Context;
import no.hiof.kjellmikael.model.PlanetSystem;
import no.hiof.kjellmikael.repository.UniverseRepository;

import java.util.ArrayList;

public class PlanetSystemController {
    private UniverseRepository universeRepository;

    public PlanetSystemController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getAllPlanetSystemes(Context context) {
        ArrayList<PlanetSystem> PlanetSystems = universeRepository.getAllPlanetSystems();

        context.json(PlanetSystems);
    }

    public void getPlanetSystem(Context context) {
        String planetSystemId = context.pathParam(":planet-system-id");

        PlanetSystem planetSystemet = universeRepository.getPlanetSystem(planetSystemId);

        context.json(planetSystemet);
    }

}
