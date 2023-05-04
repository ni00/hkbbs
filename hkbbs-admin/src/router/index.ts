import { createRouter, createWebHashHistory, RouterOptions, Router, RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
    { path: '/overview', name: 'Overview', component: () => import('../views/Overview.vue') },
    { path: '/data', name: 'Data', component: () => import('../views/Data.vue') },
    { path: '/notice', name: 'Notice', component: () => import('../views/Notice.vue') },
    { path: '/post', name: 'Post', component: () => import('../views/Post.vue') },
    { path: '/user', name: 'User', component: () => import('../views/User.vue') }
]

// RouterOptions是路由选项类型
const options: RouterOptions = {
    history: createWebHashHistory(),
    routes,
}

// Router是路由对象类型
const router: Router = createRouter(options)

export default router