
public class Ellipse implements Shape {
	
	private Double radiusX;
	private Double radiusY;
	public Point center;
	
	public Ellipse(Double radiusX, Double radiusY, Point center){
		
		this.radiusX = radiusX;
		this.radiusY = radiusY;
		this.center = center;
	}
	
	public Ellipse(Ellipse other){
		
		this.radiusX = new Double(other.radiusX);
		this.radiusY = new Double(other.radiusY);
		this.center = new Point(other.center);
	}
	
	public Double getPerimeter(){
		return 4 * Math.sqrt(Math.pow(radiusX, 2) + Math.pow(radiusY, 2));
	}
	
	public Double getArea(){
		return Math.PI * radiusX * radiusY;
	}
	
	public Point getLeftPoint(){
		return new Point(center.getX() - radiusX, center.getY());
	}
	
	public Point getRightPoint(){
		return new Point(center.getX() + radiusX, center.getY());
	}
	
	public Point getTopPoint(){
		return new Point(center.getX(), center.getY() + radiusY);
	}
	
	public Point getBottomPoint(){
		return new Point(center.getX(), center.getY() - radiusY);
	}

	public Point getCenter(){
		return center;
	}
	
	@Override
	public String toString() {
		return String.format("Ellipse[(%f, %f),(%f, %f)]", center.getX(), center.getY(), 2 * radiusY, 2 * radiusX);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + ((radiusX == null) ? 0 : radiusX.hashCode());
		result = prime * result + ((radiusY == null) ? 0 : radiusY.hashCode());
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
		Ellipse other = (Ellipse) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radiusX == null) {
			if (other.radiusX != null)
				return false;
		} else if (!radiusX.equals(other.radiusX))
			return false;
		if (radiusY == null) {
			if (other.radiusY != null)
				return false;
		} else if (!radiusY.equals(other.radiusY))
			return false;
		return true;
	}
	
}
