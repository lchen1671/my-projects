public class Term{

	double coefficient;
	String variable;
	int exponent;
	boolean constant;//this is true if a Term has no variable expression
	//TODO: Write getters for all of the above fields

	public Term(double coefficient, String var, int exp){
		//set the value of all the fields
		//if variable is non-empty, sets constant to 'false'
		this.coefficient = coefficient;
		this.variable = var;
		this.exponent = exp;
		if(!var.equals(""))constant = false;
		else constant = true;
		if (coefficient == 0){
			variable="";
			exp=0;
			constant = true;
		}
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public boolean isConstant() {
		return constant;
	}

	public void setConstant(boolean constant) {
		this.constant = constant;
	}


	/**
	 *a constructor for constant: 
	 */
	Term(double constant){
		//sets coefficient to constant, variable to "", exponent to "0" and constant to 'true')
		this.coefficient = constant;
		this.variable = "";
		this.exponent = 0;
		this.constant = true;
	}
	/**
	 *Write getters for each field
	 *Note that the getter for the boolean should be called 'isConstant'
	 */ 

	public Term getAddInverse(){
		//returns the additive inverse of this Term
		return new Term(this.coefficient*-1,this.variable,this.exponent);
	}

	public int getDegree(){
		//returns the exponent
		return exponent;
	}

	public boolean isPositive(){
		//returns true if the coefficient is positive (or zero), false otherwise
		if(coefficient >= 0){
			return true;
		}
		else{
			return false;
		}
	}
	public String toString(){
		/**
		 *Some tips to consider:
		 *doubles always print with trailing zeros (i.e. 2.0) This is not desireable
		 *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
		 *If a term has an exponent of 1, the 1 should not be shown
		 *For exponents, use '^'. The GUI will change it into superscript.
		 */
		String s = "";
		if(coefficient ==-1.0 || coefficient == 1.0){
			if(coefficient==-1.0)s+="-";
		}else{
			s+=coefficient;
		}
		s+=variable;
		if(exponent!=0&&exponent!=1)s+="^"+exponent;
		return s;
	}

	/**

	 * 

	 * 

	 * @param s

	 * @param t

	 * @return 'true' if s and t are like terms (same variable and exponent)

	 */

	public static boolean areLikeTerms(Term s, Term t){
		if(s.variable.equals(t.variable)||(s.exponent==t.exponent)){
			return true;
		}
		else return false;
	}

	/**

	 * returns a new Term with same variable and exponent as s and t but combined coefficient

	 * @param s

	 * @param t

	 * @return

	 */

	public static Term combine(Term s, Term t){
		return new Term(s.coefficient+t.coefficient,s.variable,s.exponent);
	}


}