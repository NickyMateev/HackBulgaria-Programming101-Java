import java.security.InvalidParameterException;

public class Triangle implements Shape {

	private Point left;
	private Point right;
	private Point top;

	public Triangle(Point left, Point right, Point top) {

		if ((left.getX() == right.getX() && left.getX() == top.getX())
				|| (left.getY() == right.getY() && left.getY() == top.getY())) {
			throw new InvalidParameterException("ERROR: Points are on the same axis.");
		}

		this.left = left;
		this.right = right;
		this.top = top;
	}

	public Triangle(Triangle other) {
		this.left = new Point(other.left);
		this.right = new Point(other.right);
		this.top = new Point(other.top);
	}

	public Point getLeftPoint() {
		return left;
	}

	public Point getRightPoint() {
		return right;
	}

	public Point getTopPoint() {
		return top;
	}

	public LineSegment getLeftSide() {
		return Point.add(left, top);
	}

	public LineSegment getRightSide() {
		return Point.add(top, right);
	}

	public LineSegment getBase() {
		return Point.add(left, right);
	}
	
	public Double getBaseLength(){
		return getBase().getLength();
	}

	public Double getPerimeter() {
		return (getLeftSide().getLength() + getRightSide().getLength() + getBase().getLength());
	}

	public Double getSemiperimeter() {
		return getPerimeter() / 2;
	}

	public Double getArea() {
		Double p = getSemiperimeter();
		Double a = getLeftSide().getLength();
		Double b = getRightSide().getLength();
		Double c = getBase().getLength();

		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
	
	public Double getHeight(){
		return (2* getArea()) / getBaseLength();
	}

	public Point getCenter() {
		Point baseMidPoint = new Point((left.getX() + right.getX()) / 2, (left.getY() + right.getY()) / 2);
		
		Point resultPoint = new Point(top.getX() + (2.0/3.0)*(baseMidPoint.getX() - top.getX()), top.getY() + (2.0/3.0)*(baseMidPoint.getY() - top.getY()));
		return resultPoint;
	}
	
	@Override
	public String toString() {
		return String.format("Triangle[(%f, %f),(%f, %f)]", getCenter().getX(), getCenter().getY(), getHeight(), getBaseLength());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
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
		Triangle other = (Triangle) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
	}
	
}