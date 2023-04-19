package org.alex.hws.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
public class Solution {

    private int id;
    private String comments;
    private String githubLink;
    private String author;
    private LocalDateTime publishDateTimeStamp;
    private String taskName;

}
