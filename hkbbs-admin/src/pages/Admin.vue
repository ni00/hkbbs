<template>
    <template v-if="!firstLogin">
        <MyHeader :admin="user_name" :title="current_view.title"></MyHeader>
        <el-container class="panel">
            <el-aside class="panel-nav" width="200px">
                <MyNav :list="nav_list" @switch="handleSwitch"></MyNav>
            </el-aside>
            <el-container class="panel-main">
                <el-main class="panel-view">
                    <RouterView></RouterView>
                </el-main>
            </el-container>
        </el-container>
    </template>
    <MyLogin v-if="firstLogin" @login="handleLogin"></MyLogin>
</template>
  
<script lang="ts" setup>
import { Router, RouterView } from 'vue-router';
import { Ref, ref, reactive, watch } from 'vue'
import { useRouter } from 'vue-router'
import MyNav, { nav_type } from '../components/MyNav.vue'
import MyHeader from '../components/MyHeader.vue'
import MyLogin from '../components/MyLogin.vue'
import nav_list from '../assets/nav-list.json'


// 控制台视图切换
const current_view: Ref<nav_type> = ref(nav_list[0])
const router: Router = useRouter()
const handleSwitch = (e: nav_type) => {
    // 监听视图切换
    console.log(e)
    current_view.value = e
}
watch(current_view, (val: nav_type) => {
    router.push(val.id)
}, { immediate: true })


// 无token信息，打开登录Dialog
let user_name: string = ""
const firstLogin: Ref<boolean> = ref(true)

const handleLogin = (e: any) => {
    // TODO:登录操作，获取token
    console.log(e)
    // 隐藏Dialog
    firstLogin.value = false
}




</script>
  
<style lang="less" scoped>
.panel {
    width: 100%;
    height: 100%;

    &-view {
        padding: 0;
    }

    &-nav {
        color: var(--el-text-color-primary);
        background: var(--el-color-primary-light-8);
    }

    &-main {
        display: flex;
        flex-direction: column;

    }
}
</style>