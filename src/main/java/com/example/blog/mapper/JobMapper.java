package com.example.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Job;
import com.example.blog.model.dto.JobDTO;
import com.example.blog.model.vo.JobSearchVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper extends BaseMapper<Job> {

    Integer countJobs(@Param("jobSearchVO") JobSearchVO jobSearchVO);

    List<JobDTO> listJobs(@Param("current") Long current, @Param("size") Long size, @Param("jobSearchVO")JobSearchVO jobSearchVO);

    List<String> listJobGroups();

}
