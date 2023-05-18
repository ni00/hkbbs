<template>
    <div class="mylist">
        <div class="mylist-title">{{title}}</div>
        <ul v-infinite-scroll="load" class="infinite-list" style="overflow: auto">
            <li v-for="i in count" :key="i" class="infinite-list-item">{{ i }}</li>
        </ul>
    </div>
</template>

<script setup lang="ts">
import { ref, defineProps } from 'vue'
const props = defineProps<{
    title: string
}>()
const count = ref(0)
const load = () => {
    count.value += 2
}
</script>


<style lang="less" scoped>
.mylist {
    height: 600px;
    &-title{
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }
}

.infinite-list {
    height: 500px;
    padding: 0;
    margin: 0;
    list-style: none;
}

.infinite-list .infinite-list-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 50px;
    background: var(--el-color-primary-light-9);
    margin: 10px;
    color: var(--el-color-primary);
}

.infinite-list .infinite-list-item+.list-item {
    margin-top: 10px;
}
</style>