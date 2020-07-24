package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.system.source.BaseRobot.SubSystem;
import com.SCHSRobotics.HAL9001.util.control.PIDController;
import com.SCHSRobotics.HAL9001.util.misc.Button;
import com.SCHSRobotics.HAL9001.util.misc.CustomizableGamepad;
import com.SCHSRobotics.HAL9001.util.misc.Toggle;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MyTankDrive extends SubSystem {
    private static final String DRIVE_BUTTON = "DriveButton";
    private DcMotor leftMotor, rightMotor;
    private CustomizableGamepad gamepad;
    private Toggle driveToggle;
    public MyTankDrive(Robot robot, String leftMotorName, String rightMotorName, Button driveButton) {
        super(robot);
        leftMotor = robot.hardwareMap.dcMotor.get(leftMotorName);
        rightMotor = robot.hardwareMap.dcMotor.get(rightMotorName);

        gamepad = new CustomizableGamepad(robot);
        gamepad.addButton(DRIVE_BUTTON, driveButton);

        driveToggle = new Toggle(Toggle.ToggleTypes.trueOnceToggle, false);
    }

    @Override
    public void init() {

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void handle() {
        driveToggle.updateToggle(robot.gamepad1.b);
        if(driveToggle.getCurrentState()) {
            drive(gamepad.getDoubleInput(DRIVE_BUTTON));
        }
        else {
            stopMotors();
        }
    }

    @Override
    public void stop() {

    }

    public void drive(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    public void stopMotors() {
        drive(0);
    }
}
