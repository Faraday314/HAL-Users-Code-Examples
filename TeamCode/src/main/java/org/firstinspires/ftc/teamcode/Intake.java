package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.system.source.BaseRobot.SubSystem;
import com.SCHSRobotics.HAL9001.util.annotations.AutonomousConfig;
import com.SCHSRobotics.HAL9001.util.annotations.TeleopConfig;
import com.SCHSRobotics.HAL9001.util.control.PIDController;
import com.SCHSRobotics.HAL9001.util.misc.Button;
import com.SCHSRobotics.HAL9001.util.misc.ConfigData;
import com.SCHSRobotics.HAL9001.util.misc.ConfigParam;
import com.SCHSRobotics.HAL9001.util.misc.CustomizableGamepad;
import com.SCHSRobotics.HAL9001.util.misc.Toggle;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.HashMap;
import java.util.Map;

public class Intake extends SubSystem {
    private static final String RUN_BUTTON = "RunButton", INTAKE_SPEED = "intake speed", MODE = "mode";
    private CustomizableGamepad gamepad;
    private DcMotor intakeLeft, intakeRight;
    private double speed;
    private Toggle toggle;
    private Mode mode;

    public enum Mode {
        HOLD_TO_INTAKE, PRESS_TO_INTAKE
    }

    public Intake(Robot robot, String leftConfig, String rightConfig, Button runButton) {
        super(robot);
        gamepad = new CustomizableGamepad(robot);
        gamepad.addButton(RUN_BUTTON, runButton);

        toggle = new Toggle(Toggle.ToggleTypes.trueWhileHeldOnce, false);

        speed = 0.5;
        mode = Mode.PRESS_TO_INTAKE;

        intakeLeft = robot.hardwareMap.dcMotor.get(leftConfig);
        intakeRight = robot.hardwareMap.dcMotor.get(rightConfig);
    }

    public Intake(Robot robot, String leftConfig, String rightConfig) {
        super(robot);

        usesConfig = true;

        toggle = new Toggle(Toggle.ToggleTypes.trueWhileHeldOnce, false);
        intakeLeft = robot.hardwareMap.dcMotor.get(leftConfig);
        intakeRight = robot.hardwareMap.dcMotor.get(rightConfig);
    }

    @Override
    public void init() {
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        if(usesConfig) {
            gamepad = robot.pullControls(this);
            ConfigData configData = robot.pullNonGamepad(this);
            speed = configData.getData(INTAKE_SPEED, Double.class);
            mode = configData.getData(MODE, Mode.class);
        }
    }

    @Override
    public void handle() {
        switch(mode) {
            case PRESS_TO_INTAKE:
                toggle.updateToggle(gamepad.getBooleanInput(RUN_BUTTON));
                if(toggle.getCurrentState()) {
                    run(speed);
                }
                else {
                    run(0.0);
                }
                break;
            case HOLD_TO_INTAKE:
                if(gamepad.getBooleanInput(RUN_BUTTON)) {
                    run(speed);
                }
                else {
                    run(0.0);
                }
                break;
        }
    }

    @Override
    public void stop() {

    }

    public void run(double power) {
        intakeLeft.setPower(power);
        intakeRight.setPower(power);
    }

    public void halt() {
        run(0);
    }

    @TeleopConfig
    public static ConfigParam[] teleopConfig() {
        return new ConfigParam[] {
                new ConfigParam(RUN_BUTTON, Button.BooleanInputs.a),
                new ConfigParam(INTAKE_SPEED, new HashMap<String, Object>() {{
                    put("0.1", 0.1);
                    put("0.2", 0.2);
                    put("0.3", 0.3);
                    put("0.4", 0.4);
                    put("0.5", 0.5);
                }}, 0.5),
                new ConfigParam(MODE, Mode.PRESS_TO_INTAKE)
        };
    }

    @AutonomousConfig
    public static ConfigParam[] jeff() {
        return new ConfigParam[] {
                new ConfigParam(INTAKE_SPEED, new HashMap<String, Object>() {{
                    put("0.1", 0.1);
                    put("0.2", 0.2);
                    put("0.3", 0.3);
                    put("0.4", 0.4);
                    put("0.5", 0.5);
                }}, 0.5)
        };
    }
}
