//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    strategys: [],
    strategyOther:[],
    Keystrategy:[],
    imagelist:[],
    ld: "display",
    hv:"none",
    sd: "none",
    imgUrls:[
      'http://localhost:8090/MyWe/images/01.jpg',
      'http://localhost:8090/MyWe/images/02.jpg',
      'http://localhost:8090/MyWe/images/04.jpg'
    ],
    indicatorDots:false,
    autoplay:true,
    interval:3000,
    duration:3000,
    imgwidth:0,
    imgheight:0

  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  //获取首页的攻略列表
  onLoad: function () {
   var that=this;
     wx.getSystemInfo({
       success: function (res) {
         var windowWidth = res.windowWidth;
         var windowHeight = res.windowHeight;
         var windowscale = windowHeight / windowWidth;//屏幕高宽比  
         console.log('windowWidth: ' + windowWidth)
         console.log('windowHeight: ' + windowHeight)
         var width = windowWidth - 20;
         var height = windowHeight/2.6;
         var cwidth=windowWidth*0.7-20;
         that.setData({
           imgwidth: width,
           imgheight:height,
           conWidth:cwidth,
         })
       }
     })
   wx.request({
     url:'http://localhost:8090/MyWe/strategy/show',
     data:{
      
     },
     header:{
       "Content-Type":"application/json"
     },
     method:"GET",
     success: function (data){
        that.setData({
          strategys:data.data.strategylist, sd: "block", ld: "none",
          hv:"display",
          strategyOther: data.data.strategyOther

        });
        console.log(data)

        
     },
     fail:function(err){},
     complete:function(){}

   });
   
  },

  SearchStrategy: function (e){
    var input=e.detail.value;
    if(input==''){

    }else{
    var that=this;
       wx.navigateTo({
         url: '../search/search?Keystrategy=' +input ,
         success: function () {},
         fail: function(res) {},
         complete: function(res) {},
        });
    }
  },
  
  viewStrategyDetail:function(e){
    var that=this;
    wx.navigateTo({
      url: '../details/details?id='+e.currentTarget.dataset.id,
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  onPullDownRefresh() {
    console.log('--------下拉刷新-------')
    wx.showNavigationBarLoading() //在标题栏中显示加载
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        var windowWidth = res.windowWidth;
        var windowHeight = res.windowHeight;
        var windowscale = windowHeight / windowWidth;//屏幕高宽比  
        console.log('windowWidth: ' + windowWidth)
        console.log('windowHeight: ' + windowHeight)
        var width = windowWidth - 20;
        var height = windowHeight / 2.6;
        var cwidth = windowWidth * 0.7 - 20;
        that.setData({
          imgwidth: width,
          imgheight: height,
          conWidth: cwidth,
        })
      }
    })
    wx.request({
      url: 'http://localhost:8090/MyWe/strategy/show',
      data: {

      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          strategys: data.data.strategylist, sd: "block", ld: "none",
          hv: "display",
          strategyOther: data.data.strategyOther

        });
        console.log(data)


      },
      fail: function (err) { },
      complete: function () {
        // complete
        wx.hideNavigationBarLoading() //完成停止加载
        wx.stopPullDownRefresh() //停止下拉刷新
      }
    })
  },
  onShow:function(){
    this.onLoad()
  }
 
})
