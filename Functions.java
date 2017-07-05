import java.util.ArrayList;

public class Functions {

    public static int findQ(Point[] points){
        int imax = 0;
        for(int i = 1; i < points.length; i++){
            if(points[i].gety() > points[imax].gety() || (points[i].gety() == points[imax].gety() && points[i].getx() > points[imax].getx()))
                imax = i;
        }
        return imax;
    }

    public static int findP(Point[] points){
        int imin = 0;
        for(int i = 1; i < points.length; i++){
            if(points[i].gety() < points[imin].gety() || (points[i].gety() == points[imin].gety() && points[i].getx() < points[imin].getx()))
                imin = i;
        }
        return imin;
    }

    public static boolean isInside(Point a, ArrayList<Point> points){
        Double x0 = a.getx();
        Double y0 = a.gety();
        Boolean side = null;

        for (int i = 0; i < points.size(); i++) {
            Double xa = points.get(i).getx();
            Double ya = points.get(i).gety();
            Double xb = points.get((i+1)%(points.size())).getx();
            Double yb = points.get((i+1)%(points.size())).gety();

            Double result = (x0 - xa)*(yb - ya) - (y0 - ya)*(xb - xa);

            if(result != 0){
                if(side == null)
                    side = result > 0;
                else if(side != (result > 0))
                    return false;
            }
        }
        return true;
    }
}
