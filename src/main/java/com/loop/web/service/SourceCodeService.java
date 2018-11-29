package com.loop.web.service;

import com.loop.web.bean.SourceCode;
import com.loop.web.dao.SourceCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 11:21
 */
@Service
public class SourceCodeService {
    @Autowired
    SourceCodeDao sourceCodeDao;
    public void addSourceCode(SourceCode sourceCode) {

        sourceCodeDao.addSourceCode(sourceCode);
    }

    public SourceCode getCodeById(Integer id) {
        return sourceCodeDao.getCodeById(id);
    }
}
