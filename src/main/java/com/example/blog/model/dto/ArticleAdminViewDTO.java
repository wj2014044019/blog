package com.example.blog.model.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author 花未眠
 * 文章编辑页码DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ArticleAdminViewDTO {

    private Integer id;

    private String articleTitle;

    private String articleContent;

    private String articleCover;

    private String categoryName;

    private List<String> tagNames;

    private Integer isTop;

    private Integer isFeatured;

    private Integer status;

    private Integer type;

    private String originalUrl;

    private String password;

}
