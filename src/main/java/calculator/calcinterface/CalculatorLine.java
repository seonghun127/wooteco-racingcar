package calculator.calcinterface;

import java.util.HashMap;
import java.util.Map;

public class CalculatorLine {
    private Map<String, Operation> operationMap;

    public CalculatorLine() {
        operationMap = new HashMap<>();
        operationMap.put("+", new Plus());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    public int calculateFormula(String[] formula) {
        int result = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            result = operationMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
        }
        return result;
    }
}