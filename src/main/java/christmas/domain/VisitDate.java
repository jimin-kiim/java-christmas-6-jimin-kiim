package christmas.domain;

import christmas.validator.Validator;

public class VisitDate {
    private int visitDate;

    public VisitDate (int visitDate) {
        visitDate = this.visitDate;
        validate(visitDate);
    }

    private void validate (int visitDate) {
        Validator.validateDateRange();
    }
}
