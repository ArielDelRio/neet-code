package arrayshashing.stringencodeanddecode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringEncodeAndDecodeTest {

    private final StringEncodeAndDecode solution = new StringEncodeAndDecode();

    @Test
    void shouldRoundTripExampleInput() {
        List<String> input = List.of("Hello", "World");

        String encoded = solution.encode(input);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded: " + decoded);

        assertIterableEquals(input, decoded);
    }

    @Test
    void shouldRoundTripSingleEmptyString() {
        List<String> input = List.of("");

        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);

        assertIterableEquals(input, decoded);
    }

    @Test
    void shouldRoundTripEmptyList() {
        List<String> input = List.of();

        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);

        assertEquals("", encoded);
        assertIterableEquals(input, decoded);
    }

    @Test
    void shouldRoundTripStringsContainingSpecialCharacters() {
        List<String> input = List.of("a#b", "12:34", "[]{}()", " ", "line1\\nline2");

        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);

        assertIterableEquals(input, decoded);
    }

    @Test
    void shouldRoundTripMixedLengths() {
        List<String> input = List.of("a", "", "longer-text-value", "xyz", "0");

        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);

        assertIterableEquals(input, decoded);
    }

    @Test
    void shouldProduceDeterministicEncodingForSameInput() {
        List<String> input = List.of("repeat", "values", "123");

        String encoded1 = solution.encode(input);
        String encoded2 = solution.encode(input);

        assertEquals(encoded1, encoded2);
    }
}
