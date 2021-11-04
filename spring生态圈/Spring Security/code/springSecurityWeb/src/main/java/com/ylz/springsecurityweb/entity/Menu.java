package com.ylz.springsecurityweb.entity;

import lombok.Data;

/**
 * @author gwj
 * @since 2021-10-24 20:55
 */
@Data
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;
}
