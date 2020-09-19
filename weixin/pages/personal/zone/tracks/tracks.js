// tracks.js
var app = getApp()
var order = ['firstLevel', 'secondLevel', 'thirdLevel', 'forthLevel', 'fifthLevel','sixthLevel']
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ld: "display",
    x:'none',
    y:'none',
    userInfo: {},
    toView:"",//后台取到的等级数据
    //picOne:"../../../../../images/11111.png",
    //picTwo: "../../../../../images/22222.png",
    //picThree: "../../../../../images/33333.png",
    //picFour: "../../../../../images/44444.png",
    //picFive: "../../../../../images/55555.png",
    //picSix: "../../../../../images/66666.png",
    showList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //从后台取得等级数据放入toView
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
      //更新数据
      that.setData({
        userInfo: userInfo
      })
    })
    var uid = wx.getStorageSync('uid')
    wx.request({
      url: 'http://localhost:8090/MyWe/level/show',
      data: {
        uid:uid,
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (data) {
        console.log(data)
        that.setData({
          data:data.data,
          picList:data.data.picList,
          x:data.data.x,
          y:data.data.y,
          showList:data.data.strategys,
          ld:'none'
       })
       if(data.data.level==0){
          that.setData({
            toView:'firstLevel'
          })
       }else if(data.data.level==1){
         that.setData({
           toView: 'firstLevel'
         })
       } else if (data.data.level == 2) {
         that.setData({
           toView: 'secondLevel'
         })
       } else if (data.data.level == 3) {
         that.setData({
           toView: 'thirdLevel'
         })
       } else if (data.data.level == 4) {
         that.setData({
           toView: 'forthLevel'
         })
       } else if (data.data.level == 5) {
         that.setData({
           toView: 'fifthLevel'
         })
       } else if (data.data.level == 6) {
         that.setData({
           toView: 'fifthLevel'
         })
       }
  }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  //取所在等级前的彩色图片，所在等级后的灰色图片，并显示:灰色图片小，彩色图片大
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