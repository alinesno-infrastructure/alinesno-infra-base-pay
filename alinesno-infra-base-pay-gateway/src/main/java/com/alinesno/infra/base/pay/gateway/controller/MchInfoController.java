package com.alinesno.infra.base.pay.gateway.controller;

import com.alinesno.infra.base.pay.entity.MchInfoEntity;
import com.alinesno.infra.base.pay.gateway.utils.MchIdUtil;
import com.alinesno.infra.base.pay.service.IMchInfoService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/pay/mchInfo")
public class MchInfoController extends BaseController<MchInfoEntity, IMchInfoService> {

    @Autowired
    private IMchInfoService service;

    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign() , page) ;
    }

    @ApiOperation("保存实体")
    @ResponseBody
    @PostMapping("saveMchInfo")
    public AjaxResult saveMchInfo(Model model, @RequestBody MchInfoEntity entity) throws Exception {

        // 生成商户号
        entity.setMchNo(MchIdUtil.getMchNo());
        if(entity.getType() == 1){  // 特约商户
            entity.setIsvNo(MchIdUtil.getIsvNo());
        }

        service.save(entity);
        return this.ok();
    }

    @Override
    public IMchInfoService getFeign() {
        return this.service;
    }
}
