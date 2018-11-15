package org.usfirst.frc.team3630.robot;

public class Constants 
{
	public static final int timeoutMs = 10;
	
	//gyro
	public static boolean turnToAngle;
	public static final double kP = 0.03;
	public static final double kI = 0.0;
	public static final double kD = 0.0;
	public static final double kF = 0.0;
	
	public static final double kTolarenceAngles = 2f;
	
	public static final double poskP = 0.03;
	public static final double poskI = 0.0;
	public static final double poskD = 0.0;
	public static final double poskF = 0.0;
	public static final double kToleranceIn = 2;
	
	public static final double wheelRadius = 3;
	public static final double ticksPerRotation = 1040; //TODO change
	
	public static final double smoothRotationSpeed = 0.6;
	
	public static final double initAutoCase = 1;
	
}
