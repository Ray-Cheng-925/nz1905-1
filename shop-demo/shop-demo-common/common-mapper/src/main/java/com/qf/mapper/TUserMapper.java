package com.qf.mapper;

import com.qf.entity.TUser;
import tk.mybatis.mapper.common.Mapper;

public interface TUserMapper extends Mapper<TUser> {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    //以上请忽略
}