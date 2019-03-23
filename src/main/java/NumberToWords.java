import com.google.common.collect.ImmutableMap;

public class NumberToWords implements NumberToWordsConverter {
    private static final ImmutableMap<Integer, String> baseNumbers = ImmutableMap.<Integer, String>builder()
            .put(0, "zero").put(1, "one").put(2, "two").put(3, "three").put(4, "four").put(5, "five")
            .put(6, "six").put(7, "seven").put(8, "eight").put(9, "nine").put(10, "ten")
            .put(11, "eleven").put(12, "twelve").put(13, "thirteen").put(14, "fourteen").put(15, "fifteen")
            .put(16, "sixteen").put(17, "seventeen").put(18, "eighteen").put(19, "nineteen")
            .put(20, "twenty").put(30, "thirty").put(40, "forty").put(50, "fifty").put(60, "sixty")
            .put(70, "seventy").put(80, "eighty").put(90, "ninety")
            .build();

    public String toWords(int number) {
        StringBuilder numToWords = new StringBuilder();
        int numThousand;

        if (number >= 1000) {
            numThousand = number / 1000;
            numToWords
                    .append(" ")
                    .append(appendBaseNumber(numThousand))
                    .append(" thousand");
            number %= 1000;
        }

        numToWords.append(appendBaseNumber(number));

        return numToWords.toString().trim();
    }

    private String appendBaseNumber(int number) {
        StringBuilder baseNumberToWords = new StringBuilder();
        int numHundred, numTen, numUnit;

        if (number >= 100) {
            numHundred = number / 100;
            baseNumberToWords
                    .append(" ")
                    .append(baseNumbers.get(numHundred))
                    .append(" hundred");
            number %= 100;
        }

        if (number > 0) {
            if (baseNumbers.containsKey(number))
                baseNumberToWords
                        .append(baseNumbers.get(number));
            else {
                numTen = number / 10;
                baseNumberToWords
                        .append(" ")
                        .append(baseNumbers.get(numTen * 10));

                numUnit = number % 10;
                if (numUnit > 0)
                    baseNumberToWords
                            .append(" ")
                            .append(baseNumbers.get(numUnit));
            }
        }
        return baseNumberToWords.toString();
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
