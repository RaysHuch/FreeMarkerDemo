package com.hu.freemarkerlib;

import java.io.File;

import static org.junit.Assert.*;

public class GeneratorTest {

    @org.junit.Test
    public void generate() throws Exception {
        Generator daoGenerator = new Generator();

        daoGenerator.generate("checkTest", "com.example.abc","myFile",11233,"man","Jeck");
    }
}