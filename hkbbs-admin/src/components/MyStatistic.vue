<template>
    <el-statistic class="my-stat" :value="first_num">
        <template #title>
            <div style="display: inline-flex; align-items: center">
                {{ title }}
                <el-icon v-if="title_icon" style="margin-left: 4px" :size="12">
                    <component :is="title_icon"></component>
                </el-icon>
            </div>
        </template>
        <template #suffix>
            {{ last_num ? '/' + last_num : "" }}
            <el-icon v-if="text_icon" style="vertical-align: -0.125em">
                <component :is="text_icon"></component>
            </el-icon>
        </template>
    </el-statistic>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';
defineProps<{
    title: string,
    first_num: number,
    last_num?: number,
    title_icon?: string,
    text_icon?: string
}>()
</script>

<style lang="less" scoped>
.my-stat{
    text-align: center;
}
</style>