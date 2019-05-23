## uniapp原生插件开发for Android

> 此教程需要有一定的Android开发基础、Android Studio使用基础、uniapp开发基础、Weex基础。
        

首先需要明确的是，uniapp调用插件就类似于js调用java代码【说不定内部就是这么实现的】，所以需要明确插件可以提供给uniapp哪些参数以及有哪一些回调值，即数据双向交互问题；
      

  
本教程以uniapp调用Android的Toast来显示消息为例【只是作为本教程的demo方便理解插件的开发流程，实际Toast已经被uniapp封装好了，性能更优，项目开发中直接使用即可】，uniapp需要传递消息给Android来通过Toast显示，调用成功之后Android返回调用结果给uniapp，这样就完成了一个最简单的双向数据交互场景；具体效果如下:



点击按钮：
```html
<button type="primary" plain="true" @click="showRichAlert()">通过Toast显示“hello uniapp for android plugin”</button>
```


调用插件显示消息，调用成功之后显示返回的结果：


```html
   Toast.show({
                    msg: "hello uniapp for android plugin"
                }, function(res) {                  
                    console.log(res.result);
                });
```
 
效果图：



![这里写图片描述](https://github.com/huangdali/uniapp-plugin-android/blob/master/preview.gif)



具体教程见博客：https://blog.csdn.net/qq137722697