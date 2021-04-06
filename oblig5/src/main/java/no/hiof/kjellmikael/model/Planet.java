package no.hiof.kjellmikael.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Planet extends NaturalSatellite{
    public static final double JUPITER_RADIUS_IN_KM = 71492;
    public static final double JUPITER_MASS_IN_KG = 1.898E27;
    public static final double EARTH_RADIUS_IN_KM = 6371;
    public static final double EARTH_MASS_IN_KG = 5.972E24;

    public Planet() {

    }

    public Planet(String name, double radius, double mass, double samiMajorAxis, double eccentricity,
                  double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, radius, mass, samiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }

    public Planet(String name, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        super(name, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
    }

    @JsonIgnore
    public double getSurfaceGravity() {
        return (CelestialBody.GRAVITATIONAL_CONSTANT * getMassInKg()) / Math.pow(getRadiusInMeter(), 2);
    }

    @JsonIgnore
    @Override
    public double getRadiusInKm() {
        return getRadius() * JUPITER_RADIUS_IN_KM;
    }

    @JsonIgnore
    private double getRadiusInMeter() {
        return getRadiusInKm() * 1000;
    }

    @JsonIgnore
    @Override
    public double getMassInKg() {
        return getMass() * JUPITER_MASS_IN_KG;
    }

    @JsonIgnore
    public double getMassInMearth() {
        return getMassInKg() / EARTH_MASS_IN_KG;
    }

    @JsonIgnore
    public double getRadiusInRearth() {
        return getRadiusInKm() / EARTH_RADIUS_IN_KM;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return String.format("%s has a radius of %s Rjup and a mass of %s Mjup", getName(), getRadius(), getMass());
    }
}
