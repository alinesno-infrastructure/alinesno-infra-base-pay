package com.alinesno.infra.base.pay.init;

import com.alinesno.infra.base.pay.entity.PayOrderEntity;
import com.alinesno.infra.base.pay.entity.TransferOrderEntity;
import com.alinesno.infra.base.pay.service.IPayOrderService;
import com.alinesno.infra.base.pay.service.ITransferOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static cn.hutool.core.date.DateUtil.parseDate;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    IPayOrderService orderService ;

    @Autowired
    ITransferOrderService transferOrderService ;

    public void initTransferOrderData(){

        long count =  transferOrderService.count() ;

        if(count < 15){

            List<TransferOrderEntity> list = new ArrayList<>() ;

            TransferOrderEntity payOrder1 = new TransferOrderEntity();
            payOrder1.setIfCode("alipay");
            payOrder1.setAccountName("");
            payOrder1.setMchOrderNo("M17199859256592143");
            payOrder1.setIsvNo("V1679222188");
            payOrder1.setAccountNo("18986215002");
            payOrder1.setAppId("6684c6c0e4b0e42ba622b160");
            payOrder1.setCurrency("CNY");
            payOrder1.setState(0);
            payOrder1.setMchNo("M1679222244");
            payOrder1.setEntryType("ALIPAY_CASH");
            payOrder1.setAmount(1);
            payOrder1.setMchName("伙计小店");
            payOrder1.setTransferDesc("打款");
            payOrder1.setTransferId("T1808378164108349442");
            payOrder1.setMchType(2);
            payOrder1.setClientIp("139.159.251.169");
            payOrder1.setNotifyUrl("");

            TransferOrderEntity payOrder2 = new TransferOrderEntity();
            payOrder2.setIfCode("alipay");
            payOrder2.setAccountName("");
            payOrder2.setMchOrderNo("M17199859019681287");
            payOrder2.setIsvNo("V1679222188");
            payOrder2.setAccountNo("18986215002");
            payOrder2.setAppId("6684c6c0e4b0e42ba622b160");
            payOrder2.setCurrency("CNY");
            payOrder2.setState(0);
            payOrder2.setMchNo("M1679222244");
            payOrder2.setEntryType("ALIPAY_CASH");
            payOrder2.setAmount(1);
            payOrder2.setMchName("伙计小店");
            payOrder2.setTransferDesc("打款");
            payOrder2.setTransferId("T1808378137554210818");
            payOrder2.setMchType(2);
            payOrder2.setClientIp("139.159.251.169");
            payOrder2.setNotifyUrl("");

            TransferOrderEntity payOrder3 = new TransferOrderEntity();
            payOrder3.setIfCode("alipay");
            payOrder3.setAccountName("林波");
            payOrder3.setMchOrderNo("M17196253294957093");
            payOrder3.setIsvNo("V1679222188");
            payOrder3.setAccountNo("o6BcIwgB7G-pnHAE1QB0vG5KHf7E");
            payOrder3.setAppId("66559b93e4b0a55927bb5bce");
            payOrder3.setCurrency("CNY");
            payOrder3.setState(0);
            payOrder3.setMchNo("M1679222244");
            payOrder3.setEntryType("ALIPAY_CASH");
            payOrder3.setAmount(1);
            payOrder3.setMchName("伙计小店");
            payOrder3.setTransferDesc("打款");
            payOrder3.setTransferId("T1806865928525205505");
            payOrder3.setMchType(2);
            payOrder3.setClientIp("139.159.251.169");
            payOrder3.setNotifyUrl("");

            TransferOrderEntity payOrder4 = new TransferOrderEntity();
            payOrder4.setIfCode("alipay");
            payOrder4.setAccountName("林波");
            payOrder4.setMchOrderNo("M17196252534359695");
            payOrder4.setIsvNo("V1679222188");
            payOrder4.setAccountNo("15756467270");
            payOrder4.setAppId("667961ece4b0e42ba622b151");
            payOrder4.setCurrency("CNY");
            payOrder4.setState(0);
            payOrder4.setMchNo("M1679222244");
            payOrder4.setEntryType("ALIPAY_CASH");
            payOrder4.setAmount(1);
            payOrder4.setMchName("伙计小店");
            payOrder4.setTransferDesc("打款");
            payOrder4.setTransferId("T1806865601654706177");
            payOrder4.setMchType(2);
            payOrder4.setClientIp("139.159.251.169");
            payOrder4.setNotifyUrl("");

            list.add(payOrder1) ;
            list.add(payOrder2) ;
            list.add(payOrder3) ;
            list.add(payOrder4) ;

            transferOrderService.saveBatch(list) ;
        }

    }

    public void initOrderData(){
       long count = orderService.count() ;
       if(count < 15){

           List<PayOrderEntity> list = new ArrayList<>() ;

           PayOrderEntity payOrderEntity1 = new PayOrderEntity();
           payOrderEntity1.setIfCode("plspay");
           payOrderEntity1.setPayOrderId("P1808487977400160258");
           payOrderEntity1.setWayName("微信H5");
           payOrderEntity1.setMchOrderNo("M17200121006555037");
           payOrderEntity1.setSubject("接口调试[M1679219294商户联调]");
           payOrderEntity1.setChannelOrderNo("P1808487978225963010");
           payOrderEntity1.setBody("接口调试[M1679219294商户联调]");
           payOrderEntity1.setRefundTimes(0L);
           payOrderEntity1.setAddTime(parseDate("2024-07-03 21:08:28"));
           payOrderEntity1.setAppId("6416da5ee4b00bed884be286");
           payOrderEntity1.setCurrency("CNY");
           payOrderEntity1.setDivisionFlag(0L);
           payOrderEntity1.setState(6L);
           payOrderEntity1.setReturnUrl("");
           payOrderEntity1.setMchNo("M1679219294");
           payOrderEntity1.setRefundAmount(0L);
           payOrderEntity1.setUpdateTime(parseDate("2024-07-03 23:09:00"));
           payOrderEntity1.setAmount(1L);
           payOrderEntity1.setMchName("火锅鸡");
           payOrderEntity1.setWayCode("WX_H5");
           payOrderEntity1.setExpiredTime(parseDate("2024-07-03 23:08:29"));
           payOrderEntity1.setNotifyState(0L);
           payOrderEntity1.setMchType(1L);
           payOrderEntity1.setClientIp("116.21.80.27");
           payOrderEntity1.setNotifyUrl("http://mch.d.jeepay.vip/api/anon/paytestNotify/payOrder");

           PayOrderEntity payOrderEntity2 = new PayOrderEntity();
           payOrderEntity2.setIfCode("plspay");
           payOrderEntity2.setPayOrderId("P1808487949218631682");
           payOrderEntity2.setWayName("支付宝二维码");
           payOrderEntity2.setMchOrderNo("M17200120980605406");
           payOrderEntity2.setSubject("接口调试[M1679219294商户联调]");
           payOrderEntity2.setErrMsg("商户应用不支持该支付方式");
           payOrderEntity2.setChannelOrderNo("P1808487906570473474");
           payOrderEntity2.setBody("接口调试[M1679219294商户联调]");
           payOrderEntity2.setRefundTimes(0L);
           payOrderEntity2.setAddTime(parseDate("2024-07-03 21:08:21"));
           payOrderEntity2.setAppId("6416da5ee4b00bed884be286");
           payOrderEntity2.setCurrency("CNY");
           payOrderEntity2.setDivisionFlag(0L);
           payOrderEntity2.setState(3L);
           payOrderEntity2.setReturnUrl("");
           payOrderEntity2.setMchNo("M1679219294");
           payOrderEntity2.setRefundAmount(0L);
           payOrderEntity2.setUpdateTime(parseDate("2024-07-03 21:08:22"));
           payOrderEntity2.setAmount(1L);
           payOrderEntity2.setMchName("火锅鸡");
           payOrderEntity2.setWayCode("ALI_QR");
           payOrderEntity2.setExpiredTime(parseDate("2024-07-03 23:08:22"));
           payOrderEntity2.setNotifyState(0L);
           payOrderEntity2.setMchType(1L);
           payOrderEntity2.setErrCode("9999");
           payOrderEntity2.setClientIp("116.21.80.27");
           payOrderEntity2.setNotifyUrl("http://mch.d.jeepay.vip/api/anon/paytestNotify/payOrder");

           PayOrderEntity payOrderEntity3 = new PayOrderEntity();
           payOrderEntity3.setIfCode("plspay");
           payOrderEntity3.setPayOrderId("P1808487905664978945");
           payOrderEntity3.setWayName("微信扫码");
           payOrderEntity3.setMchOrderNo("M17200120681723840");
           payOrderEntity3.setSubject("接口调试[M1679219294商户联调]");
           payOrderEntity3.setChannelOrderNo("P1808487906570473474");
           payOrderEntity3.setBody("接口调试[M1679219294商户联调]");
           payOrderEntity3.setRefundTimes(0L);
           payOrderEntity3.setAddTime(parseDate("2024-07-03 21:08:11"));
           payOrderEntity3.setAppId("6416da5ee4b00bed884be286");
           payOrderEntity3.setCurrency("CNY");
           payOrderEntity3.setDivisionFlag(0L);
           payOrderEntity3.setState(6L);
           payOrderEntity3.setReturnUrl("");
           payOrderEntity3.setMchNo("M1679219294");
           payOrderEntity3.setRefundAmount(0L);
           payOrderEntity3.setUpdateTime(parseDate("2024-07-03 23:09:00"));
           payOrderEntity3.setAmount(1L);
           payOrderEntity3.setMchName("火锅鸡");
           payOrderEntity3.setWayCode("WX_NATIVE");
           payOrderEntity3.setExpiredTime(parseDate("2024-07-03 23:08:11"));
           payOrderEntity3.setNotifyState(0L);
           payOrderEntity3.setMchType(1L);
           payOrderEntity3.setClientIp("116.21.80.27");
           payOrderEntity3.setNotifyUrl("http://mch.d.jeepay.vip/api/anon/paytestNotify/payOrder");

           list.add(payOrderEntity1) ;
           list.add(payOrderEntity2) ;
           list.add(payOrderEntity3) ;

           orderService.saveBatch(list) ;
       }
    }

    @Override
    public void run(String... args) throws Exception {
        initOrderData() ;
        initTransferOrderData();
    }
}
