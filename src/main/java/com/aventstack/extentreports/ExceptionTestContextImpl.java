package com.aventstack.extentreports;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aventstack.extentreports.model.ExceptionInfo;
import com.aventstack.extentreports.model.ExceptionTestContext;
import com.aventstack.extentreports.model.Test;

public class ExceptionTestContextImpl {
    List<ExceptionTestContext> exTestContextList;
    
    public ExceptionTestContextImpl() { 
        exTestContextList = new ArrayList<>();
    }
    
    public void setExceptionContext(ExceptionInfo ei, Test test) {
        Optional<ExceptionTestContext> exOptionalTestContext = exTestContextList.stream().filter(x -> x.getExceptionInfo().getExceptionName().equals(ei.getExceptionName())).findFirst();
        
        if (exOptionalTestContext.isPresent()) {
            exOptionalTestContext.get().setTest(test);
        }
        else {
            ExceptionTestContext exTestContext = new ExceptionTestContext(ei);
            exTestContext.setTest(test);
            exTestContextList.add(exTestContext);
        }
    }

    public List<ExceptionTestContext> getExceptionTestContextList() { 
        return exTestContextList; 
    }
}
