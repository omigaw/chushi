<template>
    <view class="page">
        <view class="page__bd">
            <view class="weui-tab">
                <view class="weui-navbar">
                    <block v-for="(item, index) in tabs" :key="index">
                        <view :id="index" class="weui-navbar__item" :class="activeIndex === index ? 'weui-bar__item_on' : ''" @click="tabClick">
                            <view class="weui-navbar__title">{{item}}</view>
                        </view>
                    </block>
                    <view class="weui-navbar__slider" :style="{'left': sliderLeft + 'px',  'transform': 'translateX(' + sliderOffset + 'px)', '-webkit-transform': 'translateX(' + sliderOffset + 'px)'}"></view>
                </view>
                <view class="weui-tab__panel">
                    <view class="weui-tab__content" :hidden="activeIndex != 0">谁赞了我</view>
                    <view class="weui-tab__content" :hidden="activeIndex != 1">我赞了谁</view>
                </view>
            </view>
        </view>
    </view>
</template>

<script>
export default {
    data () {
        return {
            tabs: ['谁赞了我', '我赞了谁'],
            activeIndex: 0,
            sliderOffset: 0,
            sliderLeft: 0,
            sliderWidth: 96
        };
    },
    methods: {
        tabClick: function (e) {
            this.sliderOffset = e.mp.currentTarget.offsetLeft;
            this.activeIndex = e.mp.currentTarget.id;
        }
    },
    mounted () {
        let that = this;
        /*eslint-disable-next-line*/
        wx.getSystemInfo({
            success: function (res) {
                that.sliderLeft = (res.windowWidth / that.tabs.length - that.sliderWidth) / 2;
                that.sliderOffset = res.windowWidth / that.tabs.length * that.activeIndex;
            }
        });
    }
};
</script>

<style lang="scss" scoped>
    .container{
        .page{
            .page__bd{
                height: 100%;
                padding-bottom: 0;
            }
            .weui-tab__content{
                padding-top: 60px;
                text-align: center;
            }
        }
    }
</style>
