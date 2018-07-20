package com.hackerton.ninRemittance.service;

import com.hackerton.ninRemittance.dao.FingerprintDao;
import com.hackerton.ninRemittance.model.*;
import com.hackerton.ninRemittance.utils.FingerPrintVerifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Service
public class FingerPrintService {
    private final FingerprintDao fingerprintDao;
    private final UserService userService;

    public FingerPrintService(FingerprintDao fingerprintDao, UserService userService) {
        this.fingerprintDao = fingerprintDao;
        this.userService = userService;
    }

    public ResponseEntity<ResponseModel> addFingerPrint(FingerPrintRequest fingerPrintRequest){
        try {

            UserDetails userDetails = userService.findByNin(fingerPrintRequest.getNin());

            Fingerprint fingerprint = new Fingerprint();
            fingerprint.setUserDetails(userDetails);

            fingerprint.setPhoto0(Base64.getDecoder().decode(fingerPrintRequest.getPhoto0().getBytes("UTF-8")));
            fingerprint.setPhoto1(Base64.getDecoder().decode(fingerPrintRequest.getPhoto1().getBytes("UTF-8")));
            fingerprint.setPhoto2(Base64.getDecoder().decode(fingerPrintRequest.getPhoto2().getBytes("UTF-8")));
            fingerprint.setPhoto3(Base64.getDecoder().decode(fingerPrintRequest.getPhoto3().getBytes("UTF-8")));
            fingerprint.setPhoto4(Base64.getDecoder().decode(fingerPrintRequest.getPhoto4().getBytes("UTF-8")));
            fingerprint.setPhoto5(Base64.getDecoder().decode(fingerPrintRequest.getPhoto5().getBytes("UTF-8")));
            fingerprint.setPhoto6(Base64.getDecoder().decode(fingerPrintRequest.getPhoto6().getBytes("UTF-8")));
            fingerprint.setPhoto7(Base64.getDecoder().decode(fingerPrintRequest.getPhoto7().getBytes("UTF-8")));
            fingerprint.setPhoto8(Base64.getDecoder().decode(fingerPrintRequest.getPhoto8().getBytes("UTF-8")));
            fingerprint.setPhoto9(Base64.getDecoder().decode(fingerPrintRequest.getPhoto9().getBytes("UTF-8")));

            fingerprintDao.save(fingerprint);
            return new ResponseEntity<>(new ResponseModel("00", "Success", "Success"), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return new ResponseEntity<>(new ResponseModel("99", "Failed", "Failed"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseModel> verifyThumbPrint(FingerPrintVerify fingerPrintVerify){
        try {
            UserDetails userDetails = userService.findByNin(fingerPrintVerify.getNin());
            Fingerprint fingerprint = fingerprintDao.findByUserDetails(userDetails);

            byte[] probeImage = Base64.getDecoder().decode(fingerPrintVerify.getImage().getBytes("UTF-8"));
            byte[] candidateImage = null;

            switch (fingerPrintVerify.getPosition()){
                case 0:
                    candidateImage = fingerprint.getPhoto0();
                    break;
                case 1:
                    candidateImage = fingerprint.getPhoto1();
                    break;
                case 2:
                    candidateImage = fingerprint.getPhoto2();
                    break;
                case 3:
                    candidateImage = fingerprint.getPhoto3();
                    break;
                case 4:
                    candidateImage = fingerprint.getPhoto4();
                    break;
                case 5:
                    candidateImage = fingerprint.getPhoto5();
                    break;
                case 6:
                    candidateImage = fingerprint.getPhoto6();
                    break;
                case 7:
                    candidateImage = fingerprint.getPhoto7();
                    break;
                case 8:
                    candidateImage = fingerprint.getPhoto8();
                    break;
                case 9:
                    candidateImage = fingerprint.getPhoto9();
                    break;

                default:
                    break;
            }

            if(FingerPrintVerifier.verify(probeImage, candidateImage))
                return new ResponseEntity<>(new ResponseModel("00", "Success", "{\"verificationStatus\" : \"Valid\"}"), HttpStatus.OK);
            else
                return new ResponseEntity<>(new ResponseModel("91", "Success", "{\"verificationStatus\" : \"Invalid\"}"), HttpStatus.NOT_FOUND);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseModel("00", "Failed", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
