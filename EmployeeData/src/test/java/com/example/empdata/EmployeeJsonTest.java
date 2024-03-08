package com.example.empdata;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
class EmployeeJsonTest {

	@Autowired
    private JacksonTester<Employee> json;
	
	@Test
    void employeeSerializationTest() throws IOException {
        Employee employee = new Employee(12,"jane");
        assertThat(json.write(employee)).isStrictlyEqualToJson("single.json");
        assertThat(json.write(employee)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(employee)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(12);
        assertThat(json.write(employee)).hasJsonPathStringValue("@.name");
        assertThat(json.write(employee)).extractingJsonPathStringValue("@.name")
                .isEqualTo("jane");
        
    }

}
