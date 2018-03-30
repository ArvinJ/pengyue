

# work diary



2018/3/28   星期三     晴

### 获取request

```java
		System.err.println("all--"+request.getQueryString());
		System.err.println("请求方式--"+request.getMethod());
		System.err.println("请求资源--"+request.getRequestURI());
		System.err.println("请求http协议版本--"+request.getProtocol());
		System.err.println("根据name,获取对应请求头数据--"+request.getHeader("Cookie"));
		System.err.println("获取所有的请求头名称--"+request.getHeaderNames());
		System.err.println("获取所有参数名称列表--"+request.getParameterNames());
```



### 数据转换成Json

```java
Map 转成 Json
1. json-lib
   Map map = new HashMap();  
   map.put("msg", "yes");//map里面装有yes  
   JSONObject jsonObject = JSONObject.fromObject(map);  

2. com.alibaba.fastjson.JSON
  JSONUtils.toJSONString(requestMap);

3.com.google.gson.2.2.2.jar 
  new Gson().toJson(param);

String转换成JSON
  String str = "{\"result\":\"success\",\"message\":\"成功！\"}";  
        JSONObject json = JSONObject.fromObject(str);  


```



### SocketServer 和 SocketClient

```java
Java Socket实现信息共享 - 聊天室
  客户端设计思路：客户端循环可以不停的输入消息，将消息发送给服务端，并开启一个线程监听服务端发过来的消息并进行处理，接收到的消息打印在控制台上。还可以输入特殊的命令，如果输入viewuser，则获取聊天室在线成员列表，输入quit，则申请退出聊天室。
  服务端设计思路：服务端启动时，启动一个队列监听器去监听聊天室内任何一个成员推送一条消息时，将消息发送给所有成员。每接收到一个客户端请求连接时，就新开一个线程进行处理，并将线程存放到线程集合中，将成员的端口后当做成员名称存放到公共的成员集合中。客户端所发送的所有消息都会存放到消息队列（ArrayBlockingQueue）中，队列监听器在队列中获取到消息后循环发送给聊天室内所有在线的成员，通知所有成员该消息是谁发送的，消息内容是什么。
  
```



### String 类中的字符串包含方法

```java
1. java 判断一个字符串是否包含某个字符 contains
   String str = "abc";  
   boolean status = str.contains("a"); 
2. 判断一个字符串中是否包含某个字符串。indexOf
  String str1 = "abcdefg"; 
   int result1 = str1.indexOf("abc");  
    if(result1 != -1){  
        System.out.println("字符串str中包含子串“abc”"+result1);  
    }else{  
        System.out.println("字符串str中不包含子串“abc”"+result1);  
    }  
  
```



2018/3/29    星期四  晴

### Git与Github的连接与使用

```doc
一.使用git 将项目上传到GitHub上

因为本地Git仓库和GitHub仓库之间的传输是通过SSH加密传输的，GitHub需要识别是否是你推送，GitHub只要知道了你的公钥，就可以确认只有你自己才能推送，所以需要配置ssh key。

1.创建SSH Key。

在用户主目录（C:\Users\Administrator）下，看看有没有.ssh文件，如果有，再看文件下有没有id_rsa和id_rsa.pub这两个文件，如果已经有了，可直接到下一步。如果没有，打开Git Bash，输入命令，创建SSH Key

$ ssh-keygen -t rsa -C "123@126.com" //123 是你自己注册GitHub的邮箱

创建成功啦，再去用户主目录里找到.ssh文件夹，里面有id_rsa和id_rsa.pub两个文件，这两个就是SSH Key的秘钥对，id_rsa是私钥，不能泄露，id_rsa.pub是公钥，可以公开。

2.接下来到GitHub上，打开“Account settings”--“SSH Keys”页面，然后点击“Add SSH Key”，填上Title（随意写），在Key文本框里粘贴 id_rsa.pub文件里的全部内容。

3.验证是否成功，在git bash里输入下面的命令
ssh -T git@github.com
如果初次设置的话，会出现如下界面，输入yes 同意即可

4.下面开始设置username和email，因为github每次commit都会记录他们
 git config --global user.name  "name"//你的GitHub登陆名
 git config --global user.email "123@126.com"//你的GitHub注册邮箱

5.接下来就是把本地仓库传到github上去，之前在GitHub上建好一个新的仓库是，跳转的页面，完全按照上面的只是操作就可以了。
git remote add origin git@github.com:flora0103/example.git    //关联一个远程库命令， git@github.com:flora0103/example.git   这个是自己远程库
git push -u origin master    //关联后,第一次推送master分支的所有内容命令，此后，每次本地提交后，就可以使用命令git push origin master推送最新修改




```

## Exception

```doc
1.java.io.IOException: 文件名、目录名或卷标语法不正确。
解决：文件命名有问题。

Windows 中文件夹命名规则是： 
① 文件名或文件夹名可以由1～256个西文字符或128个汉字（包括空格）组成，不能多于256个字符。 
② 文件名可以有扩展名，也可以没有。有些情况下系统会为文件自动添加扩展名。一般情况下，文件名与扩展名中间用符号“.”分隔。 
③ 文件名和文件夹名可以由字母、数字、汉字或~、!、@、#、$、%、^、&、( )、_、-、{}、’等组合而成。 
④ 可以有空格，可以有多于一个的圆点。 
⑤ 文件名或文件夹名中不能出现以下字符：\、/、:、*、?、"、<、>、| 。 
⑥ 不区分英文字母大小写。 



```



2018/3/30   星期五  阴

### java  获取tomcat下目录

```doc

String path = request.getSession().getServletContext().getRealPath("/"); 
			// path:D:\Arvin\AreaCode\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\IHAD-master\
			String headSculpturePath = request.getSession().getServletContext().getRealPath("/upload")+"/";
			// D:\Arvin\AreaCode\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\IHAD-master\upload/
			String nodepath = this.getClass().getClassLoader().getResource("/").getPath();  
			// nodepath:/D:/Arvin/AreaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/IHAD-master/WEB-INF/classes/
			//String temporaryDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/temporary_directory/" +"pengyue"+uuid+sdfn.format(new Date()));
```







### socket长连接与短连接

```java

```

### IO流

```java

```

### ActiveMQ

```doc

```



