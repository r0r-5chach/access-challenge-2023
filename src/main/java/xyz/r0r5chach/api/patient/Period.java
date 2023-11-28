package xyz.r0r5chach.api.patient;

import java.time.LocalDate;

public class Period {
    private LocalDate start, end;

    public Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public Period(LocalDate end) {
        this(LocalDate.now(), end);
    }

    public Period(String start, String end) {
        this(LocalDate.parse(start), LocalDate.parse(end));
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
