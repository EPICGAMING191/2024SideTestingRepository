package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;


import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvWebcam;

import java.util.List;
import java.util.Objects;

public class RoboKaiTensorFlowToolkit {
    public HardwareMap hardware_map;
    public TfodProcessor TFOD_processor;
    public VisionPortal portal;
    public Telemetry telemetry;
    public boolean debug;
    public static final String SEASON_MODEL = "CenterStage.tflite";

    public RoboKaiTensorFlowToolkit(HardwareMap hardware_map, Telemetry target_telemetry, boolean debug){
        this.hardware_map = hardware_map;
        this.telemetry = target_telemetry;
        this.debug = debug;
    }

    public void debug_(String message){
        if (debug == true) {
            telemetry.addLine(message);
        }
    }

    public boolean USE_WEBCAM = true;


    public enum ModelType {
        SEASON_DEFAULT_MODEL,
        CUSTOM_TFOD_MODEL_ASSET,
        CUSTOM_TFOD_MODEL_FILE
    }

    public void enableCamera(boolean enabled){
        // Enable/Disable Camera
        USE_WEBCAM = enabled;
    }

    public void startStreamOnFTCDashboard(HardwareMap hardwareMap, TfodProcessor pro, String webcam_name){
        // TODO: Fix this
        //FtcDashboard.getInstance().startCameraStream(new_,0);
    }

    public TfodProcessor createTFODProcessor(ModelType modelType, String modelPath){
        TfodProcessor processor;
        if (modelType == ModelType.CUSTOM_TFOD_MODEL_FILE) {
            processor = new TfodProcessor.Builder()
                    .setModelFileName(modelPath)
                    // The following default settings are available to un-comment and edit as needed to
                    // set parameters for custom models.
                    //.setModelLabels(LABELS)
                    //.setIsModelTensorFlow2(true)
                    //.setIsModelQuantized(true)
                    //.setModelInputSize(300)
                    //.setModelAspectRatio(16.0 / 9.0)
                    .build();
            return processor;
        }
        else if (modelType == ModelType.CUSTOM_TFOD_MODEL_ASSET) {
            processor = new TfodProcessor.Builder()
                    .setModelAssetName(modelPath)
                    // The following default settings are available to un-comment and edit as needed to
                    // set parameters for custom models.
                    //.setModelLabels(LABELS)
                    //.setIsModelTensorFlow2(true)
                    //.setIsModelQuantized(true)
                    //.setModelInputSize(300)
                    //.setModelAspectRatio(16.0 / 9.0)
                    .build();
            return processor;
        }
        else{
            processor = new TfodProcessor.Builder()
                    .setModelAssetName(SEASON_MODEL)
                    //Load default model for the season
                    // The following default settings are available to un-comment and edit as needed to
                    // set parameters for custom models.
                    //.setModelLabels(LABELS)
                    //.setIsModelTensorFlow2(true)
                    //.setIsModelQuantized(true)
                    //.setModelInputSize(300)
                    //.setModelAspectRatio(16.0 / 9.0)
                    .build();
        }
        TFOD_processor = processor;
        return processor;
    }

    public VisionPortal createVisionPortal(HardwareMap hardwareMap, TfodProcessor processor, String WEBCAM_NAME, boolean live_view){
        VisionPortal.Builder builder = new VisionPortal.Builder();
        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            WebcamName webcamName = hardwareMap.get(WebcamName.class, WEBCAM_NAME);
            builder.setCamera(webcamName);
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }
        builder.enableLiveView(live_view);
        builder.addProcessor(processor);
        return builder.build();
    }

    public TfodProcessor createProcessorFromModel(HardwareMap hardwareMap, String modelPath, ModelType type, String webcamNameString, boolean liveViewEnabled, boolean useDefaultSeasonModel){
        TfodProcessor created_processor;
        if (useDefaultSeasonModel){
            String path = "";
            created_processor = createTFODProcessor(type, path);
        }
        else {
            created_processor = createTFODProcessor(type, modelPath);
        }

        VisionPortal new_portal;
        new_portal = createVisionPortal(hardwareMap, created_processor, webcamNameString, liveViewEnabled);
        portal = new_portal;
        return created_processor;
    }

    public VisionPortal getVisionPortal(){
        //TODO: Figure out if this line causes errors with the initial variable creation
        return portal;
    }

    public String setVisionPortalProcessor(VisionProcessor processor){
        try {
            portal.setProcessorEnabled(processor, true);
        } catch (Exception e) {
            return "Error setting processor: " + e;
        }
        return "Successfully set active processor to processor" + processor.toString();
    }

    public void stopStreaming(){
        portal.stopStreaming();
    }

    public void resumeStreaming(){
        portal.resumeStreaming();
    }

    public List<Recognition> getProcessorRecognitionsList(TfodProcessor processor){
        return processor.getRecognitions();
    }

    public double getRecognitionXCoordinate(Recognition recognition){
        return (recognition.getLeft() + recognition.getRight()) / 2;
    }

    public double getRecognitionYCoordinate(Recognition recognition){
        return (recognition.getTop() + recognition.getBottom()) / 2;
    }

    public void printDetails(Telemetry telemetry, Recognition recognition, double objectX, double objectY){
        telemetry.addData(""," ");
        telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
        telemetry.addData("- Position", "%.0f / %.0f", objectX, objectY);
        telemetry.addData("- Size", "%.0f x %.0f", recognition.getWidth(), recognition.getHeight());
    }

    public void exit(){
        stopStreaming();
    }


}
