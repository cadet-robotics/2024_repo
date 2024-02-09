// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static class OperatorConstants
    {
        public static final int kDriverControllerPort = 0;
        public static final int kCoDriverControllerPort = 1;
        public static final double DEADZONE = 0.065;
        public static final int INTAKE_MOTOR_ID = 22;//TO DO Change back to 18
        public static final int LAUNCH_MOTOR_ID1 = 18;
        public static final int LAUNCH_MOTOR_ID2 = 19;
        public static final int LAUNCH_ELEVATION_MOTOR_ID = 20;
        public static final int CLIMBER_MOTOR_ID = 21;
        public static final double CLIMB_ASCEND_SPEED = 0.5;
        public static final double CLIMB_DESCEND_SPEED = -0.25;
        //Climber limit switch indexes
        public static final int CLIMB_ASCEND_LS = 0;
        public static final int CLIMB_DESCEND_LS = 1;
        //Launch limit switch indexes 
        public static final int LAUNCH_ELEV_ASCEND_LS = 2;
        public static final int LAUNCH_ELEV_DESCEND_LS = 3;

    }
}
