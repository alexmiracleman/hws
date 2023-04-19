package org.alex.hws.dao.jdbc;


import org.alex.hws.entity.Solution;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcSolutionDaoITest {
    @Test
    public void testFindAllReturnCorrectData() {
        JdbcSolutionDao jdbcSolutionDao = new JdbcSolutionDao();
        List<Solution> solutions = jdbcSolutionDao.findAll();
        assertFalse(solutions.isEmpty());
        for (Solution solution : solutions) {
            assertNotEquals(0, solution.getId());
            assertNotNull(solution.getAuthor());
            assertNotNull(solution.getComments());
            assertNotNull(solution.getPublishDateTimeStamp());
            assertNotNull(solution.getGithubLink());
        }


    }


}