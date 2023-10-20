package com.atguigu.spzx.cloud.mapper;

import com.atguigu.spzx.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2023-10-20
 */
@Mapper
public interface UserMapper {

    User findById(long id);
}
