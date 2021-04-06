/*package no.hiof.kjellmikael.mainold;

import no.hiof.kjellmikael.model.Star;
import no.hiof.kjellmikael.model.Planet;
import no.hiof.kjellmikael.model.PlanetSystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Star sun = new Star("Sun",1.0, 1.0, 5777);

        Planet mercury = new Planet("Mercury",0.03412549655905556,1.7297154899894627E-4, 0.387, 0.206, 88, sun);
        Planet venus = new Planet("Venus",0.08465003077267387,0.002564278187565859, 0.723, 0.007, 225, sun);
        Planet earth = new Planet("Earth",0.08911486599899289,0.003146469968387777, 1, 0.017, 365, sun);
        Planet mars = new Planet("Mars",0.04741089912158004,3.3667017913593256E-4, 1.524, 0.093, 687, sun);
        Planet jupiter = new Planet("Jupiter",1.0,1.0, 5.20440, 0.049, 4380, sun);
        Planet saturn = new Planet("Saturn",0.8145247020645666,0.2994204425711275, 9.5826, 0.057, 10585, sun);
        Planet uranus = new Planet("Uranus",0.35475297935433336,0.04573761854583773, 19.2184, 0.046, 30660, sun);
        Planet neptune = new Planet("Neptune",0.34440217087226543,0.05395152792413066, 30.11, 0.010, 60225, sun);

        Planet[] planets = {
                mercury, venus, earth, mars, jupiter, saturn, uranus, neptune
        };

        List<Planet> planets = new ArrayList<>();

        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);
        planets.add(saturn);
        planet1.add(uranus);
        planet1.add(neptune);

        Collections.sort(planet1);

        System.out.println(planet1);

        Collections.reverse(planet1);

        System.out.println(planet1);

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, planets);

        System.out.println("oppg 2.3 \n" + solarSystem);
        System.out.println("oppg 2.4 \nSaturns radius i Km : " + saturn.getRadiusInKm() +" Km, vekt i Kg : " + saturn.getMassInKg() + " Kg");
        System.out.println("oppg 2.4 \nSolens radius i Km : " + sun.getRadiusInKm() + " Km, Vekt i Kg : " + sun.getMassInKg() + " Kg");
        System.out.println("oppg 2.5 \nGravity neptune " + neptune.gravity() + " m/s^2 \n");
        System.out.println(solarSystem.getSmallestPlanet() + "er den minste planeten \n");
        System.out.println(solarSystem.getBiggestPlanet() + "er den støreste planeten");
        System.out.println("min favoritt planet er: " + solarSystem.getPlanet("jupiter"));

        int[] allDegrees = {
          0,90,180,270,360
        };

        DecimalFormat formatter = new DecimalFormat("0");

        for (int i = 0; i < allDegrees.length; i++) {
            System.out.println("Earth has a distance of " +
                    formatter.format(earth.distanceToCentralBodyD(allDegrees[i])) +
                    " Km to the Sun at " + allDegrees[i] + " degrees") ;
        }

        System.out.println();

        double[] allradians = {
                Math.toRadians(0), Math.toRadians(90), Math.toRadians(180), Math.toRadians(270), Math.toRadians(360)
        };

        for (int i = 0; i < allradians.length; i++) {
            System.out.println("Earth has a distance of " +
                    formatter.format(earth.distanceToCentralBodyR(allradians[i])) +
                    " Km to the Sun at " + allradians[i] + " radians");
        }

        System.out.println();

        int[] earthDegrees = {
                0, 45, 90, 135, 180
        };

        DecimalFormat formatterD = new DecimalFormat("0.00");

        for (int i = 0; i < earthDegrees.length; i++) {
            double distance = earth.distanceToCentralBodyD(earthDegrees[i]);

            System.out.println("At a distance of " + formatter.format(distance) + "km, Earth has a velocity of: " + formatterD.format(earth.orbitingVelocity(distance)) + " Km/s");
        }


        Collections.sort(planet1);

        System.out.println(planet1);

        Collections.reverse(planet1);

        System.out.println(planet1);

    }

}
*/