package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.BaseAutonomous;
import com.SCHSRobotics.HAL9001.util.annotations.LinkTo;
import com.SCHSRobotics.HAL9001.util.annotations.MainRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@LinkTo(destination = "blah1")
@Autonomous(name = "blah2")
public class MyAutonomousProgram extends BaseAutonomous {
    public @MainRobot MyRobot robot;

    @Override
    public void main() {
        robot.drive.drive(1);
    }
}
