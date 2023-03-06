package com.example.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConditionVO {

    private Long current;

    private Long size;

    private String keywords;

    private Integer categoryId;

    private Integer loginType;

    private Integer type;

    private Integer status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    //是否审核
    private Integer isReview;

    //是否置顶
    private Integer isTop;
    //是否推荐
    private Integer isFeatured;


}
