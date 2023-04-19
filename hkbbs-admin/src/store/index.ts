import { createPinia } from 'pinia'
import { defineStore } from 'pinia'
export const useUserStore = defineStore({
    id: 'user', 
    state: () => {
        return {
            token:""
        }
    },
    actions: {
        updateToken(token: string) {
            this.token = token
        }
    }
})

const store = createPinia()
export default store