
public class Circle implements Shape {
	
	private Double radius;
	private Point center;
	
	public Circle(Double radius, Point center){
		
		this.radius = new Double(radius);
		this.center = center;
	}
	
	public Circle(Circle other){
		
		this.radius = new Double(other.radius);
		this.center = new Point(other.center);
	}
	
	public Point getLeftPoint(){
		return new Point(center.getX() - radius, center.getY());
	}
	
	public Point getRightPoint(){
		return new Point(center.getX() + radius, center.getY());
	}
	
	public Point getTopPoint(){
		return new Point(center.getX(), center.getY() + radius);
	}
	
	public Point getBottomPoint(){
		return new Point(center.getX(), center.getY() - radius);
	}
	
	public Point getCenter(){
		return center;
	}
	
	public Double getArea(){
		return Math.PI * (Math.pow(radius, 2));
	}

	public Double getPerimeter(){
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return String.format("Circle[(%f, %f),(%f, %f)]", center.getX(), center.getY(), 2 * radius, 2 * radius);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
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
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		return true;
	}
	
}
