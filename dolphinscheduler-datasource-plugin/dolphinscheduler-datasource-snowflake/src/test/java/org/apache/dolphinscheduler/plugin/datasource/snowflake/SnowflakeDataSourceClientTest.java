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

package org.apache.dolphinscheduler.plugin.datasource.snowflake;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SnowflakeDataSourceClientTest {

    @Mock
    private SnowflakeDataSourceClient snowflakeDataSourceClient;

    @Test
    public void testCheckClient() {
        snowflakeDataSourceClient.checkClient();
        Mockito.verify(snowflakeDataSourceClient).checkClient();
    }

    @Test
    public void testGetConnection() {
        Connection connection = Mockito.mock(Connection.class);
        Mockito.when(snowflakeDataSourceClient.getConnection()).thenReturn(connection);
        Assertions.assertNotNull(snowflakeDataSourceClient.getConnection());

    }

}
