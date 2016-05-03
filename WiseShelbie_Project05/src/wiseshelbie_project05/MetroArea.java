
package wiseshelbie_project05;


public class MetroArea {
    
    private String name;
    private String country;
    private double population;
    private double area;
    
    public MetroArea(String name, String country, double population, double area){
    this.name = name;
    this.country = country;
    this.population = population;
    this.area = area;
          
}
    public double getDensity(){
        return this.population * this.area;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the population
     */
    public double getPopulation() {
        return population;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }
    
    @Override
    public String toString(){
        return String.format("%-5s %-5s 1%5f %5f %5f", this.name, this.country, this.population, this.area, getDensity());
    }
    
}
