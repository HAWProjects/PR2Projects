
package haw.pr2.jgame;

import haw.pr2.jgame.interfaces.TimeDiff;
import jgame.platform.JGEngine;


public class Lever {
    
    public static Lever valueOf(int keyUp, int keyDown, JGEngine engine, double max, boolean negativeValues, double timeToMax, boolean autoZero){
        return new Lever(keyUp, keyDown, engine, max, negativeValues, timeToMax, autoZero);
    }
    
    private double level = 0.0;
    private final int keyUp;
    private final int keyDown;
    private final JGEngine engine;
    private final double max;
    private final boolean allowNegativeValues;
    private final double timeToMax;
    private final boolean autoZero;

    private Lever(int keyUp, int keyDown, JGEngine engine, double max, boolean negativeValues, double timeToMax, boolean autoZero) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.engine = engine;
        this.max = max;
        this.allowNegativeValues = negativeValues;
        this.timeToMax = timeToMax;
        this.autoZero = autoZero;
    }

    private void setLevel(double level) {
        if(level > max){
            level = max;
        }
        else if(allowNegativeValues && level < -max){
            level = -max;
        }
        else if(!allowNegativeValues && level < 0.0){
            level = 0.0;
        }
        this.level = level;
    }

    public double getLevel() {
        return level;
    }

    public double update(TimeDiff elapsedTime){
        if (keyUp > 0 && engine.getKey(keyUp)){
            setLevel(getLevel() + ((Math.abs(max)/timeToMax) * elapsedTime.value()) );
        }else if(keyDown > 0 && engine.getKey(keyDown)){
            setLevel(getLevel() - ((Math.abs(max)/timeToMax) * elapsedTime.value()) );
        }else if(autoZero){
            setLevel(getLevel() + Math.signum(-getLevel()) * ((Math.abs(max)/timeToMax) * elapsedTime.value()) );
        }
        return level;
    }
    
}
