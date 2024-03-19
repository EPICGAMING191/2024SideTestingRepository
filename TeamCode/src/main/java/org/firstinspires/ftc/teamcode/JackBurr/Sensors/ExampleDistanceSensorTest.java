package org.firstinspires.ftc.teamcode.JackBurr.Sensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class ExampleDistanceSensorTest extends OpMode {
    public DistanceSensor sensor;
    @Override
    public void init() {
        sensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
    }

    @Override
    public void loop(){
        telemetry.addLine("Sensor Distance: " + sensor.getDistance(DistanceUnit.INCH));
    }
}