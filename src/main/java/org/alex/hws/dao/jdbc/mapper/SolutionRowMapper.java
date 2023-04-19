package org.alex.hws.dao.jdbc.mapper;

import org.alex.hws.entity.Solution;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class SolutionRowMapper {

    public Solution mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String githubLink = resultSet.getString("github_link");
        String author = resultSet.getString("author");
        String comments = resultSet.getString("comments");
        Timestamp publishDateTimeStamp = resultSet.getTimestamp("publish_date");
        String taskName = resultSet.getString("task_name");


        Solution solution = Solution.builder().
                id(id)
                .githubLink(githubLink)
                .comments(comments)
                .taskName(taskName)
                .author(author)
                .publishDateTimeStamp(publishDateTimeStamp.toLocalDateTime())
                .build();

        return solution;



    }
}
