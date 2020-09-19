// getlocation.js
// 引用百度地图微信小程序JSAPI模块 
var bmap = require('../../lib/bmap-wx.js');

var wxMarkerData = [];

Page({
  data: {
    markers: [],
    latitude: '',
    longitude: '',
    rgcData: {},
    Height:0,
    actionSheetHidden:true,
    location:'',
  },
  
  
  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        //设置map高度，根据当前设备宽高满屏显示
        that.setData({
          view: {
            Height: res.windowHeight
          }
        })
      }
    })
    // 新建百度地图对象 
    var BMap = new bmap.BMapWX({
      ak: 'G1pidjBY3jItu9VSLWuHDDd3atMbrqNv'
    });
    var fail = function (data) {
      console.log(data)
    };
    var success = function (data) {
      wxMarkerData = data.wxMarkerData;
      that.setData({
        markers: wxMarkerData
      });
      that.setData({
        latitude: wxMarkerData[0].latitude
      });
      that.setData({
        longitude: wxMarkerData[0].longitude
      });


      that.showSearchInfo(wxMarkerData,wxMarkerData[0].id);

    }
    // 发起regeocoding检索请求 
    BMap.regeocoding({
      fail: fail,
      success: success,
      iconPath: '../../dist/img/location2.svg',
      //iconTapPath: '../../../images/location.svg',
    });
    
  },
  showSearchInfo: function (data, i) {
    var that = this;
    that.setData({
      rgcData: {
        address: '地址：' + data[i].address + '\n',
        desc: '描述：' + data[i].desc + '\n',
        business: '商圈：' + data[i].business
      }
    });
  },
  actionSheetTap: function (e) {
    this.setData({
      actionSheetHidden: !this.data.actionSheetHidden
    })
  },
  makertap: function (e) {
    var that = this;
    var id = e.markerId;
    that.showSearchInfo(wxMarkerData, id);
  },
  actionSheetbindchange: function () {
    this.setData({
      actionSheetHidden: !this.data.actionSheetHidden
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

  commitLocation:function(e){
    var that=this;
var pages = getCurrentPages();
var prevPage = pages[pages.length - 2];
prevPage.setData({location: e.currentTarget.dataset.address});
/*
    that.setData({
      location: e.currentTarget.dataset.address
    })
    */
    //var location = e.currentTarget.dataset.address
    wx.navigateBack({
      url:'../../pages/adds/adds',
      data:{
        location:location
      }
    })
  }
})