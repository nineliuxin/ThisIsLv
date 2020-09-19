// research.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    Keygathers:{},
    imgUrls: [
      'http://localhost:8090/MyWe/images/旅游1.png',
      'http://localhost:8090/MyWe/images/旅游2.png',
      'http://localhost:8090/MyWe/images/旅游3.png'
    ],
    ld: 'display',
    hv: 'none',
    indicatorDots: false,
    autoplay: true,
    interval: 3000,
    duration: 3000,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        var windowWidth = res.windowWidth;
        var windowHeight = res.windowHeight;
        var windowscale = windowHeight / windowWidth;//屏幕高宽比  
        console.log('windowWidth: ' + windowWidth)
        console.log('windowHeight: ' + windowHeight)
        var width = (windowWidth - 30) / 2;
        var height = width
        that.setData({
          w: width,
          h: height,
        })
      }
    })
    wx.request({
      url: 'http://localhost:8090/MyWe/gather/search',
      data: {
          Keyword:options.Keygather,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          Keygathers:data.data.Keygathers,
          ld: "none",
          hv: "display",

        });
        console.log(data)


      },
      fail: function (err) { },
      complete: function () { }

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
  
  }
})