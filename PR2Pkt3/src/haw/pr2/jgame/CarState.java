package haw.pr2.jgame;
import haw.pr2.jgame.interfaces.*;

public enum CarState
{
	DRIVINGFORWARD
	{
		@Override
		public void switchState(Car car)
		{
			if (Math.abs(car.getSteeringLevel()) > Konstants.MAXSTEERING)
			{
				car.setState(DRIVINGCURVE);
			}
			else if (car.getSpeed().value() < Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGFORWARD);
			}
		}

		@Override
		public void step(TimeDiff elapsedTime, Car car)
		{
			 System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// Dynamik
			// gaspedalstellung
			double proplevel = car.getProplevel();
			// aktuelle Leistung Auto
			Power powerProp = car.getPowerPropMax().mul(proplevel);
			
			// Antriebskraft
			Force forcePropMax = calculateForcePropMax(car);  // Newton[kg*m/s**2]

			// Bremskraft
			Force forceBrakeMax = calculateForceBrakeMax(car);

			// Kraft
			Force forcePropAbs = powerProp.div(car.getSpeed());
			if (car.isASRActive())
			{
				forcePropAbs = Factory.forceInNewton(Math.min(forcePropMax.value(), (powerProp.div(car.getSpeed())).value()));
			}
			// Abs
			checkAbs(car, forceBrakeMax, forcePropMax);
			
			Force forceProp = forcePropAbs.mul(Math.signum(proplevel));// Newton [kg*m/s**2]

			// Widerstandskraft
			Force forceDrag =  calculateForceDrag(car); 
			
			
			// Gesamtkraft die in dem Moment wirkt
			Force force = calculateForce(forceProp,forceDrag,forceBrakeMax);// Newton [kg*m/s**2]

			// Kurvenradius

			// Beschleunigung
		
			Acc acc = calculateAcc(car, force);
		

			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add(acc.mul(elapsedTime));
			
			double courseAngle = car.getCurrentDirection();

			if (carSpeed.value() > -0.2 && carSpeed.value() < 0.2 && proplevel < 0.1)
			{
				carSpeed = Factory.speedInMeterProSeKunde(Konstants.ZERO);
			}

			Length deltaX = carSpeed.mul(elapsedTime).mul(Math.cos(courseAngle));
			Length deltaY = carSpeed.mul(elapsedTime).mul(Math.sin(courseAngle));

			if (car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1)
			{
				car.setSteeringLevel(0.0);
			}
			car.setTime(car.getTime().add(elapsedTime));
			car.setPosX(car.getPosX() + deltaX.value());
			car.setPosY(car.getPosY() + deltaY.value());
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
			
		}

	},

	DRIVINGCURVE
	{
		@Override
		public void switchState(Car car)
		{
			if ((Math.abs(car.getSteeringLevel()) < Konstants.MAXSTEERING) && car.getSpeed().value() > 0.0)
			{
				car.setState(DRIVINGFORWARD);
			}
			else if (car.getSpeed().value() <= Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGCURVE);
			}
		}

		@Override
		public void step(TimeDiff elapsedTime, Car car)
		{
			 System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// gaspedalstellung
			double proplevel = car.getProplevel();

			// aktuelle Leistung Auto
			Power powerProp = car.getPowerPropMax().mul(proplevel); // Newton

			// Antriebskraft
			Force forcePropMax =  calculateForcePropMax(car);

			// Bremskraft
			Force forceBrakeMax = calculateForceBrakeMax(car);

			// Kraft
			Force forcePropAbs = Factory.forceInNewton(0.0); // Newton [kg*m/s**2]
			if (car.isASRActive())
			{
				forcePropAbs = Factory.forceInNewton(Math.min(forcePropMax.value(), (powerProp.div(car.getSpeed())).value()));
			}
			else
			{
				forcePropAbs = powerProp.div(car.getSpeed());
			}

			// Abs
			checkAbs(car, forceBrakeMax, forcePropMax);

			Force forceProp = forcePropAbs.mul(Math.signum(proplevel));// Newton
																		// [kg*m/s**2]
			
			// Widerstandskraft
			Force forceDrag = calculateForceDrag(car); 
			
			// Gesamtkraft die in dem Moment wirkt
			Force force = calculateForce(forceProp, forceDrag, forceBrakeMax);

			// Kurvenradius
			Length curveRadius = car.getCurveRadius().div(car.getSteeringLevel());

			// Beschleunigung
			Acc acc =  calculateAcc(car, force);

			// Maximale Beschleunigung
			Acc maxAcc = Konstants.ACCEARTH.mul(car.getTraktion().getValue()); // 1 = tractCoeff
			
			Acc curveAcc = car.getSpeed().curveAcc(curveRadius.abs());
			if (Math.abs(acc.value()) + curveAcc.value() > maxAcc.value())
			{
				 car.setState(SLIDING);
			}
			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add(acc.mul(elapsedTime));

			double degree = car.getCurrentDirection();
			Length deltaPos = carSpeed.mul(elapsedTime);

			double deltaCourseAngle = deltaPos.value() / curveRadius.value();
			
			//Bogenma� in Grad� umrechnen
//			deltaCourseAngle = (deltaCourseAngle / Math.PI) * 180;
			

			double courseAngle = (degree + deltaCourseAngle * car.getCurveRadius().value());

			System.out.println("__________________________"+courseAngle+"------------------------------------------");
			
			Length deltaX = deltaPos.mul(Math.cos(courseAngle));
			Length deltaY = deltaPos.mul(Math.sin(courseAngle));

			if (car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1)
			{
				car.setSteeringLevel(0.0);
			}
			car.setTime(car.getTime().add(elapsedTime));
			car.setPosX(car.getPosX() + deltaX.value());
			car.setPosY(car.getPosY() + deltaY.value());
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
		}
	},

	STOPPED
	{
		@Override
		public void switchState(Car car)
		{
			if (car.getProplevel() > 0.1)
			{
				car.setSpeed(Factory.speedInMeterProSeKunde(0.1));
				car.setState(DRIVINGFORWARD);
			}
			else
			{
				car.setSpeed(Factory.speedInMeterProSeKunde(0.0));
				car.setState(STOPPED);
			}
		}

		@Override
		public void step(TimeDiff elapsedTime, Car car)
		{
			car.setTime(car.getTime().add(elapsedTime));
		}

	},
	SLIDING
	{
		 
		@Override
		public void switchState(Car car)
		{
			if (car.getSpeed().value() <= Konstants.ZERO)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(SLIDING);
			}
		}

		@Override
		public void step(TimeDiff elapsedTime, Car car)
		{
			System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// Antriebskraft
			Force forcePropMax =  calculateForcePropMax(car);
			// Bremskraft
			Force forceBrakeMax = calculateForceBrakeMax(car);

			// Kraft
			// Widerstandskraft
			Force forceDrag = calculateForceDrag(car); 
			
			// Gesamtkraft die in dem Moment wirkt
			Force force = calculateForce(forcePropMax, forceDrag, forceBrakeMax); // Newton[kg*m/s**2]

			// Beschleunigung
			
			Acc acc = calculateAcc(car, force);

			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add((acc.mul(elapsedTime)));

			double degree = car.getCurrentDirection();
			Length deltaPos = carSpeed.mul(elapsedTime);

			double courseAngle = degree;

			if (carSpeed.value() > -0.2 && carSpeed.value() < 0.2)
			{
				carSpeed = Factory.speedInMeterProSeKunde(Konstants.ZERO);
			}

			Length deltaX = deltaPos.mul( Math.cos(courseAngle));
			Length deltaY = deltaPos.mul(Math.sin(courseAngle));

			car.setSteeringLevel(0.0);
			car.setTime(car.getTime().add( elapsedTime));
			car.setPosX(car.getPosX() + deltaX.value());
			car.setPosY(car.getPosY() + deltaY.value());
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
		}
	};

	

	protected Force calculateForcePropMax(Car car)
	{
		return car.getMass().mul(Konstants.ACCEARTH).mul(car.getTraktion().getValue()); // Newton[kg*m/s**2]
	}
	
	protected Acc calculateAcc(Car car, Force force) {
		return force.div(car.getMass());
	}

	protected Force calculateForce(Force forceProp, Force forceDrag, Force forceBrakeMax) {	
		return forceProp.add(forceDrag).add(forceBrakeMax); 
	}

	protected void checkAbs(Car car, Force forceBrakeMax, Force forcePropMax) {
		if (car.isABSActive())
		{
			if (forceBrakeMax.value() > forcePropMax.value())
			{
				forceBrakeMax = forcePropMax;
			}
		}
		else
		{
			if (Math.abs(forceBrakeMax.value()) > forcePropMax.value())
			{
				System.out.println("ABS Sliding ******************************");
				car.setState(SLIDING);
			}
		}
	}

	protected Force calculateForceDrag(Car car) {
		return car.getdragConst().mul(car.getSpeed().mul(car.getSpeed())).mul(Factory.speedInMeterProSeKunde(-(car.getSpeed().signum()).value())); // Newton[kg*m/s**2]
	}

	protected Force calculateForceBrakeMax(Car car){
		return (car.getMass().mul(Konstants.ACCEARTH).mul(-2)).mul(car.getTraktion().getValue()).mul(car.getBrakelevel());
	}
	
	public abstract void switchState(Car car);
	public abstract void step(TimeDiff elapsedTime, Car car);
}
