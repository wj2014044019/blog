package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.blog.entity.Menu;
import com.example.blog.mapper.MenuMapper;
import com.example.blog.mapper.RoleMenuMapper;
import com.example.blog.model.dto.LabelOptionDTO;
import com.example.blog.model.dto.MenuDTO;
import com.example.blog.model.dto.UserMenuDTO;
import com.example.blog.model.vo.ConditionVO;
import com.example.blog.model.vo.MenuVO;
import com.example.blog.service.MenuService;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;

    private final RoleMenuMapper roleMenuMapper;

    @Override
    public List<MenuDTO> listMenus(ConditionVO conditionVO) {
        List<Menu> menus = menuMapper.selectList(new LambdaQueryWrapper<Menu>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()),Menu::getName,conditionVO.getKeywords()));
        List<Menu> catalogs = listCatalogs(menus);
        Map<Integer,List<Menu>> childrenMap = getMenuMap(menus);
        List<MenuDTO> menuDTOS = catalogs.stream().map(item -> {
            MenuDTO menuDTO = new MenuDTO();
            BeanUtils.copyProperties(item,menuDTO);
            List<MenuDTO> list =  childrenMap.get(item.getId()).stream().map(
                    items-> {
                        MenuDTO menusDTO = new MenuDTO();
                        BeanUtils.copyProperties(items,menusDTO);
                        return menusDTO;
                    }
            ).collect(Collectors.toList());
            menuDTO.setChildren(list);
            return menuDTO;
        }).sorted(Comparator.comparing(MenuDTO::getOrderNum)).collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(childrenMap)) {
            List<Menu> childrenList = new ArrayList<>();
            childrenMap.values().forEach(childrenList::addAll);
            List<MenuDTO> childrenDTOList = childrenList.stream()
                    .map(item -> {
                        MenuDTO menuDTO = new MenuDTO();
                        BeanUtils.copyProperties(item,menuDTO);
                        return menuDTO;
                    })
                    .sorted(Comparator.comparing(MenuDTO::getOrderNum))
                    .collect(Collectors.toList());
            menuDTOS.addAll(childrenDTOList);
        }
        return menuDTOS;
    }

    private Map<Integer, List<Menu>> getMenuMap(List<Menu> menus) {
        return menus.stream()
                .filter(item -> Objects.nonNull(item.getPath()))
                .collect(Collectors.groupingBy(Menu::getParentId));
    }

    private List<Menu> listCatalogs(List<Menu> menus) {
        return menus.stream()
                .filter(item -> Objects.isNull(item.getParentId()))
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());

    }

    @Override
    public void saveOrUpdateMenu(MenuVO menuVO) {

    }

    @Override
    public void updateMenuIsHidden() {

    }

    @Override
    public void deleteMenu(Integer menuId) {

    }

    @Override
    public List<LabelOptionDTO> listMenuOptions() {
        return null;
    }

    @Override
    public List<UserMenuDTO> listUserMenus() {
        return null;
    }
}
