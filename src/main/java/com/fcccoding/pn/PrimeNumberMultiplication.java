package com.fcccoding.pn;

import java.util.*;

public class PrimeNumberMultiplication {

    public static void main(String[] args) {

        boolean x = true;
        PrimeNumberMultiplication m = new PrimeNumberMultiplication();
        while (x) {
            x = m.handleInputs();
        }
    }

    public boolean handleInputs() {
        String input = null;
        System.out.println(" \n \n Enter the number of primes for the table or enter X to exit: ");
        Scanner scanner = new Scanner(System.in);

        input = scanner.next();
        if (input.equalsIgnoreCase("X"))
            return false;
        else if (!input.matches("^[0-9]*$"))
            System.out.println("Not a valid input for total number of primes.");
        else {
            PrimeNumberMultiplication m = new PrimeNumberMultiplication();
            int n = Integer.parseInt(input);
            printMultiplicationTable(n);
        }
        return true;
    }


    public void printMultiplicationTable(int n) {

        System.out.println("Version1 with Lists");
        List<List<Long>> prodList = generatePrimeMultipliersv1(n);
        for (int j = 0; j < prodList.size(); j++) {
            List<Long> temp = prodList.get(j);
            for (int k = 0; k < temp.size(); k++) {
                System.out.format("%5s", temp.get(k));
            }
            System.out.println();
        }

        System.out.println("Version2 with Arrays");
        Long[][] result = generatePrimeMultipliersv2(n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.format("%5s", result[i][j]);
            }
            System.out.println();
        }

        System.out.println("Version3 with Arrays - modified");
        Long[][] result2 = generatePrimeMultipliersv3(n);
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2.length; j++) {
                System.out.format("%5s", result2[i][j]);
            }
            System.out.println();
        }
    }

    public Long[][] generatePrimeMultipliersv3(int n) {
        Long[][] resultArray = new Long[n][n];
        List<Integer> primeList = generatePrimes(n);
        for (int i = 0; i < primeList.size(); i++) {
            resultArray[i][0] = primeList.get(i).longValue();
            for (int j = 1; j < resultArray.length; j++) {
                resultArray[i][j] = Long.valueOf(primeList.get(j) * primeList.get(i));
            }
        }
        return resultArray;
    }

    public Long[][] generatePrimeMultipliersv2(int n) {
        Long[][] resultArray = new Long[n][n];
        List<Integer> primeList = generatePrimes(n);
        for (int i = 0; i < n; i++) {
            resultArray[i][0] = primeList.get(i).longValue();
            resultArray[0][i] = primeList.get(i).longValue();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i <= j) {
                    resultArray[i][j] = resultArray[i][0] * resultArray[0][j];
                    resultArray[j][i] = resultArray[i][j];
                }
            }
        }
        return resultArray;
    }

    public List<List<Long>> generatePrimeMultipliersv1(int n) {
        List<List<Long>> prodList = new LinkedList<>();
        List<Integer> primeList = generatePrimes(n);
        int listIndex = 0;
        int multiplier;
        while (listIndex < n) {
            multiplier = primeList.get(listIndex);
            List<Long> temp = new ArrayList<>();
            for (int i = 0; i < primeList.size(); i++) {
                temp.add(new Long(multiplier * primeList.get(i)));
            }
            prodList.add(listIndex, temp);
            listIndex++;
        }
        return prodList;
    }


    public List<Integer> generatePrimes(int n) {
        List<Integer> primeResult = new LinkedList<>();
        int i = 1;
        while (n != 0) {
            if (isPrime(i)) {
                primeResult.add(i);
                n--;
            }
            i++;
        }
        return primeResult;
    }

    public boolean isPrime(int n) {
        if (n == 1 || n == 2)
            return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
