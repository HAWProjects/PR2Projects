package haw.pr2.jgame;

import java.awt.event.KeyEvent;

/**
 * @author abt434
 *
 */

public abstract class Car {
	private double _speed; // Geschwindigkeit [ms^-1]
	private double _posX; // XPosition des Autos [m]
	private double _posY; // YPosition des Autos [m]
	private double _proplevel; // Gaspedalstellung
	private double _brakelevel;
	private double _time; // Zeit [s]
	private double _steeringLevel; // Lenkeinschlag zwischen -1 und 1
	private double _currentDirection; // >=0 &&  < 360 Grad
	private Player player;

	




	private CarState _state;
	private Traktion _traktion;

	public Car() {
		this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
	}

	public Car(double time, double posX, double posY, double speed, double proplevel, double brakelevel, double steeringLevel) {
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


	}

	/*************************************************** only getter & setter ***********************************************************/
	public double getSpeed() {
		return _speed;
	}

	public void setSpeed(double speed) {
		_speed = speed;
	}

	public double getPosX() {
		return _posX;
	}

	public void setPosX(double posX) {
		_posX = posX;
	}

	public double getPosY() {
		return _posY;
	}

	public void setPosY(double posY) {
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

	public double getTime() {
		return _time;
	}

	public void setTime(double time) {
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
		return player.isASROn();
	}
	
	public boolean isABSActive(){
		return player.isAbsOn();
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
	public void update(double aDeltaTime) {
		getState().switchState(this);
		getState().step(aDeltaTime, this);	
		
		System.out.println("''''''''''''''''''''''''''''''''''''''' " + this.getState());
	}

	/****************************************************** abstract Methods *******************************************************/
	/**
	 * Liefert die Masse des Autos
	 * 
	 * @return
	 */
	abstract double getMass();

	/**
	 * Liefert die Leistung des Autos
	 * 
	 * @return
	 */
	abstract double getPowerPropMax();

	/**
	 * liefert die Hoechstgeschwindigkeit des Autos
	 * 
	 * @return
	 */
	abstract double getSpeedMax();

	/**
	 * @return
	 */
	abstract double getdragConst();

	/**
	 * @return
	 */
	abstract double getCurveRadius();

}
