package com.javabase.javatpsafetytnet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JavaTpSafetytNet.class)
class JavaTpSafetytNetTest {

    @Test
    void contextLoads() {
    }

    @Test
    public void mainContextTest() {
        JavaTpSafetytNet.main(new String[] {});
    }
}