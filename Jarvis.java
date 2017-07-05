import java.util.ArrayList;

public class Jarvis {


    public static ArrayList<Point> jarvis(Point[] points){
        ArrayList<Point> result = new ArrayList<>();
        Point p = points[Functions.findP(points)];
        Point q = points[Functions.findQ(points)];

        result.add(p);

        Point current = p;
        current.printPoint();

        do{
            Double angMin;
            int iMin;

            if(current.equals(points[0])){
                angMin = current.calcAngleR(points[1]);
                iMin = 1;
            }else{
                angMin = current.calcAngleR(points[0]);
                iMin = 0;
            }
            for (int i = 0; i < points.length; i++) {
                if(!current.equals(points[i])){
                    Double angCur = current.calcAngleR(points[i]);
                    if((angCur < angMin) || (angCur == angMin && current.distance(points[i]) < current.distance(points[iMin]))){
                        angMin = angCur;
                        iMin = i;
                    }
                }
            }
            result.add(points[iMin]);
            current = points[iMin];
        }while (!current.equals(q));

        do{
            Double angMin;
            int iMin;

            if(current.equals(points[0])){
                angMin = current.calcAngleL(points[1]);
                iMin = 1;
            }else{
                angMin = current.calcAngleL(points[0]);
                iMin = 0;
            }

            for (int i = 0; i < points.length; i++) {
                if(!current.equals(points[i])){
                    Double angCur = current.calcAngleL(points[i]);
                    if((angCur < angMin) || (angCur == angMin && current.distance(points[i]) < current.distance(points[iMin]))){
                        angMin = angCur;
                        iMin = i;
                    }
                }
            }
            result.add(points[iMin]);
            current = points[iMin];
        }while(!current.equals(p));
        result.remove(result.size() - 1); // Punkt P został dodany dwa razy
        return result;
    }
}
