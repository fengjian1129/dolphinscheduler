package org.apache.dolphinscheduler.plugin.task.sql;

import org.apache.dolphinscheduler.common.utils.LoggerUtils;
import org.apache.dolphinscheduler.plugin.task.api.TaskExecutionContext;

import org.apache.hive.jdbc.HiveStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;

/**
 * HiveSqlLogThread
 */
public class HiveSqlLogThread extends Thread {
    private final HiveStatement statement;
    private final Logger logger;
    private final TaskExecutionContext taskExecutionContext;

    public HiveSqlLogThread(Statement statement, Logger logger, TaskExecutionContext taskExecutionContext) {
        this.statement = (HiveStatement) statement;
        this.logger = logger;
        this.taskExecutionContext = taskExecutionContext;
    }

    @Override
    public void run() {
        if (statement == null) {
            logger.info("hive statement is null,end this log query!");
            return;
        }
        try {
            while (!statement.isClosed() && statement.hasMoreLogs()) {
                for (String log: statement.getQueryLog(true,500)) {
                    logger.info(log);
                    List<String> appIds = LoggerUtils.getAppIds(log, logger);
                    if (!appIds.isEmpty()) {
                        taskExecutionContext.setAppIds(String.join(",", appIds));
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("listen hive log thread error,exception:[{}]",e);
        }
    }
}
