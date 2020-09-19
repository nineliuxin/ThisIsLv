// lookuser.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    show: 'none',
    ld:'display',
    navbar: ['发布的攻略', '发布的召集令'],
    currentTab: 0,
    imgwidth: 0,
    imgheight: 0,
    user_id:0,
    w:0,
    h:0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var id=options.id
      var uid = wx.getStorageSync('uid')
      this.setData({
        user_id: id,
      })
      var that=this
      wx.request({
        url: 'http://localhost:8090/MyWe/user/lookuser',
        data: {
          id: id,
          uid:uid,
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (data) {
          console.log(data);
          that.setData({
            ld: 'none',
            show: 'display',
            data:data.data,
            strategys:data.data.strategys,
            text: data.data.text,
            focus: data.data.focus,
            fans: data.data.fans
          });
          wx.getSystemInfo({
            success: function (res) {
              var windowWidth = res.windowWidth;
              var windowHeight = res.windowHeight;
              var windowscale = windowHeight / windowWidth;//屏幕高宽比  
              console.log('windowWidth: ' + windowWidth)
              console.log('windowHeight: ' + windowHeight)
              var width = windowWidth - 20;
              var height = windowHeight / 3;
              var cwidth = windowWidth * 0.7 - 20;
              that.setData({
                imgwidth: width,
                imgheight: height,
                conWidth: cwidth,
              })
            }
          })
        },
        fail: function (err) { },
        complete: function (res) { }
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
  navbarTap: function (e) {
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
      var id = e.currentTarget.dataset.idx;
      var user_id = this.data.user_id;
      var that = this
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
      });

      if (id == 1) {
        wx.request({
          url: 'http://localhost:8090/MyWe/user/lookuserG',
          data: {
            user_id: user_id
          },
          header: {
            "Content-Type": "application/json"
          },
          method: "GET",
          success: function (gatherList) {
            console.log(gatherList);
            that.setData({
              gatherList: gatherList.data,
              ld: 'none'
            });
          }
        })
      }
    },
  viewStrategyDetail:function(e){
    var that = this;
    wx.navigateTo({
      url: '../details/details?id=' + e.currentTarget.dataset.id,
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  viewgatherDetail: function (e) {
    var that = this;
    wx.navigateTo({
      url: '../gather/gather?id=' + e.currentTarget.dataset.id,
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  clickme:function(options){
    var id=this.data.user_id
    var uid = wx.getStorageSync('uid')
    var that=this
      wx.request({
        url: 'http://localhost:8090/MyWe/user/userFocus',
        data: {
          id:id,
          uid: uid
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (data) {
            that.setData({
              text:data.data.text,
              focus:data.data.focus,
              fans:data.data.fans
            })
        }
      })

  }
})