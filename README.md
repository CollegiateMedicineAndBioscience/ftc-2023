# Synergistic Effect

Welcome to the programming repository for the Team 9027 Synergistic Effect (Collegiate School of Medicine and Bioscience)! This repository is open-source, so feel free to download, play around, or contribute. Below is a guide detailing how to get set up with a local version of this code and how to begin using this code with your own bot.

| Table of Contents                                                                 |
| --------------------------------------------------------------------------------- |
| [Getting Started](#getting-started)                                               |
| [Prerequisites](#prerequisites)                                                   |
| [Recommended Tutorials](#recommended-tutorials)                                   |
| [Documentation](#documentation)                                                   |
| [Downloading and Installing](#downloading-and-installing)                         |
| [Sample OpModes](#sample-opmodes)                                                 |
| [Creating Your Own OpModes](#creating-your-own-opmodes)                           |
| [Naming Conventions](#naming-conventions)                                         |
| [Changing the Hardware Mapping](#changing-the-hardware-mapping)                   |
| [Downloading the App to the Control Hub](#downloading-the-app-to-the-control-hub) |
| [Contributing](#contributing)                                                     |

## Getting Started

This repository contains code that is entirely written in Android Studio. As such, there is no possibility for support of the FTC Blocks Online System. However, there is still value in learning how the FTC Blocks Online system works to learn how the code at its base interacts with the robot. It is highly recommended that you learn how Java and how classes interact, as much of the code works through inheritance from the hardware classes that FTC provides to interact with their allowed machinery. For autonomous programming, it is also highly recommended (but not required when you are starting out), to learn about AI training and how Tensorflow learns from the visual data that we can provide using Vuforia (VERY COMPLICATED! NOT REQUIRED! SERIOUSLY, IF YOU'RE NEW, THERE'S LITERALLY NO NEED TO LEARN THIS YET). This repository also uses `git` and GitHub for collaboration, code sharing, and cloud storage. It is almost a hard requirement that you learn how to use `git` and GitHub (IMPORTANT! DO NOT IGNORE!). If you want to learn any of this, tutorials will be included [down below](#recommended-tutorials).

## Prerequisites

This project contains the code to build an entire app from start to finish. Therefore it is very large and contains a lot of different dependencies. DO NOT FEEL INTIMIDATED. Once you have all of them installed onto your computer, they require almost no maintenance and will allow you to work on any aspect of the robotics programming (except Tensorflow, as I said, VERY COMPLICATED). A list of the prerequisite installs are included down below.

- Android Studio - This is an advanced integrated development environment for creating Android apps. This tool is the same tool that professional Android app developers use. It includes a bit of a learning curve before you get used to the software, but is unfortunately required for high-level performance in FTC. Android Studio can be installed [here](https://developer.android.com/studio/), and supports Windows, Linux, ChromeOS, and MacOS.

- Git - This is a shell tools that integrates with GitHub for versioning and checkpointing code. It also allows for merging of different versions of the same file (happens pretty frequently with multiple developers). It you have done programming on your computer before, you may already have Git installed. You can check whether Git is installed by typing `git --version` in CMD (Windows), Terminal (Linux, MacOS), or crosh (ChromeOS). The command should output a version number like this: `git version 2.35.1`. If you do not have git installed, you can install it [here](https://git-scm.com/downloads).

- GitHub - GitHub integrates with Git to provide online support and code-sharing between multiple devices. This is what allows multiple developers to work on the same project (or file) at the same time. It also provides support for Issue tracking and resolution, as well as some basic project management. You will want to [create an account](https://github.com/signup) on GitHub to effectively collaborate and upload code.

## Recommended Tutorials

This is where most of the tutorials required to interact with the app will be linked. This will also include any documentation provided by FTC on their provided classes, as well as some recommended tutorials on Java, Git, and GitHub.

### Java

If you do not already know Java, learning it will be a long process, but it can be done. Java is the fundamental programming language that is used for all programming done through Android Studio and this repository. There are multiple resources that you can use to learn Java, as well as modern documentation that you can use to read up on specific functions that are used in this repository.

Java Tutorials -

- [Java Tutorial for Beginners - Programming with Mosh](https://www.youtube.com/watch?v=eIrMbAQSU34)
- [Derek Banas' Playlist - 1 - 16](https://www.youtube.com/playlist?list=PLE7E8B7F4856C9B19)
- [thenewboston's Playlist](https://www.youtube.com/playlist?list=PLFE2CE09D83EE3E28)
- [FTC Java Tutorials](https://www.youtube.com/playlist?list=PLEuGrYl8iBm7wW9gyxpLDhBJAOWDZid1P) - This is not a set of basic tutorials, this is for programmers who already know Java and want to learn how to interact with the bot.

### Git and GitHub

Git is a relatively simple tool that can be learned relatively quickly. There are some essential thing to learn, such as commiting code and creating branches. Many Git and GitHub tutorials come bundled together, as they are usually used together in projects to provide cloud-based, cooperative, code-development.

Git Tutorials -

- [Git & GitHub Complete Tutorial - Simplilearn](https://www.youtube.com/watch?v=eeuNAIZoWRU)
- [Git & GitHub Crash Course - freeCodeCamp](https://www.youtube.com/watch?v=RGOj5yH7evk)

## Documentation

This is where most of the documentation about the tools that are used by this repository will be linked. This will also include almost all of the relevant documentation provided by FTC through their repository as well. It is highly recommended that you understand how to read through the docs to find what you need (though there is no need to read the entire docs).

- [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)
- [Git Documentation](https://git-scm.com/docs)
- [FTC Technology Information and Resources](https://www.firstinspires.org/resource-library/ftc/technology-information-and-resources)
- [FTC Programming Resources](https://ftc-docs.firstinspires.org/programming_resources/index.html)
- [FTC Control System Online Documentation](https://github.com/FIRST-Tech-Challenge/FtcRobotController/wiki)
- [FTC Java Classes Documentation](https://javadoc.io/doc/org.firstinspires.ftc)

## Downloading and Installing

Before proceding with the steps below, you should have all of the [prerequisites](#prerequisites) listed above already installed on your machine. These steps will also assume that you have a basic understanding of how to navigate a file directory in a terminal.

1. Clone the repository into the desired directory using `git clone https://github.com/C4theBomb/ftc-robotics.git`
2. You can now open the folder named `ftc-robotics` in Android Studio. Gradle will automatically begin downloading any dependencies that you do not already have on your machine.
3. You should now be able to modify the code. The team's code can be found in [/TeamCode/src/main/java/org/firstinspires/ftc/teamcode](TeamCode/src/main/java/org/firstinspires/ftc/teamcode).

## Sample OpModes

This project contains a large selection of Sample OpModes (robot code examples)that you can learn from in [/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples](FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples).

## Creating Your Own OpModes

OpModes are used to define custom operational modes in the control hub. There are two different types of OpModes. The first type, designated by the `@TeleOp` decorator, is used for connecting robot functions to the controllers through the Rev Control Hub. The second type of OpMode, desginated by the decorator `@Autonomous`, is used for the first 30-second period of the competition, and is used to define a sequence of tasks (or an AI operation), that the robot will perform in sequence without input from a human controller. An OpMode is created by inheriting from the `LinearOpMode` or `OpMode`. `LinearOpMode` is the preffered class to inherit from due to `OpMode` padding loop times. `LinearOpMode` includes some essential functions that are neccessary for programming a good OpMode. The `runOpMode` function is declared and will run when the OpMode is selected in the FTC Driver Hub. The `waitForStart` function can be called to pause execution of the OpMode until the driver presses the start button on the Driver Hub. The while-loop which conditionally runs on the `opModeIsActive` function will continue to run until the OpMode is stopped. An example of the opmode and the implementations of each of these functions will be included down below.

```java
@TeleOp(name="Mecanum Drive", group="Bot Centric")
public class BotCentricMecanumWheelDrive extends LinearOpMode {
    /*
     * Declare the bot class instance
     * This instance will include references to all of the motors on the bot as public variables.
     * Bot classes will be stored in the botclasses folder of the teamcode folder.
     */
    Athena robot = new Athena(hardwareMap);

    @Override
    public void runOpMode() {
        /*
         *   Initialization of any specific hardware here.
         */

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        robot.runtime.reset();

        while (opModeIsActive()) {
            /*
             * Write the operational loop for the robot here.
             * This should included any controller inputs and telemetry updates.
             */
        }
    }
}
```

## Naming Conventions

Naming conventions are used to standardize code and make sure that all of the code will work together as expected. Many programming languages have syntaxes that must be followed to not overlap with any native functions, so programming conventions are used across the prorgamming industry to ensure that all code looks similar and programming styles are standardized.

### Packages

Packages are what groups together similar types of files. Names should always be in lowercase. They should also be meaningful and not overlap with any existing packages in the same folder tree. Examples of acceptable package declarations are included down below.

```java
package org.firstinspires.ftc.teamcode.botclasses;
package org.firstinspires.ftc.teamcode;
```

### Classes

Classes are included in all files. Names should be in CamelCase. The class name should be descriptive and dummarize exactly what the program does.

```java
class BotCentricMecanumWheelDrive
class ClawAttachment
```

### Methods

Methods are used inside classes to define functions specific to that class. These will almost always be written in mixed case. Use verbs to describe what custom methods do. Note that all calls are case-sensitive, meaning that capitalization DOES matter.

```java
public static void runOpMode() {}
public static void init() {}
private static Integer randomFunction() {}
```

### Variables

Used to store information for later use. Should always be in mixed case, the names should be unique and describe what the variable represents in the code.

```java
public BNO055IMU imu;
private Integer yPos;
DcMotor leftFrontDrive;
```

## Changing the Hardware Mapping

All of the hardware on the bot needs to have their port numbers mapped to names in the Driver Hub. This is done so that the code can connect to different elements of the bot without needing to have their port numbers references. Instead, they can be referenced like this within the bot class.

```java
leftFrontDrive  = hardwareMap.get(DcMotor.class, "leftFrontDrive");
```

This [tutorial](https://www.youtube.com/watch?v=qm9mcyrjY54) by FTC will walk you through how to configure and change the hardware map for your robot.

## Downloading the App to the Control Hub

This is the last step of getting the code up and running. This will download all of the code onto the Control Hub, which will then feed the code back to the Driver Hub.

1. Navigate to the repository folder in terminal.
2. Ensure that you are on the `main` branch (stable), using the command `git checkout main`.
3. Then download the lastest code from the repository using the command `git pull`.
4. Ensure that the Driver Hub is connected to the wifi network of the Control Hub.
5. Connect the Control Hub to your computer using a USB-C or USB-A cable.
6. Open the `ftc-robotics` folder in Android Studio.
7. At the top right corner, ensure that the build target selected is `TeamCode`, and that the device selected is `FTC Control Hub`.
8. Press the hammer icon to build your code. Wait, as this process may take several minutes depending on the size of your code.
9. Open the Controller App. After you reconnect the device to the Control Hub wifi network, the new OpModes should be visible under the Autonomous or TeleOp menus.

## Contributing

The `main` branch of this repository is locked from direct pushes to keep the code in that branch stable. You will be able to upload new code to the main branch through the use of a pull request (PR). If you do not know what that is, it is highly recommended to follow some of the [tutorials](#git-and-github) listed above. Any new code from contributors will need to be created in a new branch. Please do not merge code between your branch and the branches of other active developers.