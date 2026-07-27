package com.cp.compelition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class TestCompetition {
	
	CompetitionScore TestObject = new CompetitionScore();
    
	@DisplayName("Test3Input")
    @ParameterizedTest(name = "[{index}] {0} -> Input: {1} Expect {2}") // กำหนดรูปแบบชื่อแต่ละรอบ
    @CsvFileSource(resources = "/com/cp/compelition/TestData/testCompelitionData.csv")
    void Test3input(String testCaseId, String value, Object expected) {
		int[] scores = Arrays.stream(value.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
		
		if (expected.toString().matches("\\d+")) {
			int expectedinteger = Integer.parseInt(expected.toString());
			assertEquals(expectedinteger , TestObject.findMaxScore(scores));
	        assertEquals(expectedinteger , TestObject.findMaxScore(scores[0], scores[1], scores[2]));
		}
		else {
	        assertEquals(expected , TestObject.findMaxScore(scores));
	        assertEquals(expected , TestObject.findMaxScore(scores[0], scores[1], scores[2]));
		}
    }
	
	
	@Test
	@DisplayName("Test Unit TC006 input over 3")
	void testCaseTC006() {
		//assertThrows("Attempt Over than 3" , TestObject.findMaxScore(1, 2, 3, 4));
		assertEquals("Attempt Over than 3", TestObject.findMaxScore(new int[] {1,2,3,4}));
	}
	
	@Test
	@DisplayName("Test Unit TC007 input Less than 3")
	void testCaseTC007() {
		//assertThrows("Attempt Over than 3" , TestObject.findMaxScore(1, 2, 3, 4));
		assertEquals("Attempt Lower than 3", TestObject.findMaxScore(new int[] {11,12}));
	}
	
}

