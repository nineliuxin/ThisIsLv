// convene.js
var app = getApp() 
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navbar: ['我发布的', '我关注的', '我报名的'],
    currentTab: 0 ,
    w: 0,
    h: 0,
    ld:'display',
    blank: 'none'
  },
  //navbarTap: function (e) {
    //this.setData({
      //currentTab: e.currentTarget.dataset.idx
    //})
   // var that=this
   // wx.request({
     // url: '',
   // })
  //} ,
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
    var user_id = wx.getStorageSync('uid')
    wx.request({
      url: 'http://localhost:8090/MyWe/gather/Userpublic',
      data: {
        user_id: user_id
      },
      header: {
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function (gathers) {
        console.log(gathers);
        that.setData({
          gathers:gathers.data,
          ld:'none'
        });
        var c = gathers.data
        if (c.length == 0) {
          that.setData({
            blank: 'display'
          })
        } else {
          that.setData({
            blank: 'none'
          })
        }
      }
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
  viewgatherDetail:function(e){
    var that = this;
    wx.navigateTo({
      url: '/pages/gather/gather?id=' + e.currentTarget.dataset.id,
      success: function () { },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  navbarTap:function(e){
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
    var id = e.currentTarget.dataset.idx;
    var user_id = wx.getStorageSync('uid')
    var that=this
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

    if(id==1){
      wx.request({
        url:'http://localhost:8090/MyWe/gather/Userfocus',
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
          var c = gatherList.data
          if (c.length == 0) {
            that.setData({
              blank: 'display'
            })
          } else {
            that.setData({
              blank: 'none'
            })
          }
        }
      })
    }else if(id==0){
      wx.request({
        url: 'http://localhost:8090/MyWe/gather/Userpublic',
        data: {
          user_id: user_id
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (gathers) {
          console.log(gathers);
          that.setData({
            gathers: gathers.data,
            ld: 'none'
          });
          var c = gathers.data
          if (c.length == 0) {
            that.setData({
              blank: 'display'
            })
          } else {
            that.setData({
              blank: 'none'
            })
          }
        }
      })
    }else if(id==2){
      wx.request({
        url: 'http://localhost:8090/MyWe/gather/Userjoin',
        data: {
          user_id: user_id
        },
        header: {
          "Content-Type": "application/json"
        },
        method: "GET",
        success: function (gatherMeun) {
          console.log(gatherMeun);
          that.setData({
            gatherMeun: gatherMeun.data,
            ld: 'none'
          });
          var c = gatherMeun.data
          if (c.length == 0) {
            that.setData({
              blank: 'display'
            })
          } else {
            that.setData({
              blank: 'none'
            })
          }
        }
      })
    }
  }
})