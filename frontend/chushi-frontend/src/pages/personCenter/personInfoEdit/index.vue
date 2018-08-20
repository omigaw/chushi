<template>
    <div class="container">
        <!--pages/enroll/enroll.wxml-->
        <scroll-view class='enroll-table'>
            <!--昵称-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">昵称</view>
                </view>
                <view class="weui-cell__bd">
                    <input class="weui-input" placeholder="请输入昵称"/>
                </view>
            </view>

            <!--性别-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">性别</view>
                </view>
                <view class="weui-cell__bd">
                    <picker :range="genderArr" :value="genderIndex" @change="bindGenderChange" >
                        <view class="weui-input">{{genderArr[genderIndex]}}</view>
                    </picker>
                </view>
            </view>

            <!--生日-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">生日</view>
                </view>
                <view class="weui-cell__bd">
                    <picker mode="date" value="birthday" start="1970-01-01" end="2010-01-01" @change="birthdayChange">
                        <view class="weui-input">{{birthday}}</view>
                    </picker>
                </view>
            </view>

            <!--学校-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">学校</view>
                </view>
                <view class="weui-cell__bd">
                    <input class="weui-input" placeholder="请输入学校"/>
                </view>
            </view>

            <!--是否毕业-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">是否毕业</view>
                </view>
                <view class="weui-cell__bd">
                    <picker mode="selector" :range="isStudentArr" :value="isStudentIndex" @change="isStudentChange">
                        <view class="weui-input">{{isStudentArr[isStudentIndex]}}</view>
                    </picker>
                </view>
            </view>

            <!--学历-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">学历</view>
                </view>
                <view class="weui-cell__bd">
                    <picker mode="selector" :range="educationArr" :value="educationIndex" @change="educationChange">
                        <view class="weui-input">{{educationArr[educationIndex]}}</view>
                    </picker>
                </view>
            </view>

            <!--身高-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">身高</view>
                </view>
                <view class="weui-cell__bd">
                    <picker mode="selector" :range="heightArr" :value="heightIndex" @change="heightChange">
                        <view class="weui-input">{{heightArr[heightIndex]}}</view>
                    </picker>
                </view>
            </view>

            <!--家乡-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">家乡</view>
                </view>
                <view class="weui-cell__bd">
                    <picker mode="region" :value="home" @change="bindRegionChange">
                        <view class="weui-input">{{home}}</view>
                    </picker>
                </view>
            </view>

            <!--微信-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">微信</view>
                </view>
                <view class="weui-cell__bd">
                    <input class="weui-input" placeholder="请输入微信"/>
                </view>
            </view>

            <!--邮箱-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">邮箱</view>
                </view>
                <view class="weui-cell__bd">
                    <input class="weui-input" placeholder="请输入邮箱"/>
                </view>
            </view>

            <!--自我介绍-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">自我介绍</view>
                </view>
                <view class="weui-cell__bd">
                    <textarea class="weui-textarea" :value='selfIntroduction' @input='selfIntroductionChange' placeholder="自我介绍" style="height: 3.3em" />
                    <view class="weui-textarea-counter">{{selfIntroduction.length}}/200</view>
                </view>
            </view>

            <!--对他的期待-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__hd">
                    <view class="weui-label">关于TA</view>
                </view>
                <view class="weui-cell__bd">
                    <textarea class="weui-textarea" :value='aboutTa' @input='aboutTaChange' placeholder="对TA的期待" style="height: 3.3em" />
                    <view class="weui-textarea-counter">{{aboutTa.length}}/200</view>
                </view>
            </view>

            <!--照片-->
            <view class="weui-cell weui-cell_input">
                <view class="weui-cell__bd">
                    <view class="weui-uploader">
                        <view class="weui-uploader__hd">
                            <view class="weui-uploader__title">照片上传</view>
                            <view class="weui-uploader__info">{{photos.length}}</view>
                        </view>
                        <view class="weui-uploader__bd">
                            <view class="weui-uploader__files" id="uploaderFiles">
                                <block v-for="(item, index) in photos" :key="index">
                                    <view class="weui-uploader__file" @click="previewImage" :id="item">
                                        <image class="weui-uploader__img" :src="item" mode="aspectFill" />
                                    </view>
                                </block>
                            </view>
                            <view class="weui-uploader__input-box">
                                <view class="weui-uploader__input" @click="chooseImage"></view>
                            </view>
                        </view>
                    </view>
                </view>
            </view>

            <!--提交-->
            <view class="weui-btn-area">
                <button class="weui-btn" type="primary" form-type="submit">提交</button>
            </view>
        </scroll-view>
    </div>
</template>

<script>
export default {
    data () {
        return {
            genderIndex: 0,
            genderArr: ['男', '女'],
            educationIndex: 2,
            educationArr: ['专科', '本科', '硕士', '博士', '其他'],
            heightIndex: 30,
            heightArr: ['140', '141', '142', '143', '144', '145', '146', '147', '148', '149',
                '150', '151', '152', '153', '154', '155', '156', '157', '158', '159',
                '160', '161', '162', '163', '164', '165', '166', '167', '168', '169',
                '170', '171', '172', '173', '174', '175', '176', '177', '178', '179',
                '180', '181', '182', '183', '184', '185', '186', '187', '188', '189', '190'],
            birthday: '1993-01-01',
            isStudentIndex: 0,
            isStudentArr: ['学生', '已毕业'],
            home: ['北京', '北京', '海淀'],
            photos: [],
            selfIntroduction: '',
            aboutTa: ''
        };
    },
    methods: {
        /*eslint-disable*/
        // 选择性别搜索
        bindGenderChange: function (e) {
            this.genderIndex = e.mp.detail.value;
        },
        // 生日选择改变
        birthdayChange: function (e) {
            this.birthday = e.mp.detail.value;
        },
        // 是否已经毕业
        isStudentChange: function (e) {
            this.isStudentIndex = e.mp.detail.value;
        },
        // 选择学历搜索
        educationChange: function (e) {
            this.educationIndex = e.mp.detail.value
        },
        // 身高修改
        heightChange: function (e) {
            this.heightIndex = e.mp.detail.value;
        },
        // 家乡修改
        bindRegionChange: function (e) {
            console.log('picker发送选择改变，携带值为', e.mp.detail.value)
            this.home = e.mp.detail.value;
        },
        // 选择图片
        chooseImage: function (e) {
            let that = this;
            wx.chooseImage({
                sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                    // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
                    that.photos = that.photos.concat(res.tempFilePaths)
                }
            })
        },
        // 预览上传的图片
        previewImage: function(e){
            wx.previewImage({
                current: e.mp.currentTarget.id, // 当前显示图片的http链接
                urls: this.data.photos // 需要预览的图片http链接列表
            })
        },
        // 自我介绍输入
        selfIntroductionChange: function (e) {
            this.selfIntroduction = e.mp.detail.value;
        },
        //	关于她
        aboutTaChange: function (e) {
            this.aboutTa = e.detail.value;
        }
    }
};
</script>

<style lang="scss" scoped>
</style>
