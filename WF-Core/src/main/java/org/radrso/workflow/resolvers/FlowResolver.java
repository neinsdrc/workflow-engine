package org.radrso.workflow.resolvers;

import org.radrso.workflow.entities.config.items.Judge;
import org.radrso.workflow.entities.config.items.Step;
import org.radrso.workflow.entities.config.items.Transfer;
import org.radrso.workflow.entities.exceptions.ConfigReadException;
import org.radrso.workflow.entities.exceptions.UnknownExceptionInRunning;
import org.radrso.workflow.entities.response.WFResponse;
import org.radrso.workflow.entities.wf.WorkflowInstance;

import java.util.List;

/**
 * Created by rao-mengnan on 2017/3/16.
 */
public interface FlowResolver {

    /**
     * 工作流程向下个状态转移一次:
     * 当前状态 -- > 当前转移函数 -- > 下一个转移状态 + 分支状态
     *
     * @return
     * @throws ConfigReadException
     */
    FlowResolver next() throws ConfigReadException, UnknownExceptionInRunning;

    /**
     * 回滚到上一步
     *
     * @return
     */
    FlowResolver rollback();

    /**
     * @return 当前是否为最后一步
     */
    boolean eof();

    /**
     * 从分支列表中取出一条
     * get and remove
     *
     * @return
     */
    Transfer popBranchTransfer();

    /**
     * 状态转移函数到下一个状态的转换
     * 若没有判断函数，则直接转移到状态转移函数定义的下一个状态以及分支状态
     * 若有判断函数，判断函数 --> 状态转移函数 --> 下一状态
     *
     * @param transfer
     * @return
     * @throws ConfigReadException
     */
    Step transferToNextStep(Transfer transfer) throws ConfigReadException, UnknownExceptionInRunning;

    /**
     * 通过判断函数获取下一个要转移的的状态
     *
     * @param judge
     * @return
     * @throws ConfigReadException
     */
    Transfer judgeNextTransfer(Judge judge) throws ConfigReadException, UnknownExceptionInRunning;

    /**
     * 更新workflowInstance中的response记录
     *
     * @param sign
     * @param response
     */
    void updateResponse(String sign, WFResponse response);

    WorkflowInstance getWorkflowInstance();

    Step getCurrentStep();

    void setCurrentStep(Step currentStep);

    Transfer getCurrentTransfer();

    Object[] getCurrentStepParams();

    String[] getCurrentStepParamNames();

    List<Transfer> getScatterBranches(Transfer transfer);

    Step getLastStep();

    Transfer getLastTransfer();

}
