/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.facade;

import com.ph.admin.verification.model.VerificationType;

import java.util.List;

public interface VerificationTypeApiFacade {

    public Integer insertVerificationType(VerificationType customerVerification);

    List<VerificationType> getAllVerificationTypes();



}
