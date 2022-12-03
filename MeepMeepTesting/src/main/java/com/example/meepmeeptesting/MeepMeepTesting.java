package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(39.4224324932042, 39.4224324932042, Math.toRadians(188.22825), Math.toRadians(188.22825), 12)
                .followTrajectorySequence(drive ->
                        /*drive.trajectorySequenceBuilder(new Pose2d(34.5, -64, Math.toRadians(90)))
                                .forward(36)
                                .splineTo(new Vector2d(30, -7), Math.toRadians(135))
                                .back(7.2)
                                .lineToSplineHeading(new Pose2d(58, -12, Math.toRadians(0)))
                                .lineToSplineHeading(new Pose2d(35.5, -12, Math.toRadians(135)))
                                .forward(7.2)
                                .back(7.2)
                                .lineToSplineHeading(new Pose2d(58, -12, Math.toRadians(0)))
                                .lineToSplineHeading(new Pose2d(35.5, -12, Math.toRadians(135)))
                                .forward(7.2)
                                .back(7.2)
                                .lineToSplineHeading(new Pose2d(58, -12, Math.toRadians(0)))
                                .lineToSplineHeading(new Pose2d(35.5, -12, Math.toRadians(135)))
                                .forward(7.2)
                                .back(7.2)
                                .lineToSplineHeading(new Pose2d(58, -12, Math.toRadians(0)))
                                .lineToSplineHeading(new Pose2d(35.5, -12, Math.toRadians(135)))
                                .forward(7.2)
                                .back(7.2)
                                .lineToSplineHeading(new Pose2d(12, -12, Math.toRadians(180)))
                                .build()*/
                        drive.trajectorySequenceBuilder(new Pose2d(-34.5, -64, Math.toRadians(90)))
                                .forward(52)
                                .strafeRight(22)
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}