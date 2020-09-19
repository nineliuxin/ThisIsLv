//app.js
//app.js 
function Login(code, username, img) {
  var that = this
  wx.request({
    url: HTTP_URL,
    data:
    {
      appid: 'wx00aff20b2fc1bd27',
      secret: 'e838e1a22c88c472d0507cea7cd6d57e',
      js_code: code,
      grant_type: 'authorization_code'
    },
    method: 'GET',
    header: { 'content-type': 'application/json' },
    success: function (a) {
      console.log(a)
      var openid = a.data.openid
      // 请求自己的服务器 
      wx.request({
        url: API_URL,
        data:
        {
          img: img ,
          openid : openid,
          username: username,
        },
        success: function (b) {
          // 成功返回用户的唯一ID(这是数据库ID) 
          console.log(b.data.uid)
          // 我这里是把用户返回的ID存到了缓存里因为，我在使用全局变 
          // 量时候发现有时候引入了js但是还会有丢失找不到的现象 
          wx.setStorageSync('uid', b.data.uid)
        }
      })
    },
    fail: function () {
      // 在这里你要考虑到用户登录失败的情况 
      wx.showToast({
        title: '网站正在维护中...',
        icon: 'loading',
        duration: 10000
      });
    }
  })
}
// 自己服务器的地址 
// 注意：开发时可以是http协议，但是如果上线必须申请https协议（也就是SSL协议）协议可以在阿里和腾讯的控制 
// 台都可以购买，例子：阿里-管理控制台-安全（云盾）-证书服务，一般用dv免费的就可以了协议申请完后需要补全， 
// 补全完毕后下载文件是个压缩包，里面有两个文件，把他们放到你服务器上，然后再配置文件中指明这是ssl协议并 
// 且指明路径，这样 你就算配置成功了，至于如何配置，网上开源的教程挺多的，nginx有Apache也有如果你 
var API_URL = "http://localhost:8090/MyWe/user/adduser";
// 微信提供的接口地址：这里必须要把https://api.weixin.qq.com这个网址在微信后台安全域名中添加进去否则你会 
// 感觉生活是如此的黑暗完全看不到希望 
var HTTP_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=appid&secret=app_sectet&grant_type=authorization_code&js_code=code";
App({
  onLaunch: function () {
    // 调用API从本地缓存中获取数据 
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
  },
  getUserInfo: function (cb) {
    var that = this
    if (this.globalData.userInfo) {
      typeof cb == "function" && cb(this.globalData.userInfo)
    } else {
      // 调用登录接口 
      wx.login({
        // login流程 
        success: function (res) {
          console.log(res)
          //登录成功 
          if (res.code) {
            // 这里是用户的授权信息每次都不一样 
            var code = res.code;
            wx.getUserInfo({
              // getUserInfo流程 
              success: function (res2) {
                // console.log(res2) 
                that.globalData.userInfo = res2.userInfo
                typeof cb == "function" && cb(that.globalData.userInfo)
                var username = res2.userInfo.nickName
                var img = res2.userInfo.avatarUrl
                // 请求自己的服务器 
                Login(code, username, img);
              }
            })
          } else {
            wx.showModal({
              title: '提示',
              content: '获取用户登录态失败！' + res.errMsg
            })
          }
        }
      })
    }
  },

 
  globalData:
  {
    userInfo: null
  },

  
})

