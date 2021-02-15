package com.aditya.project.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;

import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        System.out.println("Example for Simple!");

        // Setting up data in message

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(1)
                .setIsSimple(true)
                .setName("Simple")
                .addAllSampleList(Arrays.asList(1, 2, 3));

        // Converting to JSON

        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        // JSON to Message

        SimpleMessage.Builder builder1 = SimpleMessage.newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder1);

        System.out.println(builder1);
    }
}
