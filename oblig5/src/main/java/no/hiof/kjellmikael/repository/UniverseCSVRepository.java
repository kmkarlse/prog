package no.hiof.kjellmikael.repository;

import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;
import no.hiof.kjellmikael.model.Star;
import java.io.*;
import java.util.ArrayList;

public class UniverseCSVRepository implements UniverseRepository {
    public String CsvFile;


    public ArrayList<PlanetSystem> CSVRepository;

    public UniverseCSVRepository(String csvFile) {
        this.CsvFile = csvFile;
        CSVRepository = LesCsvFile(csvFile);


    }

    public static ArrayList<PlanetSystem> LesCsvFile(String filNavn) {
        ArrayList<PlanetSystem> planetSystemsListe = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filNavn))){
            String linje;

            PlanetSystem planetSystem = null;
            Star star;
            String systemNavn = "";

            while ((linje = bufferedReader.readLine()) != null){
                String[] planetSystems = linje.split(";");

                if (!planetSystems[0].equals(systemNavn) ) {
                    star = new Star(planetSystems[2],
                            Double.parseDouble(planetSystems[3]),
                            Double.parseDouble(planetSystems[4]),
                            Double.parseDouble(planetSystems[5]),
                            planetSystems[6]
                    );

                    planetSystem = new PlanetSystem(
                            planetSystems[0],
                            star,
                            planetSystems[1]
                    );

                    Planet planet = new Planet(
                            planetSystems[7],
                            Double.parseDouble(planetSystems[8]),
                            Double.parseDouble(planetSystems[9]),
                            Double.parseDouble(planetSystems[10]),
                            Double.parseDouble(planetSystems[11]),
                            Double.parseDouble(planetSystems[12]),
                            star,
                            planetSystems[13]
                    );

                    planetSystem.addPlanet(planet);
                    planetSystemsListe.add(planetSystem);

                } else {
                    if (planetSystem != null) {
                        star = planetSystem.getCenterStar();

                        Planet planet = new Planet(
                                planetSystems[7],
                                Double.parseDouble(planetSystems[8]),
                                Double.parseDouble(planetSystems[9]),
                                Double.parseDouble(planetSystems[10]),
                                Double.parseDouble(planetSystems[11]),
                                Double.parseDouble(planetSystems[12]),
                                star,
                                planetSystems[13]
                        );

                        planetSystem.addPlanet(planet);
                    }
                }

                systemNavn = planetSystems[0];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return planetSystemsListe;
    }

    public void skrivTilCsv(File kilde)  {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(kilde))) {

            for (PlanetSystem etPlanetSystem : CSVRepository ) {
                ArrayList<Planet> planets = etPlanetSystem.getPlanets();
                Star star = etPlanetSystem.getCenterStar();

                for (Planet planet : planets) {
                    bufferedWriter.write(
                            etPlanetSystem.getName() + ";" +
                                    star.getPictureUrl() + ";" +
                                    star.getName() + ";" +
                                    star.getRadius() + ";" +
                                    star.getMass() + ";" +
                                    star.getEffectiveTemp() + ";" +
                                    star.getPictureUrl() + ";" +
                                    planet.getName() + ";" +
                                    planet.getRadius() + ";" +
                                    planet.getMass() + ";" +
                                    planet.getSemiMajorAxis() + ";" +
                                    planet.getEccentricity() + ";" +
                                    planet.getOrbitalPeriod() + ";" +
                                    planet.getPictureUrl()
                    );
                    bufferedWriter.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        return new ArrayList<>(CSVRepository);
    }

    @Override
    public PlanetSystem getPlanetSystem(String navn) {
        for (PlanetSystem planetSystem : CSVRepository) {
            if (planetSystem.getName().equalsIgnoreCase(navn))
                return planetSystem;
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemNavn) {
        PlanetSystem aktueltPlanetSystem = getPlanetSystem(planetSystemNavn);

        if(aktueltPlanetSystem != null)
            return aktueltPlanetSystem.getPlanets();

        return new ArrayList<>();
    }

    @Override
    public Planet getPlanet(String planetSystemId, String planetId) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemId);

        if (planetSystem != null)
            return planetSystem.getPlanet(planetId);
        return null;
    }

    @Override
    public Planet createPlanet(String planetSystemId) {
        PlanetSystem planetSystem = getPlanetSystem(planetSystemId);
        Planet planet = createPlanet(planetSystemId);
        planetSystem.addPlanet(planet);
        return planet;
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
