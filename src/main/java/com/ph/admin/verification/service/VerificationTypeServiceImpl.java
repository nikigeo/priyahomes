/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.service;

import com.ph.admin.verification.dao.VerificationTypeDao;
import com.ph.admin.verification.model.VerificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationTypeServiceImpl implements VerificationTypeService {

    @Autowired(required = true)
    private VerificationTypeDao verificationTypeDao;


    public Integer insertVerificationType(VerificationType customerVerification) {
        return verificationTypeDao.insertVerificationType(customerVerification);
    }

    public List<VerificationType> getAllVerificationTypes() {
        return verificationTypeDao.getAllVerificationTypes();
    }
}
