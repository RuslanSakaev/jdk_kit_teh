package org.example.hw.hw4;

import java.io.Serializable;

public record Employee(int employeeId, String phoneNumber, String name, int experience) implements Serializable {
}
