package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class AutoDriveExecutor 
{
	DifferentialDrive autoDrive = new DifferentialDrive(RobotMap.right, RobotMap.left);
	double speedR;
	double speedL;
	
	public void setSpeedR(double speedR)
	{
		this.speedR = speedR;
	}
	
	public void setSpeedL(double speedL)
	{
		this.speedL = speedL;
	}
	
	public void execute()
	{
		autoDrive.tankDrive(speedL, speedR);
	}
}
