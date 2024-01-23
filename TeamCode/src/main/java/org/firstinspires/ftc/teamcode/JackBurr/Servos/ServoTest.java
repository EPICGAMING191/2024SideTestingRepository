package org.firstinspires.ftc.teamcode.JackBurr.Servos;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class ServoTest extends OpMode {
    HardwareMap hwMap;
    public ServoTest(HardwareMap hwMap){
        this.hwMap = hwMap;
    }
    public Servo servo;
    public ElapsedTime main;
    @Override
    public void init(){
        servo = hardwareMap.get(Servo.class, "servo");
        main = new ElapsedTime();
        try {
            servo = hwMap.get(Servo.class, "servo");
        }
        catch (Exception e){
            //The file has not been run from another file
        }
    }

    @Override
    public void start(){
        main.reset();
    }

    @Override
    public void loop() {
        if (gamepad1.y && main.seconds() > 0.2){
            servo.setPosition(-1);
            main.reset();
        }
        else if (gamepad1.x && main.seconds() > 0.2){
            servo.setPosition(1);
            main.reset();
        }
        telemetry.addData("Servo Position: ", servo.getPosition());
        telemetry.update();
    }
}
