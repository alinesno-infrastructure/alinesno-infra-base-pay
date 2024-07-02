<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 业务最新巡检</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
              <div class="direct-box">
                <ul>
                  <li class="box-item" v-for="item in paymentAdvantages" :key="item">
                    <div class="dire-panel">
                      <div class="panel-title">
                        <i class="dire-panel-icon" :class="item.icon" :alt="item.name" />
                        {{ item.title }} 
                      </div>
                      <div class="panel-describe">
                        {{ item.description }}
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
          </div>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 应用场景</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:100%" v-for="item in selectedPaymentScenarios" :key="item">
                  <div class="app-info">
                    <div class="app-item-title">
                      <i :class="item.icon" :alt="item.name" />
                        {{ item.name }}
                    </div>
                    <div class="app-item desc">{{ item.description }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>

        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script setup>

const paymentAdvantages = [
  { icon: 'fa-solid fa-money-bill-wave', title: '多渠道支付集成', description: '一站式接入借记卡、微信、支付宝等主流支付方式，满足不同用户的支付偏好' },
  { icon: 'fa-solid fa-sync-alt', title: '即时结算', description: '提供快速的交易确认与资金结算服务，缩短商家收款周期，提高资金周转效率' },
  { icon: 'fa-solid fa-shield-alt', title: '安全保障', description: '采用先进的加密技术和风控体系，保障每一笔交易的安全，降低欺诈风险' },
  { icon: 'fa-solid fa-chart-line', title: '数据分析', description: '提供详细的交易数据分析，帮助商家洞察消费趋势，优化产品策略' },
  { icon: 'fa-solid fa-cogs', title: '灵活定制', description: '提供API接口和SDK，便于开发者集成，可根据业务需求定制支付流程' },
];


const selectedPaymentScenarios = [
  { icon: 'fa-solid fa-credit-card', name: '线上电商支付', description: '支持电商平台的多样化支付需求，集成多种支付方式，提升消费者购物体验，加速交易流程。' },
  { icon: 'fa-solid fa-store', name: '实体店铺收款', description: '为实体零售店提供便捷的收款服务，能轻松实现，减少收银时间，提高服务效率。' },
  { icon: 'fa-solid fa-users', name: '餐饮业支付管理', description: '针对餐饮行业的支付特点，提供快速结账、分账、预授权等功能，满足顾客快速支付的需求' },
];


</script>