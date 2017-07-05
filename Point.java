public class Point {
    private Double x;
    private Double y;

    Point(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    void printPoint(){ System.out.println("(" + x +", " + y + ")");}

    Double getx(){
        return x;
    }

    Double gety(){
        return y;
    }

    public boolean equals(Point a){
        return (x == a.getx() && y == a.gety());
    }

    public Double distance(Point a){
        return Math.sqrt(x*x + y*y);
    }

    public Double[] calcVect(Point a){
        Double[] result = new Double[2];
        result[0] = a.getx() - x;
        result[1] = a.gety() - y;
        return result;
    }

    public Double calcAngleR(Point b){
        Double x = this.calcVect(b)[0];
        Double y = this.calcVect(b)[1];
        Double cos = x/(Math.sqrt(x*x + y*y));
        if(this.gety() <= b.gety()) {
            return Math.acos(cos);
        }else {
            return Math.acos(cos) + Math.PI;
        }
    }

    public Double calcAngleL(Point b){
        Double x = this.calcVect(b)[0];
        Double y = this.calcVect(b)[1];
        Double cos = -x/(Math.sqrt(x*x + y*y));
        if(this.gety() >= b.gety())
            return Math.acos(cos);
        else
            return Math.acos(cos) + Math.PI;
    }
}
