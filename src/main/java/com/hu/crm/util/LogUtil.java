package com.hu.crm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hu.crm.domain.Employee;
import com.hu.crm.domain.Log;
import com.hu.crm.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class LogUtil {
    @Autowired
    private ILogService logService;
    public void writeLog(JoinPoint joinPoint) {
        if(joinPoint.getTarget() instanceof ILogService){
            return;
        }
        Log log = new Log();
        HttpServletRequest request = UserContext.get();
        Employee currentUser = (Employee) request.getSession().getAttribute(UserContext.USERINSESSION);
        String remoteAddr = request.getRemoteAddr();
        String function = joinPoint.getTarget().getClass().getName() + ":" + joinPoint.getSignature().getName();
        ObjectMapper mapper = new ObjectMapper();
        String params = null;
        try {
            params = mapper.writeValueAsString(joinPoint.getArgs());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.setFunction(function);
        log.setOpuser(currentUser);
        log.setOpip(remoteAddr);
        log.setParams(params);
        log.setOptime(new Date());
        logService.insert(log);
    }
}
