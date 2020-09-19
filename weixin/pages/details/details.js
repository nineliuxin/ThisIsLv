// details.js
//获取应用实例
var app = getApp()
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    imagelist: [],
    userInfo:{},
    name: {},
    lc:'none',
    ld: 'display',
    strategyDetail:{},
    src1:'',
    src2:'',
    imgwidth:0,
    imgheight:0
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad:function(options) {
    //wx.getUserInfo({
    //  success:function(res){
    //    var userInfo=res.userInfo
    //    var name=userInfo.nickName
    //  }
    //})
    var that = this
    var id=options.id
    var user_id = wx.getStorageSync('uid')
    
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
      //更新数据
      that.setData({
        userInfo: userInfo
      });
    wx.request({
        url: 'http://localhost:8090/MyWe/strategy/details',
        data: {
          id: id,
          user_id:user_id,
          user_name: userInfo.nickName
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (data) {
          console.log(data);
          that.setData({
            strategyDetail: data.data.strategy,
            imagelist: data.data.imageArray,
            src1: data.data.res,
            src2: data.data.re,
            lc:'display',
            ld:'none'
          });
          wx.getSystemInfo({
            success: function (res) {
              var image=that.data.imagelist;
              var windowWidth = res.windowWidth;
              var windowHeight = res.windowHeight;
              var windowscale = windowHeight / windowWidth;//屏幕高宽比  
              console.log('windowWidth: ' + windowWidth)
              console.log('windowHeight: ' + windowHeight)
              var width;
              var height;
              if(image.length==1){
                width=windowWidth-20;
                height=width*windowscale;
              } else if (image.length == 2){
                width=(windowWidth-30)/2;
                height=width;
              }else if(image.length==3){
                width=(windowWidth-40)/3;
                height=width;
              } else if (image.length==4){
                width = (windowWidth-30)/2;
                height = width;
              } else if (image.length>4){
                width = (windowWidth - 40) / 3;
                height = width;
              }
              that.setData({
                imgwidth:width,
                imgheight:height,
              })
            }
          })
        },
        fail: function (err) { },
        complete: function (res) {}

      })
      



    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  praise: function (e){
    var user_id = wx.getStorageSync('uid')
    var id = e.currentTarget.dataset.id
    //var name = userInfo.nickName
    var $this=this;
    //调用应用实例的方法获取全局数据
   // app.getUserInfo(function (userInfo) {
      //更新数据
     // $this.setData({
       // userInfo: userInfo
      //});
    wx.request({
      url: 'http://localhost:8090/MyWe/strategy/praise',
      data:{
        id:id,
        user_id:user_id,
      },
    header: {
      "Content-Type": "application/json"
    },
  method: "GET",
  success: function(data) {
    $this.setData({
      src1:data.data.res,
      strategyDetail: data.data.strategy,
    });
  },
    
  fail: function (err) { },
  complete: function () { }
    })

 // })
  
},


  collect:function(e) {
    var user_id = wx.getStorageSync('uid')
    var id = e.currentTarget.dataset.id
    //var name = userInfo.nickName
    var $this = this;
    //app.getUserInfo(function (userInfo) {
      //更新数据
      //$this.setData({
        //userInfo: userInfo
      //});
    wx.request({
      url: 'http://localhost:8090/MyWe/strategy/collection',
      data: {
        id: id,
        user_id:user_id,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        $this.setData({
          src2: data.data.re,
          strategyDetail: data.data.strategy,
        });
      },

      fail: function (err) { },
      complete: function () { }
    })
    //})
  },
previewImage:function(e){
  var that = this;
  var id = e.currentTarget.dataset.id;
  var imageList = that.data.imagelist;
  var images=new Array();
  for(var i=0;i<imageList.length;i++){
    images[i] = imageList[i].image
  }
  wx.previewImage({
    current: images[id],
    urls: images
  });
},

LookUser:function(e){
  var that=this
  wx.navigateTo({
    url:'../../pages/lookuser/lookuser?id='+e.currentTarget.dataset.id,
    success: function () { },
    fail: function (res) { },
    complete: function (res) { },
  });
}
  
})