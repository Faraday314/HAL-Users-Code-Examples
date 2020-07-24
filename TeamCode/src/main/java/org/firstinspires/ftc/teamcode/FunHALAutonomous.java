package org.firstinspires.ftc.teamcode;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.BaseAutonomous;
import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.util.annotations.LinkTo;
import com.SCHSRobotics.HAL9001.util.math.Vector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import static java.lang.Math.PI;

@LinkTo(destination = "fun HAL teleop")
@Autonomous(name = "fun HAL autonomous")
public class FunHALAutonomous extends BaseAutonomous {
    public Cygnus myRobot;

    @Override
    protected Robot buildRobot() {
        myRobot = new Cygnus(this);
        return myRobot;
    }

    @Override
    public void main() {
        myRobot.intake.run(1);
        myRobot.drive.drive(new Vector(1, PI/2, Vector.CoordinateType.POLAR));
    }
}
