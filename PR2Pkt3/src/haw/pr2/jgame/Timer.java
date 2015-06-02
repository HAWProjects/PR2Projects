package haw.pr2.jgame;

import haw.pr2.jgame.interfaces.TimeDiff;


/**
 *
 * @author abt434
 */
public class Timer {
    private long timeLast;
    private TimeDiff timeElapsed;

    private Timer() {
        
        timeLast = System.currentTimeMillis();
        timeElapsed = Factory.timeInSec(Konstants.ZERO);
    }
    
    public static Timer valueOf(){
    return new Timer();
    }

    private long getTimeLast() {
        return timeLast;
    }

    private void setTimeLast(long timeLast) {
        this.timeLast = timeLast;
    }

    public TimeDiff getTimeElapsed() {
        return timeElapsed;
    }

    private void setTimeElapsed(TimeDiff timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
    
    public TimeDiff update(){
        long timeCurrent = System.currentTimeMillis();
        TimeDiff diff = Factory.timeInSec((timeCurrent - getTimeLast()) / 1000.0);
        
        setTimeElapsed(diff);
        setTimeLast(timeCurrent);
        return diff;
    }
}
