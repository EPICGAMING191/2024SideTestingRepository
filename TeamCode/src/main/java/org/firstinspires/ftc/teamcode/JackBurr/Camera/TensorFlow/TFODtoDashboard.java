package org.firstinspires.ftc.teamcode.JackBurr.Camera.TensorFlow;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;
import com.acmerobotics.dashboard.FtcDashboard;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvCamera.AsyncCameraOpenListener;

import java.util.List;

@TeleOp
public class TFODtoDashboard extends OpMode {
    private OpenCvWebcam webcam;
    private TfodProcessor tfodProcessor;
    private FtcDashboard dashboard;
    private MyOpenCvPipeline pipeline;

    private static final String MODEL_PATH = "CenterStage.tflite";
    private static final String WEBCAM_NAME = "Webcam 1";

    @Override
    public void init() {
        // Initialize the FTC Dashboard
        dashboard = FtcDashboard.getInstance();

        // Initialize TensorFlow processor
        tfodProcessor = new TfodProcessor.Builder()
                .setModelAssetName(MODEL_PATH)
                .build();

        // Initialize and set up the webcam
        webcam = OpenCvCameraFactory.getInstance().createWebcam(
                hardwareMap.get(WebcamName.class, WEBCAM_NAME)
        );

        // Initialize OpenCV pipeline
        pipeline = new MyOpenCvPipeline();
        webcam.setPipeline(pipeline);

        // Open the webcam and start streaming
        webcam.openCameraDeviceAsync(new AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
                // Start streaming to FTC Dashboard
                dashboard.startCameraStream(webcam, 0);
            }

            @Override
            public void onError(int errorCode) {
                telemetry.addData("Camera Error", "Error Code: %d", errorCode);
            }
        });

        // Initialize TensorFlow processor with the webcam pipeline
        webcam.setPipeline(new TfodPipeline(tfodProcessor));
    }

    @Override
    public void loop() {
        // Get the recognitions from TensorFlow
        List<Recognition> recognitions = tfodProcessor.getRecognitions();

        // Process recognitions and send data to telemetry
        for (Recognition recognition : recognitions) {
            telemetry.addData("Label", recognition.getLabel());
            telemetry.addData("Confidence", recognition.getConfidence());
            telemetry.addData("Left", recognition.getLeft());
            telemetry.addData("Top", recognition.getTop());
            telemetry.addData("Right", recognition.getRight());
            telemetry.addData("Bottom", recognition.getBottom());
        }
    }

    @Override
    public void stop() {
        // Stop streaming and cleanup
        if (dashboard != null) {
            dashboard.stopCameraStream();
        }
        if (webcam != null) {
            webcam.stopStreaming();
        }
    }

    // OpenCV Pipeline that integrates TFOD
    public class TfodPipeline extends OpenCvPipeline {
        private TfodProcessor tfodProcessor;

        public TfodPipeline(TfodProcessor tfodProcessor) {
            this.tfodProcessor = tfodProcessor;
        }

        @Override
        public Mat processFrame(Mat input){

            // Process frame with TensorFlow
            //tfodProcessor.processFrame(input); TODO: ERROR IS HERE

            // Return the processed frame
            return input;
        }
    }

    // Example OpenCV Pipeline
    public class MyOpenCvPipeline extends OpenCvPipeline {
        @Override
        public Mat processFrame(Mat input) {
            Mat output = new Mat();
            // Pass through the frame without modification
            input.copyTo(output);
            return output;
        }
    }
}
