// adds.js
//var total=[];
var app=getApp();
var utils=require('../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
      imageList:[],
      pics:[],
      swithChecked:'',
      location:'开启定位分享才可以在当前位置留下足迹哟！',
      tipsrc:'../../images/tip.png',
      showMessage: false,
      messageContent: '',
      flag:true,
      lock:false

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var that=this
      that.setData({
        location:options.location
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
  onShow: function (e) {
    var pages = getCurrentPages();
    var currPage = pages[pages.length - 1];
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

  chooseImage: function (event) {
    var that = this;
    wx.chooseImage({
      count: 9,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        var imagegList = that.data.imageList.concat(res.tempFilePaths)
        var tempFilesPaths=res.tempFilePaths
        console.info(res.tempFilePaths.length);
        //that.uploadFile2(tempFilesPaths,0);
        that.setData({
          imageList: imagegList,
          pics: tempFilesPaths
        });
      },
    })

  },

  previewImage:function(e){
    if(this.endTime - this.startTime > 350){
      this.setData({
        flag:false
      })
      console.log("长按")
    }else{
    var that=this;
    var id=e.currentTarget.dataset.id;
    var imageList=that.data.imageList;
    wx.previewImage({
      current:imageList[id],
      urls:this.data.imageList
    });
    console.log("点击")
    }
  },


  switchChange:function(event){
    var that=this
    var check = event.detail.value
    if (!!check==true){
      wx.navigateTo({
        url: '../../pages/getlocation/getlocation',
      })
      that.setData({
        tipsrc:''
      })
    }else{
      that.setData({
        location:'',
        tipsrc:''
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


  saveStrategyInfo: function (e) {
    var data = e.detail.value
    if (data.name =='') {
      this.showMessage('请输入标题')
    }else if(data.text==''){
      this.showMessage('请输入内容')
    }else{
      this.showMessage(' 发布成功')
      console.log(data)
      var that = this
      var id=wx.getStorageSync('uid')
      var pics=that.data.imageList
      var location=that.data.location
      var model = JSON.stringify(pics);
      //调用应用实例的方法获取全局数据
      app.getUserInfo(function (userInfo) {
        //更新数据
        that.setData({
          userInfo: userInfo
        });
        wx.request({
          url: 'http://localhost:8090/MyWe/strategy/adds',
          data: {
            id: id,
            user_name: userInfo.nickName,
            title: data.name,
            content: data.text,
            location:location,
            pics:model,

          },
          header: {
            "Content-Type": "application/json"
          },
          method: "GET",
          success: function () { 
            
          },

          fail: function (err) { },
          complete: function () { }
        })
      })
      utils.uploadimg({
        url: 'http://localhost:8090/MyWe/upload',
        filePath: pics,
        name: 'file',
        //success: function (res) {
        //var data = res.data
        // var obj=new Object();
        // obj.ind=i+1;
        // console.info(data);
        // obj.src=data;
        // console.info("---------------");
        // console.info(obj);
        // that.data.imageList.push(obj);
        //}
      })

        
  }
 
  
},

  bindTouchStart: function (e) {
    this.startTime = e.timeStamp;
  },
bindTouchEnd: function (e) {
    this.endTime = e.timeStamp;
  },

  deleteimg:function(e){
    var id = e.currentTarget.dataset.id
    this.data.imageList.splice(id, 1)
    var that=this
    that.setData({
      imageList: that.data.imageList
    })
    
  },

 // previewimg:function(e){
   // var that = this;
    //var id = e.currentTarget.dataset.id;
    //var imageList = that.data.imageList;
    //wx.previewImage({
      //current: imageList[id],
      //urls: this.data.imageList
    //});
    //console.log("点击")
  //}


})