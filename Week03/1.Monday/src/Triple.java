
public class Triple<T, U, V> {

	private T tripletA;
	private U tripletB;
	private V tripletC;
	
	public Triple(T tripletA, U tripletB, V tripletC){
		
		this.tripletA = tripletA;
		this.tripletB = tripletB;
		this.tripletC = tripletC;
	}
	
	public T getTripletA(){
		return tripletA;
	}
	
	public U getTripletB(){
		return tripletB;
	}
	
	public V getTripletC(){
		return tripletC;
	}
	
	public void setTripletA(T tripletA){
		this.tripletA = tripletA;
	}
	
	public void setTripletB(U tripletB){
		this.tripletB = tripletB;
	}
	
	public void setTripletC(V tripletC){
		this.tripletC = tripletC;
	}
	
	@Override
	public String toString() {
		return "(" + tripletA + ", " + tripletB + ", " + tripletC + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tripletA == null) ? 0 : tripletA.hashCode());
		result = prime * result + ((tripletB == null) ? 0 : tripletB.hashCode());
		result = prime * result + ((tripletC == null) ? 0 : tripletC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triple other = (Triple) obj;
		if (tripletA == null) {
			if (other.tripletA != null)
				return false;
		} else if (!tripletA.equals(other.tripletA))
			return false;
		if (tripletB == null) {
			if (other.tripletB != null)
				return false;
		} else if (!tripletB.equals(other.tripletB))
			return false;
		if (tripletC == null) {
			if (other.tripletC != null)
				return false;
		} else if (!tripletC.equals(other.tripletC))
			return false;
		return true;
	}
	
}
