<template>
    <el-row class="overall">
        <el-col :span="6">
            <MyStatistic title="Daily active users" :first_num="268500"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="Ratio of men to women" :first_num="138" :last_num="100" title_icon="Male"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="Total Transactions" :first_num="172000"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="Feedback number" :first_num="562" text_icon="ChatLineRound"></MyStatistic>
        </el-col>
    </el-row>
    
</template>

<script setup lang="ts">
import MyStatistic from '../components/MyStatistic.vue';
</script>

<style lang="less" scoped>
.overall {
    margin-top: 20px;
}
</style>