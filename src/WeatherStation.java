import java.util.*;
import java.io.*;

class WeatherStation{
  private String name;
  private Location location;
  private List<WeatherRecord> records = new LinkedList<>();

  /**
   * Reads contents of a file and uses the first two lines to initialise
   * the name and location fields.
   * @param filename name of the file we need to open
   * @throws FileNotFoundException in case of missing file or wrong filename
   */
  public WeatherStation(String filename) throws FileNotFoundException{

        Scanner input = new Scanner(new File(filename));
        List<String> line = new ArrayList<>();
        while(input.hasNextLine()){
          line.add(input.nextLine());
        }

        //Initialise name
        name = line.get(0);

        //Initialise location
        location = new Location(line.get(1));

        //Create records
        for (Integer i = 4; i < line.size(); i++) {
          WeatherRecord temp  = new WeatherRecord(line.get(i));
          records.add(temp);
        }


  }

  /**
   *
   * @return int value of the number of stored weather records
   */

  public int getRecordCount(){
    return records.size();
  }

  /**
   *
   * @return location returns location of the weather station
   */
  public Location getLocation(){
    return location;
  }

  /**
   *
   * @return name returns the name of the station
   */
  public String getName(){
    return name;
  }

  /**
   * Returns a single record from the data, given position
   * @param index position of the record we need
   * @return records.get(index) record itself
   */
  public WeatherRecord getRecord(int index){
    return records.get(index);
  }

  /**
   *  Returns a record representing the month with highest number of sunshine hours
   * @return records.get(index) record containing the highest number of sunshine hours
   */
  public WeatherRecord findSunniestMonth(){
    double maxSun = 0.0, tempMax= 0.0;

    //Stores the index of the sunniest month
    int index = 0;

    for (int i = 0; i < records.size(); i++){
      tempMax = records.get(i).getSunHours();

      if (tempMax > maxSun){
        maxSun = tempMax;
        index = i;
      }
    }
    return records.get(index);
  }

  /**
   * Sums rainfall measurements for each 12-month period and compares the sum
   * @return year with highest total rainfall
   */
  public int findWettestYear(){
    double temp=0.0;
    double max=0.0;
    int index=0, j = 0;

    for (int i = 0; i < records.size(); i+=12) {
      temp = 0;
      for ( j = 0; j < 12; j++) {
        temp+=records.get(j+i).getRainfall();
      }

      if(temp>max){
        max=temp;
        index = i+j;
      }

    }
    return records.get(index-1).getYear();
  }

  /**
   * Similiar to findWettestYear()
   * @return year with lowest total rainfall
   */
  public int findDriestYear(){
    //Holds the temporary lowest value of rainfall
    double temp=0.0;

    double min=0.0;

    int index=0, j = 0;

    for (int i = 0; i < records.size(); i+=12) {
      temp = 0;
      for ( j = 0; j < 12; j++) {
        temp+=records.get(j+i).getRainfall();

      }
      if ( i == 0){
        min = temp;
      }

      if(temp<min){
        min=temp;
        index = j+i;
      }

    }
    return records.get(index-1).getYear();
  }

  /**
   * Calculates average maximum temperature for a given month, averaged over the entire data
   * @param month int value of month
   * @return average maximum temperature
   */
  public double meanMaxTemp(int month){
    double maxTemp=0;
    int counter=0;
    for(int i=0; i< records.size(); i++){
      if(records.get(i).getMonth()==month){
        maxTemp+=records.get(i).getMaxTemp();
        counter++;
        }

    }
    return maxTemp/counter;
  }

  /**
   * Calculates total rainfall measured during year specified
   * @param year integer value representing the year
   * @return sum double representing the total rainfall
   */
  public double totalRainfall(int year){
    double sum=0.0;
    int index=0;

    for(index =0;index<records.size();index+=12){
      if(year==records.get(index).getYear()){
        for(int j=0;j<12;j++){
          sum+=records.get(index+j).getRainfall();
        }
      }
    }
    return sum;
  }
}
