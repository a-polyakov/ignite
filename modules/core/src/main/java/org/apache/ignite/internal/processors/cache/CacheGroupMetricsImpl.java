/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Cache group metrics
 */
public class CacheGroupMetricsImpl implements CacheGroupMetrics {
    /** Number of partitions need processed for finished indexes create or rebuilding. */
    private final AtomicLong indexBuildCountPartitionsLeft;

    /** */
    public CacheGroupMetricsImpl() {
        indexBuildCountPartitionsLeft = new AtomicLong();
    }


    /** {@inheritDoc} */
    @Override public long getIndexBuildCountPartitionsLeft() {
        return indexBuildCountPartitionsLeft.get();
    }

    /** Set number of partitions need processed for finished indexes create or rebuilding. */
    public void setIndexBuildCountPartitionsLeft(long indexBuildCountPartitionsLeft) {
        this.indexBuildCountPartitionsLeft.set(indexBuildCountPartitionsLeft);
    }

    /**
     * Commit the complete index building for partition.
     * @return Decrement number of partitions need processed for finished indexes create or rebuilding.
     */
    public long decIndexBuildCountPartitionsLeft() {
        return indexBuildCountPartitionsLeft.decrementAndGet();
    }
}
