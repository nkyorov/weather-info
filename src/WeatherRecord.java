import java.util.*;
import java.io.*;

class WeatherRecord implements Comparable<WeatherRecord>{

  private int year;
  private int month;
  private double maxTemp;
  private double minTemp;
  private int frostDay;
  private double rainfall;
  private double sunHours;

  /**
   * Initialises the fields, representing the data
   * @param line read from file in WeatherRecord
   */
  public WeatherRecord(String line){
    String[] split = line.trim().split(" +");
    if (split.length!=7){
      throw new InputMismatchException("Wrong number of values");
    }
    year = Integer.parseInt(split[0]);
    month = Integer.parseInt(split[1]);
    maxTemp = Double.parseDouble(split[2]);
    minTemp = Double.parseDouble(split[3]);
    frostDay = Integer.parseInt(split[4]);
    rainfall = Double.parseDouble(split[5]);
    sunHours = Double.parseDouble(split[6]);
  }

  /**
   * Getter for year
   * @return year
   */
  public int getYear(){
    return year;
  }

  /**
   * Getter for month
   * @return month
   */
  public int getMonth(){
    return month;
  }

  /**
   * Getter for maxTemp
   * @return maxTemp
   */
  public double getMaxTemp(){
    return maxTemp;
  }

  /**
   * Getter for minTemp
   * @return minTemp
   */
  public double getMinTemp(){
    return minTemp;
  }

  /**
   * Getter for frostdays
   * @return frostday
   */
  public int getFrostDays(){
    return frostDay;
  }

  /**
   * Getter for rainfall
   * @return rainfall
   */
  public double getRainfall(){
    return rainfall;
  }

  /**
   * Getter for SunHours field
   * @return sunHours
   */
  public double getSunHours(){
    return sunHours;
  }

  /**
   * Returns the name of the month as a string
   * @return monthStr string value of month
   */
  public String getMonthName(){
    String monthStr;
    switch(month){
      case 1: monthStr="January"; break;
      case 2: monthStr="February";break;
      case 3: monthStr="March";break;
      case 4: monthStr="April";break;
      case 5: monthStr="May";break;
      case 6: monthStr="June";break;
      case 7: monthStr="July";break;
      case 8: monthStr="August";break;
      case 9: monthStr="September";break;
      case 10:  monthStr="October";break;
      case 11:  monthStr="November";break;
      case 12:  monthStr="December";break;

      default:  monthStr="Invalid month"; break;
    }
    return monthStr;
  }
  /**
   *
   * @return boolean value
   */
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    if (!super.equals(object)) return false;

    WeatherRecord that = (WeatherRecord) object;

    if (year != that.year) return false;
    if (month != that.month) return false;
    if (Double.compare(that.maxTemp, maxTemp) != 0) return false;
    if (Double.compare(that.minTemp, minTemp) != 0) return false;
    if (frostDay != that.frostDay) return false;
    if (Double.compare(that.rainfall, rainfall) != 0) return false;
    if (Double.compare(that.sunHours, sunHours) != 0) return false;

    return true;
  }
  /**
   * Creates hashcode given all fields
   * @return boolean value
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    result = 31 * result + year;
    result = 31 * result + month;
    temp = Double.doubleToLongBits(maxTemp);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(minTemp);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + frostDay;
    temp = Double.doubleToLongBits(rainfall);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(sunHours);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
  /**
   * Compares objects on year and month only
   * @return int value
   **/
  public int compareTo(WeatherRecord other){
    int comp = Integer.compare(year,other.year);
    if (comp == 0){
      comp = Integer.compare(month,other.month);
    }
    return comp;
  }




}
