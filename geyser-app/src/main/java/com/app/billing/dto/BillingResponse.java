package com.app.billing.dto;

import lombok.Data;

@Data
public class BillingResponse {
    String name;
    Double amount;
    Long duration;
}
