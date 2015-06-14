package haw.pr2.jgame;

public enum CarState
{
	DRIVINGFORWARD
	{
		@Override
		public void switchState(Car car)
		{
			if(Math.abs(car.getSteeringLevel()) > Konstants.MAXSTEERING)
			{
				car.setState(DRIVINGCURVE);
			}
			else if(car.getSpeed() < Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGFORWARD);
			}
		}
		
		@Override
		public void step(double elapsedTime, Car car)
		{
			// Dynamik
			// gaspedalstellung
			double proplevel = car.getProplevel();
			// aktuelle Leistung Auto
			double powerProp = car.getPowerPropMax() * proplevel; // Newton[kg*m/s**2]
			
			// Traktionskraft
			double forcePropMax = calculateForcePropMax(car);
			
			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue();
			double forceBrake = forceBrakeMax * car.getBrakelevel();
			
			// Beschleunigung
			double acc = forcePropMax / car.getMass();
			// Bremsbeschleunigung
			double accBrake = forceBrake / car.getMass();
			
			// Antriebskraft
			double forcePropAbs = 0;
			double min = Math.min(forcePropMax, (powerProp / car.getSpeed()));
			if(car.isASRActive())
			{
				forcePropAbs = min;
			}
			else
			{
				
				forcePropAbs = powerProp / car.getSpeed();
				
				System.err.println("abs**********************************" + forcePropAbs);
				System.err.println("max**********************************" + forcePropMax);
				if(forcePropAbs > forcePropMax)
				{
					car.setState(SLIDING);
				}
			}
			
			if(car.isABSActive() && Math.abs(forceBrake) > forcePropMax)
			{
				forceBrake = -forcePropMax;
			}
			else
			{
				if(Math.abs(forceBrake) > forcePropMax)
				{
					car.setState(SLIDING);
				}
			}
			
			double forceProp = forcePropAbs * Math.signum(proplevel);// Newton [kg*m/s**2]
			
			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton[kg*m/s**2]
			
			// Gesamtkraft die in dem Moment wirkt
			double force = forceProp + forceDrag + forceBrake; // Newton
																// [kg*m/s**2]
			
			// Kurvenradius
			
			// Beschleunigung
			
			acc = force / car.getMass();
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);
			double courseAngle = car.getCurrentDirection();
			
			double deltaX = (carSpeed * elapsedTime) * Math.cos(courseAngle);
			double deltaY = (carSpeed * elapsedTime) * Math.sin(courseAngle);
			
			if(car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1)
			{
				car.setSteeringLevel(0.0);
			}
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
			
		}
	},
	
	DRIVINGCURVE
	{
		@Override
		public void switchState(Car car)
		{
			if((Math.abs(car.getSteeringLevel()) < Konstants.MAXSTEERING) && car.getSpeed() > 0.0)
			{
				car.setState(DRIVINGFORWARD);
			}
			else if(car.getSpeed() <= Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGCURVE);
			}
		}
		
		@Override
		public void step(double elapsedTime, Car car)
		{
			System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// gaspedalstellung
			double proplevel = car.getProplevel();
			
			// aktuelle Leistung Auto
			double powerProp = car.getPowerPropMax() * proplevel; // Newton
			
			// Antriebskraft
			double forcePropMax = calculateForcePropMax(car);
			
			// Bremskraft
			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue();
			double forceBrake = forceBrakeMax * car.getBrakelevel();
			
			// Kraft
			double forcePropAbs = 0;
			double min = Math.min(forcePropMax, (powerProp / car.getSpeed()));
			if(car.isASRActive())
			{
				forcePropAbs = min;
			}
			else
			{
				
				forcePropAbs = powerProp / car.getSpeed();
				
				if(forcePropAbs > min)
				{
					car.setState(SLIDING);
				}
			}
			
			if(car.isABSActive() && Math.abs(forceBrake) > forcePropMax)
			{
				forceBrake = -forcePropMax;
			}
			else
			{
				if(Math.abs(forceBrake) > forcePropMax)
				{
					car.setState(SLIDING);
				}
			}
			double forceProp = forcePropAbs * Math.signum(proplevel);
			
			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			double force = forceProp + forceDrag + forceBrakeMax; // Newton
																	// [kg*m/s**2]
			
			// Kurvenradius
			double curveRadius = car.getCurveRadius() / car.getSteeringLevel();
			
			// Beschleunigung
			double acc = force / car.getMass();
			
			// Maximale Beschleunigung
			double maxAcc = Konstants.ACCEARTH * car.getTraktion().getValue(); // 1 = tractCoeff
			
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);
			
			double normalenWinkel = car.getCurrentDirection() + (0.5 * Math.PI);
			double x = car.getPosX();
			double y = car.getPosY();
	        double xm = x + (Math.cos(normalenWinkel) * curveRadius);
	        double ym = y + (Math.sin(normalenWinkel) * curveRadius);
	        double gamma = (car.getSpeed() * elapsedTime)/curveRadius;
	        double deltaX = (((x - xm) * Math.cos(gamma)) - ((y - ym) * Math.sin(gamma))) + xm;
	        double deltaY = (((x - xm) * Math.sin(gamma)) + ((y - ym) * Math.cos(gamma))) + ym;
	        boolean c = Math.abs(car.getMass() * ((car.getSpeed() * car.getSpeed())/curveRadius)) < forcePropMax;
	        if (!c) { // TODO: moeglicherweise auch if (c) !!!
	            car.setState(SLIDING);
	        }
	        
			
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(car.getCurrentDirection() + gamma);
			car.setSpeed(carSpeed);
			
			// double degree = car.getCurrentDirection();
			// double deltaPos = carSpeed * elapsedTime;
			//
			// double deltaCourseAngle = deltaPos / curveRadius;
			//
			// double courseAngle = (degree + deltaCourseAngle * car.getCurveRadius());
			//
			// System.out.println("__________________________" + courseAngle +
			// "------------------------------------------");
			//
			// double deltaX = (deltaPos) * Math.cos(courseAngle);
			// double deltaY = (deltaPos) * Math.sin(courseAngle);
			
			// double curveAcc = (car.getSpeed() * car.getSpeed()) / Math.abs(curveRadius);
			// if (Math.abs(acc + curveAcc) > maxAcc) {
			// car.setState(SLIDING);
			// }
			//
			// if (car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1) {
			// car.setSteeringLevel(0.0);
			// }
			//
			// car.setTime(car.getTime() + elapsedTime);
			// car.setPosX(car.getPosX() + deltaX);
			// car.setPosY(car.getPosY() + deltaY);
			// car.setCurrentDirection(courseAngle);
			// car.setSpeed(carSpeed);
		}
	},
	
	STOPPED
	{
		@Override
		public void switchState(Car car)
		{
			if(car.getProplevel() > 0.1)
			{
				car.setSpeed(0.1);
				car.setState(DRIVINGFORWARD);
			}
			else
			{
				car.setSpeed(0.0);
				car.setState(STOPPED);
			}
		}
		
		@Override
		public void step(double elapsedTime, Car car)
		{
			car.setTime(car.getTime() + elapsedTime);
		}
	},
	SLIDING
	{
		
		@Override
		public void switchState(Car car)
		{
			if(car.getSpeed() <= Konstants.ZERO)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(SLIDING);
			}
		}
		
		@Override
		public void step(double elapsedTime, Car car)
		{
			System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// Antriebskraft
			double forcePropMax = calculateForcePropMax(car);
			
			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue();
			
			// Kraft
			
			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			double force = forcePropMax + forceDrag + forceBrakeMax; // Newton[kg*m/s**2]
			
			// Kurvenradius
			
			// Beschleunigung
			double acc = force / car.getMass();
			// Maximale Beschleunigung
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);
			
			double degree = car.getCurrentDirection();
			double deltaPos = carSpeed * elapsedTime;
			
			double courseAngle = degree;
			
			double deltaX = (deltaPos) * Math.cos(courseAngle);
			double deltaY = (deltaPos) * Math.sin(courseAngle);
			
			car.setSteeringLevel(0.0);
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
		}
	};
	
	protected double calculateForcePropMax(Car car)
	{
		return car.getMass() * (Konstants.ACCEARTH * car.getTraktion().getValue()); // Newton[kg*m/s**2]
	}
	
	public abstract void switchState(Car car);
	
	public abstract void step(double elapsedTime, Car car);
}
