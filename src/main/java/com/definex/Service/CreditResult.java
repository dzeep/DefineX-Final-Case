package com.definex.Service;

import lombok.Data;

@Data
public class CreditResult {
    private boolean isApproved;
    private double limit;

    public CreditResult(boolean isApproved, double limit) {
        this.isApproved = isApproved;
        this.limit = limit;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}

    