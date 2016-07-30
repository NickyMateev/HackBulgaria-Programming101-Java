import java.security.InvalidParameterException;

public class LineSegment implements Comparable<LineSegment> {
	
	private Point startPoint;
	private Point endPoint;
	
	public LineSegment(Point startPoint, Point endPoint){
		
		if(startPoint.equals(endPoint)){
			throw new InvalidParameterException("ERROR: Cannot create a line segment with zero length!");
		}
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public LineSegment(LineSegment line){
	
		this.startPoint = new Point(line.startPoint);
		this.endPoint = new Point(line.endPoint);
	}
	
	public Point getStartPoint(){
		return startPoint;
	}
	
	public Point getEndPoint(){
		return endPoint;	
	}
	
	public Double getLength(){
		return Math.sqrt(Math.pow((endPoint.getX() - startPoint.getX()), 2) + Math.pow((endPoint.getY() - startPoint.getY()), 2));
	}

	@Override
	public String toString() {
		return String.format("Line[(%f, %f), (%f, %f)]", startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endPoint == null) ? 0 : endPoint.hashCode());
		result = prime * result + ((startPoint == null) ? 0 : startPoint.hashCode());
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
		LineSegment other = (LineSegment) obj;
		if (endPoint == null) {
			if (other.endPoint != null)
				return false;
		} else if (!endPoint.equals(other.endPoint))
			return false;
		if (startPoint == null) {
			if (other.startPoint != null)
				return false;
		} else if (!startPoint.equals(other.startPoint))
			return false;
		return true;
	}

	@Override
	public int compareTo(LineSegment o) {
		
		if(o.getLength() == this.getLength()){
			return 0;
		} else if(o.getLength() < this.getLength()){
			return 1;
		} else {
			return -1;
		}
	}

	
	
	
}