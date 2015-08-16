package org.kayura.bpm.engine.executor;

import org.kayura.bpm.engine.IWorkflowContext;
import org.kayura.bpm.exceptions.WorkflowException;
import org.kayura.bpm.types.Actor;
import org.kayura.bpm.types.StartArgs;
import org.kayura.bpm.types.StartResult;

public class StartupWorkflowExecutor extends Executor<StartResult> {
    
    private StartArgs args;
    
    public StartupWorkflowExecutor(StartArgs args) {
	this.args = args;
    }
    
    @Override
    public StartResult doRun(IWorkflowContext context) {
	
	StartResult result = new StartResult();
	
	try {
	    argsCheck();
	    
	} catch (Exception e) {
	    result.setError("流程启动失败。原因：%s", e.getMessage());
	}
	
	return result;
    }
    
    private void argsCheck() {
	
	if (args != null) {
	    throw new WorkflowException("必须定义流程的启动参数，不允许为空。");
	}
	
	Actor actor = args.getActor();
	if (actor == null) {
	    throw new WorkflowException("必须定义流程的启动者。");
	}
	
    }
    
}