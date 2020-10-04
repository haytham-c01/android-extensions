package com.haytham.coder.extensions.integerExtensions

import com.haytham.coder.extensions.isValidIndex
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsValidIndexTest {

    // when: index is -5
    // then: return false
    @Test
    fun isValidIndex_indexNegative5_returnsFalse(){
        // arrange
        val index= -5

        // act
        val result= index.isValidIndex()

        // assert
        assertFalse(result)
    }

    // when: index is -1 (minimum bound)
    // then: return false
    @Test
    fun isValidIndex_indexNegative1_returnsFalse(){
        // arrange
        val index= -1
        // act
        val result= index.isValidIndex()

        // assert
        assertFalse(result)
    }

    // when: index is 5
    // then: return true
    @Test
    fun isValidIndex_indexPositive5_returnsTrue(){
        // arrange
        val index= 5

        // act
        val result= index.isValidIndex()

        // assert
        assertTrue(result)
    }

    // when: index is 5 && size = 10
    // then: return true
    @Test
    fun isValidIndex_indexPositive5AndSizePos10_returnsTrue(){
        // arrange
        val index= 5
        val size= 10

        // act
        val result= index.isValidIndex(size= size)

        // assert
        assertTrue(result)
    }

    // when: index == size == 5
    // then: return false
    @Test
    fun isValidIndex_indexAndSizePos5_returnsFalse(){
        // arrange
        val index= 5

        // act
        val result= index.isValidIndex(size= index)

        // assert
        assertFalse(result)
    }

    // when: index = 15,  size = 10 (index > size)
    // then: return false
    @Test
    fun isValidIndex_index15Size10_returnsFalse(){
        // arrange
        val index= 15
        val size= 10

        // act
        val result= index.isValidIndex(size= size)

        // assert
        assertFalse(result)
    }
}