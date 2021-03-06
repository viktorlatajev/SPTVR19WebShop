/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Consumers;
import entity.Products;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ConsumersFacade;
import session.ProductsFacade;
import session.UserFacade;
import session.UserRolesFacade;

/**
 *
 * @author Elena
 */
@WebServlet(name = "UserServlet", urlPatterns = {
    
    "/buyProductForm",
    "/buyProduct"
    
})
public class UserServlet extends HttpServlet {
    @EJB
    private ProductsFacade productFacade;
    @EJB
    private ConsumersFacade consumerFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private UserRolesFacade userRolesFacade;
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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.setAttribute("info", "Войдите в систему!");
            request.getRequestDispatcher("/WEB-INF/showLoginForm.jsp").forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("info", "Войдите в систему!");
            request.getRequestDispatcher("/WEB-INF/showLoginForm.jsp").forward(request, response);
            return;
        }
        boolean isRole = userRolesFacade.isRole("CONSUMER", user);
        if(!isRole) {
            request.setAttribute("info", "Войдите в систему!");
            request.getRequestDispatcher("/WEB-INF/showLoginForm.jsp").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {  
            case "/buyProductForm":
                List<Products> listProducts = productFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                request.getRequestDispatcher("/WEB-INF/buyProductForm.jsp").forward(request, response);
                break;
                
            case "/buyProduct":
                String productId = request.getParameter("productId");
                Products product = productFacade.find(Long.parseLong(productId));
                
                Consumers consumer = user.getConsumers();
                
                if (product.getAmount()<=0){ 
                    request.setAttribute("info","Товар недоступен");
                    request.getRequestDispatcher("/buyProductForm").forward(request, response);
                    break;
                }
                if (consumer.getMoney()<product.getPrice()) {
                    request.setAttribute("info", "Недостаточно средств");
                    request.getRequestDispatcher("/buyProductForm").forward(request, response);
                    break;
                }
                consumer.setMoney(consumer.getMoney()-(product.getPrice()));
                consumerFacade.edit(consumer);
                product.setAmount(product.getAmount()-1);
                productFacade.edit(product);
                request.setAttribute("info","Товар куплен");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
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
