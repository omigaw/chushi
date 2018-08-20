<template>
    <div class="container">
        <div class="card">
            邀约卡   8张
        </div>
        <div style="color:red">如何获取更多的邀约卡?</div>
        <div class="bottom">
            <div class="button">
                <button open-type='share'class="weui-btn" type="primary">分享小程序</button>
            </div>
            <div>保存图片发朋友圈</div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
    },
    methods: {

    },
    onShareAppMessage: function (res) {
        if (res.from === 'button') {
            // 来自页面内转发按钮
            // console.log(res.target)
        }
        return {
            title: '初识在校园',
            // path: '/page/user?id=123'
        }
    },
    mounted () {
    }
};
</script>

<style lang="scss" scoped>
    .container{
        text-align: center;
        >div{
            margin: 20rpx 0;
            >div{
                margin: 20rpx 0;
            }
        }
        .card{
            height: 300rpx;
            margin: 50rpx 0;
            border: 1px solid #ccc;
        }
        .bottom{
            position: absolute;
            bottom: 30rpx;
            width: 100%;
        }
    }
</style>
