package org.alex.hws.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alex.hws.entity.Solution;
import org.alex.hws.service.SolutionService;
import org.alex.hws.web.util.PageGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ShowAllReviewsRequestServlet extends HttpServlet {
    private SolutionService solutionService;

    public ShowAllReviewsRequestServlet(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Solution> solutions = solutionService.findAll();
        PageGenerator pageGenerator = PageGenerator.instance();
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("solutions", solutions);
        String page = pageGenerator.getPage("reviews_list.html", parameters);
        resp.getWriter().write(page);
    }
}
