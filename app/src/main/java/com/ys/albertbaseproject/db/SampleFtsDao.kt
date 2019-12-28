/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ys.albertbaseproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the [SampleFtsEntity] class.
 */
@Dao
interface SampleFtsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sampls: List<SampleFtsEntity>)

    @Query("SELECT * FROM sampleFts")
    suspend fun getAllSamples(): List<SampleFtsEntity>

    @Query("SELECT sampleId FROM sampleFts WHERE sampleFts MATCH :query")
    suspend fun searchAllSamples(query: String): List<String>
}