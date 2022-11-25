package com.example.backend.infrastructure.database.mapper

import com.example.backend.infrastructure.database.mapper.UserDynamicSqlSupport.User
import com.example.backend.infrastructure.database.mapper.UserDynamicSqlSupport.User.age
import com.example.backend.infrastructure.database.mapper.UserDynamicSqlSupport.User.id
import com.example.backend.infrastructure.database.mapper.UserDynamicSqlSupport.User.name
import com.example.backend.infrastructure.database.mapper.UserDynamicSqlSupport.User.profile
import com.example.backend.infrastructure.database.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insertMultipleHelper(multipleInsertStatement: MultiRowInsertStatementProvider<UserRecord>) =
    insertMultiple(multipleInsertStatement.insertStatement, multipleInsertStatement.records)

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(profile).toProperty("profile")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultipleHelper, records, User) {
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(profile).toProperty("profile")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(name).toPropertyWhenPresent("name", record::name)
        map(age).toPropertyWhenPresent("age", record::age)
        map(profile).toPropertyWhenPresent("profile", record::profile)
    }

private val columnList = listOf(id, name, age, profile)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(profile).equalTo(record::profile)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(profile).equalToWhenPresent(record::profile)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(profile).equalTo(record::profile)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(profile).equalToWhenPresent(record::profile)
        where(id, isEqualTo(record::id))
    }