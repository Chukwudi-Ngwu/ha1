package htw.berlin.prog2;

import java.math.BigDecimal;
import java.util.*;

public class ExpressionEvaluator {

    public static String evaluate(String expr) {
        try {
            Queue<String> rpn = toRPN(expr);
            BigDecimal res = evalRPN(rpn);
            return res.stripTrailingZeros().toPlainString();
        } catch (Exception e) {
            return "Error";
        }
    }

    private static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        char[] a = s.replaceAll("\\s+","").toCharArray();
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if ((c >= '0' && c <= '9') || c == '.') {
                num.append(c);
            } else {
                if (num.length() > 0) { tokens.add(num.toString()); num.setLength(0); }
                if (c == '-' && (i == 0 || "+-*/(^".indexOf(a[i-1]) >= 0 || a[i-1] == '(')) {
                    StringBuilder nextNum = new StringBuilder("-");
                    i++;
                    while (i < a.length && ((a[i]>='0'&&a[i]<='9')||a[i]=='.')) nextNum.append(a[i++]);
                    i--;
                    tokens.add(nextNum.toString());
                } else {
                    tokens.add(String.valueOf(c));
                }
            }
        }
        if (num.length()>0) tokens.add(num.toString());
        return tokens;
    }

    private static Queue<String> toRPN(String expr) {
        List<String> tokens = tokenize(expr);
        Queue<String> output = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();
        Map<String,Integer> prec = Map.of("+",1,"-",1,"*",2,"/",2,"^",3);
        for (String t : tokens) {
            if (t.matches("-?\\d+(\\.\\d+)?")) {
                output.add(t);
            } else if (prec.containsKey(t)) {
                while (!ops.isEmpty() && prec.containsKey(ops.peek()) &&
                       ((prec.get(ops.peek()) > prec.get(t)) || (prec.get(ops.peek()).equals(prec.get(t))))) {
                    output.add(ops.pop());
                }
                ops.push(t);
            } else if (t.equals("(")) {
                ops.push(t);
            } else if (t.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) output.add(ops.pop());
                if (!ops.isEmpty() && ops.peek().equals("(")) ops.pop();
            }
        }
        while (!ops.isEmpty()) output.add(ops.pop());
        return output;
    }

    private static BigDecimal evalRPN(Queue<String> rpn) {
        Deque<BigDecimal> st = new ArrayDeque<>();
        while (!rpn.isEmpty()) {
            String t = rpn.poll();
            if (t.matches("-?\\d+(\\.\\d+)?")) {
                st.push(new BigDecimal(t));
            } else {
                BigDecimal b = st.pop();
                BigDecimal a = st.pop();
                switch (t) {
                    case "+": st.push(a.add(b)); break;
                    case "-": st.push(a.subtract(b)); break;
                    case "*": st.push(a.multiply(b)); break;
                    case "/":
                        if (b.compareTo(BigDecimal.ZERO)==0) throw new ArithmeticException("div by 0");
                        st.push(a.divide(b, 10, BigDecimal.ROUND_HALF_UP));
                        break;
                    default: throw new RuntimeException("Unknown op "+t);
                }
            }
        }
        return st.pop();
    }
}
