package haw.pr2.jgame.units;

public enum Multiplier {
    NONE(1.0),
    KILO(1000),
    MILLI(0.0001);
    
        
    private double multiplier;
    
    private Multiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}
