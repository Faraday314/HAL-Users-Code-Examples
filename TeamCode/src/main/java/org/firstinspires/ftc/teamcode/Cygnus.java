package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.system.subsystems.MechanumDrive;
import com.SCHSRobotics.HAL9001.system.subsystems.OmniWheelDrive;
import com.SCHSRobotics.HAL9001.system.subsystems.QuadWheelDrive;
import com.SCHSRobotics.HAL9001.system.subsystems.TankDrive;
import com.SCHSRobotics.HAL9001.util.calib.AnglePIDTunerSystem;
import com.SCHSRobotics.HAL9001.util.calib.CameraCalib;
import com.SCHSRobotics.HAL9001.util.calib.ColorspaceCalib;
import com.SCHSRobotics.HAL9001.util.calib.EncoderDistanceCalib;
import com.SCHSRobotics.HAL9001.util.control.PIDController;
import com.SCHSRobotics.HAL9001.util.math.Units;
import com.SCHSRobotics.HAL9001.util.misc.Button;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.opencv.core.Mat;
import org.opencv.core.Size;

public class Cygnus extends Robot {
    public Intake intake;
    public MechanumDrive drive;
    public StoneDetector stoneDetector;
    public Cygnus(OpMode opMode) {
        super(opMode);
        intake = new Intake(this, "leftIntake", "rightIntake", new Button(2, Button.DoubleInputs.right_stick_x));
        drive = new MechanumDrive(this, "topLeft", "topRight", "bottomLeft", "bottomRight");

        stoneDetector = new StoneDetector(this);
        enableViewport(new Button(1, Button.BooleanInputs.noButton));
    }
}
