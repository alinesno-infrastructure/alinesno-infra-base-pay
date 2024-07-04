<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="商户名称" prop="mchShortName">
                  <el-input v-model="queryParams.mchShortName" placeholder="请输入商户名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item label="商户名称" prop="mchShortName">
                  <el-input v-model="queryParams['condition[mchShortName|like]']" placeholder="请输入商户名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="MchNotifyList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />

               <!-- 业务字段-->
               <el-table-column label="订单ID" align="left" key="mchShortName" prop="mchShortName" v-if="columns[0].visible" >
                  <template #default="scope">
                     <div>
                        {{ scope.row.mchShortName}}
                     </div>
                     <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.promptId">
                        全称: {{ scope.row.mchName}}
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="商户订单号" align="center" width="200" key="mchNo" prop="mchNo" v-if="columns[5].visible">
                  <template #default="scope">
                     <div style="cursor: pointer;" v-copyText="scope.row.mchNo">
                        {{ scope.row.mchNo}} <el-icon><CopyDocument /></el-icon>
                     </div>
                  </template>
               </el-table-column>

               <el-table-column label="通知状态" align="center" width="120" key="notifyState" prop="notifyState" v-if="columns[1].visible" :show-overflow-tooltip="true">
                  <template #default="scope">
                     <div v-if="scope.row.notifyState == 1">
                        <el-button type="danger" bg text> <i class="fa-solid fa-truck-fast"></i> 未发送</el-button>
                     </div>
                     <div v-if="scope.row.notifyState == 0">
                        <el-button type="info" bg text> <i class="fa-solid fa-truck-fast"></i>  已发送</el-button>
                     </div>
                  </template>
               </el-table-column>

               <el-table-column label="订单类型" align="center" key="type" width="180" v-if="columns[5].visible">
                  <template #default="scope">
                     <el-button type="primary" bg text v-if="scope.row.type == 0" > <i class="fa-solid fa-link"></i> 普通商户</el-button>
                     <el-button type="danger" bg text v-if="scope.row.type == 1" > <i class="fa-solid fa-link"></i> 特约商户</el-button>
                  </template>
               </el-table-column>

               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[1].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="250" class-name="small-padding fixed-width">
                  <template #default="scope">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:MchNotify:edit']">详情</el-button>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

   </div>
</template>

<script setup name="MchNotify">

import {
   listMchNotify,
   delMchNotify,
   getMchNotify,
   updateMchNotify,
   changStatusField,
   addMchNotify
} from "@/api/base/pay/mchNotify";

const router = useRouter();
const { proxy } = getCurrentInstance();

// 定义变量
const MchNotifyList = ref([]);
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
   { key: 0, label: `商户名称`, visible: true },
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
      mchShortName: undefined,
      isvNo: undefined
   },
   rules: {
      mchShortName: [{ required: true, message: "简称不能为空", trigger: "blur" }] , 
      mchName: [{ required: true, message: "名称不能为空", trigger: "blur" }],
      type: [{ required: true, message: "类型不能为空", trigger: "blur" }] , 
      contactName: [{ required: true , message: "用户名不能为空", trigger: "blur"}],
      contactTel: [{ required: true, message: "密码不能为空", trigger: "blur" }] , 
      isvNo: [{ required: true, message: "备注不能为空", trigger: "blur" }] 
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listMchNotify(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      MchNotifyList.value = res.rows;
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
   const ids = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除应用编号为"' + ids + '"的数据项？').then(function () {
      return delMchNotify(ids);
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
      MchNotifyName: undefined,
      nickName: undefined,
      password: undefined,
      phonenumber: undefined,
      mchNo: "0",
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
   const id = row.id || ids.value;
   getMchNotify(id).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateMchNotify(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addMchNotify(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

/** 修改状态 */
const handleChangStatusField = async(field , value , id) => {
    // 判断tags值 这样就不会进页面时调用了
      const res = await changStatusField({
         field: field,
         value: value?1:0,
         id: id
      }).catch(() => { })
      if (res && res.code == 200) {
         // 刷新表格
         getList()
      }
}

getList();

</script>
