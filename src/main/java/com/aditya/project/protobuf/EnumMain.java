package com.aditya.project.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {

        System.out.println("Example for Enums!");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(2)
                .setDayOfTheWeek(EnumExample.DayOfTheWeek.MONDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }

}
