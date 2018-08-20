<template>
    <div class="container">
        <div class="list">
            <div class="list-item" v-for="(item, index) in activityList" :key="index">
                <div class="title">{{item.name}}</div>
                <div>{{item.detail}}</div>
            </div>
        </div>
    </div>
</template>

<script>
// Use Vuex
// import store from '@/store/index';

export default {
    data () {
        return {
            activityList: [{
                name: '端午节森林公园',
                detail: '森林公园森林公园森林公园森林公园森林公园'
            }, {
                name: '国庆节长城',
                detail: '八达岭长城八达岭长城八达岭长城八达岭长城八达岭长城'
            }]
        };
    },
    computed: {

    },
    methods: {

    }

};
</script>

<style lang="scss" scoped>
    .container{
        .list{
            display: flex;
            flex-direction: column;
            .list-item{
                .title{
                    text-align: center;
                }
                height: 200px;
                margin: 10rpx 0;
                padding: 10rpx;
                border: 1px solid #ccc;
            }
        }
    }
</style>
