import Vue from 'vue';
import App from './App';
import '../static/weui/weui.css';
Vue.config.productionTip = false;
App.mpType = 'app';

const app = new Vue(App);
app.$mount();

export default {
    // 这个字段走 app.json
    config: {
        // 页面前带有 ^ 符号的，会被编译成首页，其他页面可以选填，我们会自动把 webpack entry 里面的入口页面加进去
        pages: ['^pages/authorize/main', 'pages/list/main', 'pages/recommend/main', 'pages/activity/main', 'pages/personCenter/main',// 导航
            'pages/personCenter/personInfoEdit/main', 'pages/personCenter/myMessage/main', 'pages/personCenter/myUpvote/main',// 个人中心
            'pages/personCenter/mySetting/main', 'pages/personCenter/myMakeFriendCard/main', 'pages/personCenter/myIdentifyUpload/main',
             'pages/personCenter/myBindingPhone/main',
            'pages/list/infoDetail/main', 'pages/list/sendMessage/main',],// 初识爱情
        window: {
            backgroundTextStyle:'#fff',
            navigationBarBackgroundColor:'#ff4141',
            navigationBarTitleText:'初识在校园',
            navigationBarTextStyle:'#000',
            'color':'#888888',
            'selectedColor':'#ff4141',
            'backgroundColor':'#fff',
             'borderStyle':'#a9a9a9',
        },
        'tabBar': {
          "color":"red",
          "selectedColor":"#11cd6e",
          "borderStyle":"#fff",
          'list': [{
                'pagePath': 'pages/list/main',
                'text': '初识爱情',
                "iconPath": '../static/icon/nav/nav-2-a.png',
            'selectedIconPath':'../static/icon/nav/nav-2-b.png',
                'selectedColor': '#4EDF80',
                'active': true,

            },{
                'pagePath': 'pages/recommend/main',
                'text': '丘比特',
                'iconPath': '../static/icon/nav/nav-2-a.png',
                'selectedIconPath': '../static/icon/nav/nav-2-b.png',
                'selectedColor': '#4EDF80',
                'active': false
            },{
                'pagePath': 'pages/activity/main',
                'text': '活动',
                "iconPath": 'static/icon/nav/nav-2-a.png',
                'selectedIconPath': 'static/icon/nav/nav-2-b.png',
                'selectedColor': '#4EDF80',
                'active': false
            },{
                'pagePath': 'pages/personCenter/main',
                'text': '我的',
                'iconPath': 'static/icon/nav/nav-2-a.png',
                'selectedIconPath': 'static/icon/nav/nav-2-b.png',
                'selectedColor': '#4EDF80',
                'active': false
            }]
        }
    }
};
