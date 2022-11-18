package com.example.backend.infrastructure.database.mapper

import com.example.backend.infrastructure.database.record.CustomerRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface CustomerMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.customerId")
    fun insert(insertStatement: InsertStatementProvider<CustomerRecord>): Int

    @Insert(
        "\${insertStatement}"
    )
    @Options(useGeneratedKeys=true,keyProperty="records.customerId")
    fun insertMultiple(@Param("insertStatement") insertStatement: String, @Param("records") records: List<CustomerRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="CustomerRecordResult", value = [
        Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        Result(column="tenant_name", property="tenantName", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectOne(selectStatement: SelectStatementProvider): CustomerRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="CustomerRecordResult", value = [
        Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        Result(column="tenant_name", property="tenantName", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<CustomerRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}