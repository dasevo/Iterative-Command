package pidClasses;

import edu.wpi.first.wpilibj.PIDOutput;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;

public class AutoDrive implements PIDOutput
{
	EncoderPIDSource encoderPIDSource;
	public PIDController posController;
	
	public AutoDrive()
	{
		
	}
	
	public void posControllerInit()
	{
		encoderPIDSource = new EncoderPIDSource();
		posController = new PIDController(Constants.poskP, Constants.poskI, Constants.poskD, Constants.poskF, encoderPIDSource, this);
		posController.setOutputRange(-.9, .9);
		posController.setAbsoluteTolerance(Constants.kToleranceIn);
		posController.setContinuous();
		posController.disable();
	}
	
	public void driveToDistance(double distance)
	{
		posController.setSetpoint(distance);
	}
	
	@Override
	public void pidWrite(double output)
	{
		Robot.autoDriveExecutor.setSpeedL(output);
		Robot.autoDriveExecutor.setSpeedR(output);
	}
	
}
