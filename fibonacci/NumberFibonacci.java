package br.com.charles.challenge.fibonacci;

public class NumberFibonacci {

    public boolean checkFibonacci(int number) {
        if (number < 0) {
            return false;
        }

        int previousNumber = 0;
        int currentNumber = 1;
        int result;

        for (int i = 0; i <= number; i++) {
            result = currentNumber + previousNumber;
            previousNumber = currentNumber;
            currentNumber = result;

            if(number == result || number == 0) {
                return true;
            }
        }

        return false;
    }
}


