package com.loop.web.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 9:48
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SourceCode {
    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private Integer solutionId;
    private String source;
}
