package com.example.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Category;
import com.example.blog.model.dto.CategoryAdminDTO;
import com.example.blog.model.dto.CategoryDTO;
import com.example.blog.model.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryDTO> listCategories();

    List<CategoryAdminDTO> listCategoriesAdmin(@Param("current") Long current, @Param("size") Long size, @Param("conditionVO") ConditionVO conditionVO);

}
