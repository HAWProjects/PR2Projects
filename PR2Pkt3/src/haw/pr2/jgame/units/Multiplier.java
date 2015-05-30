package haw.pr2.jgame.units;

public enum Multiplier {
    NONE(1.0),
    KILO(1000),
    MILLI(0.001),
    HOURINMIN(60.0),
    MININSEC(60.0),
    HOURINSEC(3600),
    KMPROSTUNDEINMETERPROSEKUNDE(0.27777778);
    
    
        
    private double multiplier;
    
    private Multiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}
