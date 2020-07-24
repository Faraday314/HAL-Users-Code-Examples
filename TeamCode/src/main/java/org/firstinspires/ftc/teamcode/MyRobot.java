package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.system.subsystems.MechanumDrive;
import com.SCHSRobotics.HAL9001.util.calib.AnglePIDTunerSystem;
import com.SCHSRobotics.HAL9001.util.calib.CameraCalib;
import com.SCHSRobotics.HAL9001.util.calib.ColorspaceCalib;
import com.SCHSRobotics.HAL9001.util.calib.EncoderDistanceCalib;
import com.SCHSRobotics.HAL9001.util.control.PIDController;
import com.SCHSRobotics.HAL9001.util.misc.BeatBox;
import com.SCHSRobotics.HAL9001.util.misc.Button;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.opencv.core.Mat;
import org.opencv.core.Size;

public class MyRobot extends Robot {
    public MyTankDrive drive;
    public MechanumDrive mecanum;
    public MyRobot(OpMode opMode) {
        super(opMode);
        drive = new MyTankDrive(this, "left", "right", new Button(1, Button.DoubleInputs.right_stick_y));
        mecanum = new MechanumDrive(this, "a", "b", "c", "d");
    }
}
