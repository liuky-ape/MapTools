import com.google.common.geometry.*;

public class test_s2 {
//测试是否在矩形区域内
   public static void is_in_sequence(){
       String[] split ="114.025914,22.629364".split(",");
       String[] coord = "114.027745,22.623408".split(",");
       //s2 object
       S2LatLngRect rect=new S2LatLngRect(S2LatLng.fromDegrees(Double.valueOf(split[1]),Double.valueOf(split[0])),
               S2LatLng.fromDegrees(Double.valueOf(coord[1]),Double.valueOf(coord[0])));

       //cell
       double lat = 22.629164;
       double lgt =114.025514 ;
       S2LatLng s2LatLng = S2LatLng.fromDegrees(lat, lgt);
       boolean contains = rect.contains(s2LatLng.toPoint());
       System.out.println(contains);
   }
   //测试是否在某个单位圆内
   public static void is_in_circle(){
       double lng = 112.030500;
       double lat = 27.970271;
       double capHeight = 6.5; //半径
       S2LatLng s2LatLng= S2LatLng.fromDegrees(lat, lng);
       S2Cap cap = S2Cap.fromAxisHeight(s2LatLng.toPoint(),capHeight);

       double lat2 = 22.629164;
       double lgt2 =114.025514 ;
       S2LatLng s2LatLng1 = S2LatLng.fromDegrees(lat2, lgt2);
       boolean contains = cap.contains(s2LatLng1.toPoint());
       System.out.println(contains);
   }
   public static void calculate_distance(){
       double lat1 = 22.629164;
       double lgt1 =114.025514 ;
       double lgt2 = 112.030500;
       double lat2 = 27.970271;
       double lgt3 = 112.032500;
       double lat3 = 27.945271;
       S2LatLng s2LatLng=S2LatLng.fromDegrees(lat1,lgt1);
       S2LatLng s2LatLng1=S2LatLng.fromDegrees(lat2,lgt2);
       S2LatLng s2LatLng2=S2LatLng.fromDegrees(lat3,lgt3);
//       S1Angle distance1 = S2EdgeUtil.getDistance(s2Point, s2Point1, s2Point2);
//getDistance返回两个点的弧度数，给定半径就为球面的距离，getEarthDistance则是半径为地球的半径；
       S1Angle distance1 = s2LatLng.getDistance(s2LatLng1);
       Double res=s2LatLng.getDistance(s2LatLng1,200);
       System.out.println(s2LatLng.getEarthDistance(s2LatLng1));
       System.out.println(distance1);
       System.out.println(res);
   }

    public static void main(String[] args) {
       is_in_sequence();
        is_in_circle();
        calculate_distance();
     }
}
