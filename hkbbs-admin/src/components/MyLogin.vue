<template>
    <el-dialog :model-value="true" :show-close="false" :close-on-click-modal="false" title="管理员登录" width="400px">
        <el-form :model="form">
            <el-form-item label="账号" label-width="50px">
                <el-input v-model="form.name" autocomplete="off" />
            </el-form-item>
            <el-form-item label="密码" label-width="50px">
                <el-input v-model="form.psw" autocomplete="off" />
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="handleClick">
                    登录
                </el-button>
            </span>
        </template>
    </el-dialog>
</template>

<script setup lang="ts">
import { defineProps, reactive, ref, Ref, toRaw } from 'vue';

const form = reactive({
    name: "",
    psw: ""
})

const emit = defineEmits(["login"])
const handleClick = () => {
    emit("login", toRaw(form))
}
</script>

<style lang="less" scoped>
.el-button--text {
    margin-right: 15px;
}

.el-select {
    width: 300px;
}

.el-input {
    width: 300px;
}

.dialog-footer {
    display: flex;
    justify-content: center;
}
</style>