package com.fabiankevin.pet.petservice;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.Port;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@KubernetesApplication(
        ports = @Port(name = "http", containerPort = 2200),
        labels = @Label(key = "version", value = "v1"),
        expose = false
)
public class PetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetServiceApplication.class, args);
    }

}
