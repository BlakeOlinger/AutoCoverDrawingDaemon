package com.ToppInd;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            // run AutoDimension.appref-ms and wait for process to finish
            var autoDimensionProcess = new ProcessBuilder("cmd.exe", "/c", "AutoDimension.appref-ms").start();
            autoDimensionProcess.waitFor();
            autoDimensionProcess.destroy();

            // wait a few seconds - ProcessBuilder is not synchronized
            Thread.sleep(33_000);

            // run AutoBalloon (sw-test.appref-ms) and wait for process to finish
            var autoBalloonProcess = new ProcessBuilder("cmd.exe", "/c", "sw-test.appref-ms").start();
            autoBalloonProcess.waitFor();
            autoBalloonProcess.destroy();

            // wait a few seconds
            Thread.sleep(6_000);

            // run AutoCenterMark
            var autoCenterMarkProcess = new ProcessBuilder("cmd.exe", "/c", "AutoCenterMark.appref-ms").start();
            autoCenterMarkProcess.waitFor();
            autoCenterMarkProcess.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}