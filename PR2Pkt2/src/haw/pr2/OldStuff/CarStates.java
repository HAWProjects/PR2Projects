package haw.pr2.OldStuff;

/**
 *
 * @author abt434
 */
public enum CarStates
{
	DRIVINGFORWORD
	{
		public CarStates step(double aDeltaTime)
		{
			return CarStates.STOPPED;
		}
	},
	DRIVINGBACK
	{
		public CarStates step(double aDeltaTime)
		{
			if (getSpeed() >= 0.0)
			{
				return CarStates.STOPPED;
			}

			return CarStates.DRIVINGBACK;
		}
	},
	DRIVINGCURVE
	{
		public CarStates step(double aDeltaTime)
		{
			if (getSpeed() >= 0.0)
			{
				return CarStates.STOPPED;
			}

			return CarStates.DRIVINGCURVE;
		}
	},
	STOPPED
	{
		public CarStates step(double aDeltaTime)
		{
			if (getSpeed() >= 0.0)
			{
				return CarStates.DRIVINGFORWORD;
			}

			return CarStates.STOPPED;
		}
	},
	SLIDING
	{
		public CarStates step(double aDeltaTime)
		{
			if (getSpeed() >= 0.0)
			{
				return CarStates.SLIDING;
			}

			return CarStates.STOPPED;
		}
	};

	public double getSpeed()
	{
		return speed;
	}

	private double speed;
	private double x;
	private double y;

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public abstract CarStates step(double aDeltaTime);
}
