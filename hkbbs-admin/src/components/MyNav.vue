<template>
    <el-scrollbar>
        <el-menu>
            <el-menu-item class="mynav" v-for="item in props.list" :key="item.id"
                :class="{ 'nav-selected': item.id === selected }" @click="handleClick(item)">
                <el-icon v-if="item.icon">
                    <component :is="item.icon"></component>
                </el-icon>
                <span class="mynav-title">{{ item.title }}</span>
            </el-menu-item>
        </el-menu>
    </el-scrollbar>
</template>

<script setup lang="ts">
import { defineProps, ref } from 'vue';

export interface nav_type {
    id: string
    title: string
    icon: string
}

const props = defineProps<{
    list: nav_type[]
}>()

const selected: Ref<string> = ref(props.list[0].id)
const emit = defineEmits(["switchNav"])

const handleClick = (e: nav_type) => {
    selected.value = e.id
    emit("switchNav", e)
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

.nav-selected {
    background-color: rgb(241, 255, 255);
}
</style>