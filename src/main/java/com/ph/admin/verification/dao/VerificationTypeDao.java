package com.ph.admin.verification.dao;

import com.ph.admin.verification.model.VerificationType;

import java.util.List;

public interface VerificationTypeDao {

    public Integer insertVerificationType(VerificationType verificationType);
    List<VerificationType> getAllVerificationTypes();

}
