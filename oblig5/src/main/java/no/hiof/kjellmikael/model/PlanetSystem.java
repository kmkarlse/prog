package no.hiof.kjellmikael.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;


public class PlanetSystem implements Comparable<PlanetSystem> {
    private String name, pictureUrl;
    private Star centerStar;
    private ArrayList<Planet> planets = new ArrayList<>();

    public PlanetSystem() {

    }

    public PlanetSystem(String name, Star centerStar) {
        this.name = name;
        this.centerStar = centerStar;
    }

    public PlanetSystem(String name, Star centerStar, String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.pictureUrl = pictureUrl;
    }

    public Planet getPlanet(String name) {
        for (Planet aPlanet : planets ) {
            if (aPlanet.getName().equalsIgnoreCase(name)) {
                return aPlanet;
            }
        }

        return null;
    }

    @JsonIgnore
    public Planet getSmallestPlanet() {
        if (planets.size() == 0)
            return null;

        Planet smallestPlanet = planets.get(0);

        for (Planet currentPlanet : planets) {
            if (currentPlanet.getRadius() < smallestPlanet.getRadius()) {
                smallestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == smallestPlanet.getRadius() &&
                    currentPlanet.getMass() < smallestPlanet.getMass()) {
                smallestPlanet = currentPlanet;
            }
        }

        return smallestPlanet;
    }

    @JsonIgnore
    public Planet getLargestPlanet() {
        if (planets.size() == 0)
            return null;

        Planet largestPlanet = planets.get(0);

        for (Planet currentPlanet : planets) {
            if (currentPlanet.getRadius() > largestPlanet.getRadius()) {
                largestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == largestPlanet.getRadius() &&
                    currentPlanet.getMass() > largestPlanet.getMass()) {
                largestPlanet = currentPlanet;
            }
        }

        return largestPlanet;
    }

    public void addPlanet(Planet aPlanet) {
        planets.add(aPlanet);
    }

    public ArrayList<Planet> getPlanets() {
        return new ArrayList<>(planets);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }


    @Override
    public String toString() {
        return name + " has " + planets.size() +
                " planets that revolve around the star " +
                centerStar.getName();
    }

    @Override
    public int compareTo(PlanetSystem otherPlanetSystem) {
        return this.getName().compareTo(otherPlanetSystem.getName());
    }

}
