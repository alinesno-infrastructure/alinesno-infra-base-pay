<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="应用名称" prop="dbName">
                  <el-input v-model="queryParams.dbName" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item label="应用名称" prop="dbName">
                  <el-input v-model="queryParams['condition[dbName|like]']" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item>
                  <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                  <el-button icon="Refresh" @click="resetQuery">重置</el-button>
               </el-form-item>
            </el-form>

            <el-row :gutter="10" class="mb8">

               <el-col :span="1.5">
                  <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete">删除</el-button>
               </el-col>

               <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
            </el-row>

            <el-table v-loading="loading" :data="RefundOrderList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />

               <!-- 业务字段-->
               <el-table-column label="支付金额" align="center" key="amount" prop="amount" v-if="columns[0].visible">
                  <template #default="scope">
                        <span> <i class="fa-solid fa-dollar-sign"></i>{{ parseAmount(scope.row.amount) }}</span>
                  </template>
               </el-table-column>
               <el-table-column label="退款金额" align="center" key="refundAmount" prop="refundAmount" v-if="columns[1].visible" :show-overflow-tooltip="true">
                  <template #default="scope">
                        <span><i class="fa-solid fa-dollar-sign"></i>{{ parseAmount(scope.row.refundAmount) }}</span>
                  </template>
               </el-table-column>

               <el-table-column label="退款订单号" align="center" width="260" key="mchOrderNo" prop="mchOrderNo" v-if="columns[4].visible" :show-overflow-tooltip="true">
                  <template #default="scope">
                     <div style="margin-top: 5px;" v-if="scope.row.payOrderId">
                        <el-button type="primary" bg text> <i class="fa-solid fa-link"></i> 支付: {{ scope.row.payOrderId }}</el-button>
                     </div>
                     <div style="margin-top: 5px;" v-if="scope.row.mchOrderNo">
                        <el-button type="success" bg text> <i class="fa-brands fa-shopify"></i> 商户: {{ scope.row.mchOrderNo }}</el-button>
                     </div>
                     <div style="margin-top: 5px;" v-if="scope.row.channelOrderNo">
                        <el-button type="danger" bg text> <i class="fa-solid fa-lemon"></i> 渠道: {{ scope.row.channelOrderNo }}</el-button>
                     </div>
                  </template>
               </el-table-column>

               <el-table-column label="支付订单号" align="center" width="260" key="mchOrderNo" prop="mchOrderNo" v-if="columns[4].visible" :show-overflow-tooltip="true">
                  <template #default="scope">
                     <div style="margin-top: 5px;" v-if="scope.row.payOrderId">
                        <el-button type="primary" bg text> <i class="fa-solid fa-link"></i> 支付: {{ scope.row.payOrderId }}</el-button>
                     </div>
                     <div style="margin-top: 5px;" v-if="scope.row.mchOrderNo">
                        <el-button type="success" bg text> <i class="fa-brands fa-shopify"></i> 商户: {{ scope.row.mchOrderNo }}</el-button>
                     </div>
                     <div style="margin-top: 5px;" v-if="scope.row.channelOrderNo">
                        <el-button type="danger" bg text> <i class="fa-solid fa-lemon"></i> 渠道: {{ scope.row.channelOrderNo }}</el-button>
                     </div>
                  </template>
               </el-table-column>

               <el-table-column label="支付状态" align="center" width="130" key="state" prop="state" v-if="columns[1].visible" :show-overflow-tooltip="true">
                  <template #default="scope">
                     <div v-if="scope.row.state == 6">
                        <el-button type="success" bg text> <i class="fa-solid fa-link"></i> 支付成功</el-button>
                     </div>
                     <div v-if="scope.row.state == 3">
                        <el-button type="danger" bg text> <i class="fa-solid fa-link"></i> 支付失败</el-button>
                     </div>
                  </template>
               </el-table-column>

               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[6].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="修改" placement="top" v-if="scope.row.RefundOrderId !== 1">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:RefundOrder:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.RefundOrderId !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:RefundOrder:remove']"></el-button>
                     </el-tooltip>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

   </div>
</template>

<script setup name="RefundOrder">

import {
   listRefundOrder,
   delRefundOrder,
   getRefundOrder,
   updateRefundOrder,
   addRefundOrder
} from "@/api/base/pay/refundOrder";

const router = useRouter();
const { proxy } = getCurrentInstance();

// 定义变量
const RefundOrderList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `应用名称`, visible: true },
   { key: 1, label: `应用描述`, visible: true },
   { key: 2, label: `表数据量`, visible: true },
   { key: 3, label: `类型`, visible: true },
   { key: 4, label: `应用地址`, visible: true },
   { key: 5, label: `状态`, visible: true },
   { key: 6, label: `更新时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      dbName: undefined,
      dbDesc: undefined
   },
   rules: {
      dbName: [{ required: true, message: "名称不能为空", trigger: "blur" }] , 
      jdbcUrl: [{ required: true, message: "连接不能为空", trigger: "blur" }],
      dbType: [{ required: true, message: "类型不能为空", trigger: "blur" }] , 
      dbUsername: [{ required: true , message: "用户名不能为空", trigger: "blur"}],
      dbPasswd: [{ required: true, message: "密码不能为空", trigger: "blur" }] , 
      dbDesc: [{ required: true, message: "备注不能为空", trigger: "blur" }] 
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listRefundOrder(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      RefundOrderList.value = res.rows;
      total.value = res.total;
   });
};

/** 搜索按钮操作 */
function handleQuery() {
   queryParams.value.pageNum = 1;
   getList();
};

/** 重置按钮操作 */
function resetQuery() {
   dateRange.value = [];
   proxy.resetForm("queryRef");
   queryParams.value.deptId = undefined;
   proxy.$refs.deptTreeRef.setCurrentKey(null);
   handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
   const RefundOrderIds = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除应用编号为"' + RefundOrderIds + '"的数据项？').then(function () {
      return delRefundOrder(RefundOrderIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      deptId: undefined,
      RefundOrderName: undefined,
      nickName: undefined,
      password: undefined,
      phonenumber: undefined,
      status: "0",
      remark: undefined,
   };
   proxy.resetForm("databaseRef");
};
/** 取消按钮 */
function cancel() {
   open.value = false;
   reset();
};

/** 新增按钮操作 */
function handleAdd() {
   reset();
   open.value = true;
   title.value = "添加应用";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const RefundOrderId = row.id || ids.value;
   getRefundOrder(RefundOrderId).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.RefundOrderId != undefined) {
            updateRefundOrder(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addRefundOrder(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

getList();

</script>
