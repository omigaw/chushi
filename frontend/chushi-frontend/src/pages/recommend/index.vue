<template>
    <div class="container">
        <div class="intro">
            什么是丘比特
        </div>
        <div class="recommend">
            <div class="time">新一轮丘比特时间： {{qiubiteEnrollTime}}</div>
            <div class="resultTime">查询结果时间： {{qiubiteResultTime}}</div>
            <div class="enroll">
                <div class="circle">报名</div>
            </div>
            <div class="result">
                <div class="circle">查询结果</div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            qiubiteEnrollTime: '2018-10-01 至 2018-10-07',
            qiubiteResultTime: '2018-10-08'
        };
    }
};
</script>

<style lang="scss" scoped>
.container{
    .intro{
        height: 100px;
        text-align: center;
        margin: 10rpx 0;
        padding: 10rpx;
        border: 1px solid #ccc;
    }
    .recommend{
        height: 400px;
        margin: 10rpx 0;
        padding: 10rpx;

        .circle{
            width: 200rpx;
            height: 200rpx;
            line-height: 200rpx;
            text-align: center;
            border-radius: 100rpx;
            background-color: lightblue;
            margin: 5rpx auto;
        }
    }
}
</style>
