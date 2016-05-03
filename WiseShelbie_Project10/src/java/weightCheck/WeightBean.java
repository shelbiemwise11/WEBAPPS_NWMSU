package weightCheck;


import javax.inject.Named;
import javax.enterprise.context.Dependent;


@Named(value = "weightBean")
@Dependent
public class WeightBean {

   private String name;
   private Double earthWeight;
   private Double desiredWeight;
   private String potPlanets;
   
    
    public WeightBean() {
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the earthWeight
     */
    public Double getEarthWeight() {
        return earthWeight;
    }

    /**
     * @param earthWeight the earthWeight to set
     */
    public void setEarthWeight(Double earthWeight) {
        this.earthWeight = earthWeight;
    }

    /**
     * @return the desiredWeight
     */
    public Double getDesiredWeight() {
        return desiredWeight;
    }

    /**
     * @param desiredWeight the desiredWeight to set
     */
    public void setDesiredWeight(Double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    /**
     * @return the potPlanets
     */
    public String getPotPlanets() {
        return potPlanets;
    }

    /**
     * @param potPlanets the potPlanets to set
     */
    public void setPotPlanets(String potPlanets) {
        this.potPlanets = potPlanets;
    }
    
    
    public String calculate(){
        return name + earthWeight;
    }
}
