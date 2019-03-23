import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberToWordsTest {
    private NumberToWords numberToWords;

    @Before
    public void setUp() {
        numberToWords = new NumberToWords();
    }

    @Test
    public void testSingleDigitNumbers() {
        Assert.assertEquals("zero", numberToWords.toWords(0));
        Assert.assertEquals("one", numberToWords.toWords(1));
        Assert.assertEquals("minus one", numberToWords.toWords(-1));
        Assert.assertEquals("nine", numberToWords.toWords(9));
    }

    @Test
    public void testDoubleDigitNumbers() {
        Assert.assertEquals("eleven", numberToWords.toWords(11));
        Assert.assertEquals("fifty", numberToWords.toWords(50));
        Assert.assertEquals("minus fifty", numberToWords.toWords(-50));
        Assert.assertEquals("sixty seven", numberToWords.toWords(67));
        Assert.assertEquals("minus seventy four", numberToWords.toWords(-74));
        Assert.assertEquals("ninety nine", numberToWords.toWords(99));
    }

    @Test
    public void testThreeDigitNumbers() {
        Assert.assertEquals("one hundred", numberToWords.toWords(100));
        Assert.assertEquals("two hundred thirty three", numberToWords.toWords(233));
        Assert.assertEquals("minus two hundred forty four", numberToWords.toWords(-244));
        Assert.assertEquals("five hundred ninety seven", numberToWords.toWords(597));
        Assert.assertEquals("minus seven hundred ninety two", numberToWords.toWords(-792));
        Assert.assertEquals("nine hundred ninety nine", numberToWords.toWords(999));
    }

    @Test
    public void testFourToSixDigitNumbers() {
        Assert.assertEquals("one thousand",
                numberToWords.toWords(1000));
        Assert.assertEquals("two thousand three hundred thirty three",
                numberToWords.toWords(2333));
        Assert.assertEquals("minus two thousand three hundred thirty three",
                numberToWords.toWords(-2333));
        Assert.assertEquals("four thousand five hundred ninety seven",
                numberToWords.toWords(4597));
        Assert.assertEquals("nine thousand nine hundred ninety nine",
                numberToWords.toWords(9999));
        Assert.assertEquals("twelve thousand eight hundred ninety seven",
                numberToWords.toWords(12897));
        Assert.assertEquals("minus twelve thousand eight hundred ninety seven",
                numberToWords.toWords(-12897));
        Assert.assertEquals("nineteen thousand one hundred forty six",
                numberToWords.toWords(19146));
        Assert.assertEquals("twenty thousand",
                numberToWords.toWords(20000));
        Assert.assertEquals("twenty thousand one",
                numberToWords.toWords(20001));
        Assert.assertEquals("fifty six thousand one hundred ninety two",
                numberToWords.toWords(56192));
        Assert.assertEquals("eighty nine thousand seven hundred sixty five",
                numberToWords.toWords(89765));
        Assert.assertEquals("ninety nine thousand nine hundred ninety nine",
                numberToWords.toWords(99999));
        Assert.assertEquals("minus ninety nine thousand nine hundred ninety nine",
                numberToWords.toWords(-99999));
        Assert.assertEquals("one hundred thousand",
                numberToWords.toWords(100000));
        Assert.assertEquals("one hundred fifty nine thousand seven hundred thirty six",
                numberToWords.toWords(159736));
        Assert.assertEquals("one hundred ninety thousand",
                numberToWords.toWords(190000));
        Assert.assertEquals("three hundred thousand",
                numberToWords.toWords(300000));
        Assert.assertEquals("seven hundred eighty five thousand six hundred seventy one",
                numberToWords.toWords(785671));
        Assert.assertEquals("minus seven hundred eighty five thousand six hundred seventy one",
                numberToWords.toWords(-785671));
    }

    @Test
    public void testOverAMillion() {
        Assert.assertEquals("one million",
                numberToWords.toWords(1000000));
        Assert.assertEquals("two million three hundred thirty three thousand eighty five",
                numberToWords.toWords(2333085));
        Assert.assertEquals("minus two million three hundred thirty three thousand eighty five",
                numberToWords.toWords(-2333085));
        Assert.assertEquals("twelve million four hundred sixty five thousand one hundred eighty one",
                numberToWords.toWords(12465181));
        Assert.assertEquals("two hundred sixty five million eight hundred ninety four thousand two hundred sixty two",
                numberToWords.toWords(265894262));
        Assert.assertEquals("minus two hundred sixty five million eight hundred ninety four thousand two hundred sixty two",
                numberToWords.toWords(-265894262));
        Assert.assertEquals("four hundred million",
                numberToWords.toWords(400000000));
        Assert.assertEquals("eight hundred ninety five million seventy three thousand",
                numberToWords.toWords(895073000));
    }

    @Test
    public void testOverABillion() {
        Assert.assertEquals("one billion",
                numberToWords.toWords(1000000000));
        Assert.assertEquals("minus one billion",
                numberToWords.toWords(-1000000000));
        Assert.assertEquals("two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven",
                numberToWords.toWords(Integer.MAX_VALUE));
        Assert.assertEquals("minus two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven",
                numberToWords.toWords(-Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputString() {
        String[] invalidArgs = {"string"};
        numberToWords.parseInput(invalidArgs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputTooManyArgs() {
        String[] invalidArgs = {"1", "2", "3"};
        numberToWords.parseInput(invalidArgs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputLargeNumber() {
        String[] invalidArgs = {"2147483648"};
        numberToWords.parseInput(invalidArgs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputVerySmallNumber() {
        numberToWords.toWords(-2147483648);
        //Integer.MIN_VALUE (=-2147483648) doesn't work because when we try to convert it to a positive number it overflows.
    }

}
