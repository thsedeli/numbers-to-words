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
        Assert.assertEquals("nine", numberToWords.toWords(9));
    }

    @Test
    public void testDoubleDigitNumbers() {
        Assert.assertEquals("eleven", numberToWords.toWords(11));
        Assert.assertEquals("fifty", numberToWords.toWords(50));
        Assert.assertEquals("sixty seven", numberToWords.toWords(67));
        Assert.assertEquals("ninety nine", numberToWords.toWords(99));
    }

    @Test
    public void testThreeDigitNumbers() {
        Assert.assertEquals("one hundred", numberToWords.toWords(100));
        Assert.assertEquals("two hundred thirty three", numberToWords.toWords(233));
        Assert.assertEquals("five hundred ninety seven", numberToWords.toWords(597));
        Assert.assertEquals("nine hundred ninety nine", numberToWords.toWords(999));
    }

    @Test
    public void testFourToSixDigitNumbers() {
        Assert.assertEquals("one thousand",
                numberToWords.toWords(1000));
        Assert.assertEquals("two thousand three hundred thirty three",
                numberToWords.toWords(2333));
        Assert.assertEquals("four thousand five hundred ninety seven",
                numberToWords.toWords(4597));
        Assert.assertEquals("nine thousand nine hundred ninety nine",
                numberToWords.toWords(9999));
        Assert.assertEquals("twelve thousand eight hundred ninety seven",
                numberToWords.toWords(12897));
        Assert.assertEquals("nineteen thousand one hundred forty six",
                numberToWords.toWords(19146));
        Assert.assertEquals("twenty thousand",
                numberToWords.toWords(20000));
        Assert.assertEquals("fifty six thousand one hundred ninety two",
                numberToWords.toWords(56192));
        Assert.assertEquals("eighty nine thousand seven hundred sixty five",
                numberToWords.toWords(89765));
        Assert.assertEquals("ninety nine thousand nine hundred ninety nine",
                numberToWords.toWords(99999));
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
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputString() {
        String[] invalidArgs = {"string"};
        numberToWords.validateAndReturnInput(invalidArgs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputTooManyArgs() {
        String[] invalidArgs = {"1", "2", "3"};
        numberToWords.validateAndReturnInput(invalidArgs);
    }
}
