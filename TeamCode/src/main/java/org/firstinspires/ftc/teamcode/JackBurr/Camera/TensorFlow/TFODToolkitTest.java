package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

@TeleOp
public class TFODToolkitTest extends OpMode {
    RoboKaiTensorFlowToolkit toolkit = new RoboKaiTensorFlowToolkit(hardwareMap);
    String MODEL_PATH = "";
    RoboKaiTensorFlowToolkit.ModelType modelType = RoboKaiTensorFlowToolkit.ModelType.CUSTOM_TFOD_MODEL_FILE;
    String WEBCAM_NAME = "Webcam 1";
    boolean LIVE_VIEW_ENABLED = true;
    boolean USE_DEFAULT_SEASON_MODEL = false;


    @Override
    public void init() {
        //TODO: Figure out if thr portal works
        TfodProcessor processor = toolkit.createProcessorFromModel(MODEL_PATH, modelType, WEBCAM_NAME, LIVE_VIEW_ENABLED, USE_DEFAULT_SEASON_MODEL);
        VisionPortal portal = toolkit.getVisionPortal();
    }

    @Override
    public void loop() {
        //TODO: Add telemetry code here
    }
}
