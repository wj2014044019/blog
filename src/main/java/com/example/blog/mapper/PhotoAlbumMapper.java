package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.PhotoAlbum;
import com.example.blog.model.dto.PhotoAlbumAdminDTO;
import com.example.blog.model.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoAlbumMapper extends BaseMapper<PhotoAlbum> {

    List<PhotoAlbumAdminDTO> listPhotoAlbumsAdmin(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO conditionVO);

}
