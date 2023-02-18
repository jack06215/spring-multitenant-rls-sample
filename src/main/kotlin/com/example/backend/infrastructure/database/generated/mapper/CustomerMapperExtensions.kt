package com.example.backend.infrastructure.database.generated.mapper

import com.example.backend.infrastructure.database.generated.mapper.CustomerDynamicSqlSupport.Customer
import com.example.backend.infrastructure.database.generated.mapper.CustomerDynamicSqlSupport.Customer.customerId
import com.example.backend.infrastructure.database.generated.mapper.CustomerDynamicSqlSupport.Customer.firstName
import com.example.backend.infrastructure.database.generated.mapper.CustomerDynamicSqlSupport.Customer.lastName
import com.example.backend.infrastructure.database.generated.mapper.CustomerDynamicSqlSupport.Customer.tenantName
import com.example.backend.infrastructure.database.generated.record.CustomerRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun CustomerMapper.count(completer: CountCompleter) =
    countFrom(this::count, Customer, completer)

fun CustomerMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Customer, completer)

fun CustomerMapper.deleteByPrimaryKey(customerId_: Long) =
    delete {
        where(customerId, isEqualTo(customerId_))
    }

fun CustomerMapper.insertMultipleHelper(multipleInsertStatement: MultiRowInsertStatementProvider<CustomerRecord>) =
    insertMultiple(multipleInsertStatement.insertStatement, multipleInsertStatement.records)

fun CustomerMapper.insert(record: CustomerRecord) =
    insert(this::insert, record, Customer) {
        map(firstName).toProperty("firstName")
        map(lastName).toProperty("lastName")
        map(tenantName).toProperty("tenantName")
    }

fun CustomerMapper.insertMultiple(records: Collection<CustomerRecord>) =
    insertMultiple(this::insertMultipleHelper, records, Customer) {
        map(firstName).toProperty("firstName")
        map(lastName).toProperty("lastName")
        map(tenantName).toProperty("tenantName")
    }

fun CustomerMapper.insertMultiple(vararg records: CustomerRecord) =
    insertMultiple(records.toList())

fun CustomerMapper.insertSelective(record: CustomerRecord) =
    insert(this::insert, record, Customer) {
        map(firstName).toPropertyWhenPresent("firstName", record::firstName)
        map(lastName).toPropertyWhenPresent("lastName", record::lastName)
        map(tenantName).toPropertyWhenPresent("tenantName", record::tenantName)
    }

private val columnList = listOf(customerId, firstName, lastName, tenantName)

fun CustomerMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Customer, completer)

fun CustomerMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Customer, completer)

fun CustomerMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Customer, completer)

fun CustomerMapper.selectByPrimaryKey(customerId_: Long) =
    selectOne {
        where(customerId, isEqualTo(customerId_))
    }

fun CustomerMapper.update(completer: UpdateCompleter) =
    update(this::update, Customer, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: CustomerRecord) =
    apply {
        set(firstName).equalTo(record::firstName)
        set(lastName).equalTo(record::lastName)
        set(tenantName).equalTo(record::tenantName)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: CustomerRecord) =
    apply {
        set(firstName).equalToWhenPresent(record::firstName)
        set(lastName).equalToWhenPresent(record::lastName)
        set(tenantName).equalToWhenPresent(record::tenantName)
    }

fun CustomerMapper.updateByPrimaryKey(record: CustomerRecord) =
    update {
        set(firstName).equalTo(record::firstName)
        set(lastName).equalTo(record::lastName)
        set(tenantName).equalTo(record::tenantName)
        where(customerId, isEqualTo(record::customerId))
    }

fun CustomerMapper.updateByPrimaryKeySelective(record: CustomerRecord) =
    update {
        set(firstName).equalToWhenPresent(record::firstName)
        set(lastName).equalToWhenPresent(record::lastName)
        set(tenantName).equalToWhenPresent(record::tenantName)
        where(customerId, isEqualTo(record::customerId))
    }