// addg.js
var app = getApp()
var area = require('../../pages/data/area')
var p = 0, c = 0, d = 0
var Ep=0,Ec=0,Ed=0
Page({

  /**
   * 页面的初始数据
   */
  data: {
    provinceName: [],
    provinceCode: [],
    provinceSelIndex: '',
    cityName: [],
    cityCode: [],
    citySelIndex: '',
    //districtName: [],
    //districtCode: [],
    //districtSelIndex: '',
    cityEnabled: false,
    //districtEnabled: false,
    showMessage: false,
    messageContent: '',

    EprovinceName: [],
    EprovinceCode: [],
    EprovinceSelIndex: '',
    EcityName: [],
    EcityCode: [],
    EcitySelIndex: '',
    EcityEnabled: false,

    Sindex: 0,
    Sdate: '2017-08-27',
    Eindex:0,
    Edate:'2017-08-27',
    connection:'',
    con_status:'',


    tempFilePaths:'../../images/upload.png',

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setAreaData()
    this.EsetAreaData()

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

//出发地
  changeProvince: function (e) {
    this.resetAreaData('province')
    p = e.detail.value
    this.setAreaData('province', p)
  },
  // 选择市
  changeCity: function (e) {
    this.resetAreaData()
    c = e.detail.value
    this.setAreaData('city', p, c)
  },
  // 选择区
  changeDistrict: function (e) {
    d = e.detail.value
    this.setAreaData('district', p, c, d)
  },
  setAreaData: function (t, p, c, d) {
    switch (t) {
      case 'province':
        this.setData({
          provinceSelIndex: p,
          cityEnabled: true
        })
        break;
      case 'city':
        this.setData({
          citySelIndex: c,
          districtEnabled: true
        })
        break;
      case 'district':
        this.setData({
          districtSelIndex: d
        })
    }

    var p = p || 0 // provinceSelIndex
    var c = c || 0 // citySelIndex
    var d = d || 0 // districtSelIndex
    // 设置省的数据
    var province = area['100000']
    var provinceName = [];
    var provinceCode = [];
    for (var item in province) {
      provinceName.push(province[item])
      provinceCode.push(item)
    }
    this.setData({
      provinceName: provinceName,
      provinceCode: provinceCode
    })
    // 设置市的数据
    var city = area[provinceCode[p]]
    var cityName = [];
    var cityCode = [];
    for (var item in city) {
      cityName.push(city[item])
      cityCode.push(item)
    }
    this.setData({
      cityName: cityName,
      cityCode: cityCode
    })
    // 设置区的数据
    var district = area[cityCode[c]]
    var districtName = [];
    var districtCode = [];
    for (var item in district) {
      districtName.push(district[item])
      districtCode.push(item)
    }
    this.setData({
      districtName: districtName,
      districtCode: districtCode
    })
  },
  // 重置数据
  resetAreaData: function (type) {
    this.setData({
      districtName: [],
      districtCode: [],
      districtSelIndex: '',
      districtEnabled: false
    })
    if (type == 'province') {
      this.setData({
        cityName: [],
        cityCode: [],
        citySelIndex: ''
      })
    }
  },
  //目的地

  EchangeProvince: function (e) {
    this.EresetAreaData('Eprovince')
    Ep = e.detail.value
    this.EsetAreaData('Eprovince', Ep)
  },
  // 选择市
  EchangeCity: function (e) {
    this.EresetAreaData()
    Ec = e.detail.value
    this.EsetAreaData('Ecity', Ep, Ec)
  },
  // 选择区
  EchangeDistrict: function (e) {
    Ed = e.detail.value
    this.EsetAreaData('district', Ep, Ec, Ed)
  },
  EsetAreaData: function (Et, Ep, Ec, Ed) {
    switch (Et) {
      case 'Eprovince':
        this.setData({
          EprovinceSelIndex: Ep,
          EcityEnabled: true
        })
        break;
      case 'Ecity':
        this.setData({
          EcitySelIndex: Ec,
          EdistrictEnabled: true
        })
        break;
      case 'Edistrict':
        this.setData({
          districtSelIndex: Ed
        })
    }

    var Ep = Ep || 0 // provinceSelIndex
    var Ec = Ec || 0 // citySelIndex
    var Ed = Ed || 0 // districtSelIndex
    // 设置省的数据
    var province = area['100000']
    var provinceName = [];
    var provinceCode = [];
    for (var item in province) {
      provinceName.push(province[item])
      provinceCode.push(item)
    }
    this.setData({
      EprovinceName: provinceName,
      EprovinceCode: provinceCode
    })
    // 设置市的数据
    var city = area[provinceCode[Ep]]
    var cityName = [];
    var cityCode = [];
    for (var item in city) {
      cityName.push(city[item])
      cityCode.push(item)
    }
    this.setData({
      EcityName: cityName,
      EcityCode: cityCode
    })
    // 设置区的数据
    var district = area[cityCode[Ec]]
    var districtName = [];
    var districtCode = [];
    for (var item in district) {
      districtName.push(district[item])
      districtCode.push(item)
    }
    this.setData({
      districtName: districtName,
      districtCode: districtCode
    })
  },
  // 重置数据
  EresetAreaData: function (type) {
    this.setData({
      districtName: [],
      districtCode: [],
      districtSelIndex: '',
      districtEnabled: false
    })
    if (type == 'Eprovince') {
      this.setData({
        EcityName: [],
        EcityCode: [],
        EcitySelIndex: ''
      })
    }
  },
  
  saveGatherInfo: function (e) {
    var data = e.detail.value
    //var telRule = /^1[3|4|5|7|8]\d{9}$/, nameRule = /^[\u2E80-\u9FFF]+$/
    if (data.name == '') {
      this.showMessage('请输入标题')
    }// else if (!nameRule.test(data.name)) {
     // this.showMessage('请输入中文名')
    //} 
    //else if (data.tel == '') {
      //this.showMessage('请输入手机号码')
    //} else if (!telRule.test(data.tel)) {
     // this.showMessage('手机号码格式不正确')
    //} 
    else if (data.province == '') {
      this.showMessage('请选择所在省')
    } else if (data.city == '') {
      this.showMessage('请选择所在市')
    } else if (data.connect == '') {
      this.showMessage('请输入联系方式')
    }
    //else if (data.district == '') {
      //this.showMessage('请选择所在区')
    //} 
    //else if (data.address == '') {
     // this.showMessage('请输入详细地址')
    //} 
    else {
      this.showMessage(' 发布成功')
      console.log(data)
      var id = wx.getStorageSync('uid')
      var that = this
      //调用应用实例的方法获取全局数据
      app.getUserInfo(function (userInfo) {
        //更新数据
        that.setData({
          userInfo: userInfo
        });
      wx.request({
        url: 'http://localhost:8090/MyWe/gather/addg',
        data:{
        user_id:id,
        user_name:userInfo.nickName,
        title:data.name,
        content:data.content,
        city:data.city,
        Ecity:data.Ecity,
        Sdate:data.Sdate,
        Edate:data.Edate,
        sex: data.Sexradiogroup,
        images:data.tempFilePaths,
        connection:data.connect,
        con_status: data.default

      },
      header:{
        "Content-Type": "application/json"
      },
      method: "GET",
      success: function () {},

      fail: function (err) { },
      complete: function () { }
      })
      wx.uploadFile({
        url:'http://localhost:8090/MyWe/upload',
        filePath: data.tempFilePaths,
        name:'file',
        success:function(res){
          var data=res.data
        }
      })

    })
  }
},
  showMessage: function (text) {
    var that = this
    that.setData({
      showMessage: true,
      messageContent: text
    })
    setTimeout(function () {
      that.setData({
        showMessage: false,
        messageContent: ''
      })
    }, 3000)
  },

  SbindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      Sindex: e.detail.value
    })
  },
  SbindDateChange: function (e) {
    this.setData({
      Sdate: e.detail.value
    })
  },

  EbindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      Eindex: e.detail.value
    })
  },
 
  EbindDateChange: function (e) {
    this.setData({
      Edate: e.detail.value
    })
  },

  radioChange:function(e){
    this.setData({
      sex:e.detail.value
    })
  },


chooseimage:function(){
    var that=this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType:['album','camera'],
      success: function(res) {
        that.setData({
          tempFilePaths:res.tempFilePaths
        })
      },
    })
   

}
  



})
