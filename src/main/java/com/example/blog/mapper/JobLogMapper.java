package com.example.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.JobLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobLogMapper extends BaseMapper<JobLog> {

    List<String> listJobLogGroups();

}
