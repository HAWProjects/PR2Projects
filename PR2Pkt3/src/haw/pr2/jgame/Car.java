package haw.pr2.jgame;

import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.*;

/**
 * @author abt434
 *
 */

public abstract class Car {
	private Speed _speed; // Geschwindigkeit [ms^-1]
	private Length _posX; // XPosition des Autos [m]
	private Length _posY; // YPosition des Autos [m]
	private double _proplevel; // Gaspedalstellung
	private double _brakelevel;
	private TimeDiff _time; // Zeit [s]
	private double _steeringLevel; // Lenkeinschlag zwischen -1 und 1
	private double _currentDirection; // >=0 &&  < 360 Grad
	
	private boolean _asr;
	
	private boolean _abs;

	private CarState _state;
	private Traktion _traktion;

	public Car() {
		this(Factory.timeInSec(0.0), Factory.length(0.0), Factory.length(0.0), Factory.speedInMeterProSeKunde(0.0), 0.0, 0.0, 0.0);
	}

	public Car(TimeDiff time, Length posX, Length posY, Speed speed, double proplevel, double brakelevel, double steeringLevel) {
		_time = time;
		_posX = posX;
		_posY = posY;
		_speed = speed;
		_state = CarState.STOPPED;
		_traktion = Traktion.NORMAL;
		_steeringLevel = steeringLevel;
		_proplevel = proplevel;
		_brakelevel = brakelevel;
		_currentDirection = 0.0;
		_abs = false;
		_asr = false;
	}

	/*************************************************** only getter & setter ***********************************************************/
	public Speed getSpeed() {
		return _speed;
	}

	public void setSpeed(Speed speed) {
		_speed = speed;
	}

	public Length getPosX() {
		return _posX;
	}

	public void setPosX(Length posX) {
		_posX = posX;
	}

	public Length getPosY() {
		return _posY;
	}

	public void setPosY(Length posY) {
		_posY = posY;
	}

	public double getProplevel() {
		return _proplevel;
	}

	public void setProplevel(double proplevel) {
		_proplevel = proplevel;
	}

	public double getBrakelevel() {
		return _brakelevel;
	}

	public void setBrakelevel(double brakelevel) {
		_brakelevel = brakelevel;
	}

	public TimeDiff getTime() {
		return _time;
	}

	public void setTime(TimeDiff time) {
		_time = time;
	}

	public double getSteeringLevel() {
		return _steeringLevel;
	}

	public void setSteeringLevel(double steeringLevel) {
		_steeringLevel = steeringLevel;
	}

	public CarState getState() {
		return _state;
	}

	public void setState(CarState state) {
		_state = state;
	}

	public double getCurrentDirection() {
		return _currentDirection;
	}

	public void setCurrentDirection(double currentDirection) {
		this._currentDirection = currentDirection;
	}

	public Traktion getTraktion() {
		return _traktion;
	}

	public void setTraktion(Traktion traktion) {
		_traktion = traktion;
	}

	public boolean isASRActive() {
		return false;
	}
	
	public boolean isABSActive(){
		return false;
	}

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getter &
	 * setter ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/

	/**
	 * calls the step method
	 * 
	 * @param aDeltaTime
	 *            : the time which is elapsed
	 */
	public void update(TimeDiff aDeltaTime) {
		getState().switchState(this);
		getState().step(aDeltaTime, this);
	}

	/****************************************************** abstract Methods *******************************************************/
	/**
	 * Liefert die Masse des Autos
	 * 
	 * @return
	 */
	abstract Mass getMass();

	/**
	 * Liefert die Leistung des Autos
	 * 
	 * @return
	 */
	abstract Power getPowerPropMax();

	/**
	 * liefert die Hoechstgeschwindigkeit des Autos
	 * 
	 * @return
	 */
	abstract Speed getSpeedMax();

	/**
	 * @return
	 */
	abstract Force getdragConst();

	/**
	 * @return
	 */
	abstract Length getCurveRadius();

}
