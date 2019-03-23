import com.google.common.collect.ImmutableMap;

public class NumberToWords implements NumberToWordsConverter {
    private static int ZERO = 0;
    private static int ONE = 1;
    private static int MINUS_ONE = -1;
    private static int TEN = 10;
    private static int ONE_HUNDRED = 100;
    private static int ONE_THOUSAND = 1000;
    private static int ONE_MILLION = 1000000;
    private static int ONE_BILLION = 1000000000;

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
        int numThousand, numMillion, numBillion;

        if (Math.signum(number) == MINUS_ONE) {
            numToWords.append("minus");
            if (number > Integer.MIN_VALUE)
                number = Math.abs(number);
            else
                throw new IllegalArgumentException("Wrong arguments - Please just pass one integer number between -2147483647 and 2147483647");
        }

        if (number == ZERO)
            numToWords.append(baseNumbers.get(number));

        if (number >= ONE_BILLION) {
            numBillion = number / ONE_BILLION;
            numToWords
                    .append(appendBaseNumber(numBillion))
                    .append(" billion");
            number %= ONE_BILLION;
        }

        if (number >= ONE_MILLION) {
            numMillion = number / ONE_MILLION;
            numToWords
                    .append(appendBaseNumber(numMillion))
                    .append(" million");
            number %= ONE_MILLION;
        }

        if (number >= ONE_THOUSAND) {
            numThousand = number / ONE_THOUSAND;
            numToWords
                    .append(appendBaseNumber(numThousand))
                    .append(" thousand");
            number %= ONE_THOUSAND;
        }

        numToWords.append(appendBaseNumber(number));

        return numToWords.toString().trim();
    }

    private String appendBaseNumber(int number) {
        StringBuilder baseNumberToWords = new StringBuilder();
        int numHundred, numTen, numUnit;

        if (number >= ONE_HUNDRED) {
            numHundred = number / ONE_HUNDRED;
            baseNumberToWords
                    .append(" ")
                    .append(baseNumbers.get(numHundred))
                    .append(" hundred");
            number %= ONE_HUNDRED;
        }

        if (number > ZERO) {
            if (baseNumbers.containsKey(number))
                baseNumberToWords
                        .append(" ")
                        .append(baseNumbers.get(number));
            else {
                numTen = number / TEN;
                baseNumberToWords
                        .append(" ")
                        .append(baseNumbers.get(numTen * TEN));

                numUnit = number % TEN;
                if (numUnit > ZERO)
                    baseNumberToWords
                            .append(" ")
                            .append(baseNumbers.get(numUnit));
            }
        }
        return baseNumberToWords.toString();
    }

    public int parseInput(String[] args) {
        int inputNumber;

        if (args.length == ZERO || args.length > ONE)
            throw new IllegalArgumentException("Wrong arguments - Please just pass one integer number as argument");

        try {
            inputNumber = Integer.parseInt(args[ZERO]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong arguments - Please just pass one integer number between -2147483647 and 2147483647");
        }

        return inputNumber;
    }
}
