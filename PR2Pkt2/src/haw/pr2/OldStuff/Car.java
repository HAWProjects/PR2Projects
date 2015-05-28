package haw.pr2.OldStuff;

import com.google.common.base.Preconditions;

public abstract class Car
{
	private static final double PROBLEVELMIN = 0.0;
	private static final double PROBLEVELMAX = 1.0;

	private static final double NULLLEVEL = 0.01;
	private static final double NULLSPEED = 0.01;

	

	private double _speed; // Geschwindigkeit [ms^-1]
	private double _pos; // Position des Autos auf einer Geraden [m]
	private double _proplevel; // Gaspedalstellung
	private double _time; // Zeit [s]

	private CarStates _state;

	public Car()
	{
		this(0.0, 0.0, 0.0, 0.0);
	}

	public Car(double time, double pos, double speed, double proplevel)
	{
		set(time, pos, speed, proplevel);

		setState(proplevel, speed);
	}

	/**
	 * versetzt den Porsche in einen Startzustand
	 * 
	 * @param time
	 * @param pos
	 * @param speed
	 * @param proplevel
	 */
	public void set(double time, double pos, double speed, double proplevel)
	{
		Preconditions.checkArgument(time >= 0.0 && pos >= 0.0 && speed >= 0.0);
		_speed = speed;
		_pos = pos;
		_proplevel = checkproplevel(proplevel, PROBLEVELMIN, PROBLEVELMAX);
		_time = time;
		setState(proplevel, speed);
	}

	/**
	 * setzt alle Werte des Porsches auf 0 zurück.
	 */
	public void reset()
	{
		this.set(0.0, 0.0, 0.0, 0.0);
		_state = CarStates.STOPPED;
	}

	/**
	 * 
	 * @param deltaTime
	 *            (in Sekunden)
	 * @param level
	 *            (zwischen 0 und 1)
	 */
	public void step(double deltaTime, double level)
	{
		Preconditions.checkArgument(deltaTime >= 0.0);

		double proplevel = checkproplevel(level, 0.0, 1.0);

		double powerProp = this.powerPropMax() * proplevel; // Newton
															// [kg*m/s**2]
		double forcePropMax = this.getMass() * Konstants.ACCEARTH; // Newton
																	// [kg*m/s**2]

		double forcePropAbs; // Newton [kg*m/s**2]
		if (_state == CarStates.DRIVINGFORWORD)
		{
			forcePropAbs = Math.min(forcePropMax, (powerProp / _speed));
		}
		else
		{
			forcePropAbs = forcePropMax;
		}

		double forceProp = forcePropAbs * Math.signum(proplevel); // Newton
																	// [kg*m/s**2]

		double forceDrag = this.getdragConst() * (Math.pow(_speed, 2)) // Newton
																// [kg*m/s**2]
				* Math.signum(-_speed);
		double force = forceProp + forceDrag; // Newton [kg*m/s**2]

		// Kinematik
		double acc = force / this.getMass(); // Beschleunigung [m/s**2]

		this.set(_time + deltaTime, _pos + (_speed * deltaTime), _speed
				+ (acc * deltaTime), proplevel);

	}

	private void setState(double proplevel, double speed)
	{
		if (proplevel < NULLLEVEL && speed < NULLSPEED)
		{
			_state = CarStates.STOPPED;
		}
		else
		{
			_state = CarStates.DRIVINGFORWORD;
		}
	}

	/**
	 * @return Geschwindigkeit
	 */
	public double getSpeed()
	{
		return _speed;
	}

	/**
	 * @return Position
	 */
	public double getPos()
	{
		return _pos;
	}

	/**
	 * @return Gaspedalposition
	 */
	public double getProplevel()
	{
		return _proplevel;
	}

	/**
	 * @return Zeit
	 */
	public double getTime()
	{
		return _time;
	}

	/*
	 * stellt sicher, dass Gaspedalstellung(proplevel) immer zwischen 0 und 1
	 * ist
	 */
	private double checkproplevel(double proplevel, double min, double max)
	{
		if (proplevel <= max && proplevel >= min)
		{
			return proplevel;
		}
		else if (proplevel < min)
		{
			return min;
		}
		else
		{
			return max;
		}
	}

	/**
	 * Liefert die Masse des Autos
	 * @return
	 */
	abstract double getMass();

	/**
	 * Liefert die Leistung des Autos
	 * @return
	 */
	abstract double powerPropMax();

	/**
	 * liefert die Höchstgeschwindigkeit des Autos
	 * @return
	 */
	abstract double speedMax();
	
	/**
	 * 
	 * @return
	 */
	abstract double getdragConst();

}
