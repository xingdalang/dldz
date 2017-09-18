package com.dzm.dldz.dao;

import com.dzm.dldz.bean.module.Module;
import com.dzm.dldz.bean.module.ModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Long moduleid);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Long moduleid);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}