
import javax.management.InvalidAttributeValueException;


public class Star extends CelestialBody{
    private static final double mStar = 1.98892E30;
    private static final double rStar = 695700;
    private double effectiveTemp;

    public Star(String navn, double radius, double masse, int effectiveTemp) {
        super(navn, radius, masse);
        this.effectiveTemp = effectiveTemp;
    }

    public double getMasseInKg() {
        return mStar * this.masse;
    }

    public double getRadiusInKm() {
        return rStar * this.radius;
    }

    public String toString() {
        return "Navn: " + name + ", Radius: " + radius + ", Masse: " + masse + " Effective Temp" + effectiveTemp;
    }


    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    @Override
    public int compareTo(CelestialBody o) {
        return 0;
    }
}
