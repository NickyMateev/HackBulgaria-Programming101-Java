package PairEmUp;

public final class Pair {

	private final Integer pairA;
	private final Integer pairB;

	Pair(Integer pairA, Integer pairB) {
		this.pairA = pairA;
		this.pairB = pairB;
	}

	public Integer getPairA() {
		return pairA;
	}

	public Integer getPairB() {
		return pairB;
	}
	
	@Override
	public String toString() {
		return "(" + this.pairA + ", " + this.pairB +")";
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pairA == null) ? 0 : pairA.hashCode());
		result = prime * result + ((pairB == null) ? 0 : pairB.hashCode());
		return result;
	}
}
