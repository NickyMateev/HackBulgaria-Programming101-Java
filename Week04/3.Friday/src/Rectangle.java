import java.security.InvalidParameterException;

public class Rectangle implements Shape {
	
	private Point upperLeftPoint;
	private Point lowerRightPoint;

	private Point lowerLeftPoint;
	private Point upperRightPoint;
	
	public Rectangle(Point upperLeftPoint, Point lowerRightPoint){
		
		if(upperLeftPoint.getX() == lowerRightPoint.getX() || upperLeftPoint.getY() == lowerRightPoint.getY()){
			throw new InvalidParameterException("ERROR: Points are on the same axis.");
		}
		
		this.upperLeftPoint = upperLeftPoint;
		this.lowerRightPoint = lowerRightPoint;
		
		this.lowerLeftPoint = new Point(upperLeftPoint.getX(), lowerRightPoint.getY());
		this.upperRightPoint = new Point(lowerRightPoint.getX(), upperLeftPoint.getY());
	}

	public Point getUpperLeft(){
		return upperLeftPoint;
	}
	
	public Point getLowerLeft(){
		return lowerLeftPoint;
	}
	
	public Point getUpperRight(){
		return upperRightPoint;
	}
	
	public Point getLowerRight(){
		return lowerRightPoint;
	}
	
	public LineSegment getLeftSide(){
		return Point.add(upperLeftPoint, lowerLeftPoint);
	}
	
	public LineSegment getUpSide(){
		return Point.add(upperLeftPoint, upperRightPoint);
	}
	
	public LineSegment getRightSide(){
		return Point.add(upperRightPoint, lowerRightPoint);
	}
	
	public LineSegment getDownSide(){
		return Point.add(lowerRightPoint, lowerLeftPoint);
	}
	
	public Double getHeight(){
		return getRightSide().getLength();
	}
	
	public Double getWidth(){
		return getUpSide().getLength();
	}
	
	public Point getCenter(){
		return new Point((upperLeftPoint.getX() + upperRightPoint.getX()) / 2, (lowerRightPoint.getY() + upperRightPoint.getY()) / 2);
	}
	
	public Double getPerimeter(){
		return (getWidth() * 2) + (getHeight() * 2);
	}
	
	public Double getArea(){
		return (getWidth() * getHeight());
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle[(%f, %f), (%f, %f)]", upperLeftPoint.getX(), upperLeftPoint.getY(), getHeight(), getWidth()); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerLeftPoint == null) ? 0 : lowerLeftPoint.hashCode());
		result = prime * result + ((lowerRightPoint == null) ? 0 : lowerRightPoint.hashCode());
		result = prime * result + ((upperLeftPoint == null) ? 0 : upperLeftPoint.hashCode());
		result = prime * result + ((upperRightPoint == null) ? 0 : upperRightPoint.hashCode());
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
		Rectangle other = (Rectangle) obj;
		if (lowerLeftPoint == null) {
			if (other.lowerLeftPoint != null)
				return false;
		} else if (!lowerLeftPoint.equals(other.lowerLeftPoint))
			return false;
		if (lowerRightPoint == null) {
			if (other.lowerRightPoint != null)
				return false;
		} else if (!lowerRightPoint.equals(other.lowerRightPoint))
			return false;
		if (upperLeftPoint == null) {
			if (other.upperLeftPoint != null)
				return false;
		} else if (!upperLeftPoint.equals(other.upperLeftPoint))
			return false;
		if (upperRightPoint == null) {
			if (other.upperRightPoint != null)
				return false;
		} else if (!upperRightPoint.equals(other.upperRightPoint))
			return false;
		return true;
	}
	
	
}
