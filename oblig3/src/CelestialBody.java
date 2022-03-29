public abstract class CelestialBody implements Comparable<CelestialBody>{
    public String name;
    public double radius;
    public double masse;

    public CelestialBody(String name, double radius, double masse){
        this.name = name;
        this.radius = radius;
        this.masse = masse;
    }

    public abstract double getMasseInKg();
    public abstract double getRadiusInKm();

    public double gravity() {
        return (0.000000000667408 * this.getMasseInKg() / (this.getRadiusInKm() * this.getRadiusInKm())) * 000001;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }
}
