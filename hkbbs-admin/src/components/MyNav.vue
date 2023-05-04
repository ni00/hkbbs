<template>
    <el-scrollbar>
        <el-menu>
            <el-menu-item class="mynav" v-for="item in list" :key="item.id" @click="handleClick(item)">
                <el-icon>
                    <component :is="item.icon"></component>
                </el-icon>
                <span class="mynav-title">{{ item.title }}</span>
            </el-menu-item>
        </el-menu>
    </el-scrollbar>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';

export interface nav_type {
    id: string
    title: string
    icon: string
}

defineProps<{
    list: nav_type[]
}>()

const emit = defineEmits(["switch"])

const handleClick = (e: nav_type) => {
    emit("switch", e)
}
</script>

<style lang="less" scoped>
.el-menu {
    border-right: none;
}

.mynav {
    display: flex;
    justify-content: center;

    &-icon {
        font-size: larger;
        margin-left: -30px;
    }

    &-title {
        padding-left: 5px;
        font-size: large;
    }
}
</style>