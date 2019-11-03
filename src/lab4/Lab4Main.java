package lab4;

import java.text.DecimalFormat;
import java.util.*;

public class Lab4Main {
    public static void main(String[] args) {
        List<List<Integer>> coalitions = Lab4Game.generateCoalitions();
        Map<List<Integer>, Integer> incomes = new HashMap<>();
        incomes.put(coalitions.get(0), 900);
        incomes.put(coalitions.get(1), 850);
        incomes.put(coalitions.get(2), 1200);
        incomes.put(coalitions.get(3), 2000);
        incomes.put(coalitions.get(4), 2400);
        incomes.put(coalitions.get(5), 2500);
        incomes.put(coalitions.get(6), 3600);

        Lab4Game game = new Lab4Game(incomes);

        List<Double> simplifiedIncomes = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Simplified incomes: ");
        for (List<Integer> coalition : coalitions) {
            double simplifiedIncome = game.findSimplifiedIncome(coalition);
            System.out.println(df.format(simplifiedIncome));
            simplifiedIncomes.add(simplifiedIncome);
        }

        System.out.println("Is super additive: " + game.superAdditiveCheck());
        System.out.println("Is significant: " + game.significantCheck());
        System.out.println("Core is not empty: " + game.isCoreNotEmpty(simplifiedIncomes));
    }
}
