public class MaxPointsOnALine {
    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    class Solution {
        public int maxPoints(Point[] points) {
            if(points.length == 0){
                return 0;
            }
            if( points.length <= 2 ){
                return points.length;
            }
            int max = 2 ;
            for( int i = 0 ; i < points.length ; i++ ){
                int samePosition = 0; //重复位置的点 个数
                int sameSlope = 1;    //斜率相同的点 个数
                for( int j = i + 1 ; j < points.length ; j++ ){
                    //判断是否为重复位置的点
                    long x1 = points[j].x - points[i].x;
                    long y1 = points[j].y - points[i].y;
                    if( x1 == 0 && y1 == 0 ){
                        samePosition++;
                    } else {
                        sameSlope++;//第二个点，所以可以直接++
                        for(int k = j + 1 ; k < points.length ; k++ ){
                            long x2 = points[k].x - points[i].x;
                            long y2 = points[k].y - points[i].y;
                            if ( x1 * y2 == x2 * y1 ) {
                                sameSlope++;
                            }
                        }
                    }
                    if(max < (samePosition + sameSlope)){
                        max = samePosition + sameSlope;
                    }
                    sameSlope = 1;
                }
            }
            return max;

        }
    }
}
