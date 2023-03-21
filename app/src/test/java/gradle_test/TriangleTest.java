package gradle_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTest {
    @Test
    @DisplayName("输入错误")
    void parameters_error_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(0, 4, 5);
        assertEquals("输入错误", type);
    }
    @Test
    @DisplayName("不等边三角形")
    void scalene_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(3, 4, 6);
        assertEquals("不等边三角形", type);
    }
    @ParameterizedTest
    @CsvSource({
            "1,2,3,非三角形",
            "-1,2,3,输入错误"
    })
    void testWithCsvSource(int a,int b,int c,String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a,b,c));
    }

    @DisplayName(value="一般边界值方法")
    @ParameterizedTest
    @CsvFileSource(resources = "/normal.csv")
    void normal_csv_file_source(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a,b,c));
    }

    @DisplayName(value="健壮性边界值方法")
    @ParameterizedTest
    @CsvFileSource(resources = "/strong.csv")
    void strong_csv_file_source(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a,b,c));
    }

    @DisplayName(value="最坏一般边界值方法")
    @ParameterizedTest
    @CsvFileSource(resources = "/worst_normal.csv")
    void worst_normal_csv_file_source(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a,b,c));
    }

    @DisplayName(value="最坏健壮性边界值方法")
    @ParameterizedTest
    @CsvFileSource(resources = "/worst_strong.csv")
    void worst_strong_csv_file_source(int a, int b, int c, String expected) {
        Triangle triangle = new Triangle();
        assertEquals(expected, triangle.classify(a,b,c));
    }
}