package Day1;

import java.util.Scanner;
import java.util.Stack;

public class bodmasCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Expression : ");
        String str = sc.nextLine();
        int result = calculate(str);
        System.out.println(result);
    }

    private static int calculate(String exp) {
        char ch[] = exp.toCharArray();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int length = exp.length();
        for(int i = 0;i<length;i++){
            if(ch[i] == ' ') continue;
            if(ch[i] >= '0' && ch[i] <= '9'){
                StringBuffer sb = new StringBuffer();
                while (i < length && ch[i] >= '0' && ch[i] <= '9'){
                    sb.append(ch[i]);
                    i++;
                }
                i--;
                operands.push(Integer.parseInt(sb.toString()));
            }else if(ch[i] == '('){
                operator.push(ch[i]);
            }else if(ch[i] == ')'){
                while(operator.peek() != '('){
                    char op = operator.pop();
                    int val1 = operands.pop();
                    int val2 = operands.pop();
                    operands.push(evaluateExp(op,val1,val2));
                }
                operator.pop();
            }

            else if(ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/' || ch[i] == 'A' || ch[i] == 'S' ||
                    ch[i] == 'M' || ch[i] == 'D'){
                while(!operator.isEmpty() && hasPrecedence(ch[i],operator.peek())){
                    operands.push(evaluateExp(operator.pop(),operands.pop(),operands.pop()));
                }
                operator.push(ch[i]);
            }
        }
        while (!operator.empty()){
            operands.push(evaluateExp(operator.pop(),operands.pop(),operands.pop()));
        }
        return operands.pop();
    }

    private static int evaluateExp(char op, int val1, int val2) {
        switch (op){
            case '+','A' : return val1+val2;
            case '-','S' : return val1 - val2;
            case '*','M' : return val1 * val2;
            case '/','D' : if(val2 == 0)
                throw new ArithmeticException("Division with Zero Result not defined");
                return val2/val1;
        }
        return 0;
    }
    private static boolean hasPrecedence(char op1 , char op2){
        if(op2 == '(' || op2 == ')'){
            return false;
        }
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }else {
            return true;
        }
    }

}
