package edu.nju.vo;

import edu.nju.model.RiskItem;

/**
 * Created by Utsuho on 16/11/21.
 */
public class StatVO {
    private RiskItem risk;
    private long count;

    public RiskItem getRisk() {
        return risk;
    }

    public void setRisk(RiskItem risk) {
        this.risk = risk;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
