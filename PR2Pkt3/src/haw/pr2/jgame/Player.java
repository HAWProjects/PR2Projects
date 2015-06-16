package haw.pr2.jgame;

import haw.pr2.jgame.interfaces.TimeDiff;

import java.awt.event.KeyEvent;

import jgame.JGObject;
import jgame.platform.JGEngine;

public class Player extends JGObject
{
	public static Player valueOf(JGEngine engine, Car car)
	{
		return new Player(engine, car);
	}

	private final JGEngine engine;
	private final Car car;
	private Lever proplevel;
	private Lever brakelevel;
	private Lever steeringWheel;
	private Switch asr;
	private Switch abs;

	private Player(JGEngine engine, Car car)
	{
		super("PlayerModel", true, 0.0, 0.0, 1, "Player");
		this.engine = engine;
		this.car = car;
		proplevel = Lever.valueOf(KeyEvent.VK_UP, KeyEvent.VK_UP, engine, 1.0, false, 0.2, true);
		brakelevel = Lever.valueOf(KeyEvent.VK_SPACE, KeyEvent.VK_SPACE, engine, 1.0, false, 0.2, true);
		steeringWheel = Lever.valueOf(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, engine, 1.0, true, 3.0, true);
		asr = Switch.valueOf(engine, KeyEvent.VK_S);
		abs = Switch.valueOf(engine, KeyEvent.VK_A);
	}
	
	/**
	 * updates the Player
	 * @param elapsedTime
	 */
	public void move(TimeDiff elapsedTime)
	{
		car.setTraktion(checktraktion());

		double steeringLevel = steeringWheel.update(elapsedTime);

		car.setProplevel(proplevel.update(elapsedTime));
		car.setBrakelevel(brakelevel.update(elapsedTime));

		if (steeringLevel < Konstants.MAXLEVEL && steeringLevel > Konstants.MINLEVEL)
		{
			car.setSteeringLevel(Konstants.ZERO);
		}
		else
		{
			car.setSteeringLevel(steeringLevel);
		}

		car.update(elapsedTime);

		x = car.getPosX().value();
		y = car.getPosY().value();

		System.out.println("Proplevel " + car.getProplevel());
		System.out.println("Lenkrad .......: " + steeringLevel);
		System.out.println("POSX:----------- " + car.getPosX());
		System.out.println("POSY: ~~~~~~~~~~~" + car.getPosY());
		

	}

	private Traktion checktraktion()
	{

		if (((Window) engine).getSwitchEis().update() && !((Window) engine).getSwitchNaesse().update()
				&& !((Window) engine).getSwitchSchnee().update())
		{
			return Traktion.ICE;
		}
		else if (((Window) engine).getSwitchNaesse().update() && !((Window) engine).getSwitchEis().update()
				&& !((Window) engine).getSwitchSchnee().update())
		{
			return Traktion.WET;
		}
		else if (((Window) engine).getSwitchSchnee().update() && !((Window) engine).getSwitchNaesse().update()
				&& !((Window) engine).getSwitchEis().update())
		{
			return Traktion.SNOW;
		}
		else
		{
			return Traktion.NORMAL;
		}

	}

	/**
	 * 
	 * @return Car
	 */
	public Car getCar()
	{
		return car;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAbsOn()
	{
		return abs.update();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isASROn()
	{
		return asr.update();
	}

}
