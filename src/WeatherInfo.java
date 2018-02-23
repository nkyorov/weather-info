import java.util.*;
import java.io.*;

public class WeatherInfo {
  public static void main(String[] args)
    throws FileNotFoundException {
      //Check the input
      if (args.length == 0) {
        System.out.println("Usage: java Weatherinfo <filename>");
        System.exit(1);
      }

      WeatherStation station = new WeatherStation(args[0]);
      System.out.println("Name: " + station.getName());
      System.out.println("Location: " + station.getLocation());
      System.out.println(station.getRecordCount() + " months of data available");
      System.out.println("Sunniest month: " + station.findSunniestMonth().getMonthName());
      System.out.println("Mean max temp in August: " + station.meanMaxTemp(8) + " deg C");
      System.out.println("Wettest year: " + station.findWettestYear());
      System.out.println("Driest year: " + station.findDriestYear());
    }
}
