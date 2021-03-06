package org.radrso.workflow.wfservice.service;

import org.radrso.workflow.entities.config.JarFile;
import org.radrso.workflow.entities.config.WorkflowConfig;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by raomengnan on 17-1-16.
 */
public interface WorkflowService {

    boolean save(WorkflowConfig workflowConfig);

    List<WorkflowConfig> getAll();

    Page<WorkflowConfig> getAll(int pno, int psize);

    WorkflowConfig getByWorkflowId(String workflowId);
    List<WorkflowConfig> getByApplication(String application);
    boolean delete(String workflowId);
    boolean deleteByApplication(String application);
    void stopWorkflow(String workflow);
    boolean restartWorkflow(String workflow, Date stopTime);

    /**
     * 以application将文件保存到相应的路径
     * 同一个application下的多个workflow可以共用同一套拓展jar文件
     * @param application
     * @param originFile
     * @return
     */
    boolean transferJarFile(String application, MultipartFile originFile);

    boolean saveJarFile(String application, String jarName, byte[] bytes);
    List<JarFile> listApplicationJarFiles(String application);

    void updateServiceStatus(WorkflowConfig workflowConfig);

}
