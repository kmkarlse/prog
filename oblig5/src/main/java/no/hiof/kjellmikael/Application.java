package no.hiof.kjellmikael;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.kjellmikael.controller.PlanetController;
import no.hiof.kjellmikael.controller.PlanetSystemController;
import no.hiof.kjellmikael.repository.UniverseCSVRepository;
import no.hiof.kjellmikael.repository.UniverseJSONRepository;
import no.hiof.kjellmikael.repository.UniverseRepository;
import no.hiof.kjellmikael.repository.UniverseDataRepository;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Application {



    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result("Hello World!");
            }
        });

        app.before("/", ctx -> ctx.redirect("/planet-system"));

        app.get("/planet-system", new VueComponent("planet-system-overview"));
        app.get("/planet-system/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-system/:planet-system-id/planets/create", new VueComponent("planet-create"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id/update",new VueComponent("planet-detail"));

        String planet100Path = "C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/jSON/planets_100.json";
        String planet4000Path ="C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/jSON/planets_4000.json";
        String planetXPath = "C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/jSON/planets_X.json";
        String planet100CsvPath = "C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/CSV/planets_100.csv";
        String planet4000CsvPath = "C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/CSV/planets_4000.csv";
        String planetXCsvPath = "C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/CSV/planets_x.csv";


        UniverseRepository universeCSVRepository = new UniverseCSVRepository(planet100CsvPath);
        UniverseRepository universeJSONRepository = new UniverseJSONRepository(planet100Path);
        UniverseRepository universeRepository = new UniverseDataRepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(universeCSVRepository);
        PlanetController planetController = new PlanetController(universeCSVRepository);

        app.get("api/planet-system", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetSystemController.getAllPlanetSystemes(ctx);
            }
        });

        app.get("/api/planet-system/:planet-system-id", planetSystemController::getPlanetSystem);
        app.get("/api/planet-system/:planet-system-id/planets", planetController::getAllPlanets);
        app.get("/api/planet-system/:planet-system-id/planets/:planet-id", planetController::getPlanet);

        app.get("/api/planet-system/:planet-system-id/planets/:planet-id/delete", planetController::deletePlanet);

        /*app.post("/api/planet-system/:planet-system-id/planets/create", planetController::createPlanet);
        app.post("/api/planet-system/:planet-system-id/planets/:planet-id/update",planetController::updatePlanetInfo);*/


        UniverseJSONRepository w = new UniverseJSONRepository(planet100Path);
        w.writeToJson(planetXPath);

        UniverseCSVRepository r = new UniverseCSVRepository(planet100CsvPath);
        File file = new File("C:/Users/SSC_S/IdeaProjects/oblig4/src/main/java/no/hiof/kjellmikael/CSV/planets_x.csv");
        r.skrivTilCsv(file);

    }
}