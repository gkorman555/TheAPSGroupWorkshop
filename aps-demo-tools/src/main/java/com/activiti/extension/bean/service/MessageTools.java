package com.activiti.extension.bean.service;

import java.util.Iterator;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.runtime.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("MessageToolsService")
public class MessageTools {

	@Autowired
	protected RuntimeService runtimeService;

	//Logger
    private static Logger logger = LoggerFactory.getLogger(MessageTools.class);

	public void findExecutionIdForMessage (final String messageName) {
	 	try {
			String infoStr="";
			logger.info("The Message Name - " + messageName);
			Thread.sleep(2000);
			for (Iterator<Execution> pI = runtimeService.createExecutionQuery().messageEventSubscriptionName(messageName).list().iterator(); pI.hasNext();){
				DelegateExecution currPI = (DelegateExecution) pI.next();
				infoStr = "Process Instance-" + currPI.getVariable("startInstanceID") + " Execution ID-" + currPI.getId() +" Description - "+ currPI.getCurrentActivityName() +",";
				logger.info("The Subscriber is - " + infoStr);
			}
		} catch (Exception e) {
			logger.error("There was an error ", e) ;
		}

	}
    
}
