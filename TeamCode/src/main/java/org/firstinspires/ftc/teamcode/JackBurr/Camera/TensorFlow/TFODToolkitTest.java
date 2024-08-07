package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.ArrayList;
import java.util.List;

@TeleOp
public class TFODToolkitTest extends OpMode {
    RoboKaiTensorFlowToolkit toolkit = new RoboKaiTensorFlowToolkit(hardwareMap);
    String MODEL_PATH = "";
    RoboKaiTensorFlowToolkit.ModelType modelType = RoboKaiTensorFlowToolkit.ModelType.CUSTOM_TFOD_MODEL_ASSET;
    String WEBCAM_NAME = "Webcam 1";
    boolean LIVE_VIEW_ENABLED = true;
    boolean USE_DEFAULT_SEASON_MODEL = false;

    public List<String> labelsList = new ArrayList<>();
    public List<Double> xList = new ArrayList<>();
    public List<Double> yList = new ArrayList<>();


    @Override
    public void init() {
        //TODO: Figure out if the portal works
        TfodProcessor processor = toolkit.createProcessorFromModel(MODEL_PATH, modelType, WEBCAM_NAME, LIVE_VIEW_ENABLED, USE_DEFAULT_SEASON_MODEL);
        VisionPortal portal = toolkit.getVisionPortal();
        //TODO: Test below line as well
        toolkit.startStreamOnFTCDashboard(hardwareMap, WEBCAM_NAME);
    }

    @Override
    public void init_loop(){
        //TODO: Add init loop code here
    }

    @Override
    public void loop() {
        List<Recognition> recognitionList = toolkit.getProcessorRecognitionsList();
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
        }
    }
}
