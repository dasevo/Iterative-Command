package pidClasses;

import org.usfirst.frc.team3630.robot.Constants;
import org.usfirst.frc.team3630.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderPIDSource implements PIDSource
{
	public EncoderPIDSource()
	{
		
	}
	
	public double pidGet()
	{
		double encoderL = RobotMap.getTicks(RobotMap.twoL);
		double encoderR = RobotMap.getTicks(RobotMap.oneR);
		double positionIn = encoderL *(Math.PI *2*Constants.wheelRadius)/Constants.ticksPerRotation;
		return positionIn;
	}
	
	public PIDSourceType getPIDSourceType()
	{
		return PIDSourceType.kDisplacement;
	}
	
	public void setPIDSourceType(PIDSourceType type)
	{
		
	}
}
