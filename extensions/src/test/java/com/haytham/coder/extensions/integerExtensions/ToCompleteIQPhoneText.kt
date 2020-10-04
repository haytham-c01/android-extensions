package com.haytham.coder.extensions.integerExtensions

import com.haytham.coder.extensions.isValidIndex
import com.haytham.coder.extensions.toCompleteIQPhone
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ToCompleteIQPhoneText {

    // when: phone is 10 chars
    // then: append +964 to the start
    @Test
    fun toCompleteIQPhone_10CharsPhone_returnsPhoneWithPlus964(){
        // arrange
        val phone= "1234567899"

        // act
        val result= phone.toCompleteIQPhone()

        // assert
        assertEquals("+964$phone", result)
    }


    // when: phone is 11 chars
    // then: remove first char && append +964 to the start
    @Test
    fun toCompleteIQPhone_11CharsPhone_returnsPhoneMinusFirstCharWithPlus964(){
        // arrange
        val phone= "01234567899"

        // act
        val result= phone.toCompleteIQPhone()

        // assert
        assertEquals("+9641234567899", result)
    }


    // when: phone is 13 chars
    // then: append + to the start
    @Test
    fun toCompleteIQPhone_13CharsPhone_returnsPhoneWithPlus(){
        // arrange
        val phone= "9641234567899"

        // act
        val result= phone.toCompleteIQPhone()

        // assert
        assertEquals("+$phone", result)
    }

    // when: phone is 14 chars
    // then: return same phone
    @Test
    fun toCompleteIQPhone_14CharsPhone_returnsSamePhone(){
        // arrange
        val phone= "+9641234567899"

        // act
        val result= phone.toCompleteIQPhone()

        // assert
        assertEquals(phone, result)
    }

    // when: phone is 15 chars
    // then: remove first to chars && append + to the start
    @Test
    fun toCompleteIQPhone_15CharsPhone_returnsPhoneMinusFirstTwoWithPlus(){
        // arrange
        val phone= "009641234567899"

        // act
        val result= phone.toCompleteIQPhone()

        // assert
        assertEquals("+9641234567899", result)
    }
}