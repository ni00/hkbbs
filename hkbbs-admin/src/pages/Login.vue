<script setup lang="ts">
import { reactive, ref } from 'vue';
import type { FormInstance, FormRules } from 'element-plus'

const loginForm = reactive({
    username: '',
    password: ''
})
const loginFormRef = ref<FormInstance>()
const loginRules = reactive<FormRules>({
    username: [
        { required: true, message: '请输入用户名', trigger: 'change' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'change' }
    ]
})


const submitForm = () => {
    console.log(1)
}
</script>

<template>
    <div id="login-box">
        <el-card id="card-box">
            <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules">
                <el-form-item label="账号" prop="username">
                    <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="loginForm.password" placeholder="请输入密码" show-password></el-input>
                </el-form-item>
                <el-form-item id="submit-box">
                    <el-button type="primary" @click="submitForm">登录</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<style lang="less">
#login-box {
    width: 100vw;
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}

#card-box {
    width: 400px;
    height: 250px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    color: #000000;
    backdrop-filter: blur(25px);

    .el-form-item__label {
        color: black;
        font-size: large;
    }

    #submit-box {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
}
</style>
