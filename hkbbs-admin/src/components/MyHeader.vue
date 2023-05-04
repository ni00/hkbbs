<template>
    <el-header id="myheader">
        <h1>{{ title }}</h1>

        <div id="myheader-toolbar">
            <span id="myheader-name">{{ admin }}</span>
            <el-dropdown>
                <el-icon style="margin-right: 8px; margin-top: 1px">
                    <setting />
                </el-icon>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>修改密码</el-dropdown-item>
                        <el-dropdown-item>退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>

        </div>
    </el-header>
</template>

<script setup lang="ts">
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
import { defineProps } from 'vue';
defineProps({
    admin: {
        type: String,
        require: true,
        readonly: true
    },
    title: {
        type: String,
        require: true,
        readonly: true
    },
})
</script>


<style lang="less" scoped>
#myheader {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    background-color: var(--el-color-primary-light-7);
    color: var(--el-text-color-primary);

    &-toolbar {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        height: 100%;
        right: 20px;
    }

    &-name {
        font-size: large;
        margin-right: 10px;
    }
}
</style>