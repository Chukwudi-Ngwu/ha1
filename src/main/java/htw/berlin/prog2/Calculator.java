package htw.berlin.prog2;

/**
 * Einfacher Wrapper, damit die Tests eine Calculator-Klasse finden.
 * Delegiert an ExpressionEvaluator (bereits angelegt).
 */
public class Calculator {
    public String evaluate(String expr) {
        return ExpressionEvaluator.evaluate(expr);
    }
}