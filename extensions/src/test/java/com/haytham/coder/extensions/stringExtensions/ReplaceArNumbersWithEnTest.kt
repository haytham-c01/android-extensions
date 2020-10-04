package com.haytham.coder.extensions.stringExtensions

import com.haytham.coder.extensions.replaceArNumbersWithEn
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceArNumbersWithEnTest {

    // when: input = ١٢٣٤٥٦٧٨٩ (all arabic numbers)
    // then: return 123456789 (convert them to english)
    @Test
    fun replaceArNumbersWithEn_allArNumbers_returnsAllEnNumbers(){
        // arrange
        val input= "١٢٣٤٥٦٧٨٩"
        // act
        val result= input.replaceArNumbersWithEn()
        // assert
        assertEquals("123456789", result)
    }


    // when: input = randomWord (contains no arabic numbers)
    // then: return randomWord (do nothing)
    @Test
    fun replaceArNumbersWithEn_noArNumbers_returnsInput(){
        // arrange
        val input= "randomWord"
        // act
        val result= input.replaceArNumbersWithEn()
        // assert
        assertEquals(input, result)
    }

    // when: input = random١٢Word (contains alphabetic characters with arabic numbers)
    // then: return random12Word (the same alphabetic characters with english numbers)
    @Test
    fun replaceArNumbersWithEn_arNumbersAtStart_returnsEnNumbersAtStart(){
        // arrange
        val input= "random١٢Word"
        // act
        val result= input.replaceArNumbersWithEn()
        // assert
        assertEquals("random12Word", result)
    }
}