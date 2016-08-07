import java.util.ArrayList;
import java.util.List;

public class IntVector {
	
	private List<Integer> vector = new ArrayList<>();
	
	public IntVector(int...vector){
		
		if(vector != null){
		
			for (int i : vector) {
				this.vector.add(i);
			}
		}
	}
	
	public IntVector(IntVector other){
		
		if(other != null){
			
			for (Integer integer : other.vector) {
			
				this.vector.add(new Integer(integer));
			}
		}
	}
	
	public int getLength(){
		return vector.size();
	}
	
	public Integer get(int index) throws InvalidIndexException {
	
		if(index < 0 || index >= getLength()){
			throw new InvalidIndexException("ERROR: Invalid index!"); 
		}
		
		return vector.get(index);
	}

	public void set(int index, Integer value) throws InvalidIndexException {
	
		if(index < 0 || index >= getLength()){
			throw new InvalidIndexException("ERROR: Invalid index!"); 
		}
		
		vector.set(index, value);
	}
	
	@Override
	public String toString() {
		return vector.toString();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vector == null) ? 0 : vector.hashCode());
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
		IntVector other = (IntVector) obj;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}
	
	public void add(IntVector other){
		
		if(getLength() != other.getLength()){
			System.out.println("Cannot add vectors of different dimensions.");
			return;
		}
			
		for (int i = 0; i < getLength(); i++) {
			
			this.vector.set(i, this.vector.get(i) + other.vector.get(i));
		}
	}
	
	
	public void subtract(IntVector other){
		
		if(getLength() != other.getLength()){
			System.out.println("Cannot subtract vectors of different dimensions.");
			return;
		}
			
		for (int i = 0; i < getLength(); i++) {
			
			this.vector.set(i, this.vector.get(i) - other.vector.get(i));
		}
	}
	
	public void add(int scalar){
		
		for (int i = 0; i < getLength(); i++) {
		
			this.vector.set(i, this.vector.get(i) + scalar);
		}
	}
	
	public void subtract(int scalar){
		
		for (int i = 0; i < getLength(); i++) {
		
			this.vector.set(i, this.vector.get(i) - scalar);
		}
	}

	public void multiply(int scalar){
		
		for (int i = 0; i < getLength(); i++) {
		
			this.vector.set(i, this.vector.get(i) * scalar);
		}
	}
	
	public void divide(int scalar){
		
		for (int i = 0; i < getLength(); i++) {
		
			this.vector.set(i, this.vector.get(i) / scalar);
		}
	}

	public IntVector product(IntVector other){
		
		if(getLength() != other.getLength()){
			System.out.println("Cannot add vectors of different dimensions.");
			return new IntVector();
		}
		
		int[] result = new int[getLength()];
		for (int i = 0; i < getLength(); i++) {
			
			result[i] = (this.vector.get(i) * other.vector.get(i));
		}
		
		return new IntVector(result);
	}

}
