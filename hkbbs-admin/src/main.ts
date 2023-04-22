import { createApp } from 'vue'
import './css/normalize.css'
import './css/index.less'
import App from './App.vue'
import store from './store'
import router from './router'

createApp(App)
    .use(store)
    .use(router)
    .mount('#app')
