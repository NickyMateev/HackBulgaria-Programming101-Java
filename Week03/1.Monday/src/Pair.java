
public class Pair<T, U> {
	
	private T pairA;
	private U pairB;
	
	public Pair(T pairA, U pairB){
		
		this.pairA = pairA;
		this.pairB = pairB;
	}
	
	public T getPairA(){
		return pairA;
	}
	
	public U getPairB(){
		return pairB;
	}
	
	public void setPairA(T pairA){
		this.pairA = pairA;
	}
	
	public void setPairB(U pairB){
		this.pairB = pairB;
	}

	@Override
	public String toString() {
		return "(" + pairA + ", " + pairB + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pairA == null) ? 0 : pairA.hashCode());
		result = prime * result + ((pairB == null) ? 0 : pairB.hashCode());
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
		Pair other = (Pair) obj;
		if (pairA == null) {
			if (other.pairA != null)
				return false;
		} else if (!pairA.equals(other.pairA))
			return false;
		if (pairB == null) {
			if (other.pairB != null)
				return false;
		} else if (!pairB.equals(other.pairB))
			return false;
		return true;
	}
}