<template>

    <div class="pay-demo-container">

    <div class="pay-demo-title">
        支付示例界面
    </div>

    <div style="width: 100%;" class="paydemo">
        <!-- <div class="paydemo-type-content"
            style="background-color: #dde4f8;color: #235cff; padding:20px; padding:15px 20px;font-weight:500;font-family:Microsoft YaHei UI;">
            <p style="margin:0;">本页面支付测试对接<a href="https://www.jeepay.com" target="_blank">计全付</a>（使用<a
                    href="/product/jeepay4plus.html">Jeepay Plus</a>搭建），下单测试需谨慎，付款失误可退回！！！</p>
        </div> -->
        <br/>
        <el-card shadow="never" style="background-color: #fff">
        <div class="paydemo-type-content">
            <div class="paydemo-type-name">聚合支付</div>
            <div class="paydemo-type-body">
                <div class="paydemo-type color-change" code="AUTO_BAR">
                    <img src="http://data.linesno.com/icons/pay/auto_bar.svg" class="paydemo-type-img">
                    <span class="color-change">聚合被扫(商家扫用户)</span>
                </div>
                <div class="paydemo-type color-change" code="WEB_CASHIER">
                    <img src="http://data.linesno.com/icons/pay/web_cashier.svg" class="paydemo-type-img">
                    <span class="color-change">web收银台</span>
                </div>
                <div class="paydemo-type color-change" code="QR_CASHIER" entrypagetype="lite">
                    <img src="http://data.linesno.com/icons/pay/qr_cashier_wx_lite.svg" class="paydemo-type-img">
                    <span class="color-change">聚合主扫(小程序)</span>
                </div>
                <div class="paydemo-type color-change" code="QR_CASHIER" entrypagetype="h5">
                    <img src="http://data.linesno.com/icons/pay/qr_cashier_wx_jsapi.svg" class="paydemo-type-img">
                    <span class="color-change">聚合主扫(公众号)</span>
                </div>
                <div class="paydemo-type color-change" code="QR_CASHIER" entrypagetype="h5">
                    <div class="paydemo-type-h5" code="QR_CASHIER">
                        <img src="http://data.linesno.com/icons/pay/qr_cashier.svg" class="paydemo-type-img">
                        <span>聚合主扫(静态码)</span>
                    </div>
                    <div id="pay-demo-qrcode" class="layer-photos-demo layui-hide" v-if="showWxQrcode">
                        <img style="width: 120px;height: 120px;padding-bottom: 10px"
                            src="http://data.linesno.com/icons/pay/pay_h5.png">
                    </div>
                </div>
            </div>

            <div class="paydemo-type-name">微信支付</div>
            <div class="paydemo-type-body">
                <div class="paydemo-type color-change this" code="WX_NATIVE">
                    <img src="http://data.linesno.com/icons/pay/wx_native.svg" class="paydemo-type-img">
                    <span class="color-change this">微信二维码</span>
                </div>
                <div class="paydemo-type color-change" code="WX_BAR">
                    <img src="http://data.linesno.com/icons/pay/wx_bar.svg" class="paydemo-type-img">
                    <span class="color-change">微信条码</span>
                </div>
                <div class="paydemo-type color-change" code="WX_QR_CASHIER">
                    <img src="http://data.linesno.com/icons/pay/wx_jsapi.svg" class="paydemo-type-img">
                    <span class="color-change">公众号/小程序</span>
                </div>
                <div class="paydemo-type color-change" code="WX_QR_CASHIER">
                    <div class="paydemo-type-h5" code="WX_H5">
                        <img src="http://data.linesno.com/icons/pay/wx_h5.svg" class="paydemo-type-img">
                        <span>微信H5</span>
                    </div>
                    <div class="paydemo-type-h5 layui-hide codeImg_wx_h5" v-if="showWxQrcode" >
                        <img style="width: 120px;height: 120px;padding-bottom: 10px"
                            src="http://data.linesno.com/icons/pay/pay_h5.png">
                        <span>请使用手机浏览器扫码</span>
                    </div>
                </div>
            </div>

            <div class="paydemo-type-name">支付宝支付</div>
            <div class="paydemo-type-body">
                <div class="paydemo-type color-change" code="ALI_QR">
                    <img src="http://data.linesno.com/icons/pay/ali_qr.svg" class="paydemo-type-img">
                    <span class="color-change">支付宝二维码</span>
                </div>
                <div class="paydemo-type color-change" code="ALI_BAR">
                    <img src="http://data.linesno.com/icons/pay/ali_bar.svg" class="paydemo-type-img">
                    <span class="color-change">支付宝条码</span>
                </div>
                <div class="paydemo-type color-change" code="ALI_QR_CASHIER">
                    <img src="http://data.linesno.com/icons/pay/ali_jsapi.svg" class="paydemo-type-img">
                    <span class="color-change">支付宝生活号</span>
                </div>
                <div class="paydemo-type color-change" code="ALI_PC">
                    <img src="http://data.linesno.com/icons/pay/ali_pc.svg" class="paydemo-type-img">
                    <span class="color-change">支付宝PC网站</span>
                </div>
                <div class="paydemo-type color-change" code="ALI_QR_CASHIER">
                    <div class="paydemo-type-h5" code="ALI_WAP">
                        <img src="http://data.linesno.com/icons/pay/ali_wap.svg" class="paydemo-type-img">
                        <span>支付宝WAP</span>
                    </div>
                    <div class="paydemo-type-h5 layui-hide codeImg_wx_h5" v-if="showWxQrcode" >
                        <img style="width: 120px;height: 120px;padding-bottom: 10px"
                            src="http://data.linesno.com/icons/pay/pay_h5.png">
                        <span>请使用手机浏览器扫码</span>
                    </div>
                </div>
            </div>

        </div>

        </el-card>

        <br/>

        <el-card shadow="never" style="background-color: #fff">

        <div class="paydemo-type-content">
            <div class="paydemo-type-name">支付信息</div>
            <el-form  label-width="auto" class="demo-ruleForm" status-icon>
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="订单编号">
                            <el-input value="M17199083456129306" disabled style="width:500px" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="商品名称">
                            <el-input value="支付接口演示" disabled style="width:500px" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="支付金额(元)">
                                <el-radio value="0.01">0.01</el-radio>
                                <el-radio value="0.57">0.57</el-radio>
                                <el-radio value="0.45">0.45</el-radio>
                                <el-radio value="0.17">0.17</el-radio>
                                <el-radio value="0.71">0.71</el-radio>
                                <el-radio value="self">自定义金额</el-radio>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <div style="margin-left:20px;margin-top:6px; text-align: right; color: rgb(68, 181, 73);font-size: 12px;float:right">
                            登录后支付，可发起退款
                        </div>
                        <el-form-item style="float:right">
                            <el-button :icon="CreditCard" type="primary" bg @click="submitForm(ruleFormRef)">
                                立即支付 
                            </el-button>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form> 
        </div>

        </el-card>
        <br/>
        <el-card shadow="never" style="background-color: #fff">
            <div class="paydemo-type-content">
                <div class="paydemo-type-name">最新支付</div>

                <el-table ref="singleTableRef" :data="tableData" highlight-current-row style="width: 100%">
                    <el-table-column type="index" width="50" label="序号" />
                    <el-table-column property="orderNumber" width="180" label="订单编号" />
                    <el-table-column property="paymentAmount" align="center" label="支付金额" />
                    <el-table-column property="paymentMethod" label="支付方式" />
                    <el-table-column property="paymentStatus" align="center" label="支付状态" />
                    <el-table-column property="customerIP" label="客户IP" />
                    <el-table-column property="creationTime" width="180" align="center" label="创建时间" />
                    <el-table-column property="address" width="80" label="操作">
                        <template #default>
                            <el-button link type="primary" size="small" @click="handleClick">退款</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <br/>
                <el-pagination
                    :page-size="20"
                    :pager-count="11"
                    layout="prev, pager, next"
                    :total="1000"
                />

            </div>
        </el-card>

        <br/>
        <br/>
        <br/>

        </div>

    </div>


</template>

<script setup>
const showWxQrcode = ref(false) ;

const tableData = ref([
  {
    orderNumber: 'M17199078490453777',
    paymentAmount: '0.01',
    paymentMethod: '聚合扫码',
    paymentStatus: '待支付',
    customerIP: '113.90.145.5*',
    creationTime: '2024-07-02 16:11:15'
  },
  {
    orderNumber: 'M17199078094987022',
    paymentAmount: '0.01',
    paymentMethod: '聚合扫码',
    paymentStatus: '待支付',
    customerIP: '113.90.145.5*',
    creationTime: '2024-07-02 16:10:45'
  },
  {
    orderNumber: 'M17199051102547915',
    paymentAmount: '0.01',
    paymentMethod: '支付宝二维码',
    paymentStatus: '支付失败',
    customerIP: '139.226.78.14*',
    creationTime: '2024-07-02 15:25:25'
  },
  {
    orderNumber: 'M17199045051235999',
    paymentAmount: '0.01',
    paymentMethod: '微信二维码',
    paymentStatus: '待支付',
    customerIP: '139.226.78.14*',
    creationTime: '2024-07-02 15:15:08'
  },
  {
    orderNumber: 'M17199037799205878',
    paymentAmount: '0.29',
    paymentMethod: '支付宝二维码',
    paymentStatus: '支付失败',
    customerIP: '184.169.244.6*',
    creationTime: '2024-07-02 15:03:01'
  },
  {
    orderNumber: 'M17199037671026832',
    paymentAmount: '0.01',
    paymentMethod: '支付宝二维码',
    paymentStatus: '支付失败',
    customerIP: '184.169.244.6*',
    creationTime: '2024-07-02 15:02:55'
  },
  {
    orderNumber: 'M17199037458946878',
    paymentAmount: '0.01',
    paymentMethod: '微信二维码',
    paymentStatus: '待支付',
    customerIP: '184.169.244.6*',
    creationTime: '2024-07-02 15:02:33'
  },
  {
    orderNumber: 'M17199030530911387',
    paymentAmount: '0.37',
    paymentMethod: '聚合扫码',
    paymentStatus: '待支付',
    customerIP: '113.1.59.3*',
    creationTime: '2024-07-02 14:50:56'
  },
  {
    orderNumber: 'M17199030296349334',
    paymentAmount: '0.37',
    paymentMethod: '聚合扫码',
    paymentStatus: '待支付',
    customerIP: '113.1.59.3*',
    creationTime: '2024-07-02 14:50:48'
  },
  {
    orderNumber: 'M17199030251284670',
    paymentAmount: '0.37',
    paymentMethod: 'web收银台',
    paymentStatus: '待支付',
    customerIP: '113.1.59.3*',
    creationTime: '2024-07-02 14:50:28'
  }
]);

</script>

<style scoped lang="scss">

.pay-demo-container{
    width: 100%;
    margin: auto;
    background: #f5f5f5;
}

.pay-demo-title {
    font-size: 1.6rem;
    text-align: center;
    padding-top: 10px;
}

.paydemo {

    max-width: 1024px;
    margin: auto;

    .paydemo-type-content {
        // padding: 10px;
        // margin-bottom: 20px;
        background-color: #FFFFFF;
        border-radius: 6px;
    }

    .paydemo-type-name {
        font-size: 16px;
        margin-bottom: 12px;
        display: flex;
        align-items: center;
    }


    .paydemo-type-body {
        display: flex;
        flex-direction: row;
        align-items: center;
        margin-bottom: 20px;
    }

    .paydemo-type {
        padding: 8px;
        border: solid 1px #e2e2e2;
        margin-right: 10px;
        cursor: pointer;
        line-height: 28px;
        font-size: 14px;
        border-radius: 2px;
    }

    .paydemo-type-img {
        width: 28px;
        height: 28px;
        margin-right: 10px;
        position: relative;
        float: left;
    }


    .paydemo-form-item {
        height: 38px;
        margin-bottom: 5px;
        display: flex;
        flex-direction: row;
        align-items: center;
    }


    .paydemo-btn {
        border: 1px solid #e2e2e2;
        background-color: #ffffff;
        color: #000000;
        margin-left: 8px;
        display: inline-flex;
        flex-direction: row;
        align-items: center;
    }

}

</style>
