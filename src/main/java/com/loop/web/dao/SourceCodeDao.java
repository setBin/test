package com.loop.web.dao;

import com.loop.web.bean.SourceCode;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 11:26
 */
public interface SourceCodeDao {



    void addSourceCode(SourceCode sourceCode);

    SourceCode getCodeById(Integer id);
}
