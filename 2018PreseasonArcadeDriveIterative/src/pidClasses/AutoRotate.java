package pidClasses;

import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.Robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;


public class AutoRotate implements PIDOutput
{
	AHRS ahrs;
	public PIDController turnController;
	private boolean adjustRight;
	
	public void gyroInit()
	{
		ahrs = new AHRS(SPI.Port.kMXP);
		turnController = new PIDController(Constants.kP, Constants.kI, Constants.kD, Constants.kF, ahrs, this);
		turnController.setInputRange(-180, 180);
		turnController.setOutputRange(-0.4, 0.4);
		turnController.setAbsoluteTolerance(Constants.kTolarenceAngles);
		turnController.setContinuous();
		turnController.disable();
	}
	
	public void turnToAngle(double angle)
	{
		if(angle>=0)
		{
			adjustRight = false;
		}
		else
		{
			adjustRight = true;
		}
		turnController.setSetpoint(angle);
	}
	
	@Override
	public void pidWrite(double output)
	{
		if(adjustRight)
		{
			Robot.autoDriveExecutor.setSpeedL(Constants.smoothRotationSpeed);
			Robot.autoDriveExecutor.setSpeedR(Constants.smoothRotationSpeed + output);
		}
		else
		{
			Robot.autoDriveExecutor.setSpeedL(Constants.smoothRotationSpeed + output);
			Robot.autoDriveExecutor.setSpeedR(Constants.smoothRotationSpeed);
		}
	}
}
