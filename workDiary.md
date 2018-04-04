

# work diary

## Use Tool

### 1.postmain

```doc
请求url中 localhost管用，ip不能访问？
解决：ip冲突了，禁用无线网络即可。
```



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

## JSON

### 一、数据转换成Json

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
Object转换成JSON
  ResultCode rc = new ResultCode(new ResultData("4fgrrt5343dfdf",  "56576767"), 0, 0, "uploadImg", "", "");
        JSONObject json2 = JSONObject.fromObject(rc);
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
短连接

连接->传输数据->关闭连接

HTTP是无状态的，浏览器和服务器每进行一次HTTP操作，就建立一次连接，但任务结束后就中断连接。短连接是指SOCKET连接后发送后接收完数据后马上断开连接

长连接

连接->传输数据->保持连接->传输数据->....->关闭连接

长连接指建立SOCKET连接后不管是否使用都保持连接，但安全性较差。

http的长连接

HTTP也可以建立长连接的，使用Connection:keep-alive,HTTP1.1默认进行持久连接。HTTP1.1和HTTP1.0相比较而言，最大的区别就是增加了持久连接支持，但还是无状态的，或者说是不可以信任的。

那什么场景下使用长连接或者短连接？

长连接多用于操作频繁，点对点的通讯(及时通讯)，而且连接数不能太多。每个TCP连接都需要三次握手，建立连接，会比较耗时。如果每个操作都要先连接，再操作的话，处理速度会降低很多。长连接的特点是每个操作完后都不断开连接，直接发送数据包就可以了，不需要每次都建立连接。
  
一、长连接和短连接的概念

　　1、长连接与短连接的概念：前者是整个通讯过程，客户端和服务端只用一个Socket对象，长期保持Socket的连接；后者是每次请求，都新建一个Socket,处理完一个请求就直接关闭掉Socket。所以，其实区分长短连接就是：整个客户和服务端的通讯过程是利用一个Socket还是多个Socket进行的。

　　可能你会想：这还不简单，长连接不就是不关Socket嘛，短连接不就是每次都关Socket每次都new Socket嘛。然而事实其实并没有那么简单的，请继续看下面的整理
  
  
  在关闭了对应的流（无论是输出或者输入）之后，下一次调用getInputStream或者getOutputStream会抛出异常说：Socket is closed；这里讲明一个事实：Socket和流联系着，流关闭了，Socket其实也就相当于关闭状态！

　　其实这个也很好理解，Socket本来就是依靠流进行关闭的，流，就只有一个，你关闭了流，Socket赖以通讯的渠道也就关闭了，与客户的连接也断开了，所以抛出异常是很合理的。

　　所以，流关闭而要求Socket正常通讯是不可能的！
  
总结  
1、对应流关闭，Socket的对应输入（出）数据的通道也就关闭，此时无法达到长连接效果；
2、关闭Socket，记得显式关闭流与socket,顺序是线管流再关socket.

3、要实先长连接，一般需要发送结束标记符号来告诉客户端服务端的某段消息已经发送完毕，否则客户端会一直阻塞在read方法。


```

## Java 流(Stream)、文件(File)和IO 



```java
Java.io 包几乎包含了所有操作输入、输出需要的类。所有这些流类代表了输入源和输出目标。
Java.io 包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。
一个流可以理解为一个数据的序列。
输入流表示从一个源读取数据，输出流表示向一个目标写数据。
Java 为 I/O 提供了强大的而灵活的支持，使其更广泛地应用到文件传输和网络编程中。
Reader 字符流    Stream 字节流

```



#### 读取控制台输入

```doc
Java 的控制台输入由 System.in 完成。
为了获得一个绑定到控制台的字符流，
你可以把 System.in 包装在一个 BufferedReader 对象中来创建一个字符流。

创建 BufferedReader 的基本语法：
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedReader 对象创建后，我们便可以使用 read() 方法从控制台读取一个字符，或者用 readLine() 方法读取一个字符串。
从控制台读取多字符输入
从 BufferedReader 对象读取一个字符要使用 read() 方法
int read( ) throws IOException
每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。 当流结束的时候返回 -1。该方法抛出 IOException。
程序示范了用 read() 方法从控制台不断读取字符直到用户输入 "q"。

从控制台读取字符串
从标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法。

它的一般格式是：

String readLine( ) throws IOException
下面的程序读取和显示字符行直到你输入了单词"end"。

控制台输出
在此前已经介绍过，控制台的输出由 print( ) 和 println() 完成。这些方法都由类 PrintStream 定义，System.out 是该类对象的一个引用。

PrintStream 继承了 OutputStream类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。

PrintStream 定义 write() 的最简单格式如下所示：

void write(int byteval)
该方法将 byteval 的低八位字节写到流中。



```

```java
public class BufferedReaderRead {
	public static void main(String[] args) throws IOException {
		char c;
		// 使用System.in 创建 BufferReader 字符流
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.err.println("输入q退出");
		do {
			c = (char)bufferedReader.read();
			System.out.println(c);
		}while(c!='q');
		
	}
}


public class BufferedReaderReadLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test;
		System.out.println("Enter 'end' to quit.");
		do {
			test = br.readLine();
			System.err.println(test);
		} while (!test.equals("end"));

	}
}

```

#### FileInputStream 

字节流，输入流 ，读取文件

```doc

该流用于从文件读取数据，它的对象可以用关键字 new 来创建。
可以使用字符串类型的文件名来创建一个输入流对象来读取文件：
InputStream f = new FileInputStream("C:/java/hello");

也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：

File f = new File("C:/java/hello");
InputStream out = new FileInputStream(f);

创建了InputStream对象，就可以使用下面的方法来读取流或者进行其他的流操作。

public void close() throws IOException{}
关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。

protected void finalize()throws IOException {}
这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。

public int read(int r)throws IOException{}
这个方法从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。

public int read(byte[] r) throws IOException{}
这个方法从输入流读取r.length长度的字节。返回读取的字节数。如果是文件结尾则返回-1。

public int available() throws IOException{}
返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取的字节数。返回一个整数值。


```

#### FileOutputStream

字节流，输出流，向文件写数据。

```doc
该类用来创建一个文件并向文件中写数据。

如果该流在打开文件进行输出前，目标文件不存在，那么该流会创建该文件。

有两个构造方法可以用来创建 FileOutputStream 对象。

使用字符串类型的文件名来创建一个输出流对象：
OutputStream f = new FileOutputStream("C:/java/hello")

也可以使用一个文件对象来创建一个输出流来写文件。我们首先得使用File()方法来创建一个文件对象：

File f = new File("C:/java/hello");
OutputStream f = new FileOutputStream(f);

创建OutputStream 对象完成后，就可以使用下面的方法来写入流或者进行其他的流操作。

public void close() throws IOException{}
关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。

protected void finalize()throws IOException {}
这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。

public void write(int w)throws IOException{}
这个方法把指定的字节写到输出流中。

public void write(byte[] w)
把指定数组中w.length长度的字节写到OutputStream中。


```

```java
public class FileStream666 {
	public static void main(String[] args) throws IOException {

		File f = new File("D:\\output.txt");
		FileOutputStream fop = new FileOutputStream(f);
		// 构建FileOutputStream对象,文件不存在会自动新建

		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

		writer.append("中文输入");
		// 写入到缓冲区

		writer.append("\r\n");
		// 换行

		writer.append("English");
		// 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

		writer.close();
		// 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

		fop.close();
		// 关闭输出流,释放系统资源

		FileInputStream fip = new FileInputStream(f);
		// 构建FileInputStream对象

		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		// 构建InputStreamReader对象,编码与写入相同

		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append((char) reader.read());
			// 转成char加到StringBuffer对象中
		}
		System.out.println(sb.toString());
		reader.close();
		// 关闭读取流

		fip.close();
		// 关闭输入流,释放系统资源

	}
}
```



#### Java中的目录

```doc
File类中有两个方法可以用来创建文件夹：

mkdir( )方法创建一个文件夹，成功则返回true，失败则返回false。
失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
mkdirs()方法创建一个文件夹和它的所有父文件夹。

import java.io.File;
 
public class CreateDir {
  public static void main(String args[]) {
    String dirname = "/tmp/user/java/bin";
    File d = new File(dirname);
    // 现在创建目录
    d.mkdirs();
  }
}

读取目录
一个目录其实就是一个 File 对象，它包含其他文件和文件夹。
如果创建一个 File 对象并且它是一个目录，那么调用 isDirectory() 方法会返回 true。
可以通过调用该对象上的 list() 方法，来提取它包含的文件和文件夹的列表。

下面展示的例子说明如何使用 list() 方法来检查一个文件夹中包含的内容：
import java.io.File;
 
public class DirList {
  public static void main(String args[]) {
    String dirname = "/tmp";
    File f1 = new File(dirname);
    if (f1.isDirectory()) {
      System.out.println( "目录 " + dirname);
      String s[] = f1.list();
      for (int i=0; i < s.length; i++) {
        File f = new File(dirname + "/" + s[i]);
        if (f.isDirectory()) {
          System.out.println(s[i] + " 是一个目录");
        } else {
          System.out.println(s[i] + " 是一个文件");
        }
      }
    } else {
      System.out.println(dirname + " 不是一个目录");
    }
  }
}


删除目录或文件

删除文件可以使用 java.io.File.delete() 方法。
以下代码会删除目录/tmp/java/，即便目录不为空。

import java.io.File;
 
public class DeleteFileDemo {
  public static void main(String args[]) {
      // 这里修改为自己的测试目录
    File folder = new File("/tmp/java/");
    deleteFolder(folder);
  }
 
  //删除文件及目录
  public static void deleteFolder(File folder) {
    File[] files = folder.listFiles();
        if(files!=null) { 
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
```



## Java IO

http://www.cnblogs.com/skywang12345/p/io_01.html

### Java IO简介

```doc
java io系统的设计初衷，就是为了实现“文件、控制台、网络设备”这些io设置的通信。例如，对于一个文件，我们可以打开文件，然后进行读取和写入。
在java 1.0中，java提供的类都是以字节(byte)为单位，例如，FileInputStream和FileOutputStream。而到了java 1.1，为了与国际化进行接轨，在java io中添加了许多以字符(Unicode)为单位进行操作的类。

在java io的称呼中，我们经常会提到“输入流”、“输出流”等等概念。首先，什么是流呢？
所谓“流”，就是一种抽象的数据的总称，它的本质是能够进行传输。
      a) 按照“流”的数据流向，可以将其化分为：输入流和输出流。
      b) 按照“流”中处理数据的单位，可以将其区分为：字节流和字符流。在java中，字节是占1个Byte，即8位；而字符是占2个Byte，即16位。而且，需要注意的是，java的字节是有符号类型，而字符是无符号类型！
```



### Java IO框架

```doc
1. 以字节为单位的输入流的框架


                  |--ByteArrayInputStream				
                  |--PipedInputStream
                  |							|DataInputStream 
inputStream-------|--FilterInputStream  ---
                  |							|BufferedInputStream 
                  |						|File
                  |--FileInputStream ---
                  |						|FileDescriptor 
                  |--ObjectInputStream


从中，我们可以看出。
(01) InputStream 是以字节为单位的输入流的超类。InputStream提供了read()接口从输入流中读取字节数据。
(02) ByteArrayInputStream 是字节数组输入流。它包含一个内部缓冲区，该缓冲区包含从流中读取的字节；通俗点说，它的内部缓冲区就是一个字节数组，而ByteArrayInputStream本质就是通过字节数组来实现的。
(03) PipedInputStream 是管道输入流，它和PipedOutputStream一起使用，能实现多线程间的管道通信。
(04) FilterInputStream 是过滤输入流。它是DataInputStream和BufferedInputStream的超类。
(05) DataInputStream 是数据输入流。它是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”。
(06) BufferedInputStream 是缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
(07) File 是“文件”和“目录路径名”的抽象表示形式。关于File，注意两点：
a), File不仅仅只是表示文件，它也可以表示目录！
b), File虽然在io保重定义，但是它的超类是Object，而不是InputStream。
(08) FileDescriptor 是“文件描述符”。它可以被用来表示开放文件、开放套接字等。
(09) FileInputStream 是文件输入流。它通常用于对文件进行读取操作。
(10) ObjectInputStream 是对象输入流。它和ObjectOutputStream一起，用来提供对“基本数据或对象”的持久存储。



2.以字节为单位的输出流的框架图



                  |--ByteArrayOutputStream				
                  |--PipedOutputStream
                  |							|DataOutputStream 
OutputStream-------|--FilterOutputStream  ---
                  |							|BufferedOutputStream 
                  |						|File
                  |--FileOutputStream ---
                  |						|FileDescriptor 
                  |--ObjectOutputStream


从中，我们可以看出。以字节为单位的输出流的公共父类是OutputStream。
(01) OutputStream 是以字节为单位的输出流的超类。OutputStream提供了write()接口从输出流中读取字节数据。
(02) ByteArrayOutputStream 是字节数组输出流。写入ByteArrayOutputStream的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。
(03) PipedOutputStream 是管道输出流，它和PipedInputStream一起使用，能实现多线程间的管道通信。
(04) FilterOutputStream 是过滤输出流。它是DataOutputStream，BufferedOutputStream和PrintStream的超类。
(05) DataOutputStream 是数据输出流。它是用来装饰其它输出流，它“允许应用程序以与机器无关方式向底层写入基本 Java 数据类型”。
(06) BufferedOutputStream 是缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
(07) PrintStream 是打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
(08) FileOutputStream 是文件输出流。它通常用于向文件进行写入操作。
(09) ObjectOutputStream 是对象输出流。它和ObjectInputStream一起，用来提供对“基本数据或对象”的持久存储。




3.以字符为单位的输入流的框架图
下面，是以字符为单位的输入流的框架图。

          |CharArrayReader 
          |PipedReader 
          |FilterReader 
Reader----
          |BufferedReader 
          |InputStreamReader <--FileReader-->File
          
从中，我们可以看出。以字符为单位的输入流的公共父类是Reader。
(01) Reader 是以字符为单位的输入流的超类。它提供了read()接口来取字符数据。
(02) CharArrayReader 是字符数组输入流。它用于读取字符数组，它继承于Reader。操作的数据是以字符为单位！
(03) PipedReader 是字符类型的管道输入流。它和PipedWriter一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedReader配套使用。
(04) FilterReader 是字符类型的过滤输入流。
(05) BufferedReader 是字符缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
(06) InputStreamReader 是字节转字符的输入流。它是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
(07) FileReader 是字符类型的文件输入流。它通常用于对文件进行读取操作。


4.以字符为单位的输出流的框架图

下面，是以字符为单位的输出流的框架图。





          |CharArrayWriter 
          |PipedWriter 
          |FilterWriter 
Writer----
          |BufferedWriter
          |InputStreamWriter <--FileWriter-->File
          |PrintWriter

(01) Writer 是以字符为单位的输出流的超类。它提供了write()接口往其中写入数据。
(02) CharArrayWriter 是字符数组输出流。它用于读取字符数组，它继承于Writer。操作的数据是以字符为单位！
(03) PipedWriter 是字符类型的管道输出流。它和PipedReader一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedWriter配套使用。
(04) FilterWriter 是字符类型的过滤输出流。
(05) BufferedWriter 是字符缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
(06) OutputStreamWriter 是字节转字符的输出流。它是字节流通向字符流的桥梁：它使用指定的 charset 将字节转换为字符并写入。
(07) FileWriter 是字符类型的文件输出流。它通常用于对文件进行读取操作。
(08) PrintWriter 是字符类型的打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。



5.字节转换为字符流的框架图

在java中，字节流能转换为字符流，下面是它们的转换关系图。
File<-----依赖----FileInputStream<---依赖---InputStreamReader<----继承---FileReader

从中，我们可以看出。
(01) FileReader继承于InputStreamReader，而InputStreamReader依赖于InputStream。具体表现在InputStreamReader的构造函数是以InputStream为参数。我们传入InputStream，在InputStreamReader内部通过转码，将字节转换成字符。
(02) FileWriter继承于OutputStreamWriter，而OutputStreamWriter依赖于OutputStream。具体表现在OutputStreamWriter的构造函数是以OutputStream为参数。我们传入OutputStream，在OutputStreamWriter内部通过转码，将字节转换成字符。



```



## 事务

```doc
事务是为了保证对同一数据表操作的一致性。
即多条语句放在事务中执行的时候，要么一起成功，要么全不成功。如果想看严格定义，就去随便找一本数据库教材看看吧。
我只说我的理解：数据库中的事务就是需要捆绑在一起执行的操作集合，他们应不能被部分的完成。
虽然事务并不都是用在数据库中的，但他们都有以下共同性质
事务应当具有ACID性质，
A是原子性(atomic)：事务中包含的各项操作必须全部成功执行或者全部不执行。任何一项操作失败，将导致整个事务失败，其他已经执行的任务所作的数据操作都将被撤销，只有所有的操作全部成功，整个事务才算是成功完成。
C是一致性(consistent)：保证了当事务结束后，系统状态是一致的。那么什么是一致的系统状态？例如，如果银行始终遵循着"银行账号必须保持正态平衡"的原则，那么银行系统的状态就是一致的。上面的转账例子中，在取钱的过程中，账户会出现负态平衡，在事务结束之后，系统又回到一致的状态。这样，系统的状态对于客户来说，始终是一致的。
I是隔离性(isolated)：使得并发执行的事务，彼此无法看到对方的中间状态。保证了并发执行的事务顺序执行，而不会导致系统状态不一致。
D是持久性(durable)：保证了事务完成后所作的改动都会被持久化，即使是发生灾难性的失败。可恢复性资源保存了一份事务日志，如果资源发生故障，可以通过日志来将数据重建起来。
```





### JAVA 消息队列

消息队列解决的是将突发大量请求转换为后端能承受的队列请求

```doc
消息队列的使用场景是怎样的？
经常听到诸如rebbitmq,activemq，请教一下各位前辈消息队列的使用场景是怎样的，什么时候会用到它
 
校验用户名等信息，如果没问题会在数据库中添加一个用户记录
如果是用邮箱注册会给你发送一封注册成功的邮件，手机注册则会发送一条短信
分析用户的个人信息，以便将来向他推荐一些志同道合的人，或向那些人推荐他
发送给用户一个包含操作指南的系统通知
等等……

除了这些之外，比较常用的就是起到消峰时需要用到：
比如你的服务器一秒能处理100个订单，但秒杀活动1秒进来1000个订单，持续10秒，在后端能力无法增加的情况下，你可以用消息队列将总共10000个请求压在队列里，后台consumer按原有能力处理，100秒后处理完所有请求（而不是直接宕机丢失订单数据）。

消息队列的主要特点是异步处理，主要目的是减少请求响应时间和解耦。所以主要的使用场景就是将比较耗时而且不需要即时（同步）返回结果的操作作为消息放入消息队列。同时由于使用了消息队列，只要保证消息格式不变，消息的发送方和接收方并不需要彼此联系，也不需要受对方的影响，即解耦和。

使用场景的话，举个例子：
假设用户在你的软件中注册，服务端收到用户的注册请求后，它会做这些操作：
校验用户名等信息，如果没问题会在数据库中添加一个用户记录
如果是用邮箱注册会给你发送一封注册成功的邮件，手机注册则会发送一条短信
分析用户的个人信息，以便将来向他推荐一些志同道合的人，或向那些人推荐他
发送给用户一个包含操作指南的系统通知
等等……
但是对于用户来说，注册功能实际只需要第一步，只要服务端将他的账户信息存到数据库中他便可以登录上去做他想做的事情了。至于其他的事情，非要在这一次请求中全部完成么？值得用户浪费时间等你处理这些对他来说无关紧要的事情么？所以实际当第一步做完后，服务端就可以把其他的操作放入对应的消息队列中然后马上返回用户结果，由消息队列异步的进行这些操作。

或者还有一种情况，同时有大量用户注册你的软件，再高并发情况下注册请求开始出现一些问题，例如邮件接口承受不住，或是分析信息时的大量计算使cpu满载，这将会出现虽然用户数据记录很快的添加到数据库中了，但是却卡在发邮件或分析信息时的情况，导致请求的响应时间大幅增长，甚至出现超时，这就有点不划算了。面对这种情况一般也是将这些操作放入消息队列（生产者消费者模型），消息队列慢慢的进行处理，同时可以很快的完成注册请求，不会影响用户使用其他功能。

所以在软件的正常功能开发中，并不需要去刻意的寻找消息队列的使用场景，而是当出现性能瓶颈时，去查看业务逻辑是否存在可以异步处理的耗时操作，如果存在的话便可以引入消息队列来解决。否则盲目的使用消息队列可能会增加维护和开发的成本却无法得到可观的性能提升，那就得不偿失了。
 
 
 
我可以举个小例子先说明应用场景

假设你的服务器每分钟的处理量为200个，但客户端再峰值的时候可能一分钟会发1000个消息给你，这时候你就可以把他做成队列，然后按正常有序的处理，先进后出(LIFO)，先进先出(FIFO）可根据自己的情况进行定夺

stack  先进后出(LIFO)--------java 对应的类 Stack

队列 先进先出(FIFO）--------java对应的类Queue



/** 
 * 
 * --------->>>>>>队列的实现-------------- 
 */  
public class MyStack<T> {  
    private LinkedList<T> storage = new LinkedList<T>();  
  
    public synchronized void push(T e) {//需要加上同步  
        storage.addFirst(e);  
    }  
  
    public T peek() {  
        return storage.getFirst();  
    }  
  
    public void pop() {  
        storage.removeFirst();  
    }  
  
    public boolean empty() {  
        return storage.isEmpty();  
    }  
  
    @Override  
    public String toString() {  
        return storage.toString();  
    }  
  
}  


```





## Java消息队列

https://www.cnblogs.com/doit8791/p/7759806.html

### 一、消息队列概述

```doc
消息队列中间件是分布式系统中重要的组件，主要解决应用解耦，异步消息，流量削锋等问题，实现高性能，高可用，可伸缩和最终一致性架构。目前使用较多的消息队列有ActiveMQ，RabbitMQ，ZeroMQ，Kafka，MetaMQ，RocketMQ
```



### 二、消息队列应用场景

以下介绍消息队列在实际应用中常用的使用场景。异步处理，应用解耦，流量削锋和消息通讯四个场景。



#### 2.1异步处理

场景说明：用户注册后，需要发注册邮件和注册短信。传统的做法有两种 1.串行的方式；2.并行方式
a、串行方式：将注册信息写入数据库成功后，发送注册邮件，再发送注册短信。以上三个任务全部完成后，返回给客户端。

b、并行方式：将注册信息写入数据库成功后，发送注册邮件的同时，发送注册短信。以上三个任务完成后，返回给客户端。与串行的差别是，并行的方式可以提高处理的时间。



假设三个业务节点每个使用50毫秒钟，不考虑网络等其他开销，则串行方式的时间是150毫秒，并行的时间可能是100毫秒。
因为CPU在单位时间内处理的请求数是一定的，假设CPU1秒内吞吐量是100次。则串行方式1秒内CPU可处理的请求量是7次（1000/150）。并行方式处理的请求量是10次（1000/100）
小结：如以上案例描述，传统的方式系统的性能（并发量，吞吐量，响应时间）会有瓶颈。如何解决这个问题呢？



引入消息队列，将不是必须的业务逻辑，异步处理。改造后的架构如下

按照以上约定，用户的响应时间相当于是注册信息写入数据库的时间，也就是50毫秒。注册邮件，发送短信写入消息队列后，直接返回，因此写入消息队列的速度很快，基本可以忽略，因此用户的响应时间可能是50毫秒。因此架构改变后，系统的吞吐量提高到每秒20 QPS。比串行提高了3倍，比并行提高了两倍。





#### 2.2应用解耦

场景说明：用户下单后，订单系统需要通知库存系统。传统的做法是，订单系统调用库存系统的接口。

传统模式的缺点：假如库存系统无法访问，则订单减库存将失败，从而导致订单失败，订单系统与库存系统耦合。

如何解决以上问题呢？引入应用消息队列后的方案，

订单系统：用户下单后，订单系统完成持久化处理，将消息写入消息队列，返回用户订单下单成功
库存系统：订阅下单的消息，采用拉/推的方式，获取下单信息，库存系统根据下单信息，进行库存操作
假如：在下单时库存系统不能正常使用。也不影响正常下单，因为下单后，订单系统写入消息队列就不再关心其他的后续操作了。实现订单系统与库存系统的应用解耦。

#### 2.3流量削锋

流量削锋也是消息队列中的常用场景，一般在秒杀或团抢活动中使用广泛。
应用场景：秒杀活动，一般会因为流量过大，导致流量暴增，应用挂掉。为解决这个问题，一般需要在应用前端加入消息队列。
a、可以控制活动的人数
b、可以缓解短时间内高流量压垮应用

用户的请求，服务器接收后，首先写入消息队列。假如消息队列长度超过最大数量，则直接抛弃用户请求或跳转到错误页面。
秒杀业务根据消息队列中的请求信息，再做后续处理

#### 2.4日志处理

日志处理是指将消息队列用在日志处理中，比如Kafka的应用，解决大量日志传输的问题。

日志采集客户端，负责日志数据采集，定时写受写入Kafka队列
Kafka消息队列，负责日志数据的接收，存储和转发
日志处理应用：订阅并消费kafka队列中的日志数据 

#### 2.5消息通讯

消息通讯是指，消息队列一般都内置了高效的通信机制，因此也可以用在纯的消息通讯。比如实现点对点消息队列，或者聊天室等
点对点通讯：

客户端A（发消息）和客户端B（收消息）使用同一消息队列，进行消息通讯。



聊天室通讯：

客户端A，客户端B，客户端N订阅同一主题，进行消息发布和接收。实现类似聊天室效果。



以上实际是消息队列的两种消息模式，点对点或发布订阅模式。

### 三、消息中间件示例

3.1电商系统



消息队列采用高可用，可持久化的消息中间件。比如Active MQ，Rabbit MQ，Rocket Mq。

消息队列采用高可用，可持久化的消息中间件。比如Active MQ，Rabbit MQ，Rocket Mq。
（1）应用将主干逻辑处理完成后，写入消息队列。消息发送是否成功可以开启消息的确认模式。（消息队列返回消息接收成功状态后，应用再返回，这样保障消息的完整性）
（2）扩展流程（发短信，配送处理）订阅队列消息。采用推或拉的方式获取消息并处理。
（3）消息将应用解耦的同时，带来了数据一致性问题，可以采用最终一致性方式解决。比如主数据写入数据库，扩展应用根据消息队列，并结合数据库方式实现基于消息队列的后续处理。



分为Zookeeper注册中心，日志收集客户端，Kafka集群和Storm集群（OtherApp）四部分组成。
Zookeeper注册中心，提出负载均衡和地址查找服务
日志收集客户端，用于采集应用系统的日志，并将数据推送到kafka队列
Kafka集群：接收，路由，存储，转发等消息处理
Storm集群：与OtherApp处于同一级别，采用拉的方式消费队列中的数据

### 四、JMS消息服务



讲消息队列就不得不提JMS 。JMS（JAVA Message Service，java消息服务）API是一个消息服务的标准/规范，允许应用程序组件基于JavaEE平台创建、发送、接收和读取消息。它使分布式通信耦合度更低，消息服务更加可靠以及异步性。
在EJB架构中，有消息bean可以无缝的与JM消息服务集成。在J2EE架构模式中，有消息服务者模式，用于实现消息与应用直接的解耦。

#### 4.1消息模型

在JMS标准中，有两种消息模型P2P（Point to Point）,Publish/Subscribe(Pub/Sub)。P2P模式包含三个角色：消息队列（Queue），发送者(Sender)，接收者(Receiver)。每个消息都被发送到一个特定的队列，接收者从队列中获取消息。队列保留着消息，直到他们被消费或超时。

P2P的特点
每个消息只有一个消费者（Consumer）(即一旦被消费，消息就不再在消息队列中)
发送者和接收者之间在时间上没有依赖性，也就是说当发送者发送了消息之后，不管接收者有没有正在运行，它不会影响到消息被发送到队列
接收者在成功接收消息之后需向队列应答成功 
如果希望发送的每个消息都会被成功处理的话，那么需要P2P模式。

##### 4.1.2 Pub/Sub模式

包含三个角色主题（Topic），发布者（Publisher），订阅者（Subscriber） 多个发布者将消息发送到Topic，系统将这些消息传递给多个订阅者。

Pub/Sub的特点
每个消息可以有多个消费者
发布者和订阅者之间有时间上的依赖性。针对某个主题（Topic）的订阅者，它必须创建一个订阅者之后，才能消费发布者的消息
为了消费消息，订阅者必须保持运行的状态
为了缓和这样严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样，即使订阅者没有被激活（运行），它也能接收到发布者的消息。
如果希望发送的消息可以不被做任何处理、或者只被一个消息者处理、或者可以被多个消费者处理的话，那么可以采用Pub/Sub模型。

#### 4.2消息消费

在JMS中，消息的产生和消费都是异步的。对于消费来说，JMS的消息者可以通过两种方式来消费消息。
（1）同步
订阅者或接收者通过receive方法来接收消息，receive方法在接收到消息之前（或超时之前）将一直阻塞；

（2）异步
订阅者或接收者可以注册为一个消息监听器。当消息到达之后，系统自动调用监听器的onMessage方法。

JNDI：Java命名和目录接口,是一种标准的Java命名系统接口。可以在网络上查找和访问服务。通过指定一个资源名称，该名称对应于数据库或命名服务中的一个记录，同时返回资源连接建立所必须的信息。
JNDI在JMS中起到查找和访问发送目标或消息来源的作用。

### 五、常用消息队列

一般商用的容器，比如WebLogic，JBoss，都支持JMS标准，开发上很方便。但免费的比如Tomcat，Jetty等则需要使用第三方的消息中间件。本部分内容介绍常用的消息中间件（Active MQ,Rabbit MQ，Zero MQ,Kafka）以及他们的特点。

#### 5.1 ActiveMQ



ActiveMQ默认启动时，启动了内置的jetty服务器，提供一个用于监控ActiveMQ的admin应用。 
http://127.0.0.1:8161/admin/

默认账号：admin

　　密码：admin

ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。ActiveMQ 是一个完全支持JMS1.1和J2EE 1.4规范的 JMS Provider实现，尽管JMS规范出台已经是很久的事情了，但是JMS在当今的J2EE应用中间仍然扮演着特殊的地位。

ActiveMQ特性如下：
⒈ 多种语言和协议编写客户端。语言: Java,C,C++,C#,Ruby,Perl,Python,PHP。应用协议： OpenWire,Stomp REST,WS Notification,XMPP,AMQP
⒉ 完全支持JMS1.1和J2EE 1.4规范 （持久化，XA消息，事务)
⒊ 对Spring的支持，ActiveMQ可以很容易内嵌到使用Spring的系统里面去，而且也支持Spring2.0的特性
⒋ 通过了常见J2EE服务器（如 Geronimo,JBoss 4,GlassFish,WebLogic)的测试，其中通过JCA 1.5 resource adaptors的配置，可以让ActiveMQ可以自动的部署到任何兼容J2EE 1.4 商业服务器上
⒌ 支持多种传送协议：in-VM,TCP,SSL,NIO,UDP,JGroups,JXTA
⒍ 支持通过JDBC和journal提供高速的消息持久化
⒎ 从设计上保证了高性能的集群，客户端-服务器，点对点
⒏ 支持Ajax
⒐ 支持与Axis的整合
⒑ 可以很容易得调用内嵌JMS provider，进行测试。





#### 5.2 Kafka

Kafka是一种高吞吐量的分布式发布订阅消息系统，它可以处理消费者规模的网站中的所有动作流数据。 这种动作（网页浏览，搜索和其他用户的行动）是在现代网络上的许多社会功能的一个关键因素。 这些数据通常是由于吞吐量的要求而通过处理日志和日志聚合来解决。 对于像Hadoop的一样的日志数据和离线分析系统，但又要求实时处理的限制，这是一个可行的解决方案。Kafka的目的是通过Hadoop的并行加载机制来统一线上和离线的消息处理，也是为了通过集群机来提供实时的消费。

Kafka是一种高吞吐量的分布式发布订阅消息系统，有如下特性：
通过O(1)的磁盘数据结构提供消息的持久化，这种结构对于即使数以TB的消息存储也能够保持长时间的稳定性能。（文件追加的方式写入数据，过期的数据定期删除）
高吞吐量：即使是非常普通的硬件Kafka也可以支持每秒数百万的消息
支持通过Kafka服务器和消费机集群来分区消息
支持Hadoop并行数据加载
Kafka相关概念
Broker
Kafka集群包含一个或多个服务器，这种服务器被称为broker[5]
Topic
每条发布到Kafka集群的消息都有一个类别，这个类别被称为Topic。（物理上不同Topic的消息分开存储，逻辑上一个Topic的消息虽然保存于一个或多个broker上但用户只需指定消息的Topic即可生产或消费数据而不必关心数据存于何处）
Partition
Parition是物理上的概念，每个Topic包含一个或多个Partition.
Producer
负责发布消息到Kafka broker
Consumer
消息消费者，向Kafka broker读取消息的客户端。
Consumer Group
每个Consumer属于一个特定的Consumer Group（可为每个Consumer指定group name，若不指定group name则属于默认的group）。
一般应用在大数据日志处理或对实时性（少量延迟），可靠性（少量丢数据）要求稍低的场景使用。





2018/4/2   星期一  多云

# 详解Java消息队列-Spring整合ActiveMq

### 一、Java消息队列----JMS概述

#### 1.什么是JMS?

JMS即Java消息服务（Java Message Service）应用程序接口。

```doc
是一个Java平台中关于面向消息中间件（MOM）的API，用于在两个应用程序之间，或分布式系统中发送消息，进行异步通信。Java消息服务是一个与具体平台无关的API，绝大多数MOM提供商都对JMS提供支持。

我们可以简单的理解：两个应用程序之间需要进行通信，我们使用一个JMS服务，进行中间的转发，通过JMS 的使用，我们可以解除两个程序之间的耦合。

```

#### 2、JMS的优势

Asynchronous（异步）

JMS 原本就是一个异步的消息服务，客户端获取消息的时候，不需要主动发送请求，消息会自动发送给可用的客户端



Reliable（可靠）

JMS保证消息只会递送一次。大家都遇到过重复创建消息问题，而JMS能帮你避免该问题。



#### 3、JMS的消息模型

　　　JMS具有两种通信模式：

　　　　　　1、Point-to-Point Messaging Domain （点对点）

　　　　　　2、Publish/Subscribe Messaging Domain （发布/订阅模式）



##### (1)、Point-to-Point Messaging Domain（点对点通信模型）

在点对点通信模式中，应用程序由消息队列，发送方，接收方组成。

每个消息都被发送到一个特定的队列，接收者从队列中获取消息。队列保留着消息，直到他们被消费或超时。

每个消息只要一个消费者
发送者和接收者在时间上是没有时间的约束，也就是说发送者在发送完消息之后，不管接收者有没有接受消息，都不会影响发送方发送消息到消息队列中。

发送方不管是否在发送消息，接收方都可以从消息队列中去到消息。

接收方在接收完消息之后，需要向消息队列应答成功。

##### (2)、Publish/Subscribe Messaging Domain（发布/订阅通信模型）

在发布/订阅消息模型中，发布者发布一个消息，该消息通过topic传递给所有的客户端。该模式下，发布者与订阅者都是匿名的，即发布者与订阅者都不知道对方是谁。并且可以动态的发布与订阅Topic。Topic主要用于保存和传递消息，且会一直保存消息直到消息被传递给客户端。

一个消息可以传递个多个订阅者（即：一个消息可以有多个接受方）
发布者与订阅者具有时间约束，针对某个主题（Topic）的订阅者，它必须创建一个订阅者之后，才能消费发布者的消息，而且为了消费消息，订阅者必须保持运行的状态。
为了缓和这样严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样，即使订阅者没有被激活（运行），它也能接收到发布者的消息。

#### 4、JMS接收消息

JMS中，消息的产生和消息是异步的。对于消费来说，JMS的消息者可以通过两种方式来消费消息。

##### （1）、同步（Synchronous）

　　　　　　　　在同步消费信息模式模式中，订阅者/接收方通过调用 receive（）方法来接收消息。在receive（）方法中，线程会阻塞直到消息到达或者到指定时间后消息仍未到达。

##### （2）、异步（Asynchronous）

　　　　　　　　使用异步方式接收消息的话，消息订阅者需注册一个消息监听者，类似于事件监听器，只要消息到达，JMS服务提供者会通过调用监听器的onMessage()递送消息。



#### 5、JMS编程模型　

1管理对象（Administered objects）-连接工厂（Connection Factories）和目的地（Destination）
2连接对象（Connections）
3会话（Sessions）
4消息生产者（Message Producers）
5消息消费者（Message Consumers）
6消息监听者（Message Listeners）



```doc
（1）、Connection Factories

　　　　　　　　创建Connection对象的工厂，针对两种不同的jms消息模型，分别有QueueConnectionFactory和TopicConnectionFactory两种。可以通过JNDI来查找ConnectionFactory对象。客户端使用一个连接工厂对象连接到JMS服务提供者，它创建了JMS服务提供者和客户端之间的连接。JMS客户端（如发送者或接受者）会在JNDI名字空间中搜索并获取该连接。使用该连接，客户端能够与目的地通讯，往队列或话题发送/接收消息。
QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initialCtx.lookup ("primaryQCF");
Queue purchaseQueue = (Queue) initialCtx.lookup ("Purchase_Queue");
Queue returnQueue = (Queue) initialCtx.lookup ("Return_Queue");

（2）、Destination

 　　　　　　　　目的地指明消息被发送的目的地以及客户端接收消息的来源。JMS使用两种目的地，队列和话题。如下代码指定了一个队列和话题：
 　　　　　　　　创建一个队列Session：
 　　　QueueSession ses = con.createQueueSession (false, Session.AUTO_ACKNOWLEDGE);  //get the Queue object  
Queue t = (Queue) ctx.lookup ("myQueue");  //create QueueReceiver  
QueueReceiver receiver = ses.createReceiver(t); 
　创建一个Topic Session：

QueueSession ses = con.createQueueSession (false, Session.AUTO_ACKNOWLEDGE);  //get the Queue object  
Queue t = (Queue) ctx.lookup ("myQueue");  //create QueueReceiver  
QueueReceiver receiver = ses.createReceiver(t); 

（3）、Connection

　　　　　　Connection表示在客户端和JMS系统之间建立的链接（对TCP/IP socket的包装）。Connection可以产生一个或多个Session。跟ConnectionFactory一样，Connection也有两种类型：QueueConnection和TopicConnection。

　　　　　　连接对象封装了与JMS提供者之间的虚拟连接，如果我们有一个ConnectionFactory对象，可以使用它来创建一个连接。
Connection connection = connectionFactory.createConnection();


Session 是我们对消息进行操作的接口，可以通过session创建生产者、消费者、消息等。Session 提供了事务的功能，如果需要使用session发送/接收多个消息时，可以将这些发送/接收动作放到一个事务中。

　　　　　　我们可以在连接创建完成之后创建session：

Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
　　　　　　这里面提供了参数两个参数，第一个参数是是否支持事务，第二个是事务的类型

（5）、Producter

　　　　　　消息生产者由Session创建，用于往目的地发送消息。生产者实现MessageProducer接口，我们可以为目的地、队列或话题创建生产者；

　　　　　　

MessageProducer producer = session.createProducer(dest);
MessageProducer producer = session.createProducer(queue);
MessageProducer producer = session.createProducer(topic);


　（6）、Consumer

　　　　　　消息消费者由Session创建，用于接收被发送到Destination的消息。

　

MessageConsumer consumer = session.createConsumer(dest);
MessageConsumer consumer = session.createConsumer(queue);
MessageConsumer consumer = session.createConsumer(topic);



（7）、MessageListener

　　　　　　消息监听器。如果注册了消息监听器，一旦消息到达，将自动调用监听器的onMessage方法。EJB中的MDB（Message-Driven Bean）就是一种MessageListener。

 
```



2018/04/03   星期二     晴

## Java 多线程

### 一、概述

一个线程不能独立的存在，它必须是进程的一部分。一个进程一直运行，直到所有的非守护线程都结束运行后才能结束。

多线程能满足程序员编写高效率的程序来达到充分利用 CPU 的目的。

```doc
新建状态:
使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 start() 这个线程。

就绪状态:
当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。

运行状态:
如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。

阻塞状态:
如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：

等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。

同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。

其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

死亡状态:
一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

线程的优先级
每一个 Java 线程都有一个优先级，这样有助于操作系统确定线程的调度顺序。

Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。

默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。

具有较高优先级的线程对程序更重要，并且应该在低优先级的线程之前分配处理器资源。但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。







```

### 二、创建一个线程

Java 提供了三种创建线程的方法：

通过实现 Runnable 接口；
通过继承 Thread 类本身；
通过 Callable 和 Future 创建线程。

通过Thread类

```java
package com.ahhf.ljxbw.arvinmq.test;

public class ArvinThread extends Thread {

	private String message;

	public ArvinThread(String message) {
		this.message = message;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(message + "运行  :  " + i);
			try {
				
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public static void main(String[] args) {
		ArvinThread mTh1 = new ArvinThread("A");
		ArvinThread mTh2 = new ArvinThread("B");
		mTh1.start();
		mTh2.start();

	}

/**
 * 程序启动运行main时候，java虚拟机启动一个进程，主线程main在main()调用时候被创建。随着调用MitiSay的两个对象的start方法，另外两个线程也启动了，这样，整个应用就在多线程下运行。
 
注意：start()方法的调用后并不是立即执行多线程代码，而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的。
从程序运行的结果可以发现，多线程程序是乱序执行。因此，只有乱序执行的代码才有必要设计为多线程。
Thread.sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。
实际上所有的多线程代码执行顺序都是不确定的，每次执行的结果都是随机的。



但是start方法重复调用的话，会出现java.lang.IllegalThreadStateException异常。
Thread1 mTh1=new Thread1("A");  
Thread1 mTh2=mTh1;  
mTh1.start();  
mTh2.start();  
输出：

Exception in thread "main" java.lang.IllegalThreadStateException
    at java.lang.Thread.start(Unknown Source)
    at com.multithread.learning.Main.main(Main.java:31)
A运行  :  0
A运行  :  1
A运行  :  2
A运行  :  3
A运行  :  4








 *
 */
```



通过实现 Runnable 接口来创建线程
创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。

为了实现 Runnable，一个类只需要执行一个方法调用 run()

```java
package com.ahhf.ljxbw.arvinmq.test;

public class ArvinThread2 implements Runnable {
	private String threadName;

	public ArvinThread2(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			System.out.println(threadName + (i + 1) + "跑起来了————————");
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}

}
public static void main(String[] args) {
 		new Thread(new ArvinThread2("张三")).start();
		new Thread(new ArvinThread2("李四")).start();

}


/**
Thread2类通过实现Runnable接口，使得该类有了多线程类的特征。run（）方法是多线程程序的一个约定。所有的多线程代码都在run方法里面。Thread类实际上也是实现了Runnable接口的类。
在启动的多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target) 构造出对象，然后调用Thread对象的start()方法来运行多线程代码。
实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。因此，不管是扩展Thread类还是实现Runnable接口来实现多线程，最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程编程的基础。

*/
```



### 三、Thread和Runnable的区别

如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。

总结：

实现Runnable接口比继承Thread类所具有的优势：

1）：适合多个相同的程序代码的线程去处理同一个资源

2）：可以避免java中的单继承的限制

3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类

 

提醒一下大家：main方法其实也是一个线程。在java中所以的线程都是同时启动的，至于什么时候，哪个先执行，完全看谁先得到CPU的资源。

在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用java命令执行一个类的时候，实际上都会启动一个ＪＶＭ，每一个ｊＶＭ实习在就是在操作系统中启动了一个进程。

### 四、线程状态转换

```doc
1、新建状态（New）：新创建了一个线程对象。
2、就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
3、运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
4、阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
（一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
（二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
（三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）
5、死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
```

### 五、线程调度

#### 1、调整线程优先级

```doc


1、调整线程优先级：Java线程有优先级，优先级高的线程会获得较多的运行机会。
 
Java线程的优先级用整数表示，取值范围是1~10，Thread类有以下三个静态常量：
static int MAX_PRIORITY
          线程可以具有的最高优先级，取值为10。
static int MIN_PRIORITY
          线程可以具有的最低优先级，取值为1。
static int NORM_PRIORITY
          分配给线程的默认优先级，取值为5。
 
Thread类的setPriority()和getPriority()方法分别用来设置和获取线程的优先级。
每个线程都有默认的优先级。主线程的默认优先级为Thread.NORM_PRIORITY。
线程的优先级有继承关系，比如A线程中创建了B线程，那么B将和A具有相同的优先级。
JVM提供了10个线程优先级，但与常见的操作系统都不能很好的映射。如果希望程序能移植到各个操作系统中，应该仅仅使用Thread类有以下三个静态常量作为优先级，这样能保证同样的优先级采用了同样的调度方式。
```



#### 2、线程睡眠

Thread.sleep(long millis)方法，使线程转到阻塞状态。millis参数设定睡眠的时间，以毫秒为单位。当睡眠结束后，就转为就绪（Runnable）状态。sleep()平台移植性好。

#### 3、线程等待

Object类中的wait()方法，导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 唤醒方法。这个两个唤醒方法也是Object类中的方法，行为等价于调用 wait(0) 一样。

#### 4、线程让步

Thread.yield() 方法，暂停当前正在执行的线程对象，把执行机会让给相同或者更高优先级的线程。

#### 5、线程加入

join()方法，等待其他线程终止。在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。

#### 6、线程唤醒

Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。 直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。
 注意：Thread中suspend()和resume()两个方法在JDK1.5中已经废除，不再介绍。因为有死锁倾向。



### 六、常用函数说明

①sleep(long millis): 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）

②join():指等待t线程终止。
使用方式。
join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。

Thread t = new AThread(); t.start(); t.join();  

#### 为什么要用join()方法

在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。

```java
// 不加join。
package com.multithread.join;  
class Thread1 extends Thread{  
    private String name;  
    public Thread1(String name) {  
        super(name);  
       this.name=name;  
    }  
    public void run() {  
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");  
        for (int i = 0; i < 5; i++) {  
            System.out.println("子线程"+name + "运行 : " + i);  
            try {  
                sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");  
    }  
}  
  
public class Main {  
  
    public static void main(String[] args) {  
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");  
        Thread1 mTh1=new Thread1("A");  
        Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");  
  
    }  
  
}  

输出结果：
main主线程运行开始!
main主线程运行结束!
B 线程运行开始!
子线程B运行 : 0
A 线程运行开始!
子线程A运行 : 0
子线程B运行 : 1
子线程A运行 : 1
子线程A运行 : 2
子线程A运行 : 3
子线程A运行 : 4
A 线程运行结束!
子线程B运行 : 2
子线程B运行 : 3
子线程B运行 : 4
B 线程运行结束!
发现主线程比子线程早结束
  
  
 
  
  
  
 //加join 
  public class Main {  
  
    public static void main(String[] args) {  
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");  
        Thread1 mTh1=new Thread1("A");  
        Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
        try {  
            mTh1.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        try {  
            mTh2.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");  
  
    }  
  
}  
运行结果：
main主线程运行开始!
A 线程运行开始!
子线程A运行 : 0
B 线程运行开始!
子线程B运行 : 0
子线程A运行 : 1
子线程B运行 : 1
子线程A运行 : 2
子线程B运行 : 2
子线程A运行 : 3
子线程B运行 : 3
子线程A运行 : 4
子线程B运行 : 4
A 线程运行结束!
主线程一定会等子线程都结束了才结束
```



③yield():暂停当前正在执行的线程对象，并执行其他线程。

        Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
         yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。

结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。可看上面的图。

```java
package com.multithread.yield;  
class ThreadYield extends Thread{  
    public ThreadYield(String name) {  
        super(name);  
    }  
   
    @Override  
    public void run() {  
        for (int i = 1; i <= 50; i++) {  
            System.out.println("" + this.getName() + "-----" + i);  
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）  
            if (i ==30) {  
                this.yield();  
            }  
        }  
      
}  
}  
  
public class Main {  
  
    public static void main(String[] args) {  
          
        ThreadYield yt1 = new ThreadYield("张三");  
        ThreadYield yt2 = new ThreadYield("李四");  
        yt1.start();  
        yt2.start();  
    }  
  
}  

运行结果：
第一种情况：李四（线程）当执行到30时会CPU时间让掉，这时张三（线程）抢到CPU时间并执行。

第二种情况：李四（线程）当执行到30时会CPU时间让掉，这时李四（线程）抢到CPU时间并执行。
```

#### sleep()和yield()的区别

        sleep()和yield()的区别):sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
        sleep 方法使当前运行中的线程睡眼一段时间，进入不可运行状态，这段时间的长短是由程序设定的，yield 方法使当前线程让出 CPU 占有权，但让出的时间是不可设定的。实际上，yield()方法对应了如下操作：先检测当前是否有相同优先级的线程处于同可运行状态，如有，则把 CPU  的占有权交给此线程，否则，继续运行原来的线程。所以yield()方法称为“退让”，它把运行机会让给了同等优先级的其他线程
       另外，sleep 方法允许较低优先级的线程获得运行机会，但 yield()  方法执行时，当前线程仍处在可运行状态，所以，不可能让出较低优先级的线程些时获得 CPU 占有权。在一个运行系统中，如果较高优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞，那么，较低优先级线程只能等待所有较高优先级的线程运行结束，才有机会运行。 


 ④setPriority(): 更改线程的优先级。

```doc
    
　　　　MIN_PRIORITY = 1
  　　   NORM_PRIORITY = 5
           MAX_PRIORITY = 10

用法：
Thread4 t1 = new Thread4("t1");
Thread4 t2 = new Thread4("t2");
t1.setPriority(Thread.MAX_PRIORITY);
t2.setPriority(Thread.MIN_PRIORITY);
```

⑤interrupt():不要以为它是中断某个线程！它只是线线程发送一个中断信号，让线程在无限等待时（如死锁时）能抛出抛出，从而结束线程，但是如果你吃掉了这个异常，那么这个线程还是不会中断的！



⑥wait()

Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作。但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。



#### wait和sleep区别

共同点： 

1. 他们都是在多线程的环境下，都可以在程序的调用处阻塞指定的毫秒数，并返回。 
2. wait()和sleep()都可以通过interrupt()方法 打断线程的暂停状态 ，从而使线程立刻抛出InterruptedException。 
   如果线程A希望立即结束线程B，则可以对线程B对应的Thread实例调用interrupt方法。如果此刻线程B正在wait/sleep /join，则线程B会立刻抛出InterruptedException，在catch() {} 中直接return即可安全地结束线程。 
   需要注意的是，InterruptedException是线程自己从内部抛出的，并不是interrupt()方法抛出的。对某一线程调用 interrupt()时，如果该线程正在执行普通的代码，那么该线程根本就不会抛出InterruptedException。但是，一旦该线程进入到 wait()/sleep()/join()后，就会立刻抛出InterruptedException 。 
   不同点： 
3. Thread类的方法：sleep(),yield()等 
   Object的方法：wait()和notify()等 
4. 每个对象都有一个锁来控制同步访问。Synchronized关键字可以和对象的锁交互，来实现线程的同步。 
   sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。 
5. wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用 
6. sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
   所以sleep()和wait()方法的最大区别是：
   　　　　sleep()睡眠时，保持对象锁，仍然占有该锁；
   　　　　而wait()睡眠时，释放对象锁。
   　　但是wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出InterruptedException（但不建议使用该方法）。
   sleep（）方法
   sleep()使当前线程进入停滞状态（阻塞当前线程），让出CUP的使用、目的是不让当前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会;
   　　 sleep()是Thread类的Static(静态)的方法；因此他不能改变对象的机锁，所以当在一个Synchronized块中调用Sleep()方法是，线程虽然休眠了，但是对象的机锁并木有被释放，其他线程无法访问这个对象（即使睡着也持有对象锁）。
   　　在sleep()休眠时间期满后，该线程不一定会立即执行，这是因为其它线程可能正在运行而且没有被调度为放弃执行，除非此线程具有更高的优先级。 
   wait（）方法
   wait()方法是Object类里的方法；当一个线程执行到wait()方法时，它就进入到一个和该对象相关的等待池中，同时失去（释放）了对象的机锁（暂时失去机锁，wait(long timeout)超时时间到后还需要返还对象锁）；其他线程可以访问；
   　　wait()使用notify或者notifyAlll或者指定睡眠时间来唤醒当前等待池中的线程。
   　　wiat()必须放在synchronized block中，否则会在program runtime时扔出”java.lang.IllegalMonitorStateException“异常。



### 七、常见线程名词解释

主线程：JVM调用程序main()所产生的线程。
当前线程：这个是容易混淆的概念。一般指通过Thread.currentThread()来获取的进程。
后台线程：指为其他线程提供服务的线程，也称为守护线程。JVM的垃圾回收线程就是一个后台线程。用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束
前台线程：是指接受后台线程服务的线程，其实前台后台线程是联系在一起，就像傀儡和幕后操纵者一样的关系。傀儡是前台线程、幕后操纵者是后台线程。由前台线程创建的线程默认也是前台线程。可以通过isDaemon()和setDaemon()方法来判断和设置一个线程是否为后台线程。
线程类的一些常用方法： 

　　sleep(): 强迫一个线程睡眠Ｎ毫秒。 
　　isAlive(): 判断一个线程是否存活。 
　　join(): 等待线程终止。 
　　activeCount(): 程序中活跃的线程数。 
　　enumerate(): 枚举程序中的线程。 
    currentThread(): 得到当前线程。 
　　isDaemon(): 一个线程是否为守护线程。 
　　setDaemon(): 设置一个线程为守护线程。(用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束) 
　　setName(): 为线程设置一个名称。 
　　wait(): 强迫一个线程等待。 
　　notify(): 通知一个线程继续运行。 
　　setPriority(): 设置一个线程的优先级。



### 八、线程同步

#### 1、synchronized关键字的作用域有二种： 

1）是某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法（如果一个对象有多个synchronized方法，只要一个线程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。这时，不同的对象实例的synchronized方法是不相干扰的。也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法； 

2）是某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问这个类中的synchronized static 方法。它可以对类的所有对象实例起作用。 

#### 2、用于方法中的某个区块中

除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。用法是: synchronized(this){/*区块*/}，它的作用域是当前对象； 

#### 3、synchronized关键字是不能继承的

也就是说，基类的方法synchronized f(){} 在继承类中并不自动是synchronized f(){}，而是变成了f(){}。继承类需要你显式的指定它的某个方法为synchronized方法； 

#### 4、小结

总的说来，synchronized关键字可以作为函数的修饰符，也可作为函数内的语句，也就是平时说的同步方法和同步语句块。如果再细的分类，synchronized可作用于instance变量、object reference（对象引用）、static函数和class literals(类名称字面常量)身上。

在进一步阐述之前，我们需要明确几点：

A．无论synchronized关键字加在方法上还是对象上，它取得的锁都是对象，而不是把一段代码或函数当作锁――而且同步方法很可能还会被其他线程的对象访问。

B．每个对象只有一个锁（lock）与之相关联。

C．实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。

1、线程同步的目的是为了保护多个线程访问一个资源时对资源的破坏。
2、线程同步方法是通过锁来实现，每个对象都有切仅有一个锁，这个锁与一个特定的对象关联，线程一旦获取了对象锁，其他访问该对象的线程就无法再访问该对象的其他非同步方法。
3、对于静态同步方法，锁是针对这个类的，锁对象是该类的Class对象。静态和非静态方法的锁互不干预。一个线程获得锁，当在一个同步方法中访问另外对象上的同步方法时，会获取这两个对象锁。
4、对于同步，要时刻清醒在哪个对象上同步，这是关键。
5、编写线程安全的类，需要时刻注意对多个线程竞争访问资源的逻辑和安全做出正确的判断，对“原子”操作做出分析，并保证原子操作期间别的线程无法访问竞争资源。
6、当多个线程等待一个对象锁时，没有获取到锁的线程将发生阻塞。
7、死锁是线程间相互等待锁锁造成的，在实际中发生的概率非常的小。真让你写个死锁程序，不一定好使，呵呵。但是，一旦程序发生死锁，程序将死掉。



### 九、线程数据传递

#### 9.1、通过构造方法传递数据 

在创建线程时，必须要建立一个Thread类的或其子类的实例。因此，我们不难想到在调用start方法之前通过线程类的构造方法将数据传入线程。并将传入的数据使用类变量保存起来，以便线程使用(其实就是在run方法中使用)。下面的代码演示了如何通过构造方法来传递数据： 

```java
package mythread;   
public class MyThread1 extends Thread   
{   
private String name;   
public MyThread1(String name)   
{   
this.name = name;   
}   
public void run()   
{   
System.out.println("hello " + name);   
}   
public static void main(String[] args)   
{   
Thread thread = new MyThread1("world");   
thread.start();   
}   
}   
```



由于这种方法是在创建线程对象的同时传递数据的，因此，在线程运行之前这些数据就就已经到位了，这样就不会造成数据在线程运行后才传入的现象。如果要传递更复杂的数据，可以使用集合、类等数据结构。使用构造方法来传递数据虽然比较安全，但如果要传递的数据比较多时，就会造成很多不便。由于Java没有默认参数，要想实现类似默认参数的效果，就得使用重载，这样不但使构造方法本身过于复杂，又会使构造方法在数量上大增。因此，要想避免这种情况，就得通过类方法或类变量来传递数据。 



#### 9.2、通过变量和方法传递数据 

向对象中传入数据一般有两次机会，第一次机会是在建立对象时通过构造方法将数据传入，另外一次机会就是在类中定义一系列的public的方法或变量（也可称之为字段）。然后在建立完对象后，通过对象实例逐个赋值。下面的代码是对MyThread1类的改版，使用了一个setName方法来设置 name变量： 

```java
package mythread;   
public class MyThread2 implements Runnable   
{   
private String name;   
public void setName(String name)   
{   
this.name = name;   
}   
public void run()   
{   
System.out.println("hello " + name);   
}   
public static void main(String[] args)   
{   
MyThread2 myThread = new MyThread2();   
myThread.setName("world");   
Thread thread = new Thread(myThread);   
thread.start();   
}   
}   
```

#### 9.3、通过回调函数传递数据 

上面讨论的两种向线程中传递数据的方法是最常用的。但这两种方法都是main方法中主动将数据传入线程类的。这对于线程来说，是被动接收这些数据的。然而，在有些应用中需要在线程运行的过程中动态地获取数据，如在下面代码的run方法中产生了3个随机数，然后通过Work类的process方法求这三个随机数的和，并通过Data类的value将结果返回。从这个例子可以看出，在返回value之前，必须要得到三个随机数。也就是说，这个 value是无法事先就传入线程类的。 

```java
package mythread;   
class Data   
{   
public int value = 0;   
}   

class Work   
{   
public void process(Data data, Integer numbers)   
{   
for (int n : numbers)   
{   
data.value += n;   
}   
}   
}

public class MyThread3 extends Thread   
{   
private Work work;   
public MyThread3(Work work)   
{   
this.work = work;   
}   
public void run()   
{   
java.util.Random random = new java.util.Random();   
Data data = new Data();   
int n1 = random.nextInt(1000);   
int n2 = random.nextInt(2000);   
int n3 = random.nextInt(3000);   
work.process(data, n1, n2, n3); // 使用回调函数   
System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+"   
+ String.valueOf(n3) + "=" + data.value);   
}   
public static void main(String[] args)   
{   
Thread thread = new MyThread3(new Work());   
thread.start();   
}   
}   
```

### 十、线程同步 synchronized 同步代码块 同步方法 同步锁

#### 1、同步代码块

1.为了解决并发操作可能造成的异常，java的多线程支持引入了同步监视器来解决这个问题，使用同步监视器的通用方法就是同步代码块。其语法如下：
synchronized(obj){
//同步代码块
}
其中obj就是同步监视器，它的含义是：线程开始执行同步代码块之前，必须先获得对同步监视器的锁定。任何时刻只能有一个线程可以获得对同步监视器的锁定，当同步代码块执行完成后，该线程会释放对该同步监视器的锁定。虽然java程序允许使用任何对象作为同步监视器，但 是同步监视器的目的就是为了阻止两个线程对同一个共享资源进行并发访问，因此通常推荐使用可能被并发访问的共享资源充当同步监视器。

example:

```java
public class Account {
    private String accountNo;
    private double balance;
    public Account(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }
 
    public double getBalance() {
        return balance;
    }
 
    public void setBalance(double balance) {
        this.balance = balance;
    }
 
    public String getAccountNo() {
        return accountNo;
    }
 
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        Account account = (Account) o;
 
        return accountNo.equals(account.accountNo);
 
    }
 
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}




public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;
 
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    public void run(){
        synchronized (account){
            if(account.getBalance()>=drawAmount){
                System.out.println(getName() + "取钱成功，吐出钞票： " + drawAmount);
                try{
                    Thread.sleep(1);
                }catch(InterruptedException ex){
                    ex.getStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            }else{
                System.out.println(getName()+"取钱失败，余额不足");
            }
        }
    }
}


public class DrawTest {
    public static void main(String[] args){
        Account acct=new Account("1234567",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}

甲取钱成功，吐出钞票： 800.0
    余额为：200.0
乙取钱失败，余额不足
3.如果将DrawThread的同步去掉：
  
  会出现这些情况的结果：

乙取钱成功，吐出钞票： 800.0
甲取钱成功，吐出钞票： 800.0
    余额为：200.0
    余额为：-600.0
 
甲取钱成功，吐出钞票： 800.0
乙取钱成功，吐出钞票： 800.0
    余额为：200.0
    余额为：200.0

```

  程序使用synchronized将run()方法里的方法体修改成同步代码块，同步监视器就是account对象，这样的做法符合“加锁-修改-释放锁”的逻辑，这样就可以保证并发线程在任一时刻只有一个线程进入修改共享资源的代码区。多次运行，结果只有一个。



#### 2、同步方法

1.同步方法就是使用synchronized关键字修饰某个方法，这个方法就是同步方法。这个同步方法(非static方法)无须显式指定同步监视器，同步方法的同步监视器是this，也就是调用该方法的对象。通过同步方法可以非常方便的实现线程安全的类，线程安全的类有如下特征：
该类的对象可以方便的被多个线程安全的访问；
每个线程调用该对象的任意方法之后都能得到正确的结果；
每个线程调用该对象的任意方法之后，该对象状态依然能保持合理状态。
2.不可变类总是线程安全的，因为它的对象状态不可改变可变类需要额外的方法来保证其线程安全，在Account类中我们只需要把balance的方法变成同步方法即可。

```java
public class Account {
    private String accountNo;
    private double balance;
    public Account(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }
 
    //因为账户余额不可以随便更改，所以只为balance提供getter方法
    public double getBalance() {
        return balance;
    }
 
    public String getAccountNo() {
        return accountNo;
    }
 
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        Account account = (Account) o;
 
        return accountNo.equals(account.accountNo);
 
    }
 
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
 
    //提供一个线程安全的draw()方法来完成取钱操作
    public synchronized void draw(double drawAmount){
        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            balance-=drawAmount;
            System.out.println("\t余额为："+balance);
        }else{
            System.out.println(Thread.currentThread().getName()+"取钱失败，余额不足");
        }
    }
}


public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;
 
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    public void run(){
        account.draw(drawAmount);
    }
}


public class DrawTest {
    public static void main(String[] args){
        Account acct=new Account("1234567",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}
```

注意，synchronized可以修饰方法，修饰代码块，但是不能修饰构造器、成员变量等。在Account类中定义draw()方法，而不是直接在 run()方法中实现取钱逻辑，这种做法更符合面向对象规则。DDD设计方式，即Domain Driven Design(领域驱动设计)，认为每个类都应该是完备的领域对象，Account代表用户账户，就应该提供用户账户的相关方法。通过draw()方法来执行取钱操作，而不是直接将setBalance()方法暴露出来任人操作。

但是，可变类的线程安全是以降低程序的运行效率为代价的，不要对线程安全类的所有方法都进行同步，只对那些会改变竞争资源(共享资源)的方法进行同步。同时，可变类有两种运行环境：单线程环境和多线程环境， 则应该为可变类提供两种版本，即线程安全版本和线程不安全版本。如JDK提供的StringBuilder在单线程环境下保证更好的性能，StringBuffer可以保证多线程安全。



#### 3、释放同步监视器的锁定

1.任何线程进入同步代码块，同步方法之前，必须先获得对同步监视器的锁定，那么如何释放对同步监视器的锁定呢，线程会在一下几种情况下释放同步监视器：

当前线程的同步方法、同步代码块执行结束，当前线程即释放同步监视器；
当前线程在同步代码块、同步方法中遇到break,return终止了该代码块、方法的继续执行；
当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致了该代码块、方法的异常结束；
当前线程执行同步代码块或同步方法时，程序执行了同步监视器对象的wait()方法，则当前线程暂停，并释放同步监视器；

2.以下几种情况，线程不会释放同步监视器：
线程执行同步代码块或同步方法时，程序调用Thread.sleep(),Thread.yield()方法来暂停当前线程的执行，当前线程不会释放同步监视器；
线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放同步监视器，当然，程序应尽量避免使用suspend()和resume()方法来控制线程。



#### 4、 同步锁：

1.Java5开始，Java提供了一种功能更加强大的线程同步机制——通过显式定义同步锁对象来实现同步，这里的同步锁由Lock对象充当。
Lock 对象提供了比synchronized方法和synchronized代码块更广泛的锁定操作，Lock是控制多个线程对共享资源进行访问的工具。通常， 锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应该先获得Lock对象。
某些锁可能允许对共享资源并发访问，如ReadWriteLock(读写锁)，Lock,ReadWriteLock是Java5提供的两个根接口，并为 Lock提供了ReentrantLock实现类，为ReadWriteLock提供了ReentrantReadWriteLock实现类。在 Java8中提供了新型的StampLock类，在大多数场景下它可以替代传统的ReentrantReadWriteLock。 ReentrantReadWriteLock为读写操作提供了三种锁模式：Writing,ReadingOptimistic,Reading。
2.在实现线程安全的控制中，比较常用的是ReentrantLock(可重入锁)。主要的代码格式如下：

```java
class X{
    //定义锁对象
    private final ReentrantLock lock=new ReentrantLock();
    //定义需要保证线程安全的方法
    public void m(){
        //加锁
        lock.lock();
        try{
            //...method body
        }
        //使用finally块来保证释放锁
        finally{
            lock.unlock();
        }
    }
}




public class Account {
    private final ReentrantLock lock=new ReentrantLock();
    private String accountNo;
    private double balance;
    public Account(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }
 
    //因为账户余额不可以随便更改，所以只为balance提供getter方法
    public double getBalance() {
        return balance;
    }
 
    public String getAccountNo() {
        return accountNo;
    }
 
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        Account account = (Account) o;
 
        return accountNo.equals(account.accountNo);
 
    }
 
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
 
    //提供一个线程安全的draw()方法来完成取钱操作
    public void draw(double drawAmount){
        //加锁
        lock.lock();
        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                balance -= drawAmount;
                System.out.println("\t余额为：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
            }
        }finally {
            lock.unlock();
        }
    }
}
```

使用Lock与使用同步代码有点相似，只是使用Lock时可以显式使用Lock对象作为同步锁，而使用同步方法时系统隐式使用当前对象作为同步监视器。使用 Lock时每个Lock对象对应一个Account对象，一样可以保证对于同一个Account对象，同一个时刻只能有一个线程进入临界区。Lock提供 了同步方法和同步代码块所没有的其他功能，包括使用非块结构的tryLock()方法，以及试图获取可中断锁的lockInterruptibly()方法，还有获取超时失效锁的tryLock(long,TimeUnit)方法。
ReentrantLock可重入锁的意思是，一个线程可以对已被加锁的ReentrantLock锁再次加锁，ReentrantLock对象会维持一个计数器来追踪lock()方法的嵌套调用，线程在每次调用lock()加锁后，必须显式调用unlock()来释放锁，所以一段被锁保护的代码可以调用另一个被相同锁保护的方法。



5、 死锁
当两个线程相互等待对方释放同步监视器时就会发生死锁，Java虚拟机没有检测，也没有采取措施来处理死锁情况，所以多线程编程时应该采取措施避免死锁出现。一旦出现死锁，程序既不会发生任何异常，也不会给出任何提示，只是所有线程都处于阻塞状态，无法继续。

```java
class A{
    public synchronized void foo(B b){
        System.out.println("当前线程名为："+Thread.currentThread().getName()+"进入了A实例的foo()方法");
        try{
            Thread.sleep(200);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("当前线程名为："+Thread.currentThread().getName()+"试图调用B实例的last()方法");
        b.last();
    }
    public synchronized void last(){
        System.out.println("进入了A类的last()方法内部");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名为："+Thread.currentThread().getName()+"进入了B实例的bar()方法");
        try{
            Thread.sleep(200);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("当前线程名为："+Thread.currentThread().getName()+"试图调用A实例的last()方法");
        a.last();
    }
    public synchronized void last(){
        System.out.println("进入了B类的last()方法内部");
    }
}
public class DeadLock implements Runnable{
    A a =new A();
    B b=new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后...");
    }
    public void run(){
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后...");
    }
    public static void main(String[] args){
        DeadLock d1=new DeadLock();
        new Thread(d1).start();
        d1.init();
    }
}
```

结果：

当前线程名为：主线程进入了A实例的foo()方法

当前线程名为：副线程进入了B实例的bar()方法

当前线程名为：主线程试图调用B实例的last()方法

当前线程名为：副线程试图调用A实例的last()方法



## Java并发编程：线程池的使用

#### 为什么用线程池

1创建/销毁线程伴随着系统开销，过于频繁的创建/销毁线程，会很大程度上影响处理效率

例如：

记创建线程消耗时间T1，执行任务消耗时间T2，销毁线程消耗时间T3

如果T1+T3>T2，那么是不是说开启一个线程来执行这个任务太不划算了！

正好，线程池缓存线程，可用已有的闲置线程来执行新任务，避免了T1+T3带来的系统开销

2线程并发数量过多，抢占系统资源从而导致阻塞

我们知道线程能共享系统资源，如果同时执行的线程过多，就有可能导致系统资源不足而产生阻塞的情况

运用线程池能有效的控制线程最大并发数，避免以上的问题

3对线程进行一些简单的管理

比如：延时执行、定时循环执行的策略等

运用线程池都能进行很好的实现

#### 线程池任务执行流程：

当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。
当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行
当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务
当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理
当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程
当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭

### 一、线程池ThreadPoolExecutor

java.uitl.concurrent.ThreadPoolExecutor类是线程池中最核心的一个类，因此如果要透彻地了解Java中的线程池，必须先了解这个类。

ThreadPoolExecutor提供了四个构造函数

```java
public class ThreadPoolExecutor extends AbstractExecutorService {
    .....
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
        BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);
    ...
}


```



各个参数的含义：

#### 1.corePoolSize：核心池的大小

该线程池中核心线程数最大值。

核心线程：

线程池新建线程的时候，如果当前线程总数小于corePoolSize，则新建的是核心线程，如果超过corePoolSize，则新建的是非核心线程

核心线程默认情况下会一直存活在线程池中，即使这个核心线程啥也不干(闲置状态)。

如果指定ThreadPoolExecutor的allowCoreThreadTimeOut这个属性为true，那么核心线程如果不干活(闲置状态)的话，超过一定时间(时长下面参数决定)，就会被销毁掉。



#### 2.maximumPoolSize

该线程池中线程总数最大值

线程总数 = 核心线程数 + 非核心线程数。它表示在线程池中最多能创建多少个线程。

#### 3.keepAliveTime

该线程池中非核心线程闲置超时时长

一个非核心线程，如果不干活(闲置状态)的时长超过这个参数所设定的时长，就会被销毁掉

如果设置allowCoreThreadTimeOut = true，则会作用于核心线程

#### 4.unit

参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：

```doc
TimeUnit.DAYS;               //天
TimeUnit.HOURS;             //小时
TimeUnit.MINUTES;           //分钟
TimeUnit.SECONDS;           //秒
TimeUnit.MILLISECONDS;      //毫秒
TimeUnit.MICROSECONDS;      //微妙
TimeUnit.NANOSECONDS;       //纳秒
```

#### 5.workQueue

```doc
该线程池中的任务队列：维护着等待执行的Runnable对象。一个阻塞队列，用来存储等待执行的任务。

当所有的核心线程都在干活时，新添加的任务会被添加到这个队列中等待处理，如果队列满了，则新建非核心线程执行任务
常用的workQueue类型：

SynchronousQueue：这个队列接收到任务的时候，会直接提交给线程处理，而不保留它，如果所有线程都在工作怎么办？那就新建一个线程来处理这个任务！所以为了保证不出现<线程数达到了maximumPoolSize而不能新建线程>的错误，使用这个类型队列的时候，maximumPoolSize一般指定成Integer.MAX_VALUE，即无限大

LinkedBlockingQueue：这个队列接收到任务的时候，如果当前线程数小于核心线程数，则新建线程(核心线程)处理任务；如果当前线程数等于核心线程数，则进入队列等待。由于这个队列没有最大值限制，即所有超过核心线程数的任务都将被添加到队列中，这也就导致了maximumPoolSize的设定失效，因为总线程数永远不会超过corePoolSize

ArrayBlockingQueue：可以限定队列的长度，接收到任务的时候，如果没有达到corePoolSize的值，则新建线程(核心线程)执行任务，如果达到了，则入队等候，如果队列已满，则新建线程(非核心线程)执行任务，又如果总线程数到了maximumPoolSize，并且队列也满了，则发生错误

DelayQueue：队列内元素必须实现Delayed接口，这就意味着你传进去的任务必须先实现Delayed接口。这个队列接收到任务时，首先先入队，只有达到了指定的延时时间，才会执行任务

```

#### 6.threadFactory

线程工厂，主要用来创建线程。

#### 7.handler

抛出异常。表示当拒绝处理任务时的策略，有以下四种取值：

```doc
ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 
```



在ThreadPoolExecutor类中有几个非常重要的方法：


execute()
submit()
shutdown()
shutdownNow()
 　　execute()方法实际上是Executor中声明的方法，在ThreadPoolExecutor进行了具体的实现，这个方法是ThreadPoolExecutor的核心方法，通过这个方法可以向线程池提交一个任务，交由线程池去执行。

　　submit()方法是在ExecutorService中声明的方法，在AbstractExecutorService就已经有了具体的实现，在ThreadPoolExecutor中并没有对其进行重写，这个方法也是用来向线程池提交任务的，但是它和execute()方法不同，它能够返回任务执行的结果，去看submit()方法的实现，会发现它实际上还是调用的execute()方法，只不过它利用了Future来获取任务执行结果

新建一个线程池的时候，一般只用5个参数的构造函数。

还有很多其他的方法：

　　比如：getQueue() 、getPoolSize() 、getActiveCount()、getCompletedTaskCount()等获取与线程池相关属性的方法

### 二、深入剖析线程池实现原理

#### 1.线程池状态

　　在ThreadPoolExecutor中定义了一个volatile变量，另外定义了几个static final变量表示线程池的各个状态：

volatile int runState;
static final int RUNNING    = 0;
static final int SHUTDOWN   = 1;
static final int STOP       = 2;
static final int TERMINATED = 3;
 　　runState表示当前线程池的状态，它是一个volatile变量用来保证线程之间的可见性；

　　下面的几个static final变量表示runState可能的几个取值。

　　当创建线程池后，初始时，线程池处于RUNNING状态；

　　如果调用了shutdown()方法，则线程池处于SHUTDOWN状态，此时线程池不能够接受新的任务，它会等待所有任务执行完毕；

　　如果调用了shutdownNow()方法，则线程池处于STOP状态，此时线程池不能接受新的任务，并且会去尝试终止正在执行的任务；

　　当线程池处于SHUTDOWN或STOP状态，并且所有工作线程已经销毁，任务缓存队列已经清空或执行结束后，线程池被设置为TERMINATED状态。

#### 2.任务的执行

　　在了解将任务提交给线程池到任务执行完毕整个过程之前，我们先来看一下ThreadPoolExecutor类中其他的一些比较重要成员变量：

```java
private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
private final ReentrantLock mainLock = new ReentrantLock();   //线程池的主要状态锁，对线程池状态（比如线程池大小
                                                              //、runState等）的改变都要使用这个锁
private final HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集
 
private volatile long  keepAliveTime;    //线程存货时间   
private volatile boolean allowCoreThreadTimeOut;   //是否允许为核心线程设置存活时间
private volatile int   corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
private volatile int   maximumPoolSize;   //线程池最大能容忍的线程数
 
private volatile int   poolSize;       //线程池中当前的线程数
 
private volatile RejectedExecutionHandler handler; //任务拒绝策略
 
private volatile ThreadFactory threadFactory;   //线程工厂，用来创建线程
 
private int largestPoolSize;   //用来记录线程池中曾经出现过的最大线程数
 
private long completedTaskCount;   //用来记录已经执行完毕的任务个数
```

　　下面我们进入正题，看一下任务从提交到最终执行完毕经历了哪些过程。

　　在ThreadPoolExecutor类中，最核心的任务提交方法是execute()方法，虽然通过submit也可以提交任务，但是实际上submit方法里面最终调用的还是execute()方法，所以我们只需要研究execute()方法的实现原理即可：

```java
public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
        if (runState == RUNNING && workQueue.offer(command)) {
            if (runState != RUNNING || poolSize == 0)
                ensureQueuedTaskHandled(command);
        }
        else if (!addIfUnderMaximumPoolSize(command))
            reject(command); // is shutdown or saturated
    }
}
```

#### 3.线程池中的线程初始化

　　默认情况下，创建线程池之后，线程池中是没有线程的，需要提交任务之后才会创建线程。

　　在实际中如果需要线程池创建之后立即创建线程，可以通过以下两个方法办到：

prestartCoreThread()：初始化一个核心线程；
prestartAllCoreThreads()：初始化所有核心线程

```java
public boolean prestartCoreThread() {
    return addIfUnderCorePoolSize(null); //注意传进去的参数是null
}
 
public int prestartAllCoreThreads() {
    int n = 0;
    while (addIfUnderCorePoolSize(null))//注意传进去的参数是null
        ++n;
    return n;
}
```

#### 4.任务缓存队列及排队策略

　　在前面我们多次提到了任务缓存队列，即workQueue，它用来存放等待执行的任务。

　　workQueue的类型为BlockingQueue<Runnable>，通常可以取下面三种类型：

　　1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；

　　2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；

　　3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。

#### 5.任务拒绝策略

　　当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：

ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务

### 6.线程池的关闭

　　ThreadPoolExecutor提供了两个方法，用于线程池的关闭，分别是shutdown()和shutdownNow()，其中：

shutdown()：不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务

#### 7.线程池容量的动态调整

　　ThreadPoolExecutor提供了动态调整线程池容量大小的方法：setCorePoolSize()和setMaximumPoolSize()，

setCorePoolSize：设置核心池大小
setMaximumPoolSize：设置线程池最大能创建的线程数目大小
　　当上述参数从小变大时，ThreadPoolExecutor进行线程赋值，还可能立即创建新的线程来执行任务。

### 三、使用示例

```java
public class Test {
     public static void main(String[] args) {   
         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                 new ArrayBlockingQueue<Runnable>(5));
          
         for(int i=0;i<15;i++){
             MyTask myTask = new MyTask(i);
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
         }
         executor.shutdown();
     }
}
 
 
class MyTask implements Runnable {
    private int taskNum;
     
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
```



从执行结果可以看出，当线程池中线程的数目大于5时，便将任务放入任务缓存队列里面，当任务缓存队列满了之后，便创建新的线程。如果上面程序中，将for循环中改成执行20个任务，就会抛出任务拒绝异常了。

#### 使用Executors类中提供的几个静态方法来创建线程池：

不过在java doc中，并不提倡我们直接使用ThreadPoolExecutor，而是使用Executors类中提供的几个静态方法来创建线程池：

```java
Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
```

```java
下面是这三个静态方法的具体实现;
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```

```doc
　　从它们的具体实现来看，它们实际上也是调用了ThreadPoolExecutor，只不过参数都已配置好了。

　　newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue；

　　newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue；

　　newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，使用的SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程。

　　实际中，如果Executors提供的三个静态方法能满足要求，就尽量使用它提供的三个方法，因为自己去手动配置ThreadPoolExecutor的参数有点麻烦，要根据实际任务的类型和数量来进行配置。

　　另外，如果ThreadPoolExecutor达不到要求，可以自己继承ThreadPoolExecutor类进行重写。
```



### 四、如何合理配置线程池的大小　

一般需要根据任务的类型来配置线程池大小：

　　如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1

　　如果是IO密集型任务，参考值可以设置为2*NCPU

　　当然，这只是一个参考值，具体的设置还需要根据实际情况进行调整，比如可以先将线程池大小设置为参考值，再观察任务运行情况和系统负载、资源利用率来进行适当调整。



2018/04/04   星期三     阴天



## Token



## Docker



## Java泛型



## 数据库连接池





## RMI



## WebService



## Nignx

## 负载均衡

## 微服务分布式架构

## Redis

## Oracle

## Mongodb



