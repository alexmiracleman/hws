package org.alex.hws.dao.jdbc.mapper;

import org.alex.hws.entity.Solution;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SolutionRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        //prepare
        SolutionRowMapper solutionRowMapper = new SolutionRowMapper();
        LocalDateTime localDateTime = LocalDateTime.of(2023, 4, 18, 19, 22, 30);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.getString("author")).thenReturn("Alex");
        when(resultSetMock.getString("github_link")).thenReturn("github");
        when(resultSetMock.getString("comments")).thenReturn("Comment");
        when(resultSetMock.getString("task_name")).thenReturn("task name");
        when(resultSetMock.getInt("id")).thenReturn(101);
        when(resultSetMock.getTimestamp("publish_date")).thenReturn(timestamp);

        //when
        Solution actual = solutionRowMapper.mapRow(resultSetMock);

        assertEquals(101, actual.getId());
        assertEquals("Alex", actual.getAuthor());
        assertEquals("github", actual.getGithubLink());
        assertEquals("task name", actual.getTaskName());
        assertEquals("Comment", actual.getComments());
        assertEquals(localDateTime, actual.getPublishDateTimeStamp());



    }

}