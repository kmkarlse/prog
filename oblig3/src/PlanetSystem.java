public class PlanetSystem implements Comparable<PlanetSystem>{
    private String name;
    private Star centerStar;
    private Planet[] planets;

    public PlanetSystem(String name, Star centerStar, Planet[] planets){
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
    }

    public Planet getPlanet(String navn) {
        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(navn)) {
                return planet;
            }
        }
        System.out.println("Om ingen planet kom frem er det en feil eller planeten finnes ikke!");
        return null;
    }

    public Planet getSmallestPlanet() {
        Planet smallestPlanet = planets[0];
        for (Planet planet : planets) {
            double smallestRadius = smallestPlanet.getRadiusInKm();
            double nextRadius = planet.getRadiusInKm();
            double smallestMasse = smallestPlanet.getMasseInKg();
            double nextMasse = planet.getMasseInKg();

            if (smallestRadius > nextRadius) {
                smallestPlanet = planet;
            } else if (smallestRadius == nextRadius) {
                if (smallestMasse > nextMasse) {
                    smallestPlanet = planet;
                }
            }
        }
        return smallestPlanet;
    }

    public Planet getBiggestPlanet() {
        Planet biggestPlanet = planets[0];
        for (Planet planet : planets) {
            double biggestRadius = biggestPlanet.getRadiusInKm();
            double nextRadius = planet.getRadiusInKm();
            double biggestMasse = biggestPlanet.getMasseInKg();
            double nextMasse = planet.getMasseInKg();

            if (biggestRadius < nextRadius) {
                biggestPlanet = planet;
            }   else if (biggestRadius == nextRadius) {
                if (biggestMasse < nextMasse) {
                    biggestPlanet = planet;
                }
            }
        }
        return biggestPlanet;
    }

    public String toString() {
        String planetSystemString = "Solsystem: \n\n" + name + "\n\nStjerne: \n\n" + centerStar + "\n\nPlaneter:\n\n";

        for (Planet valgtPlanet : planets) {
            planetSystemString += valgtPlanet;
        }
        return planetSystemString;
    }

    @Override
    public int compareTo(PlanetSystem planetSystem) {
        return this.name.compareTo(planetSystem.name);
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

    public void setCenterStar(String name) {
        this.centerStar = centerStar;
    }

    public Planet[] getPlanets() {
        return planets;
    }

    public void setPlanets(Planet[] planets) {
        this.planets = planets;
    }
}
