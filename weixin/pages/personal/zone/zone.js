// zone.js
var app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    code:{},
    openid:{},
    bgsrc:'/images/toptop.jpg',
    data:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
    var that=this
    var user_id = wx.getStorageSync('uid')
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
      //更新数据
      that.setData({
        userInfo: userInfo
      })
    })
    wx.request({
      url: 'http://localhost:8090/MyWe/user/show',
      data: {
        id:user_id,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        that.setData({
          data:data.data
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
  
  },

  addGather:function(){
    var that = this;
    wx.navigateTo({
      url: '../../addg/addg',
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    });
  },

  addStrategy: function () {
    var that = this;
    wx.navigateTo({
      url: '../../adds/adds',
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    });
  },
 
})