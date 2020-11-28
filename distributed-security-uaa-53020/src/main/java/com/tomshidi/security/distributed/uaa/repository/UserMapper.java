package com.tomshidi.security.distributed.uaa.repository;


import com.tomshidi.security.distributed.uaa.entity.PermissionEntity;
import com.tomshidi.security.distributed.uaa.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author TomShiDi
 * @description `
 * @date 2020-11-28 19:58:46
 **/
@Repository
public interface UserMapper {

    /**
     * `
     * @param username `
     * @return `
     */
    UserEntity getUserByUsername(@Param("username") String username);

    /**
     * `
     * @param userId `
     * @return `
     */
    List<PermissionEntity> getUserPermissionByUserId(@Param("user_id") String userId);
}
