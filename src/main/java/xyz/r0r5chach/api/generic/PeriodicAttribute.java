package xyz.r0r5chach.api.generic;

import xyz.r0r5chach.api.patient.Period;

public class PeriodicAttribute {
    protected Period period;

    public PeriodicAttribute(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }
}
