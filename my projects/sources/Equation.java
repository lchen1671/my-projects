import java.util.ArrayList;
public class Equation{
	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
	double a=0;
	double b=0;
	double c=0;
	double d=0;
	//TODO: Make getters for all of the above
	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}
	public void setLeftSide(ArrayList<Term> leftSide) {
		this.leftSide = leftSide;
	}
	public ArrayList<Term> getRightSide() {
		return rightSide;
	}
	public void setRightSide(ArrayList<Term> rightSide) {
		this.rightSide = rightSide;
	}
	public boolean isCancelRight() {
		return cancelRight;
	}
	public void setCancelRight(boolean cancelRight) {
		this.cancelRight = cancelRight;
	}
	public ArrayList<Double> getSolution() {
		return solution;
	}
	public void setSolution(ArrayList<Double> solution) {
		this.solution = solution;
	}
	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		//sets values of leftSide and rightSide only
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	public boolean isLinear(){
		//returns 'true' if this equation is linear
		//and every term is either constant or has the same variable
//		boolean rightSideLinear = false;
//		boolean leftSideLinear = false;
//		boolean variablesRight = true;
//		for(Term x: this.leftSide){
//			if(x.variable != leftSide.get(0).variable){
//				variablesRight = false;
//			}
//		}
//		for(Term x: this.rightSide){
//			if(x.variable != rightSide.get(0).variable){
//				variablesRight = false;
//			}
//		}
//		if(getHighestDegreeTerm(this.leftSide).exponent == 1){
//			leftSideLinear = true;
//		}
//		if(getHighestDegreeTerm(this.rightSide).exponent == 1){
//			rightSideLinear = true;
//		}
//		if(rightSideLinear && leftSideLinear && variablesRight){
//			return true;
//		}
//		return false;
		return isOfDegree(1);
	}
	
	private boolean isOfDegree(int degree){
		int maxDegree = 0;
		int minDegree = 0;
		String variable = "";
		for (Term t: leftSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)minDegree=t.getDegree();
			if(!t.isConstant())variable=t.getVariable();
		}
		for (Term t: rightSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)minDegree=t.getDegree();
			if(!t.isConstant())variable=t.getVariable();
		}
		if(maxDegree==degree && minDegree >=0 && variablesMatch(variable))return true;
		else return false;
	}
	
	private boolean variablesMatch(String s){
		boolean match = true;
		for(Term t: leftSide){
			if(!t.isConstant() && !t.getVariable().equals(s)) return false;
		}
		for(Term t: rightSide){
			if(!t.isConstant() && !t.getVariable().equals(s)) return false;
		}
		return match;
	}
	public boolean isQuadratic(){
		//returns 'true' if this equation is quadratic
		//and every term is either constant or has the same variable
//		boolean rightSideQuadratic = false;
//		boolean leftSideQuadratic = false;
//		boolean variablesRight = true;
//		for(Term x: this.leftSide){
//			if(x.variable != leftSide.get(0).variable){
//				variablesRight = false;
//			}
//		}
//		for(Term x: this.rightSide){
//			if(x.variable != rightSide.get(0).variable){
//				variablesRight = false;
//			}
//		}
//		if(getHighestDegreeTerm(this.leftSide).exponent == 2 && getHighestDegreeTerm(this.leftSide).exponent < 3){
//			leftSideQuadratic = true;
//		}
//		if(getHighestDegreeTerm(this.rightSide).exponent == 2 && getHighestDegreeTerm(this.leftSide).exponent < 3){
//			leftSideQuadratic = true;
//		}
//		if(leftSideQuadratic && leftSideQuadratic && variablesRight){
//			return true;
//		}
//		return false;
		return isOfDegree(2);
	}
	public boolean isSolveable(){
		//returns 'true' if this equation is linear or quadratic, 'false' otherwise 
		//(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
		if(isLinear() || isQuadratic()){
			return true;
		}
		return false;
	}
	public boolean cancelRight(){
		//sets the value of cancelRight and
		//returns 'true' if the equation should be solved by subtracting terms from the right side, false if it is better to subtract terms on the left side
//		if(getHighestDegreeTerm(this.leftSide).exponent >= getHighestDegreeTerm(this.rightSide).exponent){
//			return true;
//		}
//		return false;
		return true;
	}
	public String getSideString(ArrayList<Term> side){
		String s = "";
		try{
			s=side.get(0).toString();
		}
		catch(Exception e){
			s = "0";
		}
		for(int i =1;i<side.size();i++){
			if(side.get(i).isPositive())s+=" + "+side.get(i);
			else s+=" - "+side.get(i).toString().replaceFirst("-", "");
		}
		return s;
	}
	
	public String toString(){
		/**
		 *Take your time on this method!
		 *There are many things to consider:
		 *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
		 *When a term is negative, the negative sign will appear as a minus.
		 */
		/*
		  		String s = getSideString(leftSide)+" = "+getSideString(rightSide);
		  		return s;
		 */
		String returnString = "";
		for(Term x: this.leftSide){
			if(x.isPositive()){
				if(this.leftSide.indexOf(x)==0){
					returnString += x.toString();	
				}
				else{
					returnString += " + " + x.toString();	
				}
			}
			else{
				returnString += " - " + x.toString();
			}
		}
		returnString += " = ";
		for(Term x: this.rightSide){
			if(x.isPositive()){
				if(this.rightSide.indexOf(x)==0){
					returnString += x.toString();	
				}
				else{
					returnString += " + " + x.toString();	
				}
			}
			else{
				returnString += "-" + x.toString();
			}
		}
		return returnString;
	}
	public static Term getHighestDegreeTerm(ArrayList<Term> side){
		//returns the term in the ArrayList that is the highest degree.
		//example
		//3x^2 + 4x^3 - 12x + x^2
		//will return 4x^3
		int high = 0;
		Term highTerm = null;
		for(Term x: side){
			if(x.getDegree()>high){
				high = x.getDegree();
				highTerm = x;
			}
		}
		return highTerm;
	}
	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
		for(int i = 0; i < sideBeingCanceled.size(); i++){
			sideBeingCanceled.get(i).getAddInverse();
		}
	}
	/**
	 * 
	 * @param side - simplifies the specified side of the equation
	 * Notes: This method should check every Term on the specified side of the equation 
	 * with every other Term to check if they are like terms (use Term.areLikeTerms(Term s, Term t)
	 * If they are, it should reassign the current Term to the combined result (use Term.combine(Term s, Term t)
	 * and remove the one with which it combined.
	 * Finally, if the resulting term has a coefficient of zero should be removed.
	 * 
	 * For example, Suppose side contains 5x + 3 -5x. Call the three terms a, b and c, respectively
	 * 1. It checks to see if 5x and 3 (a and b) are like terms, they are not
	 * 2. It checks to see if 5x and -5x (a and c) are like terms, they are
	 * 3. Since 5x and -5x are like terms, a = Term.cobine(a, c) then leftSide.remove(c)
	 * 4. Now side contains 0x + 3. Since term a has a coefficient of zero, remove it.
	 * 5. Now side contains 3. 
	 * 
	 * ONE MORE NOTE: Since you will be removing items from side, use a standard for loop
	 * and remember that when something is moved, everything "slides over"
	 */
	public void simplify(ArrayList<Term> side){
		for(int i = 0; i < side.size(); i++){
			if(Term.areLikeTerms(side.get(i), side.get(i+1))){
				Term.combine(side.get(i), side.get(i+1));
			}
			if(side.get(i).getCoefficient() == 0){
				side.remove(i);
				i--;
			}
		}
	}
	/**
	 * 
	 * @param sideWithVariable - we can assume the side with a variable is of the form ax + b
	 * @return the solution
	 * 
	 * Example: 3x + 21 = 0
	 * 1. Identify the constant term in the sideWithVariable (21)
	 * 2. Identify the variable term in the sideWithVariable (3x)
	 * 3. Add the additive inverse of the constant Term to both sides of the equation (3x = -21)
	 * 4. Multiple both sides by the additive inverse of the coefficient of the variable term (.33333333)
	 */
	/**
	 * 
	 * @param side
	 * @param scalar
	 * multiplies all Terms on the given side by the given scalar
	 * (Hint: use setCoefficient(double))
	 */
	
	public void solveLinear(ArrayList<Term> sideWithVariable){
    	Term tmpConst = new Term(0);
    	Term tmpVarTerm = new Term(0); 
    	for(Term t : sideWithVariable){ //4 
    		if(t.isConstant()){
    			tmpConst = t; //if term constant = t
    		}
    		if(!t.getVariable().equals("")){  // check if empty after number if not = t
    			tmpVarTerm = t; 
    		}
    	}
    	rightSide.add(tmpConst.getAddInverse());
    	leftSide.add(tmpConst.getAddInverse()); //sim & add inv of hi degree term --> lowest
    
    }
    
    public void solveQuadratic(Equation eq){
    	factor(eq.leftSide);
    	
    }
    
    public void factor(ArrayList<Term> eq){//based on interpret
        a = eq.get(0).getCoefficient(); // get coe of first term
        b = eq.get(1).getCoefficient();
        c = eq.get(2).getCoefficient();
        double d = (b*b) - 4*(a*c); // get d
        
        double[] positiveFacts = null;
        double[] negativeFacts = null;
        for(int i = 0; i < a*c; i++){
            if((a*c)%i == 0){
                positiveFacts[i] = i;
                negativeFacts[i] = -1; //looks for factor pair
            }
        }
        
        if(d > 0){
            System.out.println(" Two real roots");
        }
        if(d == 0){
            System.out.println(" One real root that is repeated");
        }
        if(d < 0){
            System.out.println("No real roots");
        }
    }
	public void multiplyScalar(ArrayList<Term> side, double scalar){
		
		
	}
}