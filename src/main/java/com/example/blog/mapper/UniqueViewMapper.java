package com.example.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.UniqueView;
import com.example.blog.model.dto.UniqueViewDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UniqueViewMapper extends BaseMapper<UniqueView> {

    List<UniqueViewDTO> listUniqueViews(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
