package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.SCHSRobotics.HAL9001.system.source.BaseRobot.Robot;
import com.SCHSRobotics.HAL9001.system.source.BaseRobot.SubSystem;
import com.SCHSRobotics.HAL9001.system.source.BaseRobot.VisionSubSystem;
import com.SCHSRobotics.HAL9001.system.subsystems.TankDrive;
import com.SCHSRobotics.HAL9001.util.misc.Grapher;

import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvPipeline;

public class StoneDetector extends SubSystem {

    Grapher grapher;

    public StoneDetector(Cygnus robot) {
        super(robot);
        grapher = new Grapher(10, 20, true);
    }

    @Override
    public void init() {
        Log.wtf("TAG", "RAN");
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void handle() {

    }

    @Override
    public void stop() {

    }

    private class Pipeline extends OpenCvPipeline {
        @Override
        public Mat processFrame(Mat input) {
            Mat graph = grapher.getNextFrame(Math.sin(System.currentTimeMillis()/1000.0));
            return graph;
        }
    }
}
