<template>
    <div class="container">
        <view class="weui-cells weui-cells_after-title">
            <view class="weui-cell">
                <view class="weui-cell__bd">玫瑰花</view>
                <view class="weui-cell__ft">{{flowerCount}}</view>
            </view>
        </view>

        <view class="weui-cells weui-cells_after-title">
            <view class="weui-cell">
                <view class="weui-cell__bd" style="color:red; font-size: 14px">如何获取玫瑰花？</view>
            </view>
        </view>

        <view class="weui-cell">
            <view class="weui-cell__bd">
                <textarea class="weui-textarea" :value='textContent' @input='inputHandler' placeholder="向对方打个招呼" style="height: 3.3em" />
                <view class="weui-textarea-counter">{{textLength}}/50</view>
            </view>
        </view>

        <button class="weui-btn" type="primary" @click="chushiClickHandler">与TA初识</button>
    </div>
</template>

<script>
import bus from '@/event/bus';
export default {
    data () {
        return {
            flowerCount: 10,
            textContent: '',
            textLength: 0
        };
    },
    methods: {
        // 发送了文本，点击了按钮
        chushiClickHandler (e) {
            this.flowerCount--;
            bus.$emit('msg-send-success', '100033');
            /*eslint-disable-next-line*/
            wx.navigateBack({
                delta: 1
            });
            // todo 发送后端请求
        },
        inputHandler (e) {
            this.textContent = e.mp.detail.value;
            this.textLength = this.textContent.length;
        }
    }
};
</script>

<style lang="scss" scoped>
.container{

}
</style>
