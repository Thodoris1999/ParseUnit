package com.ttyrovou.utils.parse;

public class ParseException extends RuntimeException {

    private ParseUnit failedUnit;

    public ParseException(ParseUnit failedUnit) {
        super(buildErrorLog(failedUnit));
        this.failedUnit = failedUnit;
    }

    public ParseException(Throwable cause, ParseUnit failedUnit) {
        super(buildErrorLog(failedUnit), cause);
        this.failedUnit = failedUnit;
    }

    private static String buildErrorLog(ParseUnit failedUnit) {
        StringBuilder returnString = new StringBuilder("\n").append(failedUnit.get().toString()).append("\n");
        while (!failedUnit.isRoot()) {
            failedUnit = failedUnit.getParent();
            returnString.append(failedUnit.get()).append("\n");
        }
        return returnString.toString();
    }
}
