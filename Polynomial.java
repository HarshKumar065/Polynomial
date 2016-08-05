import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Polynomial {
    private HashMap<Integer,Double> polynomialExpression;

    public Polynomial() {
        polynomialExpression = new HashMap<>();
    }

    public Polynomial(HashMap<Integer,Double> polynomialExpression) {
        this.polynomialExpression=polynomialExpression;
    }

    public void setPolynomialExpression(HashMap<Integer, Double> polynomialExpression) {
        this.polynomialExpression = polynomialExpression;
    }

    public HashMap<Integer,Double> getPolynomialExpression() {
        return polynomialExpression;
    }

    public Polynomial add(Polynomial a, Polynomial b) {
        Polynomial c = new Polynomial();
        Set<Integer> keys = new HashSet(a.polynomialExpression.keySet());
        keys.addAll(b.getPolynomialExpression().keySet());
        ArrayList<Integer> exponents = new ArrayList<>();
        exponents.addAll(keys);
        for (int exponent: exponents) {
            if(a.polynomialExpression.containsKey(exponent)==false)
                c.polynomialExpression.put(exponent,b.polynomialExpression.get(exponent));
            else if(b.polynomialExpression.containsKey(exponent)==false)
                c.polynomialExpression.put(exponent,a.polynomialExpression.get(exponent));
            else
                c.polynomialExpression.put(exponent,a.polynomialExpression.get(exponent)+b.polynomialExpression.get(exponent));
        }
        return c;
    }

    public Polynomial subtract(Polynomial a, Polynomial b) {
        Polynomial c = new Polynomial();
        Set<Integer> keys = new HashSet(a.polynomialExpression.keySet());
        keys.addAll(b.getPolynomialExpression().keySet());
        ArrayList<Integer> exponents = new ArrayList<>();
        exponents.addAll(keys);
        for (int exponent: exponents) {
            if(a.polynomialExpression.containsKey(exponent)==false)
                c.polynomialExpression.put(exponent,-b.polynomialExpression.get(exponent));
            else if(b.polynomialExpression.containsKey(exponent)==false)
                c.polynomialExpression.put(exponent,a.polynomialExpression.get(exponent));
            else
                c.polynomialExpression.put(exponent,a.polynomialExpression.get(exponent)-b.polynomialExpression.get(exponent));
        }
        return c;
    }
    public Polynomial multiply(Polynomial a, Polynomial b) {
        Polynomial c = new Polynomial();
        return c;
    }

    public String toString(Polynomial a) {
        return "";
    }
    public void toHTML(Polynomial a) {

    }
    public void toLatex(Polynomial a) {

    }
    public static void main(String[] args) {

    }

}


	    public static void parseInput(Polynomial p , String s){
	    	HashMap<Integer,Double> tm = new HashMap<Integer,Double>();
	    	String[] coeff = s.split("x\\^\\d+\\+?");
	    	String[] terms = s.split("(-|\\+)");
	    	
    	    for (int i = 0; i< coeff.length; i++) {
    	    	String[] parts = terms[i].split("\\^");
    	    	if(parts.length > 1 ){
    	    		tm.put(Integer.parseInt(parts[1]),Double.parseDouble(coeff[i]));
    	    	}
    	    	else
    	    		tm.put(0,Double.parseDouble(coeff[i]));
    	    }
    	    System.out.println(tm);
	    }
	    public static void main(String[] args){
	    	Polynomial p1 = new Polynomial();
	    	Polynomial p2 = new Polynomial();
	    	String s1 = args[0];
	    	String s2 = args[1];
	    	parseInput(p1 , s1);
	    	   
	    }

}
