<template>
    <div class="container">
        <button open-type="getUserInfo" lang="zh_CN" @getuserinfo="onGotUserInfo" @click="clickHandler">授权进入小程序</button>
    </div>
</template>

<script>
export default {
    data () {
        return {
        };
    },
    methods: {
        // 点击同意之后的事件
        onGotUserInfo (e) {
            // 查看是否授权
            wx.getUserInfo({
                success: function(res) {
                    console.log(res.userInfo);
                    wx.setStorage({
                        key:"userInfo",
                        data: res.userInfo
                    })
                    wx.switchTab({
                        url: '../list/main'
                    });
                }
            })
        }
    },
    mounted () {
        // 进页面检查是否已经授权
        wx.getSetting({
            success: function(res){
                if (res.authSetting['scope.userInfo']) {
                    // 已经授权，跳转到首页
                    wx.switchTab({
                        url: '../list/main'
                    });
                }else {
                    // 没有授权，不用跳转，等待用户主动按按钮。
                }
            }
        })
    }
};
</script>

<style lang="scss" scoped>
.container{
    button{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
}
</style>
