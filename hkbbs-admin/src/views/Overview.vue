<template>
    <el-row class="overall">
        <el-col :span="6">
            <MyStatistic title="用户数" :first_num="268500"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="男女比" :first_num="138" :last_num="100" title_icon="Male"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="访问量" :first_num="172000"></MyStatistic>
        </el-col>
        <el-col :span="6">
            <MyStatistic title="帖子数" :first_num="562" text_icon="ChatLineRound"></MyStatistic>
        </el-col>
    </el-row>
    <el-row class="charts">
        <el-col :span="12">
            <MyStackedChart></MyStackedChart>
        </el-col>
        <el-col :span="6">
            <MyList title="用户"></MyList>
        </el-col>
        <el-col :span="6">
            <MyList title="新帖"></MyList>
        </el-col>
    </el-row>
</template>

<script setup lang="ts">
import MyStatistic from '../components/MyStatistic.vue';
import MyStackedChart from '../components/MyStackedChart.vue';
import MyList from '../components/MyList.vue';
</script>


<style lang="less" scoped>
.overall {
    margin-top: 20px;
}

.charts{
    margin-top: 50px;
}
</style>