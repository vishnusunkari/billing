package com.nic.billing.controller;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.nic.billing.model.Billing;
import com.nic.billing.service.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author vishnu.sunkari
 * @created 04/27/2021
 */
@RestController
@XRayEnabled
@Slf4j
public class BillingController {


    @Autowired
    @Qualifier("xRayRestTemplate")
    private RestTemplate restTemplate;

    /*@Value("${MEMBERSHIP_URI:http://localhost:8080}")
    private String membershipHost;*/

    @Autowired
    BillingService billingService;

    @PostMapping(path = "/v1/process", consumes = "application/json", produces="application/json")
    public Billing processBilling(@RequestBody Billing billingMsg, HttpServletRequest request) {

        log.info("BillingController.processBilling start");
        billingMsg = billingService.processBilling(billingMsg);
        return billingMsg;
    }

}