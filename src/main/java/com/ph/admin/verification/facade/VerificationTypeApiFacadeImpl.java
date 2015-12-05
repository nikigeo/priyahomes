/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.facade;

import com.ph.admin.verification.model.VerificationType;
import com.ph.admin.verification.service.VerificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class VerificationTypeApiFacadeImpl implements VerificationTypeApiFacade {

    @Autowired(required = true)
    private VerificationTypeService verificationService;


    public Integer insertVerificationType(VerificationType customerVerification) {
        return verificationService.insertVerificationType(customerVerification);
    }

    public List<VerificationType> getAllVerificationTypes() {
        return verificationService.getAllVerificationTypes();
    }
}
