package com.softwarecafe.spelPackage;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
//        Expression expression = parser.parseExpression("'Hello SPEL'.concat('!')");
//        String msg  = (String) expression.getValue();
//        Expression expression = parser.parseExpression("'Hello SPEL'.bytes.length");
//        int msg = (Integer)expression.getValue( );
//        Expression expression = parser.parseExpression("new String('hello world').toUpperCase()");
//        String msg = expression.getValue(String.class );
//        System.out.println(msg);



//arithmetic operator
        System.out.println(parser.parseExpression("'Welcome SPEL'+'!'").getValue());
        System.out.println(parser.parseExpression("10 * 10/2").getValue());
        System.out.println(parser.parseExpression("'Today is: '+ new java.util.Date()").getValue());

//logical operator
        System.out.println(parser.parseExpression("true and true").getValue());

//Relational operator
        System.out.println(parser.parseExpression("'sonoo'.length()==5").getValue());

        Calculation calculation=new Calculation();
        StandardEvaluationContext context=new StandardEvaluationContext(calculation);


        parser.parseExpression("number").setValue(context,"5");

        System.out.println(calculation.cube());
    }
}
