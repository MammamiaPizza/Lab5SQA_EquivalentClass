package com.cp.shiftCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.cp.shiftCipher.ShiftCipher;


public class TestShiftCipher {
   
	ShiftCipher TestObject = new ShiftCipher();
	

	@ParameterizedTest
	@DisplayName("Test Encript")
	@CsvFileSource(resources = "/com/cp/shiftCipher/testResource/testEncriptData.csv")
	public void EncriptionTest(String plainText, int key, String expectedResult) {
		assertEquals(expectedResult, TestObject.encrypt(plainText, key));
	}
	
	
	
	
  @ParameterizedTest
  @DisplayName("Test Decript")
  @CsvFileSource(resources = "/com/cp/shiftCipher/testResource/testDecriptData.csv")
  public void DecriptionTest(String cipherText, int key, String expectedResult) {
    assertEquals(expectedResult, TestObject.decrypt(cipherText, key));
  }
}
