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

/**
 *
 * @author Elena
 */
@WebServlet(name = "UserServlet", urlPatterns = {
    "/addProduct",
    "/createProduct",
    "/editProductForm",
    "/editProduct",
    "/editConsumerForm",
    "/editConsumer",
    "/listConsumers",
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
        String path = request.getServletPath();
        switch (path) {
            case "/addProduct":
                request.getRequestDispatcher("/WEB-INF/addProductForm.jsp").forward(request, response);
                break;
                
            case "/createProduct":
                String name = request.getParameter("name");
                String size = request.getParameter("size");
                String amount = request.getParameter("amount");
                String price = request.getParameter("price");
                if ("".equals(name) || name == null 
                        || "".equals(size) || size == null 
                        || "".equals(amount) || amount == null 
                        || "".equals(price) || price == null){
                    request.setAttribute("info","Заполните все поля!");
                    request.setAttribute("name",name);
                    request.setAttribute("size",size);
                    request.setAttribute("amount",amount);
                    request.setAttribute("price",price);
                    request.getRequestDispatcher("/WEB-INF/addProductForm.jsp").forward(request, response);
                    break;
                }
                Products product = new Products(name, size, Integer.parseInt(amount), Integer.parseInt(price));
                productFacade.create(product);
                request.setAttribute("info","Парник добавлен: " +product.toString());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
                
            case "/editProductForm":
                String productId = request.getParameter("productId");
                product = productFacade.find(Long.parseLong(productId));
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/editProductForm.jsp").forward(request, response);
                break;
                
            case "/editProduct":
                productId = request.getParameter("productId");
                product = productFacade.find(Long.parseLong(productId));
                name = request.getParameter("name");
                size = request.getParameter("size");
                amount = request.getParameter("amount");
                price = request.getParameter("price");
                if ("".equals(name) || name == null 
                        || "".equals(size) || size == null 
                        || "".equals(amount) || amount == null 
                        || "".equals(price) || price == null){
                    request.setAttribute("info","Поля не должны быть пустыми!");
                    request.setAttribute("productId", product.getId());
                    request.getRequestDispatcher("/editProductForm").forward(request, response);
                    break;
                }
                product.setName(name);
                product.setSize(size);
                product.setAmount(Integer.parseInt(amount));
                product.setPrice(Integer.parseInt(price));
                productFacade.edit(product);
                request.setAttribute("info","Товар отредактирован!");
                request.setAttribute("productId", product.getId());
                request.getRequestDispatcher("/editProductForm").forward(request, response);
                break;
                
            
            case "/editConsumerForm":
                String consumerId = request.getParameter("consumerId");
                Consumers consumer = consumerFacade.find(Long.parseLong(consumerId));
                request.setAttribute("consumer", consumer);
                request.getRequestDispatcher("/WEB-INF/editConsumerForm.jsp").forward(request, response);
                break;
                
            case "/editConsumer":
                consumerId = request.getParameter("consumerId");
                consumer = consumerFacade.find(Long.parseLong(consumerId));
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String money = request.getParameter("money");
                if ("".equals(firstName) || firstName == null 
                        || "".equals(lastName) || lastName == null 
                        || "".equals(money) || money == null){
                    request.setAttribute("info","Поля не должны быть пустыми!");
                    request.setAttribute("consumerId", consumer.getId());
                    request.getRequestDispatcher("/editConsumerForm").forward(request, response);
                    break;
                }
                consumer.setFirstName(firstName);
                consumer.setLastName(lastName);
                consumer.setMoney(Integer.parseInt(money));
                consumerFacade.edit(consumer);
                request.setAttribute("info","Пользователь отредактирован!");
                request.setAttribute("consumerId", consumer.getId());
                request.getRequestDispatcher("/editConsumerForm").forward(request, response);
                break;
                
            
            case "/listConsumers":
                List<Consumers> listConsumers = consumerFacade.findAll();
                request.setAttribute("listConsumers", listConsumers);
                request.getRequestDispatcher("/WEB-INF/listConsumers.jsp").forward(request, response);
                break;
                
            case "/buyProductForm":
                listConsumers = consumerFacade.findAll();
                request.setAttribute("listConsumers", listConsumers);
                List<Products> listProducts = productFacade.findAll();
                request.setAttribute("listProducts", listProducts);
                request.getRequestDispatcher("/WEB-INF/buyProductForm.jsp").forward(request, response);
                break;
                
            case "/buyProduct":
                productId = request.getParameter("productId");
                product = productFacade.find(Long.parseLong(productId));
                consumerId = request.getParameter("consumerId");
                consumer = consumerFacade.find(Long.parseLong(consumerId));
                
                if ("".equals(productId) || productId == null 
                        || "".equals(consumerId) || consumerId == null){
                    
                    request.setAttribute("info","Заполните все поля!");
                    listConsumers = consumerFacade.findAll();
                    request.setAttribute("listConsumers", listConsumers);
                    listProducts = productFacade.findAll();
                    request.setAttribute("listProducts", listProducts);
                    request.getRequestDispatcher("/WEB-INF/buyProductForm.jsp").forward(request, response);
                    break;
                }
                if (consumer.getMoney()<product.getPrice()) {
                    request.setAttribute("info", "Недостаточно средств");
                    listConsumers = consumerFacade.findAll();
                    request.setAttribute("listConsumers", listConsumers);
                    listProducts = productFacade.findAll();
                    request.setAttribute("listProducts", listProducts);
                    request.getRequestDispatcher("/WEB-INF/buyProductForm.jsp").forward(request, response);
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
