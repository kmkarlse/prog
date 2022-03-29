public class Planet extends NaturalSattelite {
    private static final double mJup = 1.898E27;
    private static final double rJup = 71492;

    public Planet(String navn, double radius, double masse, double semiMajorAxis, double eccentricity, long orbitalPeriod, CelestialBody centralCelestialBody) {
            super(navn, radius, masse, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }

    public Planet(String name, double radius, double masse){
        super(name, radius, masse);
    }

    public double getMasseInKg() {
        return mJup * this.masse;
    }

    public double getRadiusInKm() {
        return rJup * this.radius;
    }

    public String toString() {
        return name + " - " + radius + " - " + masse + "\n";
    }

    @Override
    public int compareTo(CelestialBody celestialBody) {
        //return this.navn.compareTo(celestialBody.navn);
        //om jeg hadde brukt Double istenden for double på masse veriden kunne jeg kjørt likt som return this.navn.compareTo(celestialBody.navn); for å sotere etter masse.
        if (this.masse < celestialBody.masse)
            return -1;
        else if (this.masse > celestialBody.masse)
            return 1;

        return 0;
    }
}
