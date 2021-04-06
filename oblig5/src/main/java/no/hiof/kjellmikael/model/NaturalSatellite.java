package no.hiof.kjellmikael.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis, eccentricity, orbitalPeriod;
    private CelestialBody centralCelestialBody;

    public static final double ASTRONOMICAL_UNITS_IN_KM = 149597871;
    public static final double KM_TO_M = 1000;

    public NaturalSatellite() {

    }

    public NaturalSatellite(String name, double radius, double mass, double semiMajorAxis, double eccentricity,
                            double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, radius, mass);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }

    public NaturalSatellite(String name, double radius, double mass, double semiMajorAxis, double eccentricity,
                            double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        super(name, radius, mass, pictureUrl);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }

    public double orbitingVelocity(double distance) {
        return orbitingVelocityInMeterPerSecond(distance) / KM_TO_M;
    }

    @JsonIgnore
    public double orbitingVelocityInMeterPerSecond(double distance) {
        // v = sqr(GM / r)
        return Math.sqrt((CelestialBody.GRAVITATIONAL_CONSTANT * centralCelestialBody.getMassInKg())  / (distance*KM_TO_M));
    }

    @JsonIgnore
    public double distanceToCentralBody(double degrees) {
        return distanceToCentralBodyWithRadians(Math.toRadians(degrees));
    }

    @JsonIgnore
    public double distanceToCentralBodyWithRadians(double radians) {
        // r = a(1 - e^2) / 1 + e cos θ
        double distanceInAU = ((semiMajorAxis * (1 - Math.pow(eccentricity, 2))) / (1 + eccentricity * Math.cos(radians)));
        return distanceInAU * ASTRONOMICAL_UNITS_IN_KM;
    }

    @JsonIgnore
    public double getMaxDistanceInOneOrbitalPeriod() {
        double maxDistance = 0;

        for (int i = 0; i <= getOrbitalPeriod(); i++) {
            double distance = distanceToCentralBodyAtDay(i);

            maxDistance = Math.max(distance, maxDistance);
        }

        return maxDistance;
    }

    @JsonIgnore
    public double getMinDistanceInOneOrbitalPeriod() {
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i <= getOrbitalPeriod(); i++) {
            double distance = distanceToCentralBodyAtDay(i);

            minDistance = Math.min(distance, minDistance);
        }

        return minDistance;
    }

    @JsonIgnore
    public double distanceToOtherSatelliteAfterDays(NaturalSatellite otherSatellite, int day) {
        double b = this.distanceToCentralBodyAtDay(day);
        double c = otherSatellite.distanceToCentralBodyAtDay(day);

        double bDegrees = this.degreesAtDayNumber(day);
        double cDegrees = otherSatellite.degreesAtDayNumber(day);

        double A = bDegrees - cDegrees;

        //a = sqrt(b^2 + c^2 - 2bc * cos(A))
        return Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2) - 2 * b * c * Math.cos(Math.toRadians(A)));
    }

    @JsonIgnore
    private double distanceToCentralBodyAtDay(int day) {
        return distanceToCentralBody(degreesAtDayNumber(day));
    }

    @JsonIgnore
    private double degreesAtDayNumber(int day) {
        return (day / getOrbitalPeriod()) * 360;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }


}
