import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Список точек не может быть пустым.");
        }
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
