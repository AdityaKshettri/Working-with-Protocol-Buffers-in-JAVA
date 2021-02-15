package com.aditya.project.protobuf;

import example.complex.Complex.DummyMessage;
import example.complex.Complex.ComplexMessage;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {

        System.out.println("Complex Example!");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        DummyMessage dummyMessage = newDummyMessage(1, "Dummy Message");

        builder.setDummy(dummyMessage);
        builder.addAllMultipleDummy(Arrays.asList(newDummyMessage(1, "1 dummy"), newDummyMessage(2, "2 dummy")));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {

        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        return dummyMessageBuilder
                .setId(id)
                .setName(name)
                .build();
    }
}
