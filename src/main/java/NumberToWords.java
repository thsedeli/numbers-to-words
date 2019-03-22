import com.google.common.collect.ImmutableMap;

public class NumberToWords implements NumberToWordsConverter {
    private static final ImmutableMap<Integer, String> baseNumbers = ImmutableMap.<Integer, String>builder()
            .put(0, "zero") .put(1, "one") .put(2, "two") .put(3, "three") .put(4, "four") .put(5, "five")
            .put(6, "six")  .put(7, "seven") .put(8, "eight") .put(9, "nine") .put(10, "ten")
            .put(11, "eleven")  .put(12, "twelve") .put(13, "thirteen") .put(14, "fourteen").put(15, "fifteen")
            .put(16, "sixteen") .put(17, "seventeen") .put(18, "eighteen") .put(19, "nineteen")
            .put(20, "twenty") .put(30, "thirty") .put(40, "fourty") .put(50, "fifty") .put(60, "sixty")
            .put(70, "seventy") .put(80, "eighty") .put(90, "ninety")
            .build();

    public String toWords(int number) {
        StringBuilder numToWords = new StringBuilder();

        if (number < 10) {
            numToWords.append(baseNumbers.get(number));
        }

        if (number < 100) {
            if (baseNumbers.containsKey(number))
                numToWords.append(baseNumbers.get(number));

            numToWords.append(baseNumbers.get(number % 10));
            //numToWords.append(baseNumbers.get(number % 10));
        }

        return numToWords.toString();
    }

    public int validateAndReturnInput(String[] args) {
        int inputNumber;

        if (args.length == 0 || args.length > 1)
            throw new IllegalArgumentException("Wrong arguments - Please just pass one integer number as argument");

        try {
            inputNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong arguments - Please just pass one integer number as argument");
        }

        return inputNumber;
    }
}
