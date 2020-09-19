// gather.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      'http://localhost:8090/MyWe/images/旅游1.png',
      'http://localhost:8090/MyWe/images/旅游2.png',
      'http://localhost:8090/MyWe/images/旅游3.png'
    ],
    indicatorDots: false,
    autoplay: true,
    interval: 3000,
    duration: 3000,
    gather:{},
    text1:'',
    text2:'',
    sex:'',
    connection:'',
    show:'none',
    src1:'',
    w:0,
    Vtype:'defaule',
    x:false,
    y:false,
    Xtype:'defaule',
    v:false,
    m:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var id = options.id
    var user_id = wx.getStorageSync('uid')

    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
      //更新数据
      that.setData({
        userInfo: userInfo
      });
      wx.request({
        url: 'http://localhost:8090/MyWe/gather/details',
        data: {
          id: id,
          user_id: user_id,
          user_name: userInfo.nickName
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (data) {
          console.log(data);
          that.setData({
            ld: 'none',
            show:'display',
            gather: data.data.gather,
            text1: data.data.text1,
            text2: data.data.text2,
            sex:data.data.sex,
            connection:data.data.con,
          });
          wx.getSystemInfo({
            success: function (res) {
              var image = that.data.imagelist;
              var windowWidth = res.windowWidth;
              var windowHeight = res.windowHeight;
              var windowscale = windowHeight / windowWidth;//屏幕高宽比  
              console.log('windowWidth: ' + windowWidth)
              console.log('windowHeight: ' + windowHeight)
              var width = (windowWidth-30)/2
              that.setData({
                w:width
              })
            }
          })
        },
        fail: function (err) { },
        complete: function (res) { }

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

  clickButton1:function(e){
    var that = this;
    that.setData({
      Vtype:'primary',
      x:true,
      y:true
    })
    var user_id = wx.getStorageSync('uid')
    var id = e.currentTarget.dataset.id
    wx.request({
      url: 'http://localhost:8090/MyWe/gather/focus',
      data: {
        gather_id: id,
        user_id: user_id,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          text1: data.data.text1,
          gather:data.data.gather,
          Vtype: 'defaule',
          x: false,
          y: false
        });
      },

      fail: function (err) { },
      complete: function () { }
    })


  },
  clickButton2: function (e) {
    var that = this;
    that.setData({
      Xtype: 'primary',
      v: true,
      m: true
    })
    var user_id = wx.getStorageSync('uid')
    var id = e.currentTarget.dataset.id
    wx.request({
      url: 'http://localhost:8090/MyWe/gather/join',
      data: {
        gather_id: id,
        user_id: user_id,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          text2: data.data.text2,
          gather: data.data.gather,
          Xtype: 'defaule',
          connection:data.data.con,
          v: false,
          m: false
        });
      },

      fail: function (err) { },
      complete: function () { }
    })


  },
  LookUser: function (e) {
    var that = this
    wx.navigateTo({
      url: '../../pages/lookuser/lookuser?id=' + e.currentTarget.dataset.id,
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    });
  }
})