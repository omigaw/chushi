<template>
    <div class="container">
        <view class="weui-cells weui-cells_after-title">
            <view class="weui-cell weui-cell_access">
                <view class="weui-cell__bd">交友卡片在首页展示</view>
                <view class="weui-cell__ft"><switch checked /></view>
            </view>
            <navigator url="../myBindingPhone/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">手机号绑定</view>
                <view class="weui-cell__ft weui-cell__ft_in-access">189****2313</view>
            </navigator>
            <navigator url="../myIdentifyUpload/main" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">身份认证</view>
                <view class="weui-cell__ft weui-cell__ft_in-access">未完成</view>
            </navigator>
            <navigator url="" class="weui-cell weui-cell_access" hover-class="weui-cell_active">
                <view class="weui-cell__bd">帮助与反馈</view>
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
    },
    mounted(){
    }
};
</script>

<style lang="scss" scoped>
    .container{
    }
</style>
