import static java.lang.Math.sqrt;

abstract class NaturalSattelite extends CelestialBody {
    private double semiMajorAxis;
    private double eccentricity;
    private long orbitalPeriod;
    private CelestialBody centralCelestialBody;
    private static final double AU = 149597871;

    public NaturalSattelite(String navn, double radius, double masse, double semiMajorAxis, double eccentricity, long orbitalPeriod, CelestialBody centralCelestialBody) {
        super(navn, radius, masse);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }

    public NaturalSattelite(String navn, double radius, double masse) {
        super(navn, radius, masse);
    }

    public double orbitingVelocity(double distanceInKm) {
        return sqrt(0.0000000000667408 * getCentralCelestialBody().getMasseInKg() / (distanceInKm / 1000))*0.000001;
    }

    private double distanceToCentralBodyCalc() {
        return semiMajorAxis * (1 - Math.pow(eccentricity,2));
    }

    public double distanceToCentralBodyD(double degrees) {
        return distanceToCentralBodyCalc() / (1 + eccentricity * Math.cos(Math.toRadians(degrees))) * AU;
    }

    public double distanceToCentralBodyR(double radians) {
        return distanceToCentralBodyCalc() / (1 + eccentricity * Math.cos(radians)) * AU;
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

    public long getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(long orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }
}
