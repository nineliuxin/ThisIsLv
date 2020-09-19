function formatTime(date) {
  var year = date.getFullYear()
  var month = date.getMonth() + 1
  var day = date.getDate()

  var hour = date.getHours()
  var minute = date.getMinutes()
  var second = date.getSeconds()


  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
  n = n.toString()
  return n[1] ? n : '0' + n
}

function uploadimg(data) {
  //var id=data.currentTarget.dataset.id
  var that = this,
    i = data.i? data.i : 0,
    success = data.success ? data.success : 0,
    fail = data.fail ? data.fail : 0;
  wx.uploadFile({
    url: data.url,
    filePath: data.filePath[i],
    name: 'fileData',
    formData: null,
    success: (resp) => {
      success++;
      console.log(resp)
      console.log(i);

    },
    fail: (res) => {
      fail++;
      console.log('fail:' + i + "fail:" + fail);
    },
    complete: () => {
      console.log(i);
      i++;
      if (i == data.filePath.length) {
        console.log('执行完毕');
        console.log('成功：' + success + "失败：" + fail);

      } else {
        console.log(i);
        data.i = i;
        data.success = success;
        data.fail = fail;
        that.uploadimg(data);
      }
    }
  });
}


module.exports = {
  formatTime: formatTime,
  uploadimg:uploadimg
}
