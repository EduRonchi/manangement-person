package com.eduardo.manangementperson;

import com.eduardo.manangementperson.domain.entity.Address;
import com.eduardo.manangementperson.domain.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ManangementpersonApplicationTests {

	@Test
	public void testImportPerson() {
		Person person = new Person();
		person.setPersonName("Eduardo");
		person.setBornDate(LocalDate.ofEpochDay(1990-01-01));

		assertEquals("Eduardo", person.getPersonName());
		assertEquals(LocalDate.ofEpochDay(1990-01-01), person.getBornDate());
	}

	@Test
	public void testImportAddress() {
		Address address = new Address();
		address.setStreet("Rua Teste");
		address.setCity("Joinville");

		assertEquals("Rua Teste", address.getStreet());
		assertEquals("Joinville", address.getCity());
	}

}
