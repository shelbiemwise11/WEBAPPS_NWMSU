
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/calories"})
public class calories extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calories</title>");    
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"calories.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bearcat Exercise Calculated Results</h1>");
            
            
            String act = request.getParameter("activity");          
            String moe = request.getParameter("method");          
            String dur = request.getParameter("duration");
            String h = request.getParameter("height");
            String w = request.getParameter("weight");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            
            
            if (dur.equals("")) {
              out.println("<h3>Mising duration time</h3>");
            }
            if (h.equals("")){
                 out.println("<h3>Mising height</h3>");          
            }
            if(w.equals("")){
                 out.println("<h3>Mising weight</h3>");          
            }
            if(age.equals("")){
                out.println("<h3>Mising age</h3>");
            }
            if(gender.equals("")){
                out.println("<h3>Mising gender</h3>");
            }
            if(moe.equals("")){
                 out.println("<h3>Mising method</h3>");
            }
           
            double bmr = 0.0;
            double met = 0.0;
            double duration = Integer.parseInt(dur);
            
            if(moe.equals("part")){
                if(act.equals("Aerobic")){
                    met = 6.83;
                }
                else if(act.equals("Baseball")){
                    met = 5;
                }
                else if(act.equals("Billiards")){
                    met = 2.5;
                }
                else if(act.equals("Climbing")){
                    met = 9.5;
                }
                else if(act.equals("Fencing")){
                    met = 6.0;
                }
                else if(act.equals("Golf")){
                    met = 3.75;
                }
                else if(act.equals("Hockey")){
                    met = 8.0;
                }
                else if(act.equals("Rugby")){
                    met = 10;
                }
                else if(act.equals("Swimming")){
                    met = 5.22;
                }
            }
            else if(moe.equals("watch")){
                met = 1.5;
            }
            
            
            
            //setting bmr based on sex/gender
              if(gender.equals( "male")){
                  bmr = 655 + ( 9.6 * Integer.parseInt(w)) + ( 1.85 * Integer.parseInt(h) ) - ( 4.68 * Integer.parseInt(age) ); //height in cm weight in kilos
              }
              else{
                  bmr = 66 + ( 13.75 * Integer.parseInt(w)) + ( 5 * Integer.parseInt(h) ) - ( 6.76 * Integer.parseInt(age) );
              }
                 
           
            double caloriesBurned =  ((bmr / 24) * met * duration);  //duration in hrs 
           
            
            
            if(!(request.getParameter("metric") == null)){
                out.printf("As a %s cm, %s kg %s, doing %s for %s hours, you burned %.1f calories!", h,w,gender,act,dur,caloriesBurned);
            }
            else{
                out.printf("As a %s ft, %s lb %s, doing %s for %s hours, you burned %.1f calories!", h,w,gender,act,dur,caloriesBurned);
            }
           
            out.println("</body>");
            out.println("</html>");
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
