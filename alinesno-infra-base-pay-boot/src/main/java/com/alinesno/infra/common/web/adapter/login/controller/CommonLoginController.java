//package com.alinesno.infra.common.web.adapter.login.controller;
//
//import com.alinesno.infra.common.facade.response.AjaxResult;
//import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
//import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//public class CommonLoginController {
//
//    /**
//     * 令牌
//     */
//    public static final String TOKEN = "token";
//
//    /**
//     * 登录方法
//     *
//     * @param loginBody 登录信息
//     * @return 结果
//     */
//    @PostMapping("/login")
//    public AjaxResult login(@RequestBody LoginBodyDto loginBody)
//    {
//        AjaxResult ajax = AjaxResult.success();
//        // 生成令牌
//        String token = UUID.randomUUID().toString() ;
//        ajax.put(TOKEN, token);
//        return ajax;
//    }
//
//    /**
//     * 获取用户信息
//     *
//     * @return 用户信息
//     */
//    @GetMapping("getInfo")
//    public AjaxResult getInfo() {
//
//        Map<String, Object> data = new HashMap<>();
//        // 将数据填充到data中...
//        data.put("permissions", new String[]{"*:*:*"});
//
//        Map<String, Object> user = new HashMap<>();
//        user.put("createBy", "admin");
//        user.put("createTime", "2023-04-23 16:11:38");
//        user.put("updateBy", null);
//        user.put("updateTime", null);
//        user.put("remark", "管理员");
//        user.put("userId", 1);
//        user.put("deptId", 103);
//        user.put("userName", "admin");
//        user.put("nickName", "AIP技术团队");
//        user.put("email", "aip-team@163.com");
//        user.put("phonenumber", "15888888888");
//        user.put("sex", "1");
//        user.put("avatar", "");
//        user.put("password", "");
//        user.put("status", "0");
//        user.put("delFlag", "0");
//        user.put("loginIp", "");
//        user.put("loginDate", "2023-09-21T16:54:12.000+08:00");
//
//        Map<String, Object> dept = new HashMap<>();
//        dept.put("createBy", null);
//        dept.put("createTime", null);
//        dept.put("updateBy", null);
//        dept.put("updateTime", null);
//        dept.put("remark", null);
//        dept.put("deptId", 103);
//        dept.put("parentId", 101);
//        dept.put("ancestors", "0,100,101");
//        dept.put("deptName", "研发部门");
//        dept.put("orderNum", 1);
//        dept.put("leader", "AIP技术团队");
//        dept.put("phone", null);
//        dept.put("email", null);
//        dept.put("status", "0");
//        dept.put("delFlag", null);
//        dept.put("parentName", null);
//        dept.put("children", new Object[]{});
//
//        user.put("dept", dept);
//
//        Map<String, Object> role = new HashMap<>();
//        role.put("createBy", null);
//        role.put("createTime", null);
//        role.put("updateBy", null);
//        role.put("updateTime", null);
//        role.put("remark", null);
//        role.put("roleId", 1);
//        role.put("roleName", "超级管理员");
//        role.put("roleKey", "admin");
//        role.put("roleSort", 1);
//        role.put("dataScope", "1");
//        role.put("menuCheckStrictly", false);
//        role.put("deptCheckStrictly", false);
//        role.put("status", "0");
//        role.put("delFlag", null);
//        role.put("flag", false);
//        role.put("menuIds", null);
//        role.put("deptIds", null);
//        role.put("permissions", null);
//        role.put("admin", true);
//
//        user.put("roles", new Object[]{role});
//
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put("user", user);
//        ajax.put("roles", user.get("roles"));
//        ajax.put("permissions", data.get("permissions"));
//
//        return ajax;
//    }
//
//    /**
//     * 获取路由信息
//     *
//     * @return 路由信息
//     */
//    @GetMapping("getRouters")
//    public AjaxResult getRouters()
//    {
//
//        Menu dashboardMenu = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new Menu.Meta("仪盘表", "dashboard", false, null), List.of(
//                new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null))
//        ));
//
//        Menu projectMenu = new Menu("PayApp", "/payApp", false, "noRedirect", "Layout", true, new Menu.Meta("商户管理", "clipboard", false, null),
//                List.of(
//                        new Menu("MchInfo", "base/pay/mchInfo/index", false,false,  "base/pay/mchInfo/index", new Menu.Meta("商户管理", "tree", false, null)),
//                        new Menu("MchApp", "base/pay/mchApp/index", false,false,  "base/pay/mchApp/index", new Menu.Meta("商户应用", "user", false, null)),
//                        new Menu("MchPayPassage", "base/pay/payChannel/index", false,false,  "base/pay/payChannel/index", new Menu.Meta("支付渠道", "education", false, null))
//                ));
//
//        List<Menu> menus = getMenus(dashboardMenu, projectMenu);
//
//        return AjaxResult.success(menus) ;
//    }
//
//    @NotNull
//    private static List<Menu> getMenus(Menu dashboardMenu, Menu projectMenu) {
//        Menu orderMenu = new Menu("Order", "/order", false, "noRedirect", "Layout", true, new Menu.Meta("支付订单", "log", false, null),
//                        List.of(
//                                new Menu("PayOrder", "base/pay/payOrder/index", false,false, "base/pay/payOrder/index", new Menu.Meta("支付订单", "form", false, null)),
//                                new Menu("RefundOrder", "base/pay/refundOrder/index", false,false, "base/pay/refundOrder/index", new Menu.Meta("退款订单", "logininfor", false, null)),
//                                new Menu("TransferOrder", "base/pay/transferOrder/index", false,false, "base/pay/transferOrder/index", new Menu.Meta("转账订单", "link", false, null)),
//                                new Menu("MchNotify", "base/pay/mchNotify/index", false,false, "base/pay/mchNotify/index", new Menu.Meta("商户通知", "people", false, null))
//                        ));
//
//        Menu monitorMenu = new Menu("Record", "/record", false, "noRedirect", "Layout", true, new Menu.Meta("记录审计", "monitor", false, null),
//                List.of(
//                        new Menu("PayRequest", "base/pay/apiRecord/index", false,false, "base/pay/apiRecord/index", new Menu.Meta("支付请求", "job", false, null))
//                ));
//
//        return List.of(dashboardMenu, projectMenu,  orderMenu , monitorMenu);
//    }
//}