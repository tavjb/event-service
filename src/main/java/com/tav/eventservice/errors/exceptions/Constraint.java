package com.tav.eventservice.errors.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Constraint {
    START_DATE_AT_OR_BEFORE_END_DATE("End date cannot be before startDate"),
    REQUIRED_ARGUMENTS_MISSING("Missing required fields");

    @Getter
    private final String errorMsg;
}
