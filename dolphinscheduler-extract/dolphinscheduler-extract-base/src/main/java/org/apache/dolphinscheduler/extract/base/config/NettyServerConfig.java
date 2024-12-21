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

package org.apache.dolphinscheduler.extract.base.config;

import java.time.Duration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NettyServerConfig {

    private String serverName;

    /**
     * init the server connectable queue
     */
    @Builder.Default
    private int soBacklog = 1024;

    /**
     * whether tcp delay
     */
    @Builder.Default
    private boolean tcpNoDelay = true;

    /**
     * whether keep alive
     */
    @Builder.Default
    private boolean soKeepalive = true;

    /**
     * send buffer size
     */
    @Builder.Default
    private int sendBufferSize = 65535;

    /**
     * receive buffer size
     */
    @Builder.Default
    private int receiveBufferSize = 65535;

    /**
     * worker threads，default get machine cpus
     */
    @Builder.Default
    private int workerThread = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * If done's receive any data from a {@link io.netty.channel.Channel} during 180s then will close it.
     */
    @Builder.Default
    private long connectionIdleTime = Duration.ofSeconds(60).toMillis();

    /**
     * listen port
     */
    private int listenPort;

}