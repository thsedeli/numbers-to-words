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
