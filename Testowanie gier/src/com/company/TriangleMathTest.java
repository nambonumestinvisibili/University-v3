package com.company;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleMathTest {

    TriangleMath triangleMath = new TriangleMath();

    @ParameterizedTest
    @MethodSource("generateValidPoints")
    void canExistsTest(Point a, Point b, Point c){
        assertTrue(triangleMath.canExist(a,b,c));
    }

    private static Stream<Arguments> generateValidPoints() {
        return Stream.of(
                Arguments.of(new Point(0,0), new Point(1,1), new Point(3,4)),
                Arguments.of(new Point(10,12), new Point(3,4), new Point(7,3)),
                Arguments.of(new Point(-2,-1), new Point(0,0), new Point(7,7)),
                Arguments.of(new Point(-3,-3), new Point(100,1), new Point(121,1)),
                Arguments.of(new Point(-4,-4), new Point(134,12), new Point(1000,1000)),
                Arguments.of(new Point(-5,-5), new Point(78,54), new Point(34,65)),
                Arguments.of(new Point(-6,-6), new Point(21,67), new Point(32, 56)),
                Arguments.of(new Point(0,0), new Point(95,32), new Point(11,11)),
                Arguments.of(new Point(3,3), new Point(1472,0), new Point(12,13))
        );
    }

    @Test
    void cantExist(){
        assertFalse(triangleMath.canExist(new Point(0,0), new Point(1,1), new Point(2,2)));
    }

    @Test
    void getTriangleTypeTest(){
        assertEquals(triangleMath.getTriangleType(new Point(0,0),
                new Point(10, 15), new Point(-3,4)), "Roznoboczny");

        assertEquals(triangleMath.getTriangleType(new Point(1,0),
                new Point(0, 5), new Point(-1,0)), "Rownoramienny");

        assertEquals(triangleMath.getTriangleType(new Point(0,0),
                new Point(6, 0), new Point(3,3*Math.sqrt(3))), "Rownoboczny");

    }

    @TestFactory
    Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
                DynamicTest.dynamicTest("shouldBeEquilateral", () -> {
                    assertEquals(triangleMath.getTriangleType(new Point(0,0),
                            new Point(10, 15), new Point(-3,4)), "Roznoboczny");

                }),
                DynamicTest.dynamicTest("shouldBeIsosceles", () -> {
                    assertEquals(triangleMath.getTriangleType(new Point(1,0),
                            new Point(0, 5), new Point(-1,0)), "Rownoramienny");

                }),
                DynamicTest.dynamicTest("shouldBeScalene", () -> {
                    assertEquals(triangleMath.getTriangleType(new Point(0,0),
                            new Point(6, 0), new Point(3,3*Math.sqrt(3))), "Rownoboczny");
                })
        );
    }
}