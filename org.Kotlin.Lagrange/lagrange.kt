import kotlin.math.*


class SolarObject
{	
   var name: String = ""
   var mass: Double = 0.0
   var distance: Double = 0.0
   var nominalL1 : Double = 1.4811E11;
}


fun main()
{
    var soList = ArrayList<SolarObject>();

    var so =  SolarObject();
    so.name = "Sun";
    so.mass = 1.989E30;
    so.distance = 0.0;

    soList.add(so);

    so =  SolarObject();
    so.name = "Earth";
    so.mass = 5.9724E24;
    so.distance = 1.496E8;


    soList.add (so);

    println(soList[0].name + " Mass = " + soList[0].mass + " Distance = " + soList[0].distance);
    println(soList[1].name + " Mass = " + soList[1].mass + " Distance = " + soList[1].distance);

    var L1 : Double = calcL1(soList[0], soList[1])
    println ("L1 = " + L1);
    println (soList[1].nominalL1 - L1);
}

fun approximate_r (so0: SolarObject, so1: SolarObject) : Double
{
   val temp0 : Double = so1.mass / (3 * so0.mass);
   val temp1 : Double = Math.cbrt(temp0);
   val r : Double = temp1 * so1.distance;
   println("r = " + r);
   return r;
    
}

fun  calcL1 (so0: SolarObject, so1: SolarObject) : Double
{
    //val sqrt3 : Double = 1.73;
    var L1 : Double;
    var R : Double = so1.distance

    var r : Double = approximate_r(so0, so1);
    val temp0 : Double = (so1.mass / Math.pow(r, 2.0)) + (so0.mass / Math.pow(R, 2.0));
    println("Temp0 = " + temp0);
    val temp1 : Double = ((so1.mass + so0.mass) * r) / Math.pow(R, 3.0);
    println("Temp1 = " + temp1);
    val temp2 : Double = R - r;
    val temp3 : Double = (so0.mass / (Math.pow(temp2, 2.0)));
    println("Temp3 = " + temp3);

    val sol1 : Double = Math.abs(temp0 - temp1);
    println("Sol1 = " + sol1);


    L1 = sol1 - temp3;

/*
    var a : Double = so0.distance + so1.distance;
    var t : Double = so0.mass / (so1.mass * 3);
    var t3 : Double = Math.cbrt(t);
    var t1 : Double = 1 - t3;
 */    

    return L1;
}