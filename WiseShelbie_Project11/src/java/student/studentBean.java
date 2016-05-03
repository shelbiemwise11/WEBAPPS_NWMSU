
package student;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "studentBean")
@RequestScoped
public class studentBean {
 
    private String firstName;
    private String lastName;
    private String password;
    private int greScore;
    private double gpa;
    private final double GPA = 4.0;
    private final int MIN_GRE = 130;
    private final int MAX_GRE = 170;
   
     public studentBean() {
       
        
    }
    
    
    public double getGPA() {
        return GPA;
    }

    public int getMIN_GRE() {
        return MIN_GRE;
    }

    public int getMAX_GRE() {
        return MAX_GRE;
    }
   
   

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the greScore
     */
    public int getGreScore() {
        return greScore;
    }

    /**
     * @param greScore the greScore to set
     */
    public void setGreScore(int greScore) {
        this.greScore = greScore;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public String getUserName(){
        return (firstName.substring(0, 1) + 
               firstName.substring(firstName.length() - 1) + 
               lastName.substring(0, 1) + 
               lastName.substring(lastName.length() - 1)).toLowerCase();
    }
    
    public int getIndex(){
        return (int)((((greScore - 130) / 10) + gpa ) * 12.5);
    }
    
}
