class Solution {

    private final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                String words = convert(part);

                if (!thousands[index].isEmpty()) {
                    words += " " + thousands[index];
                }

                result.insert(0, words + " ");
            }

            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }

    private String convert(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            return tens[num / 10] +
                (num % 10 != 0 ? " " + convert(num % 10) : "");
        }

        return belowTwenty[num / 100] + " Hundred" +
            (num % 100 != 0 ? " " + convert(num % 100) : "");
    }
}
