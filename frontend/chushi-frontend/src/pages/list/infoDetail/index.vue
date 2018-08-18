<template>
    <div class="container">
        <swiper :indicator-dots="swiper.indicatorDots" class="swiper"
                :autoplay="swiper.autoplay" :interval="swiper.interval" :duration="swiper.duration">
            <block v-for="(item, index) in imgUrls" :key="index">
                <swiper-item class="swiper-item">
                    <image :src="item" class="slide-image" mode="aspectFill" @click="imageClickHandler(index)"/>
                </swiper-item>
            </block>
        </swiper>

        <!--基本情况-->
        <view class="weui-panel weui-panel_access">
            <view class="weui-panel__hd">晓雪 认证用户</view>
            <view class="weui-panel__bd">
                <view class="weui-media-box weui-media-box_text">
                    <view class="weui-media-box__desc">
                        北京 22岁 169cm 家乡合肥 清华大学 在读
                    </view>
                </view>
            </view>
        </view>

        <!--自我介绍-->
        <view class="weui-panel weui-panel_access">
            <view class="weui-panel__hd">自我介绍</view>
            <view class="weui-panel__bd">
                <view class="weui-media-box weui-media-box_text">
                    <!--<view class="weui-media-box__title weui-media-box__title_in-text">标题一</view>-->
                    <view class="weui-media-box__desc">真正严肃的哲学问题只有一个，那便是自杀。判断人生值不值得活，等于回答哲学的根本问题。
                        至于世界是否有三维，精神是否分三六九等，都是些儿戏罢了。</view>
                </view>
            </view>
        </view>

        <!--对另一半的期待-->
        <view class="weui-panel weui-panel_access">
            <view class="weui-panel__hd">对另一半的期待</view>
            <view class="weui-panel__bd">
                <view class="weui-media-box weui-media-box_text">
                    <view class="weui-media-box__desc">不存在无阴影的太阳，而且必须认识黑夜。对生活说”是”，对未来说”不”。
                        没有一种命运是对人的惩罚。</view>
                </view>
            </view>
        </view>

        <!--我想对你说-->
        <view class="weui-panel weui-panel_access">
            <view class="weui-panel__hd">我想对你说</view>
            <view class="weui-panel__bd">
                <view class="weui-media-box weui-media-box_text">
                    <view class="weui-media-box__desc">一切伟大的行动和思想，都有一个微不足道的开始。</view>
                </view>
            </view>
        </view>

        <button class="weui-btn" type="primary" :disabled="isDisabled" @click="chushiClickHandler">{{btnText}}</button>
    </div>
</template>

<script>
import bus from '@/event/bus';
export default {
    data () {
        return {
            swiper: {
                indicatorDots: true,
                autoplay: false,
                interval: 100,
                duration: 100
            },
            isDisabled: false,
            btnText: '与TA初识',
            imgUrls: ['../../static/nv/6.png', '../../static/nv/2.png', '../../static/nan/1.png', '../../static/nan/2.png']
        };
    },
    methods: {
        imageClickHandler (index) {
            let current = this.imgUrls[index];
            /*eslint-disable-next-line*/
            wx.previewImage({
                current: current,
                urls: this.imgUrls
            });
        },
        // 点击与他初识按钮, 跳转到发消息页面
        chushiClickHandler (e) {
            if (!this.isDisabled) {
                /*eslint-disable-next-line*/
                wx.navigateTo({
                    url: '../sendMessage/main'
                });
            }
        }
    },
    mounted () {
        bus.$on('msg-send-success', (id) => {
            this.isDisabled = true;
            this.btnText = '信息已发送';
        });
    }
};
</script>

<style lang="scss" scoped>
.container{
    background-color: #eee;
    .swiper{
        background-color: white;
        width: 100%;
        height: 430rpx;
        .swiper-item{
            image{
                width: 100%;
                max-height: 430rpx;
            }
        }
    }
    .weui-panel{
        .weui-media-box__desc{
            overflow: visible;
            -webkit-line-clamp: 5;
        }
    }
}
</style>
