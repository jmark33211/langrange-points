
class SolarObject
{	
   var name: String = ""
   var mass: Double = 0.0
   var distance: Double = 0.0
}



fun main()
{
    var soList = ArrayList<SolarObject>();

    var so =  SolarObject();
    so.name = "Sun";
    so.mass = 1988500.0;
    so.distance = 0.0;

    soList.add(so);

    so.name = "Earth";
    so.mass = 5.9724;
    so.distance = 92.96;


    soList.add (so);

    println(soList[0].name + " Mass = " + soList[0].mass + " Distance = " + soList[0].distance);
    println(soList[1].name + " Mass = " + soList[1].mass + " Distance = " + soList[1].distance);
}