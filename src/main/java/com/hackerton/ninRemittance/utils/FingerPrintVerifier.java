package com.hackerton.ninRemittance.utils;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FingerPrintVerifier {

    public static boolean verify(byte[] probeImage, byte[] candidateImage){
        boolean matches = false;
        try {
//            byte[] probeImage = Files.readAllBytes(Paths.get("probe.jpeg"));
//            byte[] candidateImage = Files.readAllBytes(Paths.get("candidate.jpeg"));
            FingerprintTemplate probe = new FingerprintTemplate()
                    .dpi(500)
                    .create(probeImage);
            FingerprintTemplate candidate = new FingerprintTemplate()
                    .dpi(500)
                    .create(candidateImage);
            double score = new FingerprintMatcher()
                    .index(probe)
                    .match(candidate);
            matches = score >= 40;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return matches;
        }
    }
}
