package com.example.blog.service;

import com.example.blog.model.dto.LabelOptionDTO;
import com.example.blog.model.dto.MenuDTO;
import com.example.blog.model.dto.UserMenuDTO;
import com.example.blog.model.vo.ConditionVO;
import com.example.blog.model.vo.MenuVO;

import java.util.List;

public interface MenuService {
    List<MenuDTO> listMenus(ConditionVO conditionVO);

    void saveOrUpdateMenu(MenuVO menuVO);

    void updateMenuIsHidden();

    void deleteMenu(Integer menuId);

    List<LabelOptionDTO> listMenuOptions();

    List<UserMenuDTO> listUserMenus();

}
