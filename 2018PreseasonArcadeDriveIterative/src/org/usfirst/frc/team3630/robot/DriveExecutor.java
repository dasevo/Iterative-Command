package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveExecutor 
{
	DifferentialDrive teleopDrive = new DifferentialDrive(RobotMap.right, RobotMap.left);
	
	public void execute()
	{
		teleopDrive.arcadeDrive(OI.lStickYAxis, OI.rStickXAxis);
	}
}
