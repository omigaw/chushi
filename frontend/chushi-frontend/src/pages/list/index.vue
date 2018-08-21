<template>
    <div class="container">
        <div class="search"><a @click='toggleFilter'>筛选</a></div>
        <div class="list">
            <div class="list-item" v-for="(item, index) in userList" :key="index" @click="itemClickHandler">
                <div class="list-item-body">
                    <div class="item-left">
                        <!--eslint-disable-->
                        <image :src="item.photo" mode="widthFix"></image>
                    </div>
                    <div class="item-right">
                        <div>{{item.nickName}}</div>
                        <div>{{item.nowLocation}}</div>
                        <div>{{item.birthday}}</div>
                        <div>{{item.university}}{{item.isStudent === '是'? '在读':'毕业'}}</div>
                        <div>{{item.signature}}</div>
                    </div>
                </div>
            </div>
        </div>
        <!--弹出层，过滤项目-->
        <div v-if="isShowFilter" class="filter-layer">
            <div class="filter-box">
                <div class="filter-item">
                    <div class="item-header">性别</div>
                    <div class="item-body">
                        <div class="text" :class="item.selected === true? 'selected':''"
                             v-for="(item, index) in genderFilterList"
                             @click="genderItemClick(index)"
                             :key="index">{{item.name}}</div>
                    </div>
                </div>
                <div class="filter-item">
                    <div class="item-header">年龄</div>
                    <div class="item-body">
                        <view class="section">
                            <picker mode="multiSelector" @change="bindMultiPickerChange" @columnchange="bindMultiPickerColumnChange" :value="multiIndex" :range="multiArray">
                                <view class="picker">
                                    当前选择：{{multiArray[0][multiIndex[0]]}}岁-{{multiArray[1][multiIndex[1]]}}岁
                                </view>
                            </picker>
                        </view>
                    </div>
                </div>
                <div class="filter-item">
                    <div class="item-header">学历</div>
                    <div class="item-body">
                        <div class="text" :class="item.selected === true? 'selected':''"
                             v-for="(item, index) in educationFilterList"
                             @click="educationItemClick(index)"
                             :key="index">{{item.name}}</div>
                    </div>
                </div>
                <div class="filter-item">
                    <div class="item-header">学位</div>
                    <div class="item-body">
                        <div class="text" :class="item.selected === true? 'selected':''"
                             v-for="(item, index) in isStudentFilterList"
                             @click="isStudentItemClick(index)"
                             :key="index">{{item.name}}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            genderFilterList: [{name: '看全部', selected: true}, {name: '看男生', selected: false}, {name: '看女生', selected: false}],
            educationFilterList: [{name: '本科', selected: true}, {name: '硕士', selected: true}, {name: '博士', selected: true}],
            isStudentFilterList: [{name: '在读', selected: true}, {name: '毕业', selected: true}],
            isShowFilter: false,
            multiArray: [['20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '31', '32', '33', '34', '35', '36', '37', '38',
                '39', '40'], ['20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '31', '32', '33', '34', '35', '36', '37', '38',
                '39', '40']],
            multiIndex: [0, 20],
            userList: [{
                uid: '1000001',
                title: '找一个适合的人，坐标北京~',
                nickName: 'huochai',
                gender: '男',
                birthday: '1991-09-09',
                isStudent: '是',
                university: '北京大学',
                nowLocation: '北京',
                grade: '研二',
                highestEducation: '硕士',
                height: '175',
                home: '河北',
                weixin: 'liushuipku',
                email: '1111@qq.com',
                photo: '../../static/nan/1.png',
                signature: '简简单单就是我，那你呢'
            }, {
                uid: '1000002',
                title: '帮朋友找男朋友，坐标清华, 走过路过不要错过',
                nickName: '喵儿',
                gender: '女',
                birthday: '1991-04-09',
                isStudent: '否',
                university: '清华大学',
                nowLocation: '北京',
                grade: '毕业',
                highestEducation: '硕士',
                height: '165',
                home: '山东',
                weixin: 'lisitsu',
                email: '197669580@qq.com',
                photo: '../../static/nv/6.png',
                signature: '愿得1人心，100手不相离'
            }, {
                uid: '1000003',
                nickName: '三少爷',
                title: '你是那个陪我纵情山水的人吗？',
                gender: '男',
                birthday: '1994-01-29',
                isStudent: '是',
                university: '北京航空航天大学',
                nowLocation: '北京',
                grade: '研3',
                highestEducation: '博士',
                height: '177',
                home: '天津',
                weixin: 'lyshy',
                email: '235436547@qq.com',
                photo: '../../static/nan/2.png',
                signature: '愿得1人心，100手不相离'
            }, {
                uid: '1000004',
                title: '招聘男盆友～',
                nickName: '小朵',
                gender: '女',
                birthday: '1998-04-06',
                isStudent: '否',
                university: '北京师范大学',
                nowLocation: '北京',
                grade: '毕业',
                highestEducation: '硕士',
                height: '163',
                home: '湖北',
                weixin: 'fsggv',
                email: 'fsdgt@qq.com',
                photo: '../../static/nv/2.png',
                signature: '愿得1人心，100手不相离'
            }]
        };
    },

    components: {
    },

    methods: {
        // 事件处理，弹出或者隐藏浮层
        toggleFilter (e) {
            e.stopPropagation();
            this.isShowFilter = !this.isShowFilter;
        },

        bindMultiPickerChange: function (e) {
            console.log('picker发送选择改变，携带值为', e.mp.detail.value);
            this.multiIndex = e.mp.detail.value;
            if (this.multiIndex[0] > this.multiIndex[1]) {
                this.multiIndex[1] = this.multiIndex[0];
            }
        },
        bindMultiPickerColumnChange: function (e) {
            console.log('修改的列为', e.mp.detail.column, '，值为', e.mp.detail.value);
            this.multiIndex[e.mp.detail.column] = e.mp.detail.value;
            if (this.multiIndex[0] > this.multiIndex[1]) {
                this.multiIndex[1] = this.multiIndex[0];
            }
        },
        // 教育程度过滤项某项改变
        educationItemClick (index) {
            this.educationFilterList[index].selected = !this.educationFilterList[index].selected;
        },
        // 是否在读过滤项事件
        isStudentItemClick (index) {
            this.isStudentFilterList[index].selected = !this.isStudentFilterList[index].selected;
        },
        // 性别过滤项某项改变事件
        genderItemClick (index) {
            this.genderFilterList[index].selected = !this.genderFilterList[index].selected;
            if (this.genderFilterList[index].selected === true) {
                this.modifySelectedState(index, this.genderFilterList[index].selected);
            }
        },
        // 修改genderFilterList选中状态
        modifySelectedState (index, state) {
            for (let i = 0; i < this.genderFilterList.length; i++) {
                if (i !== index && this.genderFilterList[i].selected === true) {
                    this.genderFilterList[i].selected = false;
                }
            }
        },

        // 某个交友人员的卡片被点击，进入其详情页
        itemClickHandler (e) {
            /*eslint-disable-next-line*/
            wx.navigateTo({
                url: '../infoDetail/main'
            });
        },

        login(){
            /*eslint-disable-next-line*/
            wx.login({
                success: function (res) {
                    if (res.code) {
                        //发起网络请求
                        wx.request({
                            url: `http://localhost:8081/chance/login_code`,
                            data: {
                                code: res.code,
                                state: 0
                            },
                            success: function (data) {
                                console.log('qingqiu', data);
                                // 将用户唯一性数据存起来
                                wx.setStorage({
                                    key:"session",
                                    data: data
                                })
                            },
                            fail: function (err) {
                                console.log('err', err);
                            }
                        });
                    } else {
                        console.log('登录失败！' + res.errMsg);
                    }
                }
            });
        }
    },
    // 下拉刷新回调接口
    onReachBottom: function () {
        console.log('gggggggggggg');
    },
    mounted () {

    },
    onLoad(){
        // 检查是否登录过期
        wx.checkSession({
            success: function(){
                //session_key 未过期，并且在本生命周期一直有效
                let session = wx.getStorageSync('session');
                console.log('登录未过期，返回session', session);
            },
            fail: () => {
                console.log('登录过期，需要重新登录');
                // 失效就重新登录
                this.login();
            }
        })
    }
};
</script>

<style lang="scss" scoped>
.container{
    .search{
        position: fixed;
        color: #1aad19;
        text-align: right;
        top: 0;
        width: 100%;
        background-color: white;
        a{
            position: relative;
            right: 10rpx;
            font-size: 14px;
        }
    }
    .list{
        display: flex;
        flex-direction: column;
        margin-top: 50rpx;
        .list-item{
            margin: 10rpx 10rpx;
            box-shadow: 10rpx 10rpx 10rpx #ccc;
            padding: 10rpx;
            border-top: 1px solid #FCFCFC;
            border-bottom: 1px solid #ccc;
            box-sizing: border-box;
            .list-item-body{
                padding-top: 10rpx;
                .item-left{
                    float: left;
                    width: 60%;
                    height: 360rpx;
                    display:flex;
                    flex-direction:row;
                    align-items:center;
                    justify-content:center;
                    image{
                        max-width: 100%;
                        max-height: 360rpx;
                    }
                }
                .item-right{
                    float: left;
                    padding: 10rpx;
                    width: 40%;
                    box-sizing: border-box;
                    font-size: 14px;
                    >div{
                        padding: 2px 0;
                    }
                }
            }
        }
    }
    .filter-layer{
        position: fixed;
        width:100%;
        height:100%;
        top: 35rpx;
        background:rgba(255,255,255,0.9);
        overflow: hidden;
        .filter-box{
            text-align: center;
            .filter-item{
                height: 200rpx;
                border-bottom: 1px solid #ccc;
                .item-header{
                    color: purple;
                }
                .item-body{
                    display: flex;
                    flex-direction: row;
                    justify-content: space-around;
                    .text{
                        background-color: #eee;
                        border-radius: 40rpx;
                        padding: 20rpx;
                        box-shadow: 10rpx 10rpx 10rpx #ccc;
                    }
                    .selected{
                        background-color: pink;
                    }
                }
            }
        }
    }
}
</style>

