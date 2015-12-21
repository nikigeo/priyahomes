/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.controller;

import com.ph.admin.verification.facade.VerificationTypeApiFacade;
import com.ph.admin.verification.model.VerificationType;
import com.ph.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("v1/ph/admin/VerificationType")
public class VerificationTypeController {

    @Autowired(required = true)
    private VerificationTypeApiFacade verificationTypeApiFacade;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public Integer createVerificationType(@RequestBody VerificationType verificationType){

        return verificationTypeApiFacade.insertVerificationType(verificationType);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<VerificationType> getAllVerificationTypes()
    {
        return verificationTypeApiFacade.getAllVerificationTypes();
    }




}