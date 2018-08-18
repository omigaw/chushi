<template>
    <div class="container">
        <div class="userInfo">
            <div class='userInfo-item'>
                <open-data type="userAvatarUrl"></open-data>
            </div>
            <div class='userInfo-item'>
                <open-data type="userNickName"></open-data>
            </div>
        </div>

        <view class="weui-cells weui-cells_after-title">
            <navigator url="./personInfoEdit/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">我的资料</view>
                <view class="weui-cell__ft weui-cell__ft_in-access"></view>
            </navigator>
            <navigator url="./myMessage/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">我的好友邀约</view>
                <view class="weui-cell__ft weui-cell__ft_in-access"><div>5</div></view>
            </navigator>
            <navigator url="./myUpvote/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">我的点赞</view>
                <view class="weui-cell__ft weui-cell__ft_in-access"><div>5</div></view>
            </navigator>
            <navigator url="./myMakeFriendCard/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">我的邀约卡</view>
                <view class="weui-cell__ft weui-cell__ft_in-access"><div>15</div></view>
            </navigator>
            <navigator url="./mySetting/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">设置</view>
                <view class="weui-cell__ft weui-cell__ft_in-access"></view>
            </navigator>
        </view>
    </div>
</template>

<script>
export default {
    data () {
        return {

        };
    },
    methods: {
        clickHandler (e) {
            /*eslint-disable*/
            wx.login({
                success: function(res) {
                    if (res.code) {
                        //发起网络请求
                        console.log(res.code);
                        // wx.request({
                        //     url: 'https://test.com/onLogin',
                        //     data: {
                        //         code: res.code
                        //     }
                        // })
                    } else {
                        console.log('登录失败！' + res.errMsg)
                    }
                }
            });
        }
    },
    mounted(){
        let session = wx.getStorageSync('session');
        console.log('个人中心页获取session', session);
    }
};
</script>

<style lang="scss" scoped>
    .container{
        .userInfo{
            display: flex;
            .userInfo-item:first-child{
                padding: 30rpx;
                width: 30%;
                ._open-data{
                    width: 161rpx;
                    height: 161rpx;
                    border-radius: 50%;
                    overflow: hidden;
                    object-fit: cover;
                    display: block;
                    float: left;
                }
            }
            .userInfo-item:nth-child(2){
                width: 70%;
                position: relative;
                display: flex;
                ._open-data{
                    position: absolute;
                    top: 50%;
                    left: 20%;
                    transform: translate(-50%, -50%);
                }
            }
        }
        .weui-cell__ft{
            div{
                width:50rpx;
                height:50rpx;
                border-radius:25rpx;
                background-color:#F94E3E;
                text-align:center;
                color: white;
            }
        }
    }
</style>
