// strategy.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ld:'display',
    imgwidth: 0,
    imgheight: 0,
    strategys: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var user_id = wx.getStorageSync('uid')
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
      url: 'http://localhost:8090/MyWe/strategy/UserPublic',
      data: {
        user_id: user_id,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (strategys) {
        that.setData({
          strategys: strategys.data,
          ld: "none",

        });
        console.log(strategys)


      },
      fail: function (err) { },
      complete: function () { }

    });

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
  
  }
})