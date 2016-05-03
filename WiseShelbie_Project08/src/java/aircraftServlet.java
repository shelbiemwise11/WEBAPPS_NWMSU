/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s518423
 */
@WebServlet(urlPatterns = {"/aircraftServlet"})
public class aircraftServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
           
            
            
            String planeType = request.getParameter("planeType");
            String fuelLevel = request.getParameter("level");
            String passNum = request.getParameter("pass");
            String raft = request.getParameter("raft");
            String vest = request.getParameter("vest");
            double weight = 0.0;
            double time = 0.0;
            
            
            
            if (planeType.equals("MC9")){    //checking for play type adding its weight
                weight += 50000;
            }
            else if(planeType.equals("MD83")){
                weight += 75000;
            }
            
            if (fuelLevel.equals("topOff")){   //checking fuel level adding weight
                weight += 10000;
            }
            else if (fuelLevel.equals("half")){
                weight += 5000;
            }
            else if (fuelLevel.equals("min")){
                weight += 1000;
            }
            
            double totalPassengers = Integer.parseInt(passNum);     //adding the time and weight per passenger 
            double randTime = Math.floor(Math.random() * (3 - 1 + 1)) +1 ;       
            weight += totalPassengers * 150;
            time += totalPassengers * randTime;
            
            if(raft.equals("raft")){
                weight += 150;
            }
            if(vest.equals("vest")){
                weight += 300;
            }
            
            
            
            try (PrintWriter out = response.getWriter()) {
              out.println("Estimated weight of aircraft is " + weight + " lb");
              out.println("Estimated boarding time for the aircraft is " + time + " minutes" );
            }
            
         
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



/*
 var pass = parseInt(document.getElementById("numOfPass").value)
   if (pass !== 0){
       randTime = Math.floor(Math.random() * (3 - 1 + 1)) +1 ;
        time += pass * randTime;
        weight += pass * 150;
   }
   else{
       allFilled = false;
   }
   
   if(document.getElementById("raft").checked){
       weight += RAFT;
   }
   else if(document.getElementById("vest").checked){
       weight += VEST;
   }
   
   if(allFilled){
       document.getElementById("weight").innerHTML = "Estimated weight is: " + weight + " lbs";
       document.getElementById("time").innerHTML = "Estimated time is: " + time + " minutes";
   }


*/