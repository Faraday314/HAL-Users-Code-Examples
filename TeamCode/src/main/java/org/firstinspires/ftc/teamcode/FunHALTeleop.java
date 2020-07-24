package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.BaseTeleop;
import com.SCHSRobotics.HAL9001.util.annotations.MainRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "fun HAL teleop")
public class FunHALTeleop extends BaseTeleop {
    public @MainRobot Cygnus myRobot;

    @Override
    protected void onInit() {
        myRobot.intake.run(1);
    }

    @Override
    protected void onInitLoop() {
        super.onInitLoop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
