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
import javax.servlet.http.HttpSession;

/**
 *
 * @author S518423
 */
@WebServlet(urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

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
           
           HttpSession session = request.getSession();
           String arrA = request.getParameter("arrA");
           session.setAttribute("ArrayA", arrA); 
           String arrB = request.getParameter("arrB");
           session.setAttribute("ArrayB", arrB); 
           
           String[] arrayA = arrA.split(";");
           String[] arrayB = arrB.split(";");
           String[] sumofArrays = new String[arrayA.length];
           for(int i =0;i<arrayA.length;i++){
               String[] arr1 = arrayA[i].split(" ");
               String[] arr2 = arrayB[i].split(" ");
               sumofArrays[i] = "";
               for(int j=0;j<arr1.length;j++){
                   int sum = Integer.parseInt(arr1[j]) + Integer.parseInt(arr2[j]);
                   sumofArrays[i] += String.format("%d ", sum);
               }
               
           }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Addition operation on 2D arrays</h1>");
            out.println("<pre>");
            for(int i =0;i<sumofArrays.length;i++){
                out.printf("%s + %s = %s\n", arrayA[i], arrayB[i], sumofArrays[i]);
            }
            out.println("</pre>");
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
