// friends.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
  hv:'none',
  ld: "display",
  w:0,
  h:0,
  gatherlist:{},
  gatherhots:{},
    },

  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        var windowWidth = res.windowWidth;
        var windowHeight = res.windowHeight;
        var windowscale = windowHeight / windowWidth;//屏幕高宽比  
        console.log('windowWidth: ' + windowWidth)
        console.log('windowHeight: ' + windowHeight)
        var width = (windowWidth - 30)/2;
        var height = width
        that.setData({
          w: width,
          h: height,
        })
      }
    })
    wx.request({
      url: 'http://localhost:8090/MyWe/gather/show',
      data: {

      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          gatherhots: data.data.gatherhot,
          gatherlist: data.data.gatherlist,
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
      this.onLoad()
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

  viewgatherhotDetail:function(e){
    var that = this;
    wx.navigateTo({
      url: '../gather/gather?id=' + e.currentTarget.dataset.id,
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
          var width = (windowWidth - 30) / 2;
          var height = width
          that.setData({
            w: width,
            h: height,
          })
        }
      })
      wx.request({
        url: 'http://localhost:8090/MyWe/gather/show',
        data: {

        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (data) {
          that.setData({
            gatherhots: data.data.gatherhot,
            gatherlist: data.data.gatherlist,
            ld: "none",
            hv: "display",

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
  
  SearchGather: function (e) {
    var input = e.detail.value;
    if (input == '') {

    } else {
      var that = this;
      wx.navigateTo({
        url: '../research/research?Keygather=' + input,
        success: function () { },
        fail: function (res) { },
        complete: function (res) { },
      });
    }
  },
  

})