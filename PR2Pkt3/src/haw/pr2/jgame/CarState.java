package haw.pr2.jgame;

import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Power;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

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
			else if(car.getSpeed().value() < Konstants.MAXLEVEL)
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
			// Dynamik
			// gaspedalstellung
			double proplevel = car.getProplevel();
			// aktuelle Leistung Auto
			Power powerProp = calculatePowerProb(car, proplevel); // Newton[kg*m/s**2]
			
			// Traktionskraft
			Force forcePropMax = calculateForcePropMax(car);
			
			// Bremskraft
			Force forceBrakeMax =  calculateForceBrakeMax(car); 
			
			Force forceBrake = forceBrakeMax.mul(car.getBrakelevel());
			
			// Beschleunigung
			Acc acc = forcePropMax.div(car.getMass());
			
			// Antriebskraft
			Force forcePropAbs = calculateForcePropAbs(forcePropMax, powerProp, car);
			if(forcePropAbs.value() > forcePropMax.value())
			{
				car.setState(SLIDING);
			}
	
			
			if(car.isABSActive() && Math.abs(forceBrake.value()) > forcePropMax.value())
			{
				forceBrake = forcePropMax.mul(-1);
			}
			else
			{
				if(Math.abs(forceBrake.value()) > forcePropMax.value())
				{
					car.setState(SLIDING);
				}
			}
			
			Force forceProp = forcePropAbs.mul(Math.signum(proplevel));// Newton [kg*m/s**2]
			
			// Widerstandskraft
			Force forceDrag =  calculateDragForce(car); // Newton[kg*m/s**2]
			
			// Gesamtkraft die in dem Moment wirkt
			Force force = forceProp.add(forceDrag).add(forceBrake); // Newton
																// [kg*m/s**2]
			
			// Kurvenradius
			
			// Beschleunigung
			
			acc = force.div(car.getMass());
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add((acc.mul(elapsedTime)));
			double courseAngle = car.getCurrentDirection();
			
			Length deltaX = (carSpeed.mul(elapsedTime).mul(Math.cos(courseAngle)));
			Length deltaY = (carSpeed.mul(elapsedTime).mul(Math.sin(courseAngle)));
			
			if(car.getSteeringLevel() < Konstants.MAXLEVEL && car.getSteeringLevel() > Konstants.MINLEVEL)
			{
				car.setSteeringLevel(Konstants.ZERO);
			}
			car.setTime(car.getTime().add(elapsedTime));
			car.setPosX(car.getPosX().add(deltaX));
			car.setPosY(car.getPosY().add(deltaY));
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
			
		}
	},
	
	DRIVINGCURVE
	{
		@Override
		public void switchState(Car car)
		{
			if((Math.abs(car.getSteeringLevel()) < Konstants.MAXSTEERING) && car.getSpeed().value() > Konstants.ZERO)
			{
				car.setState(DRIVINGFORWARD);
			}
			else if(car.getSpeed().value() <= Konstants.MAXLEVEL)
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
			// gaspedalstellung
			double proplevel = car.getProplevel();
			
			// aktuelle Leistung Auto
			Power powerProp = calculatePowerProb(car, proplevel); // Newton
			
			// Antriebskraft
			Force forcePropMax = calculateForcePropMax(car);
			
			// Bremskraft
			// Bremskraft
			Force forceBrakeMax =  calculateForceBrakeMax(car);
			Force forceBrake = forceBrakeMax.mul(car.getBrakelevel());
			
			// Kraft
			Force forcePropAbs = calculateForcePropAbs(forcePropMax, powerProp, car);
				
				if(forcePropAbs.value() > forcePropMax.value())
				{
					car.setState(SLIDING);
				}
			
			
			if(car.isABSActive() && Math.abs(forceBrake.value()) > forcePropMax.value())
			{
				forceBrake = forcePropMax.mul(-1);
			}
			else
			{
				if(Math.abs(forceBrake.value()) > forcePropMax.value())
				{
					car.setState(SLIDING);
				}
			}
			Force forceProp = forcePropAbs.mul(Math.signum(proplevel));
			
			// Widerstandskraft
			Force forceDrag = calculateDragForce(car); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			Force force = forceProp.add(forceDrag).add(forceBrake); // Newton [kg*m/s**2]
			
			// Kurvenradius
			System.err.println("Steeringlevel: " + car.getSteeringLevel());
			Length curveRadius = car.getCurveRadius().div(car.getSteeringLevel());
			
			// Beschleunigung
			Acc acc = force.div(car.getMass());
			
			// Maximale Beschleunigung
			Acc maxAcc = Konstants.ACCEARTH.mul(car.getTraktion().getValue()); 
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add((acc.mul(elapsedTime)));
			
			double normalenWinkel = car.getCurrentDirection() + (0.5 * Math.PI);
//			double normalenWinkel = car.getCurrentDirection() * (180 / Math.PI); //+ (0.5 * Math.PI);
			Length x = car.getPosX();
			Length y = car.getPosY();
	        Length xm = x.add(Math.cos(normalenWinkel)*(curveRadius.value()));
	        Length ym = y.add(Math.sin(normalenWinkel)*(curveRadius.value()));
	        double gamma = (car.getSpeed().value()*elapsedTime.value())/((curveRadius.value()));
	        Length deltaX = (((x.sub(xm)).mul(Math.cos(gamma)).sub(((y.sub(ym)).mul(Math.sin(gamma))).add(xm))));
	        Length deltaY = (((x.sub(xm)).mul(Math.sin(gamma)).add(((y.sub(ym)).mul(Math.cos(gamma))).add(ym))));
	        
	        boolean a = (Math.abs(acc.value()) + Math.abs((car.getSpeed().value() * car.getSpeed().value())/curveRadius.value())) <= maxAcc.value();
	        boolean c = Math.abs(car.getMass().value() * ((car.getSpeed().value() * car.getSpeed().value())/curveRadius.value())) < forcePropMax.value();
	        if (!c) { // TODO: moeglicherweise auch if (c) !!!
//	            car.setState(SLIDING);
	        }
	        
			car.setTime(car.getTime().add(elapsedTime));
			System.err.println("ich setze sachen");
			car.setPosX(deltaX);
			car.setPosY(deltaY);
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
				car.setSpeed(Factory.speed(0.2));
				car.setState(DRIVINGFORWARD);
			}
			else
			{
				car.setSpeed(Factory.speed(Konstants.ZERO));
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
			if(car.getSpeed().value() <= Konstants.ZERO)
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
			
			// Antriebskraft
			Force forcePropMax = calculateForcePropMax(car);
			
		
			// Kraft
			
			// Widerstandskraft
			Force forceDrag = calculateDragForce(car);; // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			Force force = forceDrag.add(calculateForceBrakeMax(car)); // Newton[kg*m/s**2]
			
			// Kurvenradius
			Length curveRadius = (car.getCurveRadius().abs());// / car.getSteeringLevel());
			
			// Beschleunigung
			Acc acc = force.div(car.getMass());
			// Maximale Beschleunigung
			
			// Kinematik
			
			// Aktuelle Geschwindigkeit nach Beschleunigung
			// Aktuelle Geschwindigkeit nach Beschleunigung
			Speed carSpeed = car.getSpeed().add((acc.mul(elapsedTime)));
			Acc maxAcc = Konstants.ACCEARTH.mul(car.getTraktion().getValue());
			
			double normalenWinkel = car.getCurrentDirection() + (0.5 * Math.PI);
//			double normalenWinkel = car.getCurrentDirection() * (180 / Math.PI); //+ (0.5 * Math.PI);
			Length x = car.getPosX();
			Length y = car.getPosY();
	        Length xm = x.add(Math.cos(normalenWinkel)*(curveRadius.value()));
	        Length ym = y.add(Math.sin(normalenWinkel)*(curveRadius.value()));
	        double gamma = (car.getSpeed().value()*elapsedTime.value())/((curveRadius.value()));
	        Length deltaX = (((x.sub(xm)).mul(Math.cos(gamma)).sub(((y.sub(ym)).mul(Math.sin(gamma))).add(xm))));
	        Length deltaY = (((x.sub(xm)).mul(Math.sin(gamma)).add(((y.sub(ym)).mul(Math.cos(gamma))).add(ym))));
	        
	        boolean a = (Math.abs(acc.value()) + Math.abs((car.getSpeed().value() * car.getSpeed().value())/curveRadius.value())) <= maxAcc.value();
	        boolean c = Math.abs(car.getMass().value() * ((car.getSpeed().value() * car.getSpeed().value())/curveRadius.value())) < forcePropMax.value();
	        if (!c) { // TODO: moeglicherweise auch if (c) !!!
//	            car.setState(SLIDING);
	        }
	        
			car.setTime(car.getTime().add(elapsedTime));
			car.setPosX(deltaX);
			car.setPosY(deltaY);
			car.setCurrentDirection(car.getCurrentDirection());
			car.setSpeed(carSpeed);
			
//			double degree = car.getCurrentDirection();
//			double deltaPos = carSpeed * elapsedTime;
//			
//			double courseAngle = degree;
//			
//			double deltaX = (deltaPos) * Math.cos(courseAngle);
//			double deltaY = (deltaPos) * Math.sin(courseAngle);
//			
//			car.setSteeringLevel(0.0);
//			car.setTime(car.getTime() + elapsedTime);
//			car.setPosX(car.getPosX() + deltaX);
//			car.setPosY(car.getPosY() + deltaY);
//			car.setCurrentDirection(courseAngle);
//			car.setSpeed(carSpeed);
		}
	};
	
	protected Force calculateForcePropMax(Car car)
	{
		return car.getMass().mul(Konstants.ACCEARTH).mul(car.getTraktion().getValue()); // Newton[kg*m/s**2]
	}
	
	protected Force calculateForcePropAbs(Force forcePropMax, Power powerProp, Car car) {
		Force min = forcePropMax.min(powerProp.div(car.getSpeed()));
		if(car.isASRActive())
		{
			return min;
		}
		else
		{
			return powerProp.div(car.getSpeed());
		}
	}

	protected Force calculateDragForce(Car car) {
		return car.getdragConst().mul((car.getSpeed().mul(car.getSpeed())).mul((car.getSpeed().mul(-1).signum())));
	}

	protected Force calculateForceBrakeMax(Car car) {
		return (car.getMass().mul(Konstants.ACCEARTH.mul(-2)).mul( car.getTraktion().getValue()));
	}

	protected Power calculatePowerProb(Car car, double proplevel) {
		return car.getPowerPropMax().mul(proplevel);
	}

	public abstract void switchState(Car car);
	
	public abstract void step(TimeDiff elapsedTime, Car car);
}
