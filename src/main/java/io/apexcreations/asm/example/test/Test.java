package io.apexcreations.asm.example.test;

import io.apexcreations.asm.ApexStorage;
import io.apexcreations.asm.example.Example;
import io.apexcreations.asm.storage.YamlStorage;
import java.io.FileNotFoundException;

public class Test {
    private static ApexStorage apexStorage = new YamlStorage();
    public static void main(String[] args) {
        Example example = new Example("This is working.");
        System.out.println(example.getUserName());
        try {
            apexStorage.load(example);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(example.getUserName());
    }

}
