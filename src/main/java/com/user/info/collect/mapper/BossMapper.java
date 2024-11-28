package com.user.info.collect.mapper;

import com.user.info.collect.entity.Boss;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BossMapper {

    void save(Boss boss);
}
