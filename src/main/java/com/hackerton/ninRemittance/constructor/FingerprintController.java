package com.hackerton.ninRemittance.constructor;

import com.hackerton.ninRemittance.model.FingerPrintRequest;
import com.hackerton.ninRemittance.model.FingerPrintVerify;
import com.hackerton.ninRemittance.model.ResponseModel;
import com.hackerton.ninRemittance.service.FingerPrintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biometrics")
public class FingerprintController {
    private final FingerPrintService fingerPrintService;

    public FingerprintController(FingerPrintService fingerPrintService) {
        this.fingerPrintService = fingerPrintService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> add(@RequestBody FingerPrintRequest fingerPrintRequest){
        return fingerPrintService.addFingerPrint(fingerPrintRequest);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> verify(@RequestBody FingerPrintVerify fingerPrintVerify){
        return fingerPrintService.verifyThumbPrint(fingerPrintVerify);
    }
}
