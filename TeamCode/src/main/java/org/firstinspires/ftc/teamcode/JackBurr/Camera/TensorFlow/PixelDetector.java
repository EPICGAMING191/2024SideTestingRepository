package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.ArrayList;
import java.util.List;

@TeleOp
public class PixelDetector extends OpMode {
    public RoboKaiTensorFlowToolkit toolkit = new RoboKaiTensorFlowToolkit(hardwareMap, telemetry,true);
    public String MODEL_PATH = "CenterStage.tflite";
    public RoboKaiTensorFlowToolkit.ModelType modelType = RoboKaiTensorFlowToolkit.ModelType.CUSTOM_TFOD_MODEL_ASSET;
    public String WEBCAM_NAME = "Webcam 1";
    boolean LIVE_VIEW_ENABLED = true;
    boolean USE_DEFAULT_SEASON_MODEL = false;

    public List<String> labelsList = new ArrayList<>();
    public List<Double> xList = new ArrayList<>();
    public List<Double> yList = new ArrayList<>();

    public TfodProcessor processor;
    public VisionPortal portal;

    @Override
    public void init() {
        telemetry.addLine(WEBCAM_NAME);
        WEBCAM_NAME = "Webcam 1";
        telemetry.addLine("WEBCAM 1  \n");
        telemetry.update();
        processor = toolkit.createProcessorFromModel(hardwareMap, MODEL_PATH, modelType, WEBCAM_NAME, LIVE_VIEW_ENABLED, USE_DEFAULT_SEASON_MODEL);
        telemetry.addLine("Created processor.");
        portal = toolkit.getVisionPortal();
        telemetry.addLine("Created portal.");

    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start(){
        toolkit.startStreamOnFTCDashboard(hardwareMap, processor, WEBCAM_NAME);
        telemetry.clearAll();
    }

    @Override
    public void loop() {
        List<Recognition> recognitionList = toolkit.getProcessorRecognitionsList(processor);
        if (recognitionList.size() < 1){
            telemetry.addLine("No objects detected yet.");
        }
        for(Recognition recognition : recognitionList){
            double x = toolkit.getRecognitionXCoordinate(recognition);
            double y = toolkit.getRecognitionYCoordinate(recognition);
            if(!labelsList.contains(recognition.getLabel())){
                labelsList.add(recognition.getLabel());
                xList.add(x);
                yList.add(y);
            }
            else {
                int index = labelsList.indexOf(recognition.getLabel());
                if (xList.get(index) != x) {
                    xList.set(index, x);
                }
                if (yList.get(index) != y) {
                    yList.set(index, y);
                }
            }
            toolkit.printDetails(telemetry, recognition, x,y);
            double x_adjusted = Math.round(x * 100.0) / 100.0;
            double y_adjusted = Math.round(y * 100.0) / 100.0;
            telemetry.addLine("Pixel Detected at (" + x_adjusted + " , " + y_adjusted +")");
        }
        if(gamepad1.options){
            toolkit.stopStreaming();
        }
    }
}
