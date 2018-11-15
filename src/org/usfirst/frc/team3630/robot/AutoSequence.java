package org.usfirst.frc.team3630.robot;

public class AutoSequence 
{
	public double autoCase;
	
	public AutoSequence()
	{
		autoCase = Constants.initAutoCase;
	}
	
	public void autoRight()
	{
		if(autoCase == 1)
		{
			Robot.autoRotate.turnController.enable();
			Robot.autoRotate.turnToAngle(45);
			if(Math.abs(Robot.autoRotate.turnController.getError()) < Constants.kToleranceIn)
			{
				autoCase = 2;
			}
		}
	}
	
	public void autoLeft()
	{
		if(autoCase == 1)
		{
			Robot.autoRotate.turnController.enable();
			Robot.autoRotate.turnToAngle(-45);
		}
	}
}
