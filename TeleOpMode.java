package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by yasnara on 10/13/17.
 */

@TeleOp(name = "TeleOpMode", group = "Tutorials")

public class TeleOpMode extends LinearOpMode
{
    private DcMotor moterLeft;
    private DcMotor motorRight;
    private Servo armServo;
    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;

    @Override
    public void runOpMode() throws InterruptedException
    {
        //TODO: Find the name of the motors
        moterLeft = hardwareMap.dcMotor.get("left_drive");
        motorRight = hardwareMap.dcMotor.get("right_drive");

        moterLeft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get("armServo");

        waitForStart();

        while(opModeIsActive())
        {
            moterLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            if(gamepad2.a)
        {
            armServo.setPosition(ARM_EXTENDED_POSITION);
        }

            if(gamepad2.b)
            {
                armServo.setPosition(ARM_RETRACTED_POSITION );
            }

            idle();
        }
    }
}