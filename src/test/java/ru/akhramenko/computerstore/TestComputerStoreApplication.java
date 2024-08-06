package ru.akhramenko.computerstore;

import org.springframework.boot.SpringApplication;

public class TestComputerStoreApplication {

    public static void main(String[] args) {
        SpringApplication.from(ComputerStoreApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
