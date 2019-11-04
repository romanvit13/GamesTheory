package lab4;

import java.util.*;

class Lab4Game {
    private static final String GENERAL_INCOME_KEY = "1,2,3";
    private Map<String, Integer> incomes;

    Lab4Game(Map<String, Integer> incomes) {
        this.incomes = incomes;
    }

    List<Double> findSimplifiedIncomes() {
        List<Double> simplifiedIncomes = new ArrayList<>();
        for (String key : incomes.keySet()) {
            double income = incomes.get(key);
            double generalIncome = getGeneralIncome();
            double incomeSum = 0;
            String[] coalitions = key.split(",");
            for (String value : coalitions) {
                incomeSum += incomes.get(value);
            }
            double generalIncomeSum = 0;
            for (int i = 1; i <= 3; i++) {
                generalIncomeSum += incomes.get(Integer.toString(i));
            }
            double simplifiedIncome = (income - incomeSum) / (generalIncome - generalIncomeSum);
            simplifiedIncomes.add(simplifiedIncome);
        }
        return simplifiedIncomes;
    }

    boolean superAdditiveCheck() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tempNums = new ArrayList<>(nums);
            tempNums.remove(i);
            int sum = tempNums.stream().reduce(0, Integer::sum);
            int generalIncome = getGeneralIncome();
            if (nums.get(i) + sum > generalIncome)
                return false;
        }

        return true;
    }

    boolean significantCheck() {
        int sum = findSum();
        int generalIncome = getGeneralIncome();
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

    List<Double> findVector(double k) {
        List<Double> vector = new ArrayList<>();
        int generalIncome = getGeneralIncome();
        for (int i = 1; i <= 3; i++) {
            double value = (generalIncome - findSum()) * k + incomes.get(Integer.toString(i));
            vector.add(value);
        }
        return vector;
    }

    double findVectorSum(List<Double> vector) {
        double sum = 0;
        for (double val : vector) {
            sum += val;
        }
        return sum;
    }

    private int findSum() {
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum += incomes.get(Integer.toString(i));
        }
        return sum;
    }

    public int getGeneralIncome() {
        return incomes.get(GENERAL_INCOME_KEY);
    }
}
