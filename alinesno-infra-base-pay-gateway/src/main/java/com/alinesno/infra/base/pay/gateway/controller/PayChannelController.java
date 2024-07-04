package com.alinesno.infra.base.pay.gateway.controller;

import com.alinesno.infra.base.pay.entity.PayChannelEntity;
import com.alinesno.infra.base.pay.service.IPayChannelService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 处理与PayChannelEntity相关的请求的Controller。
 * 继承自BaseController类并实现IPayChannelService接口。
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "PayChannel")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/pay/payChannel")
public class PayChannelController extends BaseController<PayChannelEntity, IPayChannelService> {

    @Autowired
    private IPayChannelService service;

    /**
     * 获取PayChannelEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));

        // TODO Error: token 无效：Bearer f5c5d938-e39a-4aed-a972-436645fb373f
        long userId = 1L ; // CurrentAccountJwt.getUserId();

        long countGitRepository = service.count(new LambdaQueryWrapper<PayChannelEntity>().eq(PayChannelEntity::getOperatorId , userId));

        // 初始化用户仓库
        if (countGitRepository == 0) {
            service.initPayChannel(userId);
        }

        return this.toPage(model, this.getFeign(), page);
    }

    /**
     * 列出所有渠道类型
     * @return
     */
    @GetMapping("/listAllChannel")
    public AjaxResult listAllChannel(){
        return AjaxResult.success(service.list()) ;
    }

    @Override
    public IPayChannelService getFeign() {
        return this.service;
    }
}
