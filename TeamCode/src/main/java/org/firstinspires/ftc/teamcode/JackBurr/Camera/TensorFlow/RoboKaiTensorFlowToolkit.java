package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

public class RoboKaiTensorFlowToolkit {
    public HardwareMap hardwareMap;
    public TfodProcessor TFOD_processor;

    public RoboKaiTensorFlowToolkit(HardwareMap hardware_map){
        hardwareMap = hardware_map;
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
        else{
            processor = new TfodProcessor.Builder()
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

    public VisionPortal createVisionPortal(TfodProcessor processor, String WEBCAM_NAME, boolean live_view){
        VisionPortal.Builder builder = new VisionPortal.Builder();
        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, WEBCAM_NAME));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }
        builder.enableLiveView(live_view);
        builder.addProcessor(processor);
        return builder.build();
    }

    public TfodProcessor createProcessorFromModel(String modelPath, ModelType type, String webcamNameString, boolean liveViewEnabled, boolean useDefaultSeasonModel){
        TfodProcessor created_processor;
        if (useDefaultSeasonModel){
            String path = "";
            created_processor = createTFODProcessor(type, path);
        }
        else {
            created_processor = createTFODProcessor(type, modelPath);
        }
        VisionPortal portal = createVisionPortal(created_processor, webcamNameString, liveViewEnabled);
        return created_processor;
    }
}
