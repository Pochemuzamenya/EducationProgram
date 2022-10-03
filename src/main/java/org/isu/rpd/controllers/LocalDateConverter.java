package org.isu.rpd.controllers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String sDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(String.valueOf(DateTimeFormat.ISO.DATE_TIME));
        LocalDate date = LocalDate.parse(sDate, formatter);
        return date;
    }
}