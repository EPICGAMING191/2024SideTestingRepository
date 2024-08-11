package org.firstinspires.ftc.teamcode.JackBurr.Other;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(group = "Telemetry")
public class TelemetryAndFTCDashboard extends LinearOpMode {
    public TelemetryAndFTCDashboard(Telemetry telemetry) {
        this.my_telemetry = telemetry;
    }
    Telemetry my_telemetry;
    Telemetry mult = new MultipleTelemetry(my_telemetry, FtcDashboard.getInstance().getTelemetry());
    @Override
    public void runOpMode() {
        while (opModeInInit()){
            mult.addLine("Hello");
            mult.update();
        }
        waitForStart();
    }
    public void setTelemetry(Telemetry telemetry) {
        my_telemetry = telemetry;
    }
}
