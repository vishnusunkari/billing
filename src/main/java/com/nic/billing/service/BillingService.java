package com.nic.billing.service;

import com.nic.billing.model.Billing;

/**
 * @author vishnu.sunkari
 * @created 04/28/2021
 */
public interface BillingService {
    Billing processBilling(Billing billingMsg);
}
