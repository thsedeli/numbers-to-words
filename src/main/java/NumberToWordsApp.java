public class NumberToWordsApp {

    public static void main(String[] args) {
        NumberToWords numberToWords = new NumberToWords();
        int inputNumber;

        try {
            inputNumber = numberToWords.parseInput(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(numberToWords.toWords(inputNumber));
    }
}
