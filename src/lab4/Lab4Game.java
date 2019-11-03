package lab4;

import java.util.*;

class Lab4Game {
    private Map<List<Integer>, Integer> incomes;

    Lab4Game(Map<List<Integer>, Integer> incomes) {
        this.incomes = incomes;
    }

    double findSimplifiedIncome(List<Integer> coalition) {
        double income = incomes.get(coalition);
        double generalIncome = incomes.get(Arrays.asList(1, 2, 3));
        double incomeSum = 0;
        for (Integer value : coalition) {
            incomeSum += incomes.get(Collections.singletonList(value));
        }
        double generalIncomeSum = 0;
        for (int i = 1; i <= 3; i++) {
            generalIncomeSum += incomes.get(Collections.singletonList(i));
        }
        return (income - incomeSum) / (generalIncome - generalIncomeSum);
    }

    boolean superAdditiveCheck() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        for (int i=0; i<nums.size(); i++) {
            List<Integer> tempNums = new ArrayList<>(nums);
            tempNums.remove(i);
            int sum = tempNums.stream().reduce(0, Integer::sum);
            int generalIncome = incomes.get(Arrays.asList(1, 2, 3));
            if (nums.get(i) + sum > generalIncome)
                return false;
        }

        return true;
    }

    boolean significantCheck() {
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum += incomes.get(Collections.singletonList(i));
        }
        int generalIncome = incomes.get(Arrays.asList(1, 2, 3));
        return sum < generalIncome;
    }

    boolean isCoreNotEmpty(List<Double> simplifiedIncomes) {
        for (double simplifiedIncome : simplifiedIncomes) {
            if (simplifiedIncome == 0 || simplifiedIncome == 1) {
                continue;
            }

            return simplifiedIncome > 0.5;
        }

        return true;
    }

    static List<List<Integer>> generateCoalitions() {
        List<List<Integer>> coalitions = new ArrayList<>();
        coalitions.add(Collections.singletonList(1));
        coalitions.add(Collections.singletonList(2));
        coalitions.add(Collections.singletonList(3));
        coalitions.add(Arrays.asList(1, 2));
        coalitions.add(Arrays.asList(1, 3));
        coalitions.add(Arrays.asList(2, 3));
        coalitions.add(Arrays.asList(1, 2, 3));
        return coalitions;
    }
}
