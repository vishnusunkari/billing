package com.nic.billing.service;

import com.nic.billing.model.Billing;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author vishnu.sunkari
 * @created 04/28/2021
 */
@Service
public class BillingServiceImpl implements BillingService{
    @Override
    public Billing processBilling(Billing billingMsg) {
        billingMsg.setBilledDate((new Date()).toString());
        billingMsg.setBillingStatus("Done");
        return billingMsg;
    }
}
