package com.example.service.adoption;

import org.springframework.data.annotation.Id;

public record Dog(@Id Integer id, String name, String breed, int age) {
}
