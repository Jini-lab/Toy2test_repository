package com.fineapple.Infrastructure.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonCodeRepository {

    @Select("SELECT code, code_name, description FROM CommonCode")
    List<CommonCode> findAll();

    @Select("SELECT code, code_name, description FROM CommonCode WHERE code_name = #{name}")
    CommonCode findByCodeName(String name);
}
