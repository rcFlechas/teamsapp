package com.rcflechas.teamsapp.models.data.local.dao

import androidx.room.*
import io.reactivex.Completable

@Dao
interface CrudDAO<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: T): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(entities: List<T>): Completable

    @Update
    fun update(entity: T): Completable

    @Delete
    fun delete(entity: T): Completable
}