package com.aditya.project.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {

        System.out.println("Example for Simple!");

        // Setting up data in message

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(1)
                .setIsSimple(true)
                .setName("Simple")
                .addAllSampleList(Arrays.asList(1, 2, 3));

        System.out.println(builder.toString());

        // Building the message

        SimpleMessage message = builder.build();

        // Writing to file

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from file

        try {
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
