/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import pidClasses.AutoDrive;
import pidClasses.AutoRotate;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	public static AutoDrive autoDrive = new AutoDrive();
	public static AutoRotate autoRotate = new AutoRotate();
	public static AutoSequence autoSequence = new AutoSequence();
	
	public static AutoDriveExecutor autoDriveExecutor = new AutoDriveExecutor();
	public static DriveExecutor teleopDriveExecutor = new DriveExecutor();
	
	public enum Destinations
	{
		LEFT, RIGHT;
	}
	
	SendableChooser <Destinations> autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		autoChooser = new SendableChooser<Destinations>();
		autoChooser.addDefault("left" , Destinations.LEFT);
		autoChooser.addObject("right", Destinations.RIGHT);
		SmartDashboard.putData("auto chooser", autoChooser);
		
		RobotMap.configureTalon(RobotMap.five);
		RobotMap.configureTalon(RobotMap.fourL);
		RobotMap.configureTalon(RobotMap.oneR);
		RobotMap.configureTalon(RobotMap.six);
		RobotMap.configureTalon(RobotMap.threeR);
		RobotMap.configureTalon(RobotMap.twoL);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		RobotMap.resetEncoders();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		autoLogic();
		autoDriveExecutor.execute();
	}

	@Override
	public void teleopInit()
	{
		RobotMap.resetEncoders();
	}
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		teleopDriveExecutor.execute();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public void autoLogic()
	{
		if(autoChooser.getSelected() == Destinations.LEFT)
		{
			autoSequence.autoLeft();
		}
		else if(autoChooser.getSelected() == Destinations.RIGHT)
		{
			autoSequence.autoRight(); 
		}
		else
		{
			
		}
	}
}
