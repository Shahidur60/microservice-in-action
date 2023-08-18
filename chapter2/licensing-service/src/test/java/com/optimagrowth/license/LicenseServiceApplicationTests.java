package com.optimagrowth.license;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({ "classpath:db/drop_schema.sql", "classpath:db/schema.sql" })
@Sql(scripts = "classpath:db/data.sql")
class LicenseServiceApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void personInfoTest() {
		System.out.println("!!!-----------Test 1 Person Information-------------------!!!");
		List<Map<String, Object>> persons = jdbcTemplate.queryForList("SELECT * FROM PERSON");
//		assertEquals(3, person.size());
		for (Object person: persons
			 ) {
			System.out.println(person);
		}

		System.out.println("!!!-----------Test 1 ENDS-------------------!!!");
		System.out.println();
	}

	@Test
	public void ReportInfoTest() {
		System.out.println("!!!-----------Test 2 Report for Organization-------------------!!!");
		List<Map<String, Object>> persons = jdbcTemplate.queryForList
				("SELECT ORGANIZATION.ORG_ID,ORGANIZATION.NAME, COUNT(PERSON.PERSON_ID) FROM ORGANIZATION JOIN MEMBERS on (ORGANIZATION.ORG_ID=MEMBERS.ORG_ID) JOIN PERSON on (PERSON.PERSON_ID=MEMBERS.PERSON_ID) GROUP BY ORGANIZATION.ORG_ID");
//		assertEquals(3, person.size());
//		for (Object person: persons
//		) {
		for(int i = 0; i< persons.size(); i++) {
			System.out.println( "Organization Name: "+ persons.get(i).get("NAME")+ " "+" AND "+"Total Student: "+ persons.get(i).get("COUNT(PERSON.PERSON_ID)"));
//			}
//			System.out.println(person.toString());
//		}
		}
		System.out.println("!!!-----------Test 2 ENDS-------------------!!!");
	}

}
