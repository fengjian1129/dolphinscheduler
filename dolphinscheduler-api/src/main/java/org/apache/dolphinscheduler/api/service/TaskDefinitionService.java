/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.api.service;

import org.apache.dolphinscheduler.api.dto.task.TaskFilterRequest;
import org.apache.dolphinscheduler.api.utils.PageInfo;
import org.apache.dolphinscheduler.api.utils.Result;
import org.apache.dolphinscheduler.common.enums.ReleaseState;
import org.apache.dolphinscheduler.dao.entity.TaskDefinition;
import org.apache.dolphinscheduler.dao.entity.User;

import java.util.Map;

/**
 * task definition service
 */
public interface TaskDefinitionService {

    /**
     * query task definition
     *
     * @param loginUser login user
     * @param projectCode project code
     * @param workflowDefinitionCode workflow definition code
     * @param taskName task name
     */
    Map<String, Object> queryTaskDefinitionByName(User loginUser,
                                                  long projectCode,
                                                  long workflowDefinitionCode,
                                                  String taskName);

    /**
     * Get resource task definition by code
     *
     * @param loginUser login user
     * @param taskCode task code
     * @return TaskDefinition
     */
    TaskDefinition getTaskDefinition(User loginUser,
                                     long taskCode);

    /**
     * Get resource task definition according to query parameter
     *
     * @param loginUser         login user
     * @param taskFilterRequest taskFilterRequest
     * @return PageResourceResponse from condition
     */
    PageInfo<TaskDefinition> filterTaskDefinition(User loginUser,
                                                  TaskFilterRequest taskFilterRequest);

    /**
     * update task definition and upstream
     *
     * @param loginUser             login user
     * @param projectCode           project code
     * @param taskCode              task definition code
     * @param taskDefinitionJsonObj task definition json object
     * @param upstreamCodes         upstream task codes, sep comma
     * @return update result code
     */
    Map<String, Object> updateTaskWithUpstream(User loginUser,
                                               long projectCode,
                                               long taskCode,
                                               String taskDefinitionJsonObj,
                                               String upstreamCodes);

    /**
     * update task definition
     *
     * @param loginUser login user
     * @param projectCode project code
     * @param taskCode task code
     * @param version the version user want to switch
     */
    Map<String, Object> switchVersion(User loginUser,
                                      long projectCode,
                                      long taskCode,
                                      int version);

    /**
     * query the pagination versions info by one certain task definition code
     *
     * @param loginUser login user info to check auth
     * @param projectCode project code
     * @param taskCode task definition code
     * @param pageNo page number
     * @param pageSize page size
     * @return the pagination task definition versions info of the certain task definition
     */
    Result queryTaskDefinitionVersions(User loginUser,
                                       long projectCode,
                                       long taskCode,
                                       int pageNo,
                                       int pageSize);

    /**
     * delete the certain task definition version by version and code
     *
     * @param loginUser login user info
     * @param projectCode project code
     * @param taskCode the task definition code
     * @param version the task definition version user want to delete
     * @return delete version result code
     */
    Map<String, Object> deleteByCodeAndVersion(User loginUser,
                                               long projectCode,
                                               long taskCode,
                                               int version);

    /**
     * query detail of task definition by code
     *
     * @param loginUser login user
     * @param projectCode project code
     * @param taskCode the task definition code
     * @return task definition detail
     */
    Map<String, Object> queryTaskDefinitionDetail(User loginUser,
                                                  long projectCode,
                                                  long taskCode);

    /**
     * gen task code list
     *
     * @param genNum gen num
     * @return task code list
     */
    Map<String, Object> genTaskCodeList(Integer genNum);

    /**
     * release task definition
     *
     * @param loginUser login user
     * @param projectCode project code
     * @param code task definition code
     * @param releaseState releaseState
     * @return update result code
     */
    Map<String, Object> releaseTaskDefinition(User loginUser,
                                              long projectCode,
                                              long code,
                                              ReleaseState releaseState);

    void deleteTaskByWorkflowDefinitionCode(long workflowDefinitionCode, int workflowDefinitionVersion);
}
