package com.example.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuVO {

    private Integer id;

    private String name;

    private String icon;

    private String path;

    private String component;

    private Integer orderNum;

    private Integer parentId;

    private Integer isHidden;

}
