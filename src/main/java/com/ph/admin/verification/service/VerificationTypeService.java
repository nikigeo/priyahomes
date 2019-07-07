/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.service;

import com.ph.admin.verification.model.VerificationType;

import java.util.List;


public interface VerificationTypeService {

    public Integer insertVerificationType(VerificationType customerVerification);

    List<VerificationType> getAllVerificationTypes();


}
