package lab4;

import utils.ArrayUtils;

import java.util.*;

public class Lab4Main {
    public static void main(String[] args) {
        Map<String, Integer> incomes = new HashMap<>();
        incomes.put("1", 900);
        incomes.put("2", 850);
        incomes.put("3", 1200);
        incomes.put("1,2", 2000);
        incomes.put("1,3", 2400);
        incomes.put("2,3", 2500);
        incomes.put("1,2,3", 3600);

        ArrayUtils arrayUtils = ArrayUtils.INSTANCE;
        Lab4Game game = new Lab4Game(incomes);

        List<Double> simplifiedIncomes = game.findSimplifiedIncomes();
        arrayUtils.printArrayAndFormat(simplifiedIncomes, "Simplified incomes: ");

        System.out.println("Is super additive: " + game.superAdditiveCheck());
        System.out.println("Is significant: " + game.significantCheck());
        System.out.println("Core is not empty: " + game.isCoreNotEmpty(simplifiedIncomes));
    }
}
